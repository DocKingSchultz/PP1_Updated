// generated with ast extension for cup
// version 0.8
// 15/0/2024 16:25:16


package rs.ac.bg.etf.pp1.ast;

public class NoNamespace extends Namespace_list {

    public NoNamespace () {
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
        buffer.append("NoNamespace(\n");

        buffer.append(tab);
        buffer.append(") [NoNamespace]");
        return buffer.toString();
    }
}
