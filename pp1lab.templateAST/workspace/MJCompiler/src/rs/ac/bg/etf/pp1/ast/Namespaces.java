// generated with ast extension for cup
// version 0.8
// 14/0/2024 17:6:47


package rs.ac.bg.etf.pp1.ast;

public class Namespaces extends Namespace_list {

    private Namespace_list namespace_list;
    private Namespace namespace;

    public Namespaces (Namespace_list namespace_list, Namespace namespace) {
        this.namespace_list=namespace_list;
        if(namespace_list!=null) namespace_list.setParent(this);
        this.namespace=namespace;
        if(namespace!=null) namespace.setParent(this);
    }

    public Namespace_list getNamespace_list() {
        return namespace_list;
    }

    public void setNamespace_list(Namespace_list namespace_list) {
        this.namespace_list=namespace_list;
    }

    public Namespace getNamespace() {
        return namespace;
    }

    public void setNamespace(Namespace namespace) {
        this.namespace=namespace;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(namespace_list!=null) namespace_list.accept(visitor);
        if(namespace!=null) namespace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(namespace_list!=null) namespace_list.traverseTopDown(visitor);
        if(namespace!=null) namespace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(namespace_list!=null) namespace_list.traverseBottomUp(visitor);
        if(namespace!=null) namespace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Namespaces(\n");

        if(namespace_list!=null)
            buffer.append(namespace_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(namespace!=null)
            buffer.append(namespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Namespaces]");
        return buffer.toString();
    }
}