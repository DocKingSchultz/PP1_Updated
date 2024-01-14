// generated with ast extension for cup
// version 0.8
// 14/0/2024 17:6:47


package rs.ac.bg.etf.pp1.ast;

public class MainVariables extends Main_variables {

    private Main_variables main_variables;
    private Var_dec var_dec;

    public MainVariables (Main_variables main_variables, Var_dec var_dec) {
        this.main_variables=main_variables;
        if(main_variables!=null) main_variables.setParent(this);
        this.var_dec=var_dec;
        if(var_dec!=null) var_dec.setParent(this);
    }

    public Main_variables getMain_variables() {
        return main_variables;
    }

    public void setMain_variables(Main_variables main_variables) {
        this.main_variables=main_variables;
    }

    public Var_dec getVar_dec() {
        return var_dec;
    }

    public void setVar_dec(Var_dec var_dec) {
        this.var_dec=var_dec;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(main_variables!=null) main_variables.accept(visitor);
        if(var_dec!=null) var_dec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(main_variables!=null) main_variables.traverseTopDown(visitor);
        if(var_dec!=null) var_dec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(main_variables!=null) main_variables.traverseBottomUp(visitor);
        if(var_dec!=null) var_dec.traverseBottomUp(visitor);
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

        if(var_dec!=null)
            buffer.append(var_dec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MainVariables]");
        return buffer.toString();
    }
}
