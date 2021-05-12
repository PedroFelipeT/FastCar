
package br.com.equipe.fastcar.classes;

public class Cliente extends Pessoa {
    private int id;
    
    public Cliente(){
        
    }
    public Cliente(int id,String nome,String cpf,String endereco,String cidade,String telefone,String email){
        super(nome,cpf,endereco,cidade,telefone,email);
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
