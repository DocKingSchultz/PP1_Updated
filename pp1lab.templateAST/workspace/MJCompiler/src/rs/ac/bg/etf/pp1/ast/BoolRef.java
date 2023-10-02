// generated with ast extension for cup
// version 0.8
// 2/9/2023 16:31:4


package rs.ac.bg.etf.pp1.ast;

public class BoolRef extends Factor {

    private Boolean b;

    public BoolRef (Boolean b) {
        this.b=b;
    }

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b=b;
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
        buffer.append("BoolRef(\n");

        buffer.append(" "+tab+b);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolRef]");
        return buffer.toString();
    }
}
