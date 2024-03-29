// generated with ast extension for cup
// version 0.8
// 5/1/2024 13:8:54


package rs.ac.bg.etf.pp1.ast;

public class PluralConstIdList extends Const_decl_list {

    private Const_decl_list const_decl_list;
    private Const_declaration_part const_declaration_part;

    public PluralConstIdList (Const_decl_list const_decl_list, Const_declaration_part const_declaration_part) {
        this.const_decl_list=const_decl_list;
        if(const_decl_list!=null) const_decl_list.setParent(this);
        this.const_declaration_part=const_declaration_part;
        if(const_declaration_part!=null) const_declaration_part.setParent(this);
    }

    public Const_decl_list getConst_decl_list() {
        return const_decl_list;
    }

    public void setConst_decl_list(Const_decl_list const_decl_list) {
        this.const_decl_list=const_decl_list;
    }

    public Const_declaration_part getConst_declaration_part() {
        return const_declaration_part;
    }

    public void setConst_declaration_part(Const_declaration_part const_declaration_part) {
        this.const_declaration_part=const_declaration_part;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(const_decl_list!=null) const_decl_list.accept(visitor);
        if(const_declaration_part!=null) const_declaration_part.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(const_decl_list!=null) const_decl_list.traverseTopDown(visitor);
        if(const_declaration_part!=null) const_declaration_part.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(const_decl_list!=null) const_decl_list.traverseBottomUp(visitor);
        if(const_declaration_part!=null) const_declaration_part.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PluralConstIdList(\n");

        if(const_decl_list!=null)
            buffer.append(const_decl_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(const_declaration_part!=null)
            buffer.append(const_declaration_part.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PluralConstIdList]");
        return buffer.toString();
    }
}
