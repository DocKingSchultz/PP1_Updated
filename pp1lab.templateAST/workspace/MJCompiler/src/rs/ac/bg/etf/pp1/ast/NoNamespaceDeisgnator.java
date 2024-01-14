// generated with ast extension for cup
// version 0.8
// 14/0/2024 17:6:47


package rs.ac.bg.etf.pp1.ast;

public class NoNamespaceDeisgnator extends Ident_namespace_expr_list {

    private Ident_expr_list ident_expr_list;

    public NoNamespaceDeisgnator (Ident_expr_list ident_expr_list) {
        this.ident_expr_list=ident_expr_list;
        if(ident_expr_list!=null) ident_expr_list.setParent(this);
    }

    public Ident_expr_list getIdent_expr_list() {
        return ident_expr_list;
    }

    public void setIdent_expr_list(Ident_expr_list ident_expr_list) {
        this.ident_expr_list=ident_expr_list;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ident_expr_list!=null) ident_expr_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ident_expr_list!=null) ident_expr_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ident_expr_list!=null) ident_expr_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoNamespaceDeisgnator(\n");

        if(ident_expr_list!=null)
            buffer.append(ident_expr_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoNamespaceDeisgnator]");
        return buffer.toString();
    }
}
