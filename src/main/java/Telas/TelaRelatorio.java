/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Classes.Pessoa;
import Classes.Utils;
import DAO.DAO;
import java.util.List;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 *
 * @author toshi
 */
public class TelaRelatorio extends javax.swing.JFrame {
private List <Pessoa> pessoas;
    /**
     * Creates new form TelaRelatorio
     */
    public TelaRelatorio() {
        super ("Tela Relatório");
        initComponents();
        setLocationRelativeTo(null);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabelRelatorio = new javax.swing.JLabel();
        jTextFieldDtInicio = new javax.swing.JTextField();
        jTextFieldDtFinal = new javax.swing.JTextField();
        jButtonGerarRelatorio = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 132, 202));

        jLabelRelatorio.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRelatorio.setText("Relatório");

        jTextFieldDtInicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de Início"));

        jTextFieldDtFinal.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Final"));

        jButtonGerarRelatorio.setText("Gerar Relatório");
        jButtonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatorioActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jTextFieldDtInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDtFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        TelaAdmin telaAdmin = new TelaAdmin();
        telaAdmin.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioActionPerformed
        if (jTextFieldDtInicio.getText() == null || jTextFieldDtInicio.getText().length() == 0 
            || jTextFieldDtFinal.getText() == null || jTextFieldDtFinal.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Preencha a data inicial e a data final");
        }
        else{
            String dtIni = jTextFieldDtInicio.getText();
            String dtFin = jTextFieldDtFinal.getText();
            try{
                DAO dao = new DAO();
                pessoas = dao.buscarVacinacao(dtIni, dtFin);
                long diff = Utils.converter(dtIni).getTime() - Utils.converter(dtFin).getTime();
                int diffInDays = (int) (( diff ) / (1000 * 60 * 60 * 24)) * -1;
                int rel1 = 0;
                int rel2 = 0;
                int rel3 = 0;
                int rel4 = 0;

                for (Pessoa p:pessoas){
                    if (p.getIdade() >= 90)
                        rel1++;
                    else if(p.getIdade() >= 70 && p.getIdade() < 90)
                        rel2++;
                    else if(p.getIdade() >= 50 && p.getIdade() < 70)
                        rel3++;
                    else
                        rel4++;
                }

                double media1 = (double) rel1 / diffInDays;
                double media2 = (double) rel2 / diffInDays;
                double media3 = (double) rel3 / diffInDays;
                double media4 = (double) rel4 / diffInDays; 

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                String r1 = "Idade >= 90";
                String r2 = "70 <= Idade < 90";
                String r3 = "50 <= Idade < 70";
                String r4 = "Idade < 50";
                dataset.addValue(media1, r1, "Idade >= 90");
                dataset.addValue(media2, r2, "70 <= Idade < 90");
                dataset.addValue(media3, r3, "50 <= Idade < 70");
                dataset.addValue(media4, r4, "Idade < 50");

                JFreeChart chart = ChartFactory.createBarChart("Relatório de Média de Vacinação","Dia " + dtIni + " até " +dtFin, "pessoas/dia", dataset);
                BarRenderer renderer = null;
                renderer = new BarRenderer();
                ChartFrame frame = new ChartFrame("Relatório", chart);
                frame.setVisible(true);
                frame.setSize(400, 650);

            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao gerar relatório, tente novamente.");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonGerarRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelRelatorio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextFieldDtFinal;
    private javax.swing.JTextField jTextFieldDtInicio;
    // End of variables declaration//GEN-END:variables
}
