package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	private int varCount;
	
	private int paramCnt;
	
	private int mainPc;
	
	public int getMainPc() {
		return mainPc;
	}
//	
//	@Override
//	public void visit(MethodTypeName MethodTypeName) {
//		if ("main".equalsIgnoreCase(MethodTypeName.getMethName())) {
//			mainPc = Code.pc;
//		}
//		MethodTypeName.obj.setAdr(Code.pc);
//		
//		// Collect arguments and local variables.
//		SyntaxNode methodNode = MethodTypeName.getParent();
//		VarCounter varCnt = new VarCounter();
//		methodNode.traverseTopDown(varCnt);
//		FormParamCounter fpCnt = new FormParamCounter();
//		methodNode.traverseTopDown(fpCnt);
//		
//		// Generate the entry.
//		Code.put(Code.enter);
//		Code.put(fpCnt.getCount());
//		Code.put(varCnt.getCount() + fpCnt.getCount());
//	}
//	
//	@Override
//	public void visit(VarDecl VarDecl) {
//		varCount++;
//	}
//
//	@Override
//	public void visit(FormalParamDecl FormalParam) {
//		paramCnt++;
//	}	
//	
//	@Override
//	public void visit(MethodDecl MethodDecl) {
//		Code.put(Code.exit);
//		Code.put(Code.return_);
//	}
//	
//	@Override
//	public void visit(ReturnExpr ReturnExpr) {
//		Code.put(Code.exit);
//		Code.put(Code.return_);
//	}
//	
//	@Override
//	public void visit(ReturnNoExpr ReturnNoExpr) {
//		Code.put(Code.exit);
//		Code.put(Code.return_);
//	}
//	
//	@Override
//	public void visit(Assignment Assignment) {
//		Code.store(Assignment.getDesignator().obj);
//	}
//	
//	
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
	public void visit(Print print_statement) {
		//Check if print statement has any arguments
		//
		boolean hasArg = print_statement.getConst_to_print() instanceof Const_to_print;
		
		//Get number 
		//
		int val = hasArg ? ((ConstToPrint)print_statement.getConst_to_print()).getI1():1;
		
		Code.loadConst(val);
		
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
//	
//	@Override
//	public void visit(AddExpr AddExpr) {
//		Code.put(Code.add);
//	}
}





