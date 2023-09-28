// generated with ast extension for cup
// version 0.8
// 28/8/2023 15:34:20


package rs.ac.bg.etf.pp1.ast;

public class Statements extends Statements_list {

    private Statements_list statements_list;
    private Statement statement;

    public Statements (Statements_list statements_list, Statement statement) {
        this.statements_list=statements_list;
        if(statements_list!=null) statements_list.setParent(this);
        this.statement=statement;
        if(statement!=null) statement.setParent(this);
    }

    public Statements_list getStatements_list() {
        return statements_list;
    }

    public void setStatements_list(Statements_list statements_list) {
        this.statements_list=statements_list;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement=statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(statements_list!=null) statements_list.accept(visitor);
        if(statement!=null) statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(statements_list!=null) statements_list.traverseTopDown(visitor);
        if(statement!=null) statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(statements_list!=null) statements_list.traverseBottomUp(visitor);
        if(statement!=null) statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statements(\n");

        if(statements_list!=null)
            buffer.append(statements_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statement!=null)
            buffer.append(statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statements]");
        return buffer.toString();
    }
}
