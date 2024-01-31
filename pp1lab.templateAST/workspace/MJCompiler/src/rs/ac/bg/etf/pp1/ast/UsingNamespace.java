// generated with ast extension for cup
// version 0.8
// 28/0/2024 20:13:24


package rs.ac.bg.etf.pp1.ast;

public class UsingNamespace extends Statement {

    private String namespace;

    public UsingNamespace (String namespace) {
        this.namespace=namespace;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace=namespace;
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
        buffer.append("UsingNamespace(\n");

        buffer.append(" "+tab+namespace);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UsingNamespace]");
        return buffer.toString();
    }
}
