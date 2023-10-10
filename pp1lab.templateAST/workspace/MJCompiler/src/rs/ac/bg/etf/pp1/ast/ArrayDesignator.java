// generated with ast extension for cup
// version 0.8
// 10/9/2023 13:15:9


package rs.ac.bg.etf.pp1.ast;

public class ArrayDesignator extends Ident_expr_list {

    private Ident_expr_list ident_expr_list;
    private Expr expr;

    public ArrayDesignator (Ident_expr_list ident_expr_list, Expr expr) {
        this.ident_expr_list=ident_expr_list;
        if(ident_expr_list!=null) ident_expr_list.setParent(this);
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
    }

    public Ident_expr_list getIdent_expr_list() {
        return ident_expr_list;
    }

    public void setIdent_expr_list(Ident_expr_list ident_expr_list) {
        this.ident_expr_list=ident_expr_list;
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
        if(ident_expr_list!=null) ident_expr_list.accept(visitor);
        if(expr!=null) expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ident_expr_list!=null) ident_expr_list.traverseTopDown(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ident_expr_list!=null) ident_expr_list.traverseBottomUp(visitor);
        if(expr!=null) expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayDesignator(\n");

        if(ident_expr_list!=null)
            buffer.append(ident_expr_list.toString("  "+tab));
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
