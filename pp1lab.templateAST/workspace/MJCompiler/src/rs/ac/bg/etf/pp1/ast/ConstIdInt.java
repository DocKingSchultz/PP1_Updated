// generated with ast extension for cup
// version 0.8
// 3/9/2023 18:22:25


package rs.ac.bg.etf.pp1.ast;

public class ConstIdInt extends Const_declaration_part {

    private String id;
    private Integer value;

    public ConstIdInt (String id, Integer value) {
        this.id=id;
        this.value=value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value=value;
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
        buffer.append("ConstIdInt(\n");

        buffer.append(" "+tab+id);
        buffer.append("\n");

        buffer.append(" "+tab+value);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstIdInt]");
        return buffer.toString();
    }
}
