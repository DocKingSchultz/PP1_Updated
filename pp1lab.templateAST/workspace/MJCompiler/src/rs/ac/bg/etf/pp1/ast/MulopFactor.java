// generated with ast extension for cup
// version 0.8
// 5/1/2024 13:8:54


package rs.ac.bg.etf.pp1.ast;

public class MulopFactor extends Factor_list {

    private Factor_list factor_list;
    private Mull_div_mod_OP mull_div_mod_OP;
    private Factor factor;

    public MulopFactor (Factor_list factor_list, Mull_div_mod_OP mull_div_mod_OP, Factor factor) {
        this.factor_list=factor_list;
        if(factor_list!=null) factor_list.setParent(this);
        this.mull_div_mod_OP=mull_div_mod_OP;
        if(mull_div_mod_OP!=null) mull_div_mod_OP.setParent(this);
        this.factor=factor;
        if(factor!=null) factor.setParent(this);
    }

    public Factor_list getFactor_list() {
        return factor_list;
    }

    public void setFactor_list(Factor_list factor_list) {
        this.factor_list=factor_list;
    }

    public Mull_div_mod_OP getMull_div_mod_OP() {
        return mull_div_mod_OP;
    }

    public void setMull_div_mod_OP(Mull_div_mod_OP mull_div_mod_OP) {
        this.mull_div_mod_OP=mull_div_mod_OP;
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor=factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(factor_list!=null) factor_list.accept(visitor);
        if(mull_div_mod_OP!=null) mull_div_mod_OP.accept(visitor);
        if(factor!=null) factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(factor_list!=null) factor_list.traverseTopDown(visitor);
        if(mull_div_mod_OP!=null) mull_div_mod_OP.traverseTopDown(visitor);
        if(factor!=null) factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(factor_list!=null) factor_list.traverseBottomUp(visitor);
        if(mull_div_mod_OP!=null) mull_div_mod_OP.traverseBottomUp(visitor);
        if(factor!=null) factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopFactor(\n");

        if(factor_list!=null)
            buffer.append(factor_list.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(mull_div_mod_OP!=null)
            buffer.append(mull_div_mod_OP.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(factor!=null)
            buffer.append(factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopFactor]");
        return buffer.toString();
    }
}
