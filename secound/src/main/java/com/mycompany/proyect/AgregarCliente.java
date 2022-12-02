/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyect;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIBEXZ
 */
public class AgregarCliente extends javax.swing.JFrame {

    ListaSimple la = new ListaSimple();
    ACLIENTE ac = new ACLIENTE(this, true);
    private int encontrado;
    private int cont = 0;
    

    public void AgregarCliente() {
        initComponents();
        
        
        //llenar();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "FECHA NACIMIENTO", "EMAIL"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("VER DATOS");
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

        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("jButton7");
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(356, 356, 356))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jButton6)
                .addGap(173, 173, 173)
                .addComponent(jButton7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //ac.setVisible(true);
        //la.insertar(new Clientes(ac.getCedula(), ac.getNombre(), ac.getFecha(), ac.getEmail()));
        //agregar();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //la.imprimirLista();
        //tabla();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //consultar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //eliminar();
        //el();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    public void agregar() {

        encontrado = 0;
        try {
            Clientes dc = new Clientes();
            dc.setCedula(ac.getCedula());
            dc.setNombre(ac.getNombre());
            dc.setFechaNacimiento(ac.getFecha());
            dc.setCorreo(ac.getEmail());
            if (encontrado == 0) {
                DataOutputStream salida = new DataOutputStream(new FileOutputStream("cliente.dat", true));
                salida.writeInt(dc.getCedula());
                salida.writeUTF(dc.getNombre());
                salida.writeUTF(dc.getFechaNacimiento());
                salida.writeUTF(dc.getCorreo());
                //System.out.print("/" + dc.getCedula() + "-" + dc.getNombre() + " - " + dc.getFechaNacimiento() + " - " + dc.getCorreo() + "/");

                JOptionPane.showMessageDialog(null, "¡Datos agregados correctamente!",
                        "Datos agregados", JOptionPane.INFORMATION_MESSAGE);

                salida.close();
            } else {
                JOptionPane.showMessageDialog(null, "¡Datos ya existen!",
                        "Datos ya existen", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex01) {
            JOptionPane.showMessageDialog(null, "¡Ocurrió un error al guardar!",
                    "Error al guardar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultar() {
        encontrado = 0;
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream(
                    "cliente.dat"));
            try {
                Clientes dc = new Clientes();
                while (true) {
                    dc.setCedula(entrada.readInt());
                    dc.setNombre(entrada.readUTF());
                    dc.setFechaNacimiento(entrada.readUTF());
                    dc.setCorreo(entrada.readUTF());
                    System.out.print(dc.getCedula());
                    if (Integer.parseInt(jTextField1.getText()) == dc.getCedula()) {
                        encontrado = 1;
                        System.out.print("/" + dc.getCedula() + "-" + dc.getNombre() + " - " + dc.getFechaNacimiento() + " - " + dc.getCorreo() + "/");
                    }
                }
            } catch (EOFException eeof) {
                entrada.close();
                if (encontrado == 0) {
                    JOptionPane.showMessageDialog(null, "¡Datos no existen!",
                            "Datos no existen", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "¡Archivo no encontrado!", "Archivo no encontrado",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException eioe) {
            JOptionPane.showMessageDialog(null, "¡Error en el dispositivo de almacenamiento!",
                    "Error en el dispositivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mover() {
        try {
            Clientes dc = new Clientes();
            DataInputStream entrada = new DataInputStream(new FileInputStream(
                    "temporal.dat"));
            DataOutputStream salida = new DataOutputStream(new FileOutputStream(
                    "cliente.dat"));
            try {
                dc.setCedula(entrada.readInt());
                dc.setNombre(entrada.readUTF());
                dc.setFechaNacimiento(entrada.readUTF());
                dc.setCorreo(entrada.readUTF());

                salida.writeInt(dc.getCedula());
                salida.writeUTF(dc.getNombre());
                salida.writeUTF(dc.getFechaNacimiento());
                salida.writeUTF(dc.getCorreo());
            } catch (EOFException eofe) {
                entrada.close();
                salida.close();

                JOptionPane.showMessageDialog(null, "¡Datos fueron modificados correctamente!",
                        "Datos modificados", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "¡Archivo no encontrado, revise!",
                    "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "¡Error desconocido, revise!",
                    "Error desconocido", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar() {
        /* try {
            Clientes dc = new Clientes();
            DataInputStream entrada = new DataInputStream(new FileInputStream("cliente.dat"));
            DataOutputStream salida = new DataOutputStream(new FileOutputStream("temporal.dat"));
            int codEliminar = Integer.parseInt(jTextField2.getText());
            try {
                while (true) {

                    dc.setCedula(entrada.readInt());
                    dc.setNombre(entrada.readUTF());
                    dc.setFechaNacimiento(entrada.readUTF());
                    dc.setCorreo(entrada.readUTF());
                    if (dc.getCedula() != codEliminar) {
                        salida.writeInt(dc.getCedula());
                        salida.writeUTF(dc.getNombre());
                        salida.writeUTF(dc.getFechaNacimiento());
                        salida.writeUTF(dc.getCorreo());
                    }
                }
            } catch (EOFException eofe) {
                entrada.close();
                salida.close();

                JOptionPane.showMessageDialog(null, "¡Datos fueron eliminados correctamente!",
                        "Datos eliminados", JOptionPane.INFORMATION_MESSAGE);

                mover();
                limpiar();
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "¡Archivo no encontrado, revise!",
                    "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "¡Error desconocido, revise!",
                    "Error desconocido", JOptionPane.ERROR_MESSAGE);
        }*/
        boolean encontrado = false;
        try {
            Clientes dc = new Clientes();
            try {
                DataInputStream entrada = new DataInputStream(new FileInputStream("cliente.dat"));
                DataOutputStream salida = new DataOutputStream(new FileOutputStream("temporal.dat"));
                try {
                    while (true) {
                        dc.setCedula(entrada.readInt());
                        dc.setNombre(entrada.readUTF());
                        dc.setFechaNacimiento(entrada.readUTF());
                        dc.setCorreo(entrada.readUTF());

                        if (dc.getCedula() != Integer.parseInt(jTextField2.getText())) {
                            salida.writeInt(dc.getCedula());
                            salida.writeUTF(dc.getNombre());
                            salida.writeUTF(dc.getFechaNacimiento());
                            salida.writeUTF(dc.getCorreo());

                        } else {
                            encontrado = true;
                        }
                    }
                } catch (EOFException eofe) {
                    salida.close();
                    entrada.close();
                    mover();
                    if (encontrado == false) {
                        JOptionPane.showMessageDialog(null, "¡El registro no fue encontrado!",
                                "Registro no encontrado", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Datos fueron eliminados correctamente!",
                                "Datos eliminados", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(null, "¡Archivo no encontrado, revise!");
            }
        } catch (IOException eioe) {
            JOptionPane.showMessageDialog(null, "¡Excepción desconocida, revise!");
        }
    }

    private void llenar() {
        encontrado = 0;
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream(
                    "cliente.dat"));
            try {
                Clientes dc = new Clientes();
                while (true) {
                    dc.setCedula(entrada.readInt());
                    dc.setNombre(entrada.readUTF());
                    dc.setFechaNacimiento(entrada.readUTF());
                    dc.setCorreo(entrada.readUTF());

                    encontrado = 1;
                    //la.insertar(new Clientes(dc.getCedula(), dc.getNombre(), dc.getFechaNacimiento(), dc.getCorreo()));
                    System.out.print(dc.getCedula() + dc.getNombre() + dc.getFechaNacimiento() + dc.getCorreo());
                }
            } catch (EOFException eeof) {
                entrada.close();
                if (encontrado == 0) {
                    JOptionPane.showMessageDialog(null, "¡Datos no existen!",
                            "Datos no existen", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "¡Archivo no encontrado!", "Archivo no encontrado",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException eioe) {
            JOptionPane.showMessageDialog(null, "¡Error en el dispositivo de almacenamiento!",
                    "Error en el dispositivo", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void el() {

        int a = Integer.parseInt(jTextField2.getText());
        System.out.print(a);
        la.eliminar(a);
    }

    public void tabla() {

        encontrado = 0;
        try {
            DataInputStream entrada = new DataInputStream(new FileInputStream(
                    "cliente.dat"));
            try {
                Clientes dc = new Clientes();
                while (true) {
                    dc.setCedula(entrada.readInt());
                    dc.setNombre(entrada.readUTF());
                    dc.setFechaNacimiento(entrada.readUTF());
                    dc.setCorreo(entrada.readUTF());

                    encontrado = 1;
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                    String data[] = {String.valueOf(dc.getCedula()), dc.getNombre(), dc.getFechaNacimiento(), dc.getCorreo()};
                    model.addRow(data);

                    

                }
            } catch (EOFException eeof) {
                entrada.close();
                if (encontrado == 0) {
                    JOptionPane.showMessageDialog(null, "¡Datos no existen!",
                            "Datos no existen", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "¡Archivo no encontrado!", "Archivo no encontrado",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException eioe) {
            JOptionPane.showMessageDialog(null, "¡Error en el dispositivo de almacenamiento!",
                    "Error en el dispositivo", JOptionPane.ERROR_MESSAGE);
        }

    }

    /*
public void limpiar() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField1.requestFocus();
    }*/

}
