package br.com.equipe.fastcar.util;

public class AuxOsValores {

    private int idMecanico;
    private int idAtendente;
    private int idVeiculo;
    private String codigoTmo;
    private String reclamacao;
    private String diagnostico;
    private double valor_total;
    private String placa;

    public AuxOsValores() {
    }

    public AuxOsValores(int idMecanico, int idAtendente, int idVeiculo, String codigoTmo, String reclamacao, String diagnostico, double valor_total,String placa) {
        this.idMecanico = idMecanico;
        this.idAtendente = idAtendente;
        this.idVeiculo = idVeiculo;
        this.codigoTmo = codigoTmo;
        this.reclamacao = reclamacao;
        this.diagnostico = diagnostico;
        this.valor_total = valor_total;
        this.placa = placa;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public int getIdAtendente() {
        return idAtendente;
    }

    public void setIdAtendente(int idAtendente) {
        this.idAtendente = idAtendente;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getCodigoTmo() {
        return codigoTmo;
    }

    public void setCodigoTmo(String codigoTmo) {
        this.codigoTmo = codigoTmo;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
