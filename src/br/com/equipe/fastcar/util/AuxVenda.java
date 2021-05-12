
package br.com.equipe.fastcar.util;

public class AuxVenda {
    private String nomeCliente;
    private double valorTotal;
    private int num_venda;
    
    public AuxVenda(){
        
    }

    public AuxVenda(String nomeCliente, double valorTotal,int num_venda) {
        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
        this.num_venda = num_venda;
    }

    public int getNum_venda() {
        return num_venda;
    }

    public void setNum_venda(int num_venda) {
        this.num_venda = num_venda;
    }
    
    
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
      
    
    
}
