// generated with ast extension for cup
// version 0.8
// 28/8/2023 15:34:20


package rs.ac.bg.etf.pp1.ast;

public class ReturnNull extends Statement {

    public ReturnNull () {
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
        buffer.append("ReturnNull(\n");

        buffer.append(tab);
        buffer.append(") [ReturnNull]");
        return buffer.toString();
    }
}
