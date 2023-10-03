package rs.ac.bg.etf.pp1;
import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {

	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	boolean main_defined = false;
	int nVars;
	String error = "[error] ";
	String info = "[info] ";
	Struct lastType;
	Logger log = Logger.getLogger(getClass());
	Struct boolType = new Struct(Struct.Int);
	Obj boolObj = new Obj(Obj.Type, "bool", boolType);
	// Add "bool" as a symbol to the symbol table
	// 
	SemanticPass()
	{
		// Initialize start state of scope to have bool as a type
		// In the future use type bool would return 0 or 1 as a result
		//
		Tab.currentScope().addToLocals(boolObj);
	}
	
	// ----------------------------------- Helper methods ---------------------
	//
	private Struct makeStruct(int typeId_struct, Struct type)
	{
		return new Struct(typeId_struct, type);
	}
	
	// ----------------------------------- Log methods -----------------------
	//
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" at line : ").append(line);
			msg.append(".");
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" at line : ").append(line);
		    msg.append(".");
		log.info(msg.toString());
	}
	
	// ------------------------------------ Program init ------------------------------------
	//
	public void visit(Prog_id prog_id) {
		// Forbid use of Program name 
		//
		prog_id.obj = Tab.insert(Obj.Prog, prog_id.getId(), Tab.noType);
		Tab.openScope();     	
	}
	public void visit(Program program) {		
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProg_id().obj);
		Tab.closeScope();
		if(!main_defined)
		{
			report_error(error+"Main not defined.", program);
		}
	}

	
	// -------------------------------------- Constants --------------------------------------
	//
	public void visit(ConstIdInt constGDecl) 
	{
		Obj res = Tab.find(constGDecl.getId());
		// Check if var is already declared in the symbol table
		//
		if(res==Tab.noObj)
		{
			// Type match check :
			//
			if(lastType.getKind()==Struct.Int)
			{
				report_info(info + "Declared global constant "+ constGDecl.getId()+".", constGDecl);
				Obj constNode = Tab.insert(Obj.Con, constGDecl.getId(), lastType);
				constNode.setAdr(constGDecl.getValue());
			}
			else
			{
				report_error(error + "Type for : " + constGDecl.getId() + " doesn't match the declaration.", constGDecl);
			}
		}
		else
		{
			report_error(error + "Global constant : " + constGDecl.getId() + " already declared.", constGDecl);
		}

	}
	public void visit(ConstIdChar constGDecl) 
	{
		Obj res = Tab.find(constGDecl.getId());
		// Check if var is already declared in the symbol table
		//
		if(res==Tab.noObj)
		{
			// Type match check :
			//
			if(lastType.getKind()==Struct.Char)
			{
				report_info(info + "Declared global constant "+ constGDecl.getId()+".", constGDecl);
				Obj constNode = Tab.insert(Obj.Con, constGDecl.getId(), lastType);
				constNode.setAdr(constGDecl.getValue());
			}
			else
			{
				report_error(error + "Type for : " + constGDecl.getId() + " doesn't match the declaration.", constGDecl);
			}
		}
		else
		{
			report_error(error + "Global constant : " + constGDecl.getId() + " already declared.", constGDecl);
		}

	}
	public void visit(ConstIdBool constGDecl) 
	{
		Obj res = Tab.find(constGDecl.getId());
		// Check if var is already declared in the symbol table
		//
		if(res==Tab.noObj)
		{
			// Type match check :
			// [*] Bool type needs to be created somehow
			//
			if(lastType.getKind()==Struct.Int)
			{
				report_info(info + "Declared global constant."+ constGDecl.getId(), constGDecl);
				Obj constNode = Tab.insert(Obj.Con, constGDecl.getId(), lastType);
				//constNode.setAdr(constGDecl.getValue());
			}
			else
			{
				report_error(error + "Type for : " + constGDecl.getId() + " doesn't match the declaration.", constGDecl);
			}
		}
		else
		{
			report_error(error + "Global constant : " + constGDecl.getId() + " already declared.", constGDecl);
		}

	}
	
	// -------------------------------------- Regular variables --------------------------------------
	//
	public void visit(VarId regularVarDecl) {
		Obj res = Tab.currentScope.findSymbol(regularVarDecl.getId());
		// Check if var is already declared in the symbol table
		//
		if(res==null)
		{
			// Type match check :
			//
			report_info(info + "Variable "+ regularVarDecl.getId()+" has been declared.", regularVarDecl);
			Obj varNode = Tab.insert(Obj.Var, regularVarDecl.getId(), lastType);
			
		}
		else
		{
			report_error(error + "Variable : " + regularVarDecl.getId() + " already declared.", regularVarDecl);
		}

	}
	
	public void visit(VarOrArrayId regularArrayDecl) {
		Obj res = Tab.currentScope.findSymbol(regularArrayDecl.getId());
		// Check if var is already declared in the symbol table
		//
		if(res==null)
		{
			// Type match check :
			//
			report_info(info + "Variable "+ regularArrayDecl.getId()+" has been declared.", regularArrayDecl);
			Obj varNode = Tab.insert(Obj.Var, regularArrayDecl.getId(), makeStruct(Struct.Array, lastType));
		}
		else
		{
			report_error(error + "Variable : " + regularArrayDecl.getId() + " already declared.", regularArrayDecl);
		}}

	// -------------------------------------- Type extraction --------------------------------------
	//
	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getId());
		
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getId() + " u tabeli simbola.", null);
			type.struct = Tab.noType;
			lastType = Tab.noType;
		} 
		else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
				lastType = typeNode.getType();
			} 
			else {
				report_error("[error] Keyword " + type.getId() + " is not a registered type. ", type);
				type.struct = Tab.noType;
				lastType = Tab.noType;
			}
		}  
	}

	// ---------------------------------------- Main init -------------------------------
	//
	public void visit(MainMethod method_dec) {
		//Check if main already defined :
		//
		Tab.chainLocalSymbols(method_dec.getMain().obj);
		Tab.closeScope();
	}
	public void visit(MainIdent method_name) {
		//Check if main already defined :
		//
		method_name.obj = Tab.noObj;
		if(main_defined==true)
		{
			report_error(error + "Main method already defined !", method_name);
		}
		main_defined=true;
		// Forbid use of main keyword
		//
		method_name.obj=Tab.insert(Obj.Meth, method_name.getName_main(), Tab.noType);
		report_info(info + "Main : " , method_name);
		Tab.openScope();
	}
	
	// --------------------------- Designator -----------------------------
	//
	public void visit(SimpleDesignator designator)
	{
		Obj obj = Tab.find(designator.getId());
		if (obj == Tab.noObj) { 
			report_error(error+ "" +designator.getId()+" was not declared ", null);
		}
		designator.obj = obj;
		// Registered use of local variable
		//
		if(designator.obj.getLevel()==0)
		{
			report_info(info+"Local use of variable "+designator.getId()+".", null);
		}
		else
		{
		// Registered use of global variable
		//	
			report_info(info+"Global use of variable "+designator.getId()+".", null);
		}
	}
	
	public boolean passed() {
		return !errorDetected;
	}



	public void visit(Assignment assignment) {
		if (!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
			report_error("Greska na liniji " + assignment.getLine() + " : " + " nekompatibilni tipovi u dodeli vrednosti ", null);
	}

//	public void visit(PrintStmt printStmt){
//		printCallCount++;    	
//	}
//
//	public void visit(ReturnExpr returnExpr){
//		returnFound = true;
//		Struct currMethType = currentMethod.getType();
//		if (!currMethType.compatibleWith(returnExpr.getExpr().struct)) {
//			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
//		}			  	     	
//	}
//
//	public void visit(ProcCall procCall){
//		Obj func = procCall.getDesignator().obj;
//		if (Obj.Meth == func.getKind()) { 
//			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + procCall.getLine(), null);
//			//RESULT = func.getType();
//		} 
//		else {
//			report_error("Greska na liniji " + procCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
//			//RESULT = Tab.noType;
//		}     	
//	}    

//	public void visit(AddExpr addExpr) {
//		Struct te = addExpr.getExpr().struct;
//		Struct t = addExpr.getTerm().struct;
//		if (te.equals(t) && te == Tab.intType)
//			addExpr.struct = te;
//		else {
//			report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
//			addExpr.struct = Tab.noType;
//		} 
//	}

//	public void visit(TermExpr termExpr) {
//		termExpr.struct = termExpr.getTerm().struct;
//	}
//
//	public void visit(Term term) {
//		term.struct = term.getFactor().struct;    	
//	}
//
//	public void visit(Const cnst){
//		cnst.struct = Tab.intType;    	
//	}
//	
//	public void visit(Var var) {
//		var.struct = var.getDesignator().obj.getType();
//	}

//	public void visit(FuncCall funcCall){
//		Obj func = funcCall.getDesignator().obj;
//		if (Obj.Meth == func.getKind()) { 
//			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
//			funcCall.struct = func.getType();
//		} 
//		else {
//			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
//			funcCall.struct = Tab.noType;
//		}
//
//	}

	
}

