// generated with ast extension for cup
// version 0.8
// 3/9/2023 18:22:25


package rs.ac.bg.etf.pp1.ast;

public class MainIdent extends Main {

    private String name_main;

    public MainIdent (String name_main) {
        this.name_main=name_main;
    }

    public String getName_main() {
        return name_main;
    }

    public void setName_main(String name_main) {
        this.name_main=name_main;
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
        buffer.append("MainIdent(\n");

        buffer.append(" "+tab+name_main);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MainIdent]");
        return buffer.toString();
    }
}
