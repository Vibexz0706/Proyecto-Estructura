/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vibexz
 */
public class PRUEBA extends javax.swing.JFrame {

    COLACARROS l = new COLACARROS();

    public class COLACARROS {

        private NODOCARRO head;
        private NODOCARRO tail;

        public COLACARROS(NODOCARRO head, NODOCARRO tail) {
            this.head = head;
            this.tail = tail;
        }

        public COLACARROS() {

        }

        public void agregar(NODOCARRO c) {

            if (head == null) {
                head = c;
                tail = c;
            } else {
                tail.setNext(c);
                tail = c;
            }

        }

        public void mostrar() {
            NODOCARRO aux = head;

            if (head != null) {
                while (aux != null) {

                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                    String data[] = {aux.getPLACA(), aux.getCilindraje(), aux.getMarca(), aux.getCombustion(), aux.getModelo(), String.valueOf(aux.getCapacidad()), String.valueOf(aux.getAno()), String.valueOf(aux.getAlquiler()), aux.getColor(), aux.getExtras()};

                    model.addRow(data);
                    aux = aux.getNext();
                }

            }
        }

        public void guardarTXT() {
            NODOCARRO aux = head;

            if (head != null) {
                while (aux != null) {

                    // String data[] = {aux.getPLACA(), aux.getCilindraje(), aux.getMarca(), aux.getCombustion(), aux.getModelo(), String.valueOf(aux.getCapacidad()), String.valueOf(aux.getAno()), String.valueOf(aux.getAlquiler()), aux.getColor(), aux.getExtras()};
                    try {

                        FileWriter fw = new FileWriter("CA.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
                        pw.print(aux.getPLACA());
                        pw.print("-" + aux.getCilindraje());
                        pw.print("-" + aux.getMarca());
                        pw.print("-" + aux.getCombustion());
                        pw.print("-" + aux.getModelo());
                        pw.print("-" + String.valueOf(aux.getCapacidad()));
                        pw.print("-" + String.valueOf(aux.getAno()));
                        pw.print("-" + String.valueOf(aux.getAlquiler()));
                        pw.print("-" + aux.getColor());
                        pw.print("-" + aux.getExtras() + "\n");
                        pw.close();
                        JOptionPane.showMessageDialog(null, "DATOS GUARDADOS EN BASE DE DATOS");
                    } catch (IOException e) {

                        System.out.print("ARCHIVO NO EXISTE");
                    }

                    aux = aux.getNext();
                }

            }
        }

        public void eliminar(String placa) {

            NODOCARRO aux = new NODOCARRO();

            aux.setPLACA(placa);

            if (head != null) {
                if (head == tail && placa.equalsIgnoreCase(head.getPLACA())) {

                    head = tail = null;

                } else if (aux.getPLACA().equalsIgnoreCase(head.getPLACA())) {

                    head = head.getNext();

                } else {
                    NODOCARRO temporal = new NODOCARRO();
                    NODOCARRO anterior = new NODOCARRO();
                    anterior = head;
                    temporal = head.getNext();
                    while (temporal != null && !temporal.getPLACA().equalsIgnoreCase(aux.getPLACA())) {

                        anterior = anterior.getNext();
                        temporal = temporal.getNext();

                    }
                    if (temporal != null) {
                        anterior.setNext(temporal.getNext());

                        if (temporal == tail) {

                            tail = anterior;

                        }

                    }

                }

            }

        }

        public void modificar(NODOCARRO c) {

            NODOCARRO aux = new NODOCARRO();

            aux = head;
            boolean encontrado = false;

            if (head != null) {

                while (aux != null && encontrado != true) {

                    if (aux.getPLACA().equals(c.getPLACA())) {

                        JOptionPane.showMessageDialog(null, "REGISTRO ENCONTRADO");
                        aux.setCilindraje(c.getCilindraje());
                        aux.setMarca(c.getMarca());
                        aux.setCombustion(c.getCombustion());
                        aux.setModelo(c.getModelo());
                        aux.setCapacidad(c.getCapacidad());
                        aux.setAno(c.getAno());
                        aux.setAlquiler(c.getAlquiler());
                        aux.setColor(c.getColor());

                        encontrado = true;

                    }
                    aux = aux.getNext();

                }

            }

        }

        public void llenarCola() {

            String linea = "";

            String delimitante = "\n";
            FileReader fw;
            BufferedReader bw;
            try {
                //File file = new File("carros.txt");
                fw = new FileReader("CA.txt");
                bw = new BufferedReader(fw);
                String l = "";
                while ((linea = bw.readLine()) != null) {
                    l += linea + "\n";

                }

                String[] campo = l.split(delimitante);
                String Carros[][] = new String[campo.length][10];
                for (int i = 0; i < campo.length; i++) {

                    String[] carro = campo[i].split("-");

                    for (int b = 0; b < 10; b++) {
                        Carros[i][b] = carro[b];

                    }

                    NODOCARRO aux1 = new NODOCARRO();

                    aux1.setPLACA(Carros[i][0]);
                    aux1.setCilindraje(Carros[i][1]);
                    aux1.setMarca(Carros[i][2]);
                    aux1.setCombustion(Carros[i][3]);
                    aux1.setModelo(Carros[i][4]);
                    aux1.setCapacidad(Integer.parseInt(Carros[i][5]));
                    aux1.setAno(Integer.parseInt(Carros[i][6]));
                    aux1.setAlquiler(Integer.parseInt(Carros[i][7]));
                    aux1.setColor(Carros[i][8]);
                    aux1.setExtras(Carros[i][9]);

                    if (head == null) {

                        head = aux1;
                        tail = aux1;

                    } else {

                        tail.setNext(aux1);
                        tail = aux1;

                    }

                }

            } catch (FileNotFoundException e) {
                System.out.print("ERROR" + e.getMessage());

            } catch (IOException ex) {
                Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }

    public PRUEBA() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PLACA", "CILINDRAJE", "MARCA", "COMBUSTION", "MODELO", "CAPACIDAD", "ANO", "ALQUILER", "COLOR", "EXTRAS"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("VER TABLA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel1.setText("COLA DE CARROS");

        jButton5.setText("GUARDAR DATOS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("VOLVER MENU");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(533, 533, 533))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(145, 145, 145)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDIALOGCARRO v = new JDIALOGCARRO(this, true);
        v.setVisible(true);
        l.agregar(new NODOCARRO(v.getPlaca(), v.getCilindraje(), v.getMarca(), v.getCombustion(), v.getModelo(), v.getCapacidad(), v.getAno(), v.getAlquiler(), v.getColor(), v.getExtras()));
        System.out.print(v.getExtras());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int fila = jTable1.getRowCount();

        for (int i = fila - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        l.mostrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JDELIMINARCARRO k = new JDELIMINARCARRO(this, true);
        k.setVisible(true);
        l.eliminar(k.getPlaca());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JDIALOGCARRO v = new JDIALOGCARRO(this, true);
        v.setVisible(true);
        l.modificar(new NODOCARRO(v.getPlaca(), v.getCilindraje(), v.getMarca(), v.getCombustion(), v.getModelo(), v.getCapacidad(), v.getAno(), v.getAlquiler(), v.getColor(), v.getExtras()));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        l.guardarTXT();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        new PanelCentral().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(PRUEBA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PRUEBA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PRUEBA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRUEBA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PRUEBA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
