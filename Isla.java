/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobosyconejos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.Timer;


public class Isla extends javax.swing.JFrame {

    int offset_x=40;
    int offset_y=40;
    int factor=5;
    
    /**
     * Creates new form Isla
     */
    public Isla() {
        initComponents();
        
        Timer temporizador = new Timer();
        
        TimerTask tarea= new TimerTask(){
            @Override
            public void run() {
                repaint();
                numeroLobos.setText(String.valueOf(Parametros.lobos.size()));
                numeroConejos.setText(String.valueOf(Parametros.conejos.size()));
            }
        };
        
        temporizador.schedule(tarea,10, 400);
    }

     @Override
    public void paint(Graphics g) {
        
        g.clearRect(offset_x,offset_y,offset_x+Parametros.anchoTablero*factor,offset_y+Parametros.altoTablero*factor);
        
        // Pinto los conejos
        g.setColor(Color.GREEN); //To change body of generated methods, choose Tools | Templates.
        Iterator it= Parametros.conejos.iterator();
        while(it.hasNext()){
            Conejos conejo= (Conejos) it.next();
            g.fillOval(offset_x+conejo.posicion.x*factor,offset_y+conejo.posicion.y*factor,factor,factor);
        }
        
        g.setColor(Color.RED);
        it = Parametros.lobos.iterator();
        while(it.hasNext()){
            Lobos lobo= (Lobos) it.next();
            g.fillOval(offset_x+lobo.posicion.x*factor,offset_y+lobo.posicion.y*factor,factor,factor);
        }
        
        
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
        numeroLobos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numeroConejos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Lobos");

        numeroLobos.setText("0");

        jLabel2.setText("Conejos");

        numeroConejos.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(646, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(numeroLobos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(numeroConejos)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numeroLobos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numeroConejos))
                .addContainerGap(278, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Isla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Isla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Isla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Isla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Isla().setVisible(true);
            }
        });
    }
    


   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel numeroConejos;
    private javax.swing.JLabel numeroLobos;
    // End of variables declaration//GEN-END:variables
}
