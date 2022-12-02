/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
 * @author VIBEXZ
 */
public class AgrerCli extends javax.swing.JFrame {

    ListaSimple la = new ListaSimple();
    COLACARROS fa = new COLACARROS();

    private int h, k;

    public void setH(int h) {
        this.h = h;
    }

    public void setK(int k) {
        this.k = k;
    }

    int encontrado = 0;

    public class ListaSimple {

        private NodeCliente head;
        private NodeCliente tail;

        public ListaSimple(NodeCliente head, NodeCliente tail) {
            this.head = head;
            this.tail = tail;
        }

        public ListaSimple() {

        }

        public void insertar(Clientes c) {
            NodeCliente newNodo = new NodeCliente(c);
            if (head == null) {

                head = newNodo;

            } else if (head.getDatos().getCedula() > newNodo.getDatos().getCedula()) {
                newNodo.setNext(head);
                head = newNodo;

            } else if (head.getDatos().getCedula() < newNodo.getDatos().getCedula() && head.getNext() == null) {
                head.setNext(newNodo);

            } else {

                NodeCliente aux = head;
                while (aux.getNext() != null && aux.getNext().getDatos().getCedula() < newNodo.getDatos().getCedula()) {
                    aux = aux.getNext();

                }
                newNodo.setNext(aux.getNext());
                aux.setNext(newNodo);

            }

        }

        public void imprimirLista() {
            NodeCliente aux = head;
            while (aux != null) {

                System.out.print(" " + String.valueOf(aux.getDatos().getCedula()) + "-" + aux.getDatos().getNombre() + "-" + aux.getDatos().getFechaNacimiento() + "-" + aux.getDatos().getCorreo() + "-" + String.valueOf(aux.getDatos().getCate()) + "\n");

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                String data[] = {String.valueOf(aux.getDatos().getCedula()), aux.getDatos().getNombre(), aux.getDatos().getFechaNacimiento(), aux.getDatos().getCorreo(), String.valueOf(aux.getDatos().getCate())};

                model.addRow(data);

                aux = aux.getNext();

            }

        }

        public void eliminar(int id) {

            if (head != null) {
                if (head.getDatos().getCedula() == id) {
                    head = head.getNext();
                } else {
                    NodeCliente aux = head;

                    while (aux.getNext() != null && aux.getNext().getDatos().getCedula() < id) {
                        aux = aux.getNext();
                    }

                    if (aux.getNext() != null && aux.getNext().getDatos().getCedula() == id) {
                        aux.setNext(aux.getNext().getNext());
                    }
                }

            }

        }

        private void modificar(Clientes c) {

            NodeCliente actual = new NodeCliente(c);
            actual = head;
            boolean encontrado = false;

            int buscar = c.getCedula();

            if (head != null) {
                while (actual != null) {
                    if (actual.getDatos().getCedula() == buscar) {
                        encontrado = true;
                        System.out.print("nodo encontrado");
                        actual.getDatos().setNombre(c.getNombre());
                        actual.getDatos().setFechaNacimiento(c.getFechaNacimiento());
                        actual.getDatos().setCorreo(c.getCorreo());
                        actual.getDatos().setCate(c.getCate());
                        System.out.print(c.getNombre());
                    }
                    actual = actual.getNext();
                }
                System.out.print("NO ENTRA");

            }

        }

        public void o() {
            NodeCliente aux = head;
            while (aux != null) {

                try {

                    FileWriter fw = new FileWriter("Clientes.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    pw.print(aux.getDatos().getCedula());
                    pw.print("-" + aux.getDatos().getNombre());
                    pw.print("-" + aux.getDatos().getFechaNacimiento());
                    pw.print("-" + aux.getDatos().getCorreo());
                    pw.print("-" + aux.getDatos().getCate() + "\n");

                    pw.close();

                } catch (IOException e) {

                    System.out.print("sss");
                }

                aux = aux.getNext();

            }

        }

        public void fA(int a, int h) {

            NodeCliente actual = new NodeCliente();

            actual = head;
            boolean encontrado = false;

            if (head != null) {
                while (actual != null) {
                    if (actual.getDatos().getCedula() == h) {
                        encontrado = true;
                        System.out.print("nodo encontrado");
                        if (a > 30) {
                            System.out.print("entro deberia de subir rango");
                            actual.getDatos().setCate(actual.getDatos().getCate() + 1);

                        } else {
                            System.out.print("YA ESTA EN EL MAXIMO");
                        }

                    }
                    actual = actual.getNext();
                }
                System.out.print("NO ENTRA");

            }

        }

    }

    //--------------------------------------------------------------------------------COPIA COLA DE CARROS---------------------------------------------------
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

                    System.out.println(aux.getPLACA() + " " + aux.getExtras());

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

        public void verificar(String b, String marca) {

            NODOCARRO aux = new NODOCARRO();

            aux = head;
            boolean encontrado = false;

            if (head != null) {

                while (aux != null && encontrado != true) {

                    if (aux.getPLACA().equals(b) && aux.getMarca().equalsIgnoreCase(marca)) {
                        JOptionPane.showMessageDialog(null, "REGISTRO ENCONTRADO, SE ASIGNO AL CLIENTE");
                        JOptionPane.showMessageDialog(null, " Se asigo el Carro " + marca + " Con el numero de Placa " + b);
                        encontrado = true;

                    }
                    aux = aux.getNext();

                }

            }

        }

    }

    //--------------------------------------------------------------------------------FIN COLA--------------------------------------------------------------------------------------------------
    public AgrerCli() {
        initComponents();
        fa.llenarCola();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "FECHA NACIMIENTO", "EMAIL", "CATEGORIA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ELIMINAR.setText("ACTUALIZAR TABLA");
        ELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARActionPerformed(evt);
            }
        });

        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("SALIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("ELIMINAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("GUARDAR DATOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("SOLICITAR VEHICULO");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Consultar Solicitud");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(65, 65, 65))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ACLIENTE ac = new ACLIENTE(this, true);
        ac.setVisible(true);
        la.insertar(new Clientes(ac.getCedula(), ac.getNombre(), ac.getFecha(), ac.getEmail(), ac.getCategoria()));
        fa.mostrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINARActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int fila = jTable1.getRowCount();

        for (int i = fila - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        la.imprimirLista();
    }//GEN-LAST:event_ELIMINARActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        MODIFICAR CA = new MODIFICAR(this, true);
        CA.setVisible(true);
        la.modificar(new Clientes(CA.getCedula(), CA.getNombre(), CA.getFecha(), CA.getEmail(), CA.getCategoria()));


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ELIMINAR A = new ELIMINAR(this, true);
        A.setVisible(true);
        la.eliminar(A.getCedula());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        la.o();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        AGREGARSOLICITUD m = new AGREGARSOLICITUD(this, true);
        m.setVisible(true);
        LISTADOBLE o = new LISTADOBLE();
        o.agregar(new ALQUILER(m.getl(), m.geth(), m.getpasajeros(), m.getMarca(), m.getExtras()));

        la.fA(m.geth(), m.getl());

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //consu l = new consu();
        //l.setVisible(true);
        fa.verificar("12", "A");

    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(AgrerCli.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgrerCli.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgrerCli.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgrerCli.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AgrerCli().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
