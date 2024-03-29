// generated with ast extension for cup
// version 0.8
// 5/1/2024 13:8:54


package rs.ac.bg.etf.pp1.ast;

public class AddExpr extends Term_list {

    private Term_list term_list;
    private Add_sub_OP add_sub_OP;
    private Term term;

    public AddExpr (Term_list term_list, Add_sub_OP add_sub_OP, Term term) {
        this.term_list=term_list;
        if(term_list!=null) term_list.setParent(this);
        this.add_sub_OP=add_sub_OP;
        if(add_sub_OP!=null) add_sub_OP.setParent(this);
        this.term=term;
        if(term!=null) term.setParent(this);
    }

    public Term_list getTerm_list() {
        return term_list;
    }

    public void setTerm_list(Term_list term_list) {
        this.term_list=term_list;
    }

    public Add_sub_OP getAdd_sub_OP() {
        return add_sub_OP;
    }

    public void setAdd_sub_OP(Add_sub_OP add_sub_OP) {
        this.add_sub_OP=add_sub_OP;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term=term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(term_list!=null) term_list.accept(visitor);
        if(add_sub_OP!=null) add_sub_OP.accept(visitor);
        if(term!=null) term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(term_list!=null) term_list.traverseTopDown(visitor);
        if(add_sub_OP!=null) add_sub_OP.traverseTopDown(visitor);
        if(term!=null) term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(term_list!=null) term_list.traverseBottomUp(visitor);
        if(add_sub_OP!=null) add_sub_OP.traverseBottomUp(visitor);
        if(term!=null) term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddExpr(\n");

        if(term_list!=null)
            buffer.append(term_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(add_sub_OP!=null)
            buffer.append(add_sub_OP.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(term!=null)
            buffer.append(term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddExpr]");
        return buffer.toString();
    }
}
