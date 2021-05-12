
package br.com.equipe.fastcar.classes;


public class Departamento {
    private int codigo;
    private String nomeDep;
    private double salario;
   
    public  Departamento(){
        
    }
    
    public  Departamento(int Codigo,String Nome,double Salario){
        this.codigo = Codigo;
        this.nomeDep = Nome;
        this.salario = Salario;

    }  
     public String getNomeDep() {
        return nomeDep;
    }

    public void setNomeDep(String nomeDep) {
        this.nomeDep = nomeDep;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nomeDep;
    }

    public void setNome(String nome) {
        this.nomeDep = nome;
    }

    @Override
    public String toString() {
        return getNomeDep(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
