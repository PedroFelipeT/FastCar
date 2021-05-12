
package br.com.equipe.fastcar.classes;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
    
    private int id_venda;
    private Date data_venda;
    private int id_cliente;
    private int cod_funcionario;
    private double valor_total;
    private int num_venda;


    ArrayList<Peca> dados = new ArrayList();

            
            
    public Venda(){
        
    }

    public Venda(int id_venda, Date data_venda, int id_cliente, int cod_funcionario,double valor_total,int num_venda) {
        this.id_venda = id_venda;
        this.data_venda = data_venda;
        this.id_cliente = id_cliente;
        this.cod_funcionario = cod_funcionario;
        this.valor_total = valor_total;
        this.num_venda = num_venda;
    }

    public int getNum_venda() {
        return num_venda;
    }

    public void setNum_venda(int num_venda) {
        this.num_venda = num_venda;
    }



    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public ArrayList<Peca> getDados() {
        return dados;
    }

    public void setDados(ArrayList<Peca> dados) {
        this.dados = dados;
    }
    
}
