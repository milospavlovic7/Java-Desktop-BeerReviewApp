/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms.korisnik;

import service.KorisnikService;
import forms.korisnik.PanelPretraga;
import forms.korisnik.PanelRecenzije;
import forms.korisnik.PanelNalogKorisnik;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milos
 */
public class KorisnikMainForm extends javax.swing.JFrame {

    /**
     * Creates new form KorisnikMainForm
     */
    public KorisnikMainForm() {
            initComponents();
            setLocationRelativeTo(null);
            inicijalizujFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jButtonPretraga = new javax.swing.JButton();
        jButtonRecenzije = new javax.swing.JButton();
        jButtonNalog = new javax.swing.JButton();
        jButtonIzadji = new javax.swing.JButton();
        jButtonOsvezi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        jButtonPretraga.setBackground(new java.awt.Color(242, 242, 242));
        jButtonPretraga.setText("Pretraga");
        jButtonPretraga.setBorderPainted(false);
        jButtonPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPretragaActionPerformed(evt);
            }
        });

        jButtonRecenzije.setBackground(new java.awt.Color(242, 242, 242));
        jButtonRecenzije.setText("Recenzije");
        jButtonRecenzije.setBorderPainted(false);
        jButtonRecenzije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecenzijeActionPerformed(evt);
            }
        });

        jButtonNalog.setBackground(new java.awt.Color(242, 242, 242));
        jButtonNalog.setText("Nalog");
        jButtonNalog.setBorderPainted(false);
        jButtonNalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNalogActionPerformed(evt);
            }
        });

        jButtonIzadji.setBackground(new java.awt.Color(255, 150, 150));
        jButtonIzadji.setText("Izadji");
        jButtonIzadji.setBorderPainted(false);
        jButtonIzadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzadjiActionPerformed(evt);
            }
        });

        jButtonOsvezi.setBackground(new java.awt.Color(242, 242, 242));
        jButtonOsvezi.setText("Osvezi");
        jButtonOsvezi.setBorderPainted(false);
        jButtonOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOsveziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonNalog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPretraga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRecenzije, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addComponent(jButtonIzadji, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOsvezi, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNalog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPretraga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRecenzije)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOsvezi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonIzadji))
                    .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNalogActionPerformed
        prikaziPanel(service.KorisnikService.getInstance().getPanelNalogKorisnik());
    }//GEN-LAST:event_jButtonNalogActionPerformed

    private void jButtonPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPretragaActionPerformed
        prikaziPanel(service.KorisnikService.getInstance().getPanelPretraga());
    }//GEN-LAST:event_jButtonPretragaActionPerformed

    private void jButtonRecenzijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecenzijeActionPerformed
        prikaziPanel(service.KorisnikService.getInstance().getPanelRecenzije());
    }//GEN-LAST:event_jButtonRecenzijeActionPerformed

    private void jButtonIzadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzadjiActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonIzadjiActionPerformed

    private void jButtonOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOsveziActionPerformed
        try {
            service.KorisnikService.getInstance().osveziDugme();
        } catch (Exception ex) {
            Logger.getLogger(KorisnikMainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonOsveziActionPerformed

    public void prikaziPanel(javax.swing.JPanel panel) {
        jPanelMain.removeAll();
        jPanelMain.setLayout(new java.awt.BorderLayout());
        jPanelMain.add(panel, java.awt.BorderLayout.CENTER);
        jPanelMain.revalidate();
        jPanelMain.repaint();
    }

    private void inicijalizujFormu() {
        try {
            KorisnikService service = KorisnikService.getInstance();
            service.inicijalnoUcitavanje();
            service.ucitajOmiljenaPiva();
            service.kreirajPanele();
            prikaziPanel(service.getPanelNalogKorisnik());
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Greška prilikom učitavanja pivara i piva.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzadji;
    private javax.swing.JButton jButtonNalog;
    private javax.swing.JButton jButtonOsvezi;
    private javax.swing.JButton jButtonPretraga;
    private javax.swing.JButton jButtonRecenzije;
    private javax.swing.JPanel jPanelMain;
    // End of variables declaration//GEN-END:variables
}
