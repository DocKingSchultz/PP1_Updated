// generated with ast extension for cup
// version 0.8
// 29/0/2024 13:23:27


package rs.ac.bg.etf.pp1.ast;

public class FindAnyStatement extends Designator_statement {

    private Designator designator;
    private Designator designator1;
    private Expr expr;

    public FindAnyStatement (Designator designator, Designator designator1, Expr expr) {
        this.designator=designator;
        if(designator!=null) designator.setParent(this);
        this.designator1=designator1;
        if(designator1!=null) designator1.setParent(this);
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
    }

    public Designator getDesignator() {
        return designator;
    }

    public void setDesignator(Designator designator) {
        this.designator=designator;
    }

    public Designator getDesignator1() {
        return designator1;
    }

    public void setDesignator1(Designator designator1) {
        this.designator1=designator1;
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
        if(designator!=null) designator.accept(visitor);
        if(designator1!=null) designator1.accept(visitor);
        if(expr!=null) expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(designator!=null) designator.traverseTopDown(visitor);
        if(designator1!=null) designator1.traverseTopDown(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(designator!=null) designator.traverseBottomUp(visitor);
        if(designator1!=null) designator1.traverseBottomUp(visitor);
        if(expr!=null) expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FindAnyStatement(\n");

        if(designator!=null)
            buffer.append(designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(designator1!=null)
            buffer.append(designator1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FindAnyStatement]");
        return buffer.toString();
    }
}
