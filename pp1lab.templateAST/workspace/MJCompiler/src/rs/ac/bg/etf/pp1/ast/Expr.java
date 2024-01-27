// generated with ast extension for cup
// version 0.8
// 27/0/2024 12:36:0


package rs.ac.bg.etf.pp1.ast;

public class Expr implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private Term_list term_list;

    public Expr (Term_list term_list) {
        this.term_list=term_list;
        if(term_list!=null) term_list.setParent(this);
    }

    public Term_list getTerm_list() {
        return term_list;
    }

    public void setTerm_list(Term_list term_list) {
        this.term_list=term_list;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(term_list!=null) term_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(term_list!=null) term_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(term_list!=null) term_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr(\n");

        if(term_list!=null)
            buffer.append(term_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr]");
        return buffer.toString();
    }
}
