
package br.com.equipe.fastcar.classes;

public class Funcionario extends Pessoa {
    private int codDepto;
    private int codigo;
    
    public Funcionario(){
        
    }

    public Funcionario(int codDepto, int codigo, String nome, String cpf, String endereco, String cidade, String telefone, String email) {
        super(nome, cpf, endereco, cidade, telefone, email);
        this.codDepto = codDepto;
        this.codigo = codigo;
    }

    

    public int getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(int codDepto) {
        this.codDepto = codDepto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
