// generated with ast extension for cup
// version 0.8
// 28/0/2024 20:13:24


package rs.ac.bg.etf.pp1.ast;

public class Namespace implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Namespace_name namespace_name;
    private NamespaceContent namespaceContent;

    public Namespace (Namespace_name namespace_name, NamespaceContent namespaceContent) {
        this.namespace_name=namespace_name;
        if(namespace_name!=null) namespace_name.setParent(this);
        this.namespaceContent=namespaceContent;
        if(namespaceContent!=null) namespaceContent.setParent(this);
    }

    public Namespace_name getNamespace_name() {
        return namespace_name;
    }

    public void setNamespace_name(Namespace_name namespace_name) {
        this.namespace_name=namespace_name;
    }

    public NamespaceContent getNamespaceContent() {
        return namespaceContent;
    }

    public void setNamespaceContent(NamespaceContent namespaceContent) {
        this.namespaceContent=namespaceContent;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(namespace_name!=null) namespace_name.accept(visitor);
        if(namespaceContent!=null) namespaceContent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(namespace_name!=null) namespace_name.traverseTopDown(visitor);
        if(namespaceContent!=null) namespaceContent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(namespace_name!=null) namespace_name.traverseBottomUp(visitor);
        if(namespaceContent!=null) namespaceContent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Namespace(\n");

        if(namespace_name!=null)
            buffer.append(namespace_name.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(namespaceContent!=null)
            buffer.append(namespaceContent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Namespace]");
        return buffer.toString();
    }
}
