// generated with ast extension for cup
// version 0.8
// 22/0/2024 17:10:42


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclarations extends Declaration_part {

    private Const_dec const_dec;

    public ConstDeclarations (Const_dec const_dec) {
        this.const_dec=const_dec;
        if(const_dec!=null) const_dec.setParent(this);
    }

    public Const_dec getConst_dec() {
        return const_dec;
    }

    public void setConst_dec(Const_dec const_dec) {
        this.const_dec=const_dec;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(const_dec!=null) const_dec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(const_dec!=null) const_dec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(const_dec!=null) const_dec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclarations(\n");

        if(const_dec!=null)
            buffer.append(const_dec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclarations]");
        return buffer.toString();
    }
}
