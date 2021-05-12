
package br.com.equipe.fastcar.classes;

public class Peca {
    private String nome;
    private int referencia;
    private String fornecedor;
    private int quantidade;
    private double valorDeCompra;
    private double valorDeVenda;
    
    
    public Peca(){
        
    }

    public Peca(String nome, int referencia, String fornecedor, int quantidade, double valorDeCompra, double valorDeVenda) {
        this.nome = nome;
        this.referencia = referencia;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.valorDeCompra = valorDeCompra;
        this.valorDeVenda = valorDeVenda;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(double valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public double getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(double valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }
}
