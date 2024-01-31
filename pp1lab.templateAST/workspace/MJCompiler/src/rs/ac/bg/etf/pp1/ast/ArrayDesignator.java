// generated with ast extension for cup
// version 0.8
// 28/0/2024 20:13:24


package rs.ac.bg.etf.pp1.ast;

public class ArrayDesignator extends Ident_expr_list {

    private Array_delegator array_delegator;
    private Expr expr;

    public ArrayDesignator (Array_delegator array_delegator, Expr expr) {
        this.array_delegator=array_delegator;
        if(array_delegator!=null) array_delegator.setParent(this);
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
    }

    public Array_delegator getArray_delegator() {
        return array_delegator;
    }

    public void setArray_delegator(Array_delegator array_delegator) {
        this.array_delegator=array_delegator;
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
        if(array_delegator!=null) array_delegator.accept(visitor);
        if(expr!=null) expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(array_delegator!=null) array_delegator.traverseTopDown(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(array_delegator!=null) array_delegator.traverseBottomUp(visitor);
        if(expr!=null) expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayDesignator(\n");

        if(array_delegator!=null)
            buffer.append(array_delegator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayDesignator]");
        return buffer.toString();
    }
}
