// generated with ast extension for cup
// version 0.8
// 28/0/2024 20:13:24


package rs.ac.bg.etf.pp1.ast;

public class ParenthesisExpr extends Factor {

    private Expr expr;

    public ParenthesisExpr (Expr expr) {
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr=expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(expr!=null) expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(expr!=null) expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ParenthesisExpr(\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ParenthesisExpr]");
        return buffer.toString();
    }
}
