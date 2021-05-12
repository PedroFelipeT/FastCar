package br.com.equipe.fastcar.classes;

public class Conta {
    private String login;
    private String senha;
    private int acesso;
    private int cod_funcionario;
    
    public Conta(){
        
    }

    public Conta(String login, String senha, int acesso, int cod_funcionario) {
        this.login = login;
        this.senha = senha;
        this.acesso = acesso;
        this.cod_funcionario = cod_funcionario;
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }
    
    
}
