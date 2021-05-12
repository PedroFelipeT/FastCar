package br.com.equipe.fastcar.connection;

import br.com.equipe.fastcar.classes.Cliente;
import br.com.equipe.fastcar.classes.Os;
import br.com.equipe.fastcar.classes.Peca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.round;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOException;

public class ArquivoTxt {

    File arquivo = new File("Vendas.txt");
    File arquivoCliente = new File("Cliente.txt");
    File temporarioVendas = new File("VendasTemp.txt");
    File osPt1 = new File("osPt1.txt");
    File osPt2 = new File("osPt2.txt");

    public void Escrever(Cliente c, ArrayList<Peca> pecas) {
        try {
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(c.getNome());
            bw.write("_");
            bw.write(c.getCpf());
            bw.write("_");
            bw.write(";");
            for (Peca p : pecas) {
                bw.write(p.getNome());
                bw.write("_");
                bw.write(Integer.toString(p.getReferencia()));
                bw.write("_");
                bw.write(Integer.toString(p.getQuantidade()));
                bw.write("_");
                bw.write(Double.toString(p.getValorDeVenda()));
                bw.write("_");
                bw.write(new DecimalFormat("0.00").format(p.getQuantidade() * p.getValorDeVenda()));
                bw.write(";");

            }

            bw.newLine();
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            System.out.println("Erro ao escrever no aquivo: " + ex);
        }

    }

    public void EscreverVendaTemp(Cliente c, ArrayList<Peca> pecas) {
        try {
            FileWriter fw = new FileWriter(temporarioVendas);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Peca p : pecas) {
                bw.write(p.getNome());
                bw.write("_");
                bw.write(Integer.toString(p.getReferencia()));
                bw.write("_");
                bw.write(Integer.toString(p.getQuantidade()));
                bw.write("_");
                bw.write(Double.toString(p.getValorDeVenda()));
                bw.write("_");
                bw.write(new DecimalFormat("0.00").format(p.getQuantidade() * p.getValorDeVenda()));
                bw.write(";");

            }

            bw.newLine();
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            System.out.println("Erro ao escrever no aquivo: " + ex);
        }

    }

    public void EscreverCliente(Cliente c) {
        try {
            FileWriter fw = new FileWriter(arquivoCliente, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(c.getNome());
            bw.write(",");
            bw.write(c.getCpf());
            bw.write(",");
            bw.write(c.getEndereco());
            bw.write(",");
            bw.write(c.getCidade());
            bw.write(",");
            bw.write(c.getTelefone());
            bw.write(",");
            bw.write(c.getEmail());
            bw.write(",");
            bw.newLine();
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            System.out.println("Erro ao escrever no aquivo: " + ex);
        }

    }

    public void EscreverOsPt1(String id, String reclamacao, String atendente, String tmo, String veiculo, String servico, String hora) {
        try {
            FileWriter fw = new FileWriter(osPt1, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(id);
            bw.write("_");
            bw.write(reclamacao);
            bw.write("_");
            bw.write(atendente);
            bw.write("_");
            bw.write(tmo);
            bw.write("_");
            bw.write(veiculo);
            bw.write("_");
            bw.write(servico);
            bw.write("_");
            bw.write(hora);
            bw.write("_");
            bw.newLine();
            bw.flush();
            bw.close();
            fw.close();

        } catch (IOException ex) {
            System.out.println("Erro ao escrever no aquivo: " + ex);
        }

    }

    public void EscreverOsPt2(String id, String diagnostico) {
        try {
            FileWriter fw = new FileWriter(osPt2, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(id);
            bw.write("_");
            bw.write(diagnostico);
            bw.write("_");
            bw.newLine();
            bw.flush();
            bw.close();
            fw.close();

        } catch (IOException ex) {
            System.out.println("Erro ao escrever no aquivo: " + ex);
        }

    }

    public static String LerArquivo(String caminho) throws IOException {
        String conteudo = "";

        try {
            FileReader fr = new FileReader(caminho);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            try {
                linha = br.readLine();
                while (linha != null) {
                    conteudo += linha;
                    linha = br.readLine();
                }
                br.close();
            } catch (IIOException x) {
                conteudo = "Erro: Não foi possivel ler o arquivo!";
            }
        } catch (FileNotFoundException ex) {
            conteudo = "Erro: Arquivo não encontrado!";
        }
        if (conteudo.contains("erro")) {
            return "";
        } else {
            return conteudo;
        }
    }
}
