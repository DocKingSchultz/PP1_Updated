package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	enum MULLOPS
	{
		MullOP,
		DivOP,
		ModOP,
		SquareBinome
	}
	
	enum PRINTOPT
	{
		ConstToPrint,
		NoConstToPrint
	}
	enum ADD_SUB_op
	{
		PlusOP,
		MinusOP
	}
	
	private int varCount;
	
	private int mainPc;
	
	private boolean endOfMethod = false;
	
	public int getMainPc() {
		return mainPc;
	}
	
	// Helper methods :
	//
	// Add a variable with const
	//
	private void addConstToVariable(Obj obj, int num)
	{
		Code.put(Code.inc);
		Code.put(obj.getAdr());
		Code.put(num);
	}
	private void prepareNewEntry(int numOfTakenElemFromStack, int numOfVariables)
	{
		Code.put(Code.enter);
		Code.put(numOfTakenElemFromStack);
		Code.put(numOfVariables);
	}
	
//--------------------------------------------------------------------
	// Main logic :
	//
	@Override
	public void visit(MainIdent method_name) {
		mainPc = Code.pc;
		System.out.print(mainPc);
		method_name.obj.setAdr(Code.pc);
		// Number of formal parameters is 0 for main, put additional number of local var
		// put additional number of local var
		//
		prepareNewEntry(0, method_name.obj.getLocalSymbols().size());
	}
	public void visit(MainMethod mm) {
		if(!endOfMethod) {
			Code.put(Code.exit);
			Code.put(Code.return_);
		}
	}

	@Override
	public void visit(ReturnNull ret) {
		endOfMethod = true;
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

//-----------------------------------------------------------------------------------------------------

	// Var/Designator expression logic
	@Override
	public void visit(VarRef varRightExpression) {
		// Push right value variable
		//
		Code.load(varRightExpression.getDesignator().obj);
	}
	
	@Override
	public void visit(Assignment ass) {
		// Store left value variable to the index 
		//
		Code.store(ass.getDesignator().obj);
	}
	
	@Override
	public void visit(Var_dec vdec) {
		varCount++;
	}

	
	@Override
	public void visit(Increment incVar) {
		Obj temp = incVar.getDesignator().obj;
		if(temp.getKind()==Obj.Var)addConstToVariable(incVar.getDesignator().obj, 1);
		else
		{
			Code.put(Code.dup2);
			Code.load(temp);
			Code.loadConst(1);
			Code.put(Code.add);
			Code.store(temp);
		}
	}
	
	@Override
	public void visit(Decrement decVar) {
		Obj temp = decVar.getDesignator().obj;
		if(temp.getKind()==Obj.Var)addConstToVariable(decVar.getDesignator().obj, -1);
		else
		{
			Code.put(Code.dup2);
			Code.load(temp);
			Code.loadConst(-1);
			Code.put(Code.add);
			Code.store(temp);
		}
	}

//-----------------------------------------------------------------------------------------------------	
	
	// Types 
	//
	@Override
	public void visit(IntRef intValue) {
		Code.loadConst(intValue.getI());
	}
	
	@Override
	public void visit(CharRef charValue) {
		Code.loadConst(charValue.getC());
	}
	
	@Override
	public void visit(BoolRef boolValue) {
		Code.loadConst(boolValue.getB());
	}

//-----------------------------------------------------------------------------------------------------
	
	// Array logic
	//
	@Override
	public void visit(OperatorNew arrinit) {
		Struct arrtype = arrinit.getType().struct;
		int arrTypeParameter = arrtype!=Tab.charType?1:0;
		Code.put(Code.newarray);
		// put operand for array type
		//
		Code.put(arrTypeParameter);
	}
	@Override
	public void visit(ArrayDelegator ad) {
		Code.load(ad.getIdent_expr_list().obj);
	}
	
//-----------------------------------------------------------------------------------------------------
	// Operators and negative value
	//
	
	@Override
	public void visit(AddExpr add_sub) {
		ADD_SUB_op op = ADD_SUB_op.valueOf(add_sub.getAdd_sub_OP().getClass().getSimpleName());
		switch(op)
		{
			case PlusOP:
				Code.put(Code.add);
				break;
			case MinusOP:
				Code.put(Code.sub);
				break;
		}
	}
	
	private void executeSquareBinome()
	{
		Code.put(Code.enter);
		Code.put(2);
		Code.put(2);
		Code.put(Code.load_n);
		Code.put(Code.load_n);
		Code.put(Code.mul);
		Code.put(Code.load_1);
		Code.put(Code.load_1);
		Code.put(Code.mul);
		Code.put(Code.load_n);
		Code.put(Code.load_1);
		Code.loadConst(2);
		Code.put(Code.mul);
		Code.put(Code.mul);
		Code.put(Code.add);
		Code.put(Code.add);
		Code.put(Code.exit);
		
		
	}
	
	@Override
	public void visit(MulopFactor mulop) {
		// Investigate which kind of operator it is :
		MULLOPS op = MULLOPS.valueOf(mulop.getMull_div_mod_OP().getClass().getSimpleName());
		switch(op)
		{
			case MullOP:
				Code.put(Code.mul);
				break;
			case DivOP:
				Code.put(Code.div);
				break;
			case ModOP:
				Code.put(Code.rem);
				break;
			case SquareBinome:
				executeSquareBinome();
				break;
		}
	}
	@Override
	public void visit(NegExpr ne) {
		Code.put(Code.neg);
	}

//-----------------------------------------------------------------------------------------------------
	
	//Read and print logic
	//
    @Override
    public void visit(Read rs) {
    	Obj var = rs.getDesignator().obj;
    	Struct type = rs.getDesignator().obj.getType();
    	
    	if(type.getKind()==Struct.Char)Code.put(Code.bread);
    	else Code.put(Code.read);
    	
        Code.store(var);
    }
	
	@Override
	public void visit(Print print_statement) {
		
		// Push blanko spaces 
		//
		PRINTOPT opt = PRINTOPT.valueOf(print_statement.getConst_to_print().getClass().getSimpleName());
		int blankoSpaces = 1;
		if(opt==PRINTOPT.ConstToPrint)blankoSpaces = ((ConstToPrint)print_statement.getConst_to_print()).getI1();
		Code.loadConst(blankoSpaces);
		
		//Push print instr
		//
		switch(print_statement.getExpr().struct.getKind())
		{
			case Struct.Int : 
				Code.put(Code.print);
				break;
			case Struct.Char:
				Code.put(Code.bprint);
				break;
			case Struct.Bool:
				Code.put(Code.print);
				break;
			default :
				// Error
				break;
		}
	}
}





