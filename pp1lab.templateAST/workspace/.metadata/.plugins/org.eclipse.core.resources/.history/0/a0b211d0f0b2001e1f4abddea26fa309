// generated with ast extension for cup
// version 0.8
// 10/9/2023 13:15:9


package rs.ac.bg.etf.pp1.ast;

public class Declarations extends Declaration_list {

    private Declaration_list declaration_list;
    private Declaration_part declaration_part;

    public Declarations (Declaration_list declaration_list, Declaration_part declaration_part) {
        this.declaration_list=declaration_list;
        if(declaration_list!=null) declaration_list.setParent(this);
        this.declaration_part=declaration_part;
        if(declaration_part!=null) declaration_part.setParent(this);
    }

    public Declaration_list getDeclaration_list() {
        return declaration_list;
    }

    public void setDeclaration_list(Declaration_list declaration_list) {
        this.declaration_list=declaration_list;
    }

    public Declaration_part getDeclaration_part() {
        return declaration_part;
    }

    public void setDeclaration_part(Declaration_part declaration_part) {
        this.declaration_part=declaration_part;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(declaration_list!=null) declaration_list.accept(visitor);
        if(declaration_part!=null) declaration_part.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(declaration_list!=null) declaration_list.traverseTopDown(visitor);
        if(declaration_part!=null) declaration_part.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(declaration_list!=null) declaration_list.traverseBottomUp(visitor);
        if(declaration_part!=null) declaration_part.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Declarations(\n");

        if(declaration_list!=null)
            buffer.append(declaration_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(declaration_part!=null)
            buffer.append(declaration_part.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Declarations]");
        return buffer.toString();
    }
}
