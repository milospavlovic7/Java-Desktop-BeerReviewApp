/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import thread.ThreadServer;
import java.sql.*;

/**
 *
 * @author USER
 */
public class ServerForm extends javax.swing.JFrame {

    
    /**
     * Creates new form ServerForm
     */
    private ThreadServer threadServer;

    public ServerForm() {
        initComponents();
        setLocationRelativeTo(null);
        lblServerStatus.setText("Server je ugasen!");
        btnPokreniServer.setEnabled(true);
        btnUgasiServer.setEnabled(false);
        setTitle("Serverska forma");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblServerStatus = new javax.swing.JLabel();
        btnPokreniServer = new javax.swing.JButton();
        btnUgasiServer = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miKonfiguracija = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblServerStatus.setText("Server status");

        btnPokreniServer.setText("Pokreni server");
        btnPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniServerActionPerformed(evt);
            }
        });

        btnUgasiServer.setText("Ugasi server");
        btnUgasiServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUgasiServerActionPerformed(evt);
            }
        });

        jMenu1.setText("Konfiguracija baze");

        miKonfiguracija.setText("Izmeni konfiguraciju");
        miKonfiguracija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKonfiguracijaActionPerformed(evt);
            }
        });
        jMenu1.add(miKonfiguracija);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPokreniServer, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(btnUgasiServer, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lblServerStatus)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblServerStatus)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPokreniServer)
                    .addComponent(btnUgasiServer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniServerActionPerformed

        if (threadServer == null || !threadServer.isAlive()) {
            threadServer = new ThreadServer();
            threadServer.start();
            lblServerStatus.setText("Server je pokrenut");
            btnUgasiServer.setEnabled(true);
            btnPokreniServer.setEnabled(false);
        }
    }//GEN-LAST:event_btnPokreniServerActionPerformed

    private void miKonfiguracijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKonfiguracijaActionPerformed
        new KonfiguracijaBaze(this, true).setVisible(true);
    }//GEN-LAST:event_miKonfiguracijaActionPerformed

    private void btnUgasiServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUgasiServerActionPerformed

        if (threadServer.getServerSocket() != null && threadServer.getServerSocket().isBound()) {
            try {
                threadServer.getServerSocket().close();
                JOptionPane.showMessageDialog(this, "Server je ugasen, gasenje programa...");
                this.dispose();
                System.exit(0);
            } catch (IOException ex) {
                Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnUgasiServerActionPerformed

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
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreniServer;
    private javax.swing.JButton btnUgasiServer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblServerStatus;
    private javax.swing.JMenuItem miKonfiguracija;
    // End of variables declaration//GEN-END:variables
}
