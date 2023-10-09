// generated with ast extension for cup
// version 0.8
// 9/9/2023 16:7:45


package rs.ac.bg.etf.pp1.ast;

public class ConstIdChar extends Const_declaration_part {

    private String id;
    private Character value;

    public ConstIdChar (String id, Character value) {
        this.id=id;
        this.value=value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
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
        buffer.append("ConstIdChar(\n");

        buffer.append(" "+tab+id);
        buffer.append("\n");

        buffer.append(" "+tab+value);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstIdChar]");
        return buffer.toString();
    }
}
