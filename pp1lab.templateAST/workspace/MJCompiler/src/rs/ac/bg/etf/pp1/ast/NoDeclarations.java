// generated with ast extension for cup
// version 0.8
// 27/0/2024 18:23:54


package rs.ac.bg.etf.pp1.ast;

public class NoDeclarations extends Declaration_list {

    public NoDeclarations () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoDeclarations(\n");

        buffer.append(tab);
        buffer.append(") [NoDeclarations]");
        return buffer.toString();
    }
}
