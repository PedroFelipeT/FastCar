/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.equipe.fastcar.front;

import br.com.equipe.fastcar.classes.Conta;
import br.com.equipe.fastcar.util.AuxControle;

/**
 *
 * @author Pedro
 */
public class FuncoesRelatorios extends javax.swing.JFrame {

    AuxControle auxControle = new AuxControle();
    Conta conta = new Conta();
    public FuncoesRelatorios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bntRelatorioVenda = new javax.swing.JButton();
        btnRelatorioVendaT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        btnOsRelatorio = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(802, 630));
        setMinimumSize(new java.awt.Dimension(802, 630));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(508, 150));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equipe/fastcar/icons/FastCarlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel3)
                .addGap(298, 298, 298))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 802, 150);

        bntRelatorioVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equipe/fastcar/icons/RelatorioVendaicon.png"))); // NOI18N
        bntRelatorioVenda.setEnabled(false);
        bntRelatorioVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntRelatorioVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRelatorioVendaActionPerformed(evt);
            }
        });
        jPanel1.add(bntRelatorioVenda);
        bntRelatorioVenda.setBounds(103, 349, 107, 83);

        btnRelatorioVendaT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equipe/fastcar/icons/VendaTotalRelaiodn.png"))); // NOI18N
        btnRelatorioVendaT.setEnabled(false);
        btnRelatorioVendaT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRelatorioVendaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioVendaTActionPerformed(evt);
            }
        });
        jPanel1.add(btnRelatorioVendaT);
        btnRelatorioVendaT.setBounds(570, 350, 107, 83);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatoiro Vendas");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 320, 130, 14);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Relatorio vendas C/Os");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(550, 320, 140, 14);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equipe/fastcar/icons/sair-menu-2.png"))); // NOI18N
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(681, 569, 71, 25);

        btnOsRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/equipe/fastcar/icons/OsRelatorioIcon.png"))); // NOI18N
        btnOsRelatorio.setEnabled(false);
        btnOsRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOsRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOsRelatorioActionPerformed(evt);
            }
        });
        jPanel1.add(btnOsRelatorio);
        btnOsRelatorio.setBounds(340, 350, 107, 83);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Relatorio OS");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(340, 320, 110, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bntRelatorioVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRelatorioVendaActionPerformed
        RelatorioVenda relatorio = new RelatorioVenda();
        relatorio.setVisible(true);
    }//GEN-LAST:event_bntRelatorioVendaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(conta.getAcesso() == 5){
            bntRelatorioVenda.setEnabled(true);
            btnRelatorioVendaT.setEnabled(true);
            btnOsRelatorio.setEnabled(true);
        }
        if(conta.getAcesso() == 2){
            bntRelatorioVenda.setEnabled(true);
            btnRelatorioVendaT.setEnabled(true);
            btnOsRelatorio.setEnabled(true);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnOsRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOsRelatorioActionPerformed
        RelatorioOs relatorioOs = new RelatorioOs();
        relatorioOs.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOsRelatorioActionPerformed

    private void btnRelatorioVendaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioVendaTActionPerformed
        RelatorioTotal relatorioTotal = new RelatorioTotal();
        relatorioTotal .setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRelatorioVendaTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FuncoesRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncoesRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncoesRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncoesRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncoesRelatorios().setVisible(true);
            }
        });
    }

    public void setConta(Conta c) {
        conta = c;
    }

    public void setAuxControle(AuxControle ac) {
        auxControle = ac;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntRelatorioVenda;
    private javax.swing.JButton btnOsRelatorio;
    private javax.swing.JButton btnRelatorioVendaT;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
