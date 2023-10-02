// generated with ast extension for cup
// version 0.8
// 2/9/2023 16:31:4


package rs.ac.bg.etf.pp1.ast;

public class Method extends Method_dec {

    private String main;
    private Main_variables main_variables;
    private Statements_list statements_list;

    public Method (String main, Main_variables main_variables, Statements_list statements_list) {
        this.main=main;
        this.main_variables=main_variables;
        if(main_variables!=null) main_variables.setParent(this);
        this.statements_list=statements_list;
        if(statements_list!=null) statements_list.setParent(this);
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
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
        if(main_variables!=null) main_variables.accept(visitor);
        if(statements_list!=null) statements_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(main_variables!=null) main_variables.traverseTopDown(visitor);
        if(statements_list!=null) statements_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(main_variables!=null) main_variables.traverseBottomUp(visitor);
        if(statements_list!=null) statements_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Method(\n");

        buffer.append(" "+tab+main);
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
        buffer.append(") [Method]");
        return buffer.toString();
    }
}
