// generated with ast extension for cup
// version 0.8
// 28/0/2024 20:13:24


package rs.ac.bg.etf.pp1.ast;

public class SimpleDesignatorWithNamespace extends Ident_expr_list {

    private String namespaceName;
    private String id;

    public SimpleDesignatorWithNamespace (String namespaceName, String id) {
        this.namespaceName=namespaceName;
        this.id=id;
    }

    public String getNamespaceName() {
        return namespaceName;
    }

    public void setNamespaceName(String namespaceName) {
        this.namespaceName=namespaceName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
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
        buffer.append("SimpleDesignatorWithNamespace(\n");

        buffer.append(" "+tab+namespaceName);
        buffer.append("\n");

        buffer.append(" "+tab+id);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SimpleDesignatorWithNamespace]");
        return buffer.toString();
    }
}
