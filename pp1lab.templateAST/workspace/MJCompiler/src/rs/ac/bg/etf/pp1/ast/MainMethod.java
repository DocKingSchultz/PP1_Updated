// generated with ast extension for cup
// version 0.8
// 14/0/2024 17:6:47


package rs.ac.bg.etf.pp1.ast;

public class MainMethod extends Method_dec {

    private Main main;
    private Main_variables main_variables;
    private Statements_list statements_list;

    public MainMethod (Main main, Main_variables main_variables, Statements_list statements_list) {
        this.main=main;
        if(main!=null) main.setParent(this);
        this.main_variables=main_variables;
        if(main_variables!=null) main_variables.setParent(this);
        this.statements_list=statements_list;
        if(statements_list!=null) statements_list.setParent(this);
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main=main;
    }

    public Main_variables getMain_variables() {
        return main_variables;
    }

    public void setMain_variables(Main_variables main_variables) {
        this.main_variables=main_variables;
    }

    public Statements_list getStatements_list() {
        return statements_list;
    }

    public void setStatements_list(Statements_list statements_list) {
        this.statements_list=statements_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(main!=null) main.accept(visitor);
        if(main_variables!=null) main_variables.accept(visitor);
        if(statements_list!=null) statements_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(main!=null) main.traverseTopDown(visitor);
        if(main_variables!=null) main_variables.traverseTopDown(visitor);
        if(statements_list!=null) statements_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(main!=null) main.traverseBottomUp(visitor);
        if(main_variables!=null) main_variables.traverseBottomUp(visitor);
        if(statements_list!=null) statements_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MainMethod(\n");

        if(main!=null)
            buffer.append(main.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(main_variables!=null)
            buffer.append(main_variables.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statements_list!=null)
            buffer.append(statements_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MainMethod]");
        return buffer.toString();
    }
}
