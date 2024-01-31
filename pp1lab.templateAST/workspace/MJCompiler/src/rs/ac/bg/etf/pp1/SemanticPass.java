package rs.ac.bg.etf.pp1;

import javax.management.openmbean.OpenMBeanConstructorInfo;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {

	boolean errorDetected = false;
	int printCallCount = 0;
	String currNamespace = "";
	Obj currentMethod = null;
	boolean returnFound = false;
	boolean main_defined = false;
	int namespaceVariableDeclarations = 0;
	int namespaceVariableUses = 0;
	int constVariablesDeclared = 0;
	int nVars;
	ArrayList<String> activeNamespaces = new ArrayList<String>(); 
	String error = "[error] ";
	String info = "[info] ";
	Struct lastType;

	Logger log = Logger.getLogger(getClass());
	Struct boolType = new Struct(Struct.Bool);
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
	
	// Modifications
	//
	
	
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
	// -------------------------------------- Namespace --------------------------------------
	//
	public void visit(Namespace n)
	{
		currNamespace="";
	}
	public void visit(NamespaceName n)
	{
		String name = n.getId();
		Obj res = Tab.find(name);
		if(res!=Tab.noObj)
		{
			report_error(error + "Namespace :" + name + " already existing ", n);
			return;
		}
		// We put for namespaces type Fld, as we are not gonna use
		// field type, as we got no classed
		//
		Tab.insert(Obj.Fld, name, new Struct(Struct.None));
		currNamespace=name;
	}
	
	
	public void visit(UsingNamespace un) 
	{
		report_info("Detected using for namespace " + un.getNamespace(), un);
		this.activeNamespaces.add(un.getNamespace());
	}
	
	
	
	// -------------------------------------- Constants --------------------------------------
	//
	public void visit(ConstIdInt constGDecl) 
	{
		Obj res;
		String varName = constGDecl.getId();
		String namespaceTag = currNamespace!=""?currNamespace+".":"";
		// Check if var is already declared in the symbol table
		//
		res = Tab.find(namespaceTag + varName);	
		if(res==Tab.noObj)
		{
			// Type match check :
			//
			if(lastType.getKind()==Struct.Int)
			{
				if(currNamespace=="")report_info(info + "Declared global constant "+ namespaceTag + varName+".", constGDecl);
				else {
					report_info(info + "Declared namespace constant "+ namespaceTag + varName+".", constGDecl);
					namespaceVariableDeclarations++;
				}
				constVariablesDeclared++;
				Obj constNode = Tab.insert(Obj.Con, namespaceTag + varName, lastType);
				constNode.setAdr(constGDecl.getValue());
			}
			else
			{
				report_error(error + "Type for : " + namespaceTag + varName + " doesn't match the declaration.", constGDecl);
			}
		}
		else
		{
			report_error(error + "Global constant : " + namespaceTag + varName + " already declared.", constGDecl);
		}

	}
	public void visit(ConstIdChar constGDecl) 
	{
		Obj res;
		String varName = constGDecl.getId();
		String namespaceTag = currNamespace!=""?currNamespace+".":"";
		// Check if var is already declared in the symbol table
		//
		res = Tab.find(namespaceTag + varName);	
		if(res==Tab.noObj)
		{
			// Type match check :
			//
			if(lastType.getKind()==Struct.Char)
			{
				if(currNamespace=="")report_info(info + "Declared global constant "+ namespaceTag + varName+".", constGDecl);
				else {
					report_info(info + "Declared namespace constant "+ namespaceTag + varName+".", constGDecl);
					namespaceVariableDeclarations++;
				}
				Obj constNode = Tab.insert(Obj.Con, namespaceTag + varName, lastType);
				constVariablesDeclared++;
				constNode.setAdr(constGDecl.getValue());
			}
			else
			{
				report_error(error + "Type for : " + namespaceTag + varName+  " doesn't match the declaration.", constGDecl);
			}
		}
		else
		{
			report_error(error + "Global constant : " + namespaceTag + varName+  " already declared.", constGDecl);
		}

	}
	public void visit(ConstIdBool constGDecl) 
	{
		Obj res;
		String varName = constGDecl.getId();
		String namespaceTag = currNamespace!=""?currNamespace+".":"";
		// Check if var is already declared in the symbol table
		//
		res = Tab.find(namespaceTag + varName);	
		if(res==Tab.noObj)
		{
			// Type match check :
			// [*] Bool type needs to be created somehow
			//
			if(lastType.getKind()==Struct.Bool)
			{
				if(currNamespace=="")report_info(info + "Declared global constant."+ namespaceTag + varName, constGDecl);
				else 
				{
					report_info(info + "Declared namespace constant."+ namespaceTag + varName, constGDecl);
					namespaceVariableDeclarations++;
				}
				constVariablesDeclared++;
				Obj constNode = Tab.insert(Obj.Con,  namespaceTag + varName, lastType);
				constNode.setAdr(constGDecl.getValue());
			}
			else
			{
				report_error(error + "Type for : "+ namespaceTag + varName+ " doesn't match the declaration.", constGDecl);
			}
		}
		else
		{
			report_error(error + "Global constant : "+ namespaceTag + varName+" already declared.", constGDecl);
		}

	}
	
	// -------------------------------------- Regular variables --------------------------------------
	//
	public void visit(VarId regularVarDecl) {
		Obj res;
		String varName = regularVarDecl.getId();
		String namespaceTag = currNamespace!=""?currNamespace+".":"";
		// Check if var is already declared in the symbol table
		//
		res = Tab.currentScope.findSymbol(namespaceTag + varName);	
		if(res==null)
		{
			// Type match check :
			//
			
			
			if(currNamespace=="")report_info(info + "Variable "+namespaceTag + varName+" has been declared.", regularVarDecl);
			else 
			{
				namespaceVariableDeclarations++;
				report_info(info + "Namespace variable "+namespaceTag + varName+" has been declared.", regularVarDecl);

			}
			Obj varNode = Tab.insert(Obj.Var, namespaceTag + varName, lastType);
			
		}
		else
		{
			report_error(error + "Variable : " + namespaceTag + varName + " already declared.", regularVarDecl);
		}

	}
	
	public void visit(VarOrArrayId regularArrayDecl) 
	{
		Obj res;
		String varName = regularArrayDecl.getId();
		String namespaceTag = currNamespace!=""?currNamespace+".":"";
		// Check if var array is already declared in the symbol table
		//
		res = Tab.currentScope.findSymbol(namespaceTag + varName);	
		if(res==null)
		{
			// Type match check :
			//
			if(currNamespace=="")report_info(info + "Variable "+ namespaceTag + varName+" has been declared.", regularArrayDecl);
			else
			{
				namespaceVariableDeclarations++;
				report_info(info + "Namespace Variable "+ namespaceTag + varName+" has been declared.", regularArrayDecl);
			}
			Obj varNode = Tab.insert(Obj.Var, namespaceTag + varName, makeStruct(Struct.Array, lastType));
		}
		else
		{
			report_error(error + "Variable : " +namespaceTag + varName + " already declared.", regularArrayDecl);
		}
	}

	// -------------------------------------- Type extraction --------------------------------------
	//
	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getId());
		
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getId() + " u tabeli simbola.", type);
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
		System.out.print("Number of namespace variables declared :" + namespaceVariableDeclarations + "\n" + "Number of namespace variables used : " + namespaceVariableUses +"\n"+ "Total number of contant variables declared : "+constVariablesDeclared+"\n");
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
	
	// ---------------------------- Statement --------------------------------------
	//
	public void visit(Print pnode)
	{
		Struct temp = pnode.getExpr().struct;
		if(temp!=Tab.charType && temp!=Tab.intType && temp!=boolType)
		{
			report_error(error+"Expression is not in valid format to be printed",null);
			return;
		}
		report_info(info+"Print check succesful", null);
		printCallCount++;
	}
	public void visit(Read rnode)
	{
		Struct temp = rnode.getDesignator().obj.getType();
		if((temp.getKind()!=Obj.Var && temp.getKind()!=Obj.Elem) ||
		   (temp!=Tab.charType && temp!=Tab.intType && temp!=boolType))
		{
			report_error(error+"Read statement is not properly called !",null);
			return;
		}
		report_info(info+"Read check succesful", null);
	}
	
	// --------------------------- Designators visits -----------------------------
	//
	public void visit(Assignment assign)
	{
		Obj leftDes = assign.getDesignator().obj;
		Struct rightExpr = assign.getExpr().struct;
		if(leftDes.getKind()!=Obj.Var && leftDes.getKind()!=Obj.Elem)
		{
			report_error(error + "Statement does not have assignable left value, at line :", assign);
		}
		else if(rightExpr.compatibleWith(leftDes.getType()))
		{
			report_info(info+"Assignemnt succesful", null);
		}
		else 
		{
			report_error(error + "Statement does not have compatible values for assignment, at line", assign);
		}
	}
		
	
	public void visit(Decrement dec)
	{
		Obj obj = dec.getDesignator().obj;
		String desIdent = dec.getDesignator().obj.getName();
		if (obj == Tab.noObj) { 
			report_error(error+ "" +desIdent+" was not declared ", null);
		}
		// Check if variable is of int TYPE
		//
		else if(obj.getKind()!=Obj.Var && obj.getKind()!=Obj.Elem)
		{
			report_error(error+ "" +desIdent+" is not a regular variable ", null);
		}
		else
		{
			report_info(info+desIdent+" decremented", dec);
		}
	}
		
	public void visit(Increment incr)
	{
		Obj obj = incr.getDesignator().obj;
		String desIdent = incr.getDesignator().obj.getName();
		if (obj == Tab.noObj) { 
			report_error(error+ "" +desIdent+" was not declared ", null);
		}
		// Check if variable is of int TYPE
		//
		else if(obj.getKind()!=Obj.Var && obj.getKind()!=Obj.Elem)
		{
			report_error(error+ "" +desIdent+" is not a regular variable ", null);
		}
		else
		{
			report_info(info+desIdent+" incremented", incr);
		}
		
	}
	
	public void visit(Designator designator)
	{
		designator.obj=designator.getIdent_expr_list().obj;
	}
	
	public void visit(ArrayDesignator arrDes)
	{
		// Check if expression in paren is of valid type
		//
		Obj obj = ((ArrayDelegator)arrDes.getArray_delegator()).getIdent_expr_list().obj;
		if(arrDes.getExpr().struct!=Tab.intType)
		{
			report_error(error+"Expression that is included in sub/add operations is not of type int", arrDes);
			arrDes.obj=Tab.noObj;
			return;
		}
		if(obj.getType().getKind()!=Struct.Array)
		{
			report_error(error+"Variable is not of type Array", arrDes);
			arrDes.obj=Tab.noObj;
			return;
		}
		arrDes.obj = new Obj(Obj.Elem, "", obj.getType().getElemType());
	}
	
	public void visit(SimpleDesignatorWithNamespace designator)
	{
		String varName = designator.getNamespaceName() + "." + designator.getId();
		Obj obj = Tab.find(varName);
		if(obj==Tab.noObj)
		{
			report_error(error+"Variable " + varName + " is not declared", designator);
			return;
		}
		designator.obj = obj;
		report_info(info+"Local use of variable "+varName+".", null);
		namespaceVariableUses++;
	}
	
	
	private Obj checkIfExistsWithNamespace(String name)
	{
		boolean foundMatch = false;
		Obj tempObj = Tab.noObj;
		for(String namespace : activeNamespaces)
		{
			tempObj = Tab.find(namespace + "." + name);
			if(tempObj!=Tab.noObj)
				{
					foundMatch = true;
					break;
				}
		}
		return tempObj;
	}
	
	public void visit(SimpleDesignatorWithoutNamespace designator)
	{
		Obj obj = Tab.find(designator.getId());
		if(obj==Tab.noObj)
		{
			obj = checkIfExistsWithNamespace(designator.getId());
		}
		if(obj==Tab.noObj)
		{
			// try to find the variable inside the namespaces
			//

			
			report_error(error+"Variable " + designator.getId() + " is not declared", designator);
			return;
		}
		designator.obj = obj;
		if(designator.obj.getLevel()==1)
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
	
	// --------------------------------- Expressions --------------------------
	//
	public void visit(Expr expr)
	{
		expr.struct=expr.getTerm_list().struct;
		
	}
	
	public void visit(AddExpr aexpr)
	{
		// Check if types are INT to proceed
		//
		if(aexpr.getTerm_list().struct != Tab.intType || aexpr.getTerm().struct!=Tab.intType)
		{
			aexpr.struct=Tab.noType;
			report_error(error+"Expression that is included in sub/add operations is not of type int", aexpr);
			return;
		}
		aexpr.struct=Tab.intType;
	}
	
	public void visit(TermExpr te)
	{
		te.struct=te.getTerm().struct;
	}
	
	public void visit (NegExpr nexpr)
	{
		// can only negate int values
		//
		if(nexpr.getTerm().struct!=Tab.intType)
		{
			report_error(error+"You cant negate value that is not int type", nexpr);
			nexpr.struct=Tab.noType;
			return;
		}
		nexpr.struct=nexpr.getTerm().struct;
		
	}
	
	public void visit(Term t)
	{
		t.struct=t.getFactor_list().struct;
	}
	
	// --------------------------------- FactorList ---------------------------
	//
	public void visit(MulopFactor mf)
	{
		// Check if factor on the right side is type of INT
		//
		if(mf.getFactor().struct!=Tab.intType || mf.getFactor_list().struct!=Tab.intType)
		{
			mf.struct=Tab.noType;
			report_error(error+"Expression that is included in mul operations is not of type int", mf);
			return;
		}
		mf.struct=Tab.intType;
	}
	
	public void visit(SimpleFactor sf)
	{
		sf.struct=sf.getFactor().struct;
	}
	
	// --------------------------------- Factor -------------------------------
	//
	public void visit(IntRef intr)
	{
		intr.struct=Tab.intType;
	}
	
	public void visit(BoolRef boolr)
	{
		boolr.struct = boolType;
	}
	
	public void visit(CharRef charr)
	{
		charr.struct=Tab.charType;
	}
	
	public void visit(VarRef varr)
	{
		varr.struct=varr.getDesignator().obj.getType();
	}
	
	public void visit(ParenthesisExpr pe)
	{
		pe.struct=pe.getExpr().struct;
	}
	
	public void visit(OperatorNew on)
	{
		// Check if expression is valid 
		//
		if(on.getExpr().struct!=Tab.intType)
		{
			on.struct=Tab.noType;
			report_error("Expression for accessing array element is not in valid format, must be int", on);
			return;
		}
		on.struct = makeStruct(Struct.Array, lastType);
	}
	
	public boolean passed() {
		return !errorDetected;
	}
}

