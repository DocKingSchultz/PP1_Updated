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
		ModOP
	}
	
	enum PRINTOPT
	{
		ConstToPrint,
		NoConstToPrint
	}
	
	private int varCount;
	
	private int mainPc;
	
	private boolean endOfMethod = false;
	
	public int getMainPc() {
		return mainPc;
	}
	
	@Override
	public void visit(MainIdent method_name) {
		mainPc = Code.pc;
		System.out.print(mainPc);
		method_name.obj.setAdr(Code.pc);
//		// Generate the entry.
		//
		Code.put(Code.enter);
		// Number of formal parameters is 0 for main
		//
		Code.put(0);
		// Put local variables on stack
		//
		Code.put(method_name.obj.getLocalSymbols().size());
	}
	public void visit(MainMethod mm) {
		if(!endOfMethod) {
			Code.put(Code.exit);
			Code.put(Code.return_);
		}
	}
	
	
	@Override
	public void visit(Var_dec vdec) {
		varCount++;
	}

	@Override
	public void visit(ReturnNull ret) {
		endOfMethod = true;
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(Assignment ass) {
		// Store left value variable to the index 
		//
		Code.store(ass.getDesignator().obj);
	}
	
//	@Override
//	public void visit(Designator Designator) {
//		SyntaxNode parent = Designator.getParent();
//		if (Assignment.class != parent.getClass() && FuncCall.class != parent.getClass()) {
//			Code.load(Designator.obj);
//		}
//	}
//	
//	@Override
//	public void visit(FuncCall FuncCall) {
//		Obj functionObj = FuncCall.getDesignator().obj;
//		int offset = functionObj.getAdr() - Code.pc; 
//		Code.put(Code.call);
//		Code.put2(offset);
//	}
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
	
	@Override
	public void visit(VarRef varRightExpression) {
		// Push right value variable
		//
		Code.load(varRightExpression.getDesignator().obj);
	}
	
	@Override
	public void visit(AddExpr AddExpr) {
		Code.put(Code.add);
	}
	
	@Override
	public void visit(NegExpr ne) {
		Code.put(Code.neg);
	}
	
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
		}
	}
}





