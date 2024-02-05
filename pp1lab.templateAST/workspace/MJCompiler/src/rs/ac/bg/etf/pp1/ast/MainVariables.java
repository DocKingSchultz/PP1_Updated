// generated with ast extension for cup
// version 0.8
// 5/1/2024 13:8:54


package rs.ac.bg.etf.pp1.ast;

public class MainVariables extends Main_variables {

    private Main_variables main_variables;
    private Var_decl var_decl;

    public MainVariables (Main_variables main_variables, Var_decl var_decl) {
        this.main_variables=main_variables;
        if(main_variables!=null) main_variables.setParent(this);
        this.var_decl=var_decl;
        if(var_decl!=null) var_decl.setParent(this);
    }

    public Main_variables getMain_variables() {
        return main_variables;
    }

    public void setMain_variables(Main_variables main_variables) {
        this.main_variables=main_variables;
    }

    public Var_decl getVar_decl() {
        return var_decl;
    }

    public void setVar_decl(Var_decl var_decl) {
        this.var_decl=var_decl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(main_variables!=null) main_variables.accept(visitor);
        if(var_decl!=null) var_decl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(main_variables!=null) main_variables.traverseTopDown(visitor);
        if(var_decl!=null) var_decl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(main_variables!=null) main_variables.traverseBottomUp(visitor);
        if(var_decl!=null) var_decl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MainVariables(\n");

        if(main_variables!=null)
            buffer.append(main_variables.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(var_decl!=null)
            buffer.append(var_decl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MainVariables]");
        return buffer.toString();
    }
}
