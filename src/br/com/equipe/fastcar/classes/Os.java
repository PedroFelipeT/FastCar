
package br.com.equipe.fastcar.classes;


public class Os {
    private int id;
    private String diagnostico;
    private String reclamacao;
    private int cod_funcionario;
    private String cod_tmo;
    private int cod_veiculo;
    private double valor_total;

    public Os() {
    }

    public Os(int id, String diagnostico, String reclamacao, int cod_atendete, String cod_tmo, int cod_veiculo, double valor_total) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.reclamacao = reclamacao;
        this.cod_funcionario = cod_atendete;;
        this.cod_tmo = cod_tmo;
        this.cod_veiculo = cod_veiculo;
        this.valor_total = valor_total;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public int getCod_atendete() {
        return cod_funcionario;
    }

    public void setCod_atendete(int cod_atendete) {
        this.cod_funcionario = cod_atendete;
    }

    public String getCod_tmo() {
        return cod_tmo;
    }

    public void setCod_tmo(String cod_tmo) {
        this.cod_tmo = cod_tmo;
    }

    public int getCod_veiculo() {
        return cod_veiculo;
    }

    public void setCod_veiculo(int cod_veiculo) {
        this.cod_veiculo = cod_veiculo;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
}
