// generated with ast extension for cup
// version 0.8
// 14/0/2024 17:6:47


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Statement statement);
    public void visit(Var_list var_list);
    public void visit(Factor_list factor_list);
    public void visit(Const_decl_list const_decl_list);
    public void visit(NamespaceContent namespaceContent);
    public void visit(Statements_list statements_list);
    public void visit(Main_variables main_variables);
    public void visit(Main main);
    public void visit(Mull_div_mod_OP mull_div_mod_OP);
    public void visit(Declaration_part declaration_part);
    public void visit(Ident_expr_list ident_expr_list);
    public void visit(Ident_namespace_expr_list ident_namespace_expr_list);
    public void visit(Declaration_list declaration_list);
    public void visit(Factor factor);
    public void visit(Const_declaration_part const_declaration_part);
    public void visit(Term_list term_list);
    public void visit(Assign assign);
    public void visit(Designator_statement designator_statement);
    public void visit(Add_sub_OP add_sub_OP);
    public void visit(Namespace_list namespace_list);
    public void visit(Const_to_print const_to_print);
    public void visit(Method_dec method_dec);
    public void visit(Var_part var_part);
    public void visit(Namespace_name namespace_name);
    public void visit(ModOP ModOP);
    public void visit(DivOP DivOP);
    public void visit(MullOP MullOP);
    public void visit(MinusOP MinusOP);
    public void visit(PlusOP PlusOP);
    public void visit(ParenthesisExpr ParenthesisExpr);
    public void visit(OperatorNew OperatorNew);
    public void visit(BoolRef BoolRef);
    public void visit(CharRef CharRef);
    public void visit(IntRef IntRef);
    public void visit(VarRef VarRef);
    public void visit(SimpleFactor SimpleFactor);
    public void visit(MulopFactor MulopFactor);
    public void visit(Term Term);
    public void visit(NegExpr NegExpr);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(Expr Expr);
    public void visit(SimpleDesignator SimpleDesignator);
    public void visit(ArrayDesignator ArrayDesignator);
    public void visit(NoNamespaceDeisgnator NoNamespaceDeisgnator);
    public void visit(NamespaceDesignator NamespaceDesignator);
    public void visit(Designator Designator);
    public void visit(Decrement Decrement);
    public void visit(Increment Increment);
    public void visit(Assignment Assignment);
    public void visit(NoConstToPrint NoConstToPrint);
    public void visit(ConstToPrint ConstToPrint);
    public void visit(StatementDerived1 StatementDerived1);
    public void visit(ReturnNull ReturnNull);
    public void visit(Read Read);
    public void visit(Print Print);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(NoStatements NoStatements);
    public void visit(Statements Statements);
    public void visit(NoMainVariables NoMainVariables);
    public void visit(MainVariables MainVariables);
    public void visit(MainIdent MainIdent);
    public void visit(MainMethod MainMethod);
    public void visit(VarOrArrayId VarOrArrayId);
    public void visit(VarId VarId);
    public void visit(SingleVarIdList SingleVarIdList);
    public void visit(MultipleVarIdList MultipleVarIdList);
    public void visit(Var_dec Var_dec);
    public void visit(ConstIdChar ConstIdChar);
    public void visit(ConstIdBool ConstIdBool);
    public void visit(ConstIdInt ConstIdInt);
    public void visit(SingleConstDeclarationPart SingleConstDeclarationPart);
    public void visit(PluralConstIdList PluralConstIdList);
    public void visit(Type Type);
    public void visit(Const_dec Const_dec);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(NoDeclarations NoDeclarations);
    public void visit(Declarations Declarations);
    public void visit(NamespaceDeclarations NamespaceDeclarations);
    public void visit(NamespaceName NamespaceName);
    public void visit(Namespace Namespace);
    public void visit(NoNamespace NoNamespace);
    public void visit(Namespaces Namespaces);
    public void visit(Prog_id Prog_id);
    public void visit(Program Program);

}
