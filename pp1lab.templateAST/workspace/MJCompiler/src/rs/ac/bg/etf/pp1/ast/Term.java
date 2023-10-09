// generated with ast extension for cup
// version 0.8
// 9/9/2023 12:57:22


package rs.ac.bg.etf.pp1.ast;

public class Term implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private Factor_list factor_list;

    public Term (Factor_list factor_list) {
        this.factor_list=factor_list;
        if(factor_list!=null) factor_list.setParent(this);
    }

    public Factor_list getFactor_list() {
        return factor_list;
    }

    public void setFactor_list(Factor_list factor_list) {
        this.factor_list=factor_list;
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
        if(factor_list!=null) factor_list.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(factor_list!=null) factor_list.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(factor_list!=null) factor_list.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Term(\n");

        if(factor_list!=null)
            buffer.append(factor_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Term]");
        return buffer.toString();
    }
}
