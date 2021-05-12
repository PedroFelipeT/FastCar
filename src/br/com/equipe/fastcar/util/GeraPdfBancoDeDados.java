package br.com.equipe.fastcar.util;

import br.com.equipe.fastcar.connection.ArquivoTxt;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeraPdfBancoDeDados {

    public void gerarPdf(String nome, String cpf, Double valorCompra) {
        String teste;
        ArquivoTxt arquivo = new ArquivoTxt();

        Document documentoPdf = new Document(PageSize.A4, 72, 72, 72, 72);
        try {
            teste = arquivo.LerArquivo("VendasTemp.txt");
            String[] testando = teste.split("_");
            String[] testando2 = teste.split(";");
            PdfWriter.getInstance(documentoPdf, new FileOutputStream("CupomFiscal " + nome + " .pdf", false));
            documentoPdf.open();

            Font f = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
            Paragraph empresa = new Paragraph("---- FASTCAR ----\nContato: 4002-8922\n" + new GregorianCalendar().getTime() + "\n---- Cupom Fiscal ----");
            empresa.setAlignment(Element.ALIGN_CENTER);
            documentoPdf.add(empresa);
            Paragraph p = new Paragraph("Nome:" + nome);
            documentoPdf.add(p);
            Paragraph p2 = new Paragraph("CPF:" + cpf);
            documentoPdf.add(p2);
            Paragraph p3 = new Paragraph("Lista de produtos:\n-----------------------");
            documentoPdf.add(p3);
            Paragraph p5 = new Paragraph("\n");
            documentoPdf.add(p5);
            //Escreve os produtos
            String[] atributo;
            for (String produto : testando2) {

                atributo = produto.split("_");

                documentoPdf.add(new Paragraph("Nome: " + atributo[0] + "\n  Referencia: " + atributo[1] + "  Quantidade: " + atributo[2]
                        + "  Valor Unitario: " + atributo[3] + "  Valor total: " + atributo[4]));

                atributo = null;
            }

            Paragraph p4 = new Paragraph("\nValor total da compra: " + new java.text.DecimalFormat("0.00").format(valorCompra));
            documentoPdf.add(p4);

            //Fecha o arquivo
            documentoPdf.close();
        } catch (FileNotFoundException | DocumentException ex) {
            System.out.println("Erro: " + ex);
        } catch (IOException ex) {
            Logger.getLogger(GeraPdfBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}//Fim da classe
