
package br.com.equipe.fastcar.classes;


public class Tmo {
    private String codigo;
    private double valorHora;
    private String descricao;
    
    public Tmo(){
        
    }
    public Tmo(String codigo, double valorHora, String descricao) {
        this.codigo = codigo;
        this.valorHora = valorHora;
        this.descricao = descricao;
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getDescricao(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
