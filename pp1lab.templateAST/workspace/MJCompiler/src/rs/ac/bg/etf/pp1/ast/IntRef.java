// generated with ast extension for cup
// version 0.8
// 10/9/2023 13:15:9


package rs.ac.bg.etf.pp1.ast;

public class IntRef extends Factor {

    private Integer i;

    public IntRef (Integer i) {
        this.i=i;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i=i;
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
        buffer.append("IntRef(\n");

        buffer.append(" "+tab+i);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IntRef]");
        return buffer.toString();
    }
}
