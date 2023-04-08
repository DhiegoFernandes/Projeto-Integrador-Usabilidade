/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Inutil.ListagemPizzas;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dhiego
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        //getContentPane().setBackground(Color.cyan); //deixa a tela principal com a cor azul
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        btnCriaPedido = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();
        mnuBarTelaPrincipal = new javax.swing.JMenuBar();
        mnuArquivo = new javax.swing.JMenu();
        mnuCadastro = new javax.swing.JMenu();
        mnuCadastroDePizzas = new javax.swing.JMenuItem();
        mnuListar = new javax.swing.JMenu();
        mnuListarPedidos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de cadastro de pizzas");

        btnCriaPedido.setText("Cria pedido TESTANDO");
        btnCriaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriaPedidoActionPerformed(evt);
            }
        });

        btnProdutos.setText("Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        mnuArquivo.setText("Arquivo");
        mnuBarTelaPrincipal.add(mnuArquivo);

        mnuCadastro.setText("Cadastro");

        mnuCadastroDePizzas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        mnuCadastroDePizzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pizza.png"))); // NOI18N
        mnuCadastroDePizzas.setText("Cadastro de pedidos");
        mnuCadastroDePizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastroDePizzasActionPerformed(evt);
            }
        });
        mnuCadastro.add(mnuCadastroDePizzas);

        mnuBarTelaPrincipal.add(mnuCadastro);

        mnuListar.setText("Listar");

        mnuListarPedidos.setText("Consulta por Pedido");
        mnuListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarPedidosActionPerformed(evt);
            }
        });
        mnuListar.add(mnuListarPedidos);

        jMenuItem2.setText("Listas todos pedidos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuListar.add(jMenuItem2);

        mnuBarTelaPrincipal.add(mnuListar);

        setJMenuBar(mnuBarTelaPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnCriaPedido)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(btnCriaPedido)
                .addGap(89, 89, 89))
        );

        setSize(new java.awt.Dimension(414, 307));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuCadastroDePizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastroDePizzasActionPerformed

        try {
            new TelaCriaPedido().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mnuCadastroDePizzasActionPerformed

    private void mnuListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarPedidosActionPerformed

        new TelaConsultaPedido().setVisible(true);
    }//GEN-LAST:event_mnuListarPedidosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        new TelaListaTodosPedidos().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnCriaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriaPedidoActionPerformed

        try {
            new TelaCriaPedido().setVisible(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCriaPedidoActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        //abre tela produtos
        new TelaProdutos().setVisible(true);
        
    }//GEN-LAST:event_btnProdutosActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriaPedido;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu mnuArquivo;
    private javax.swing.JMenuBar mnuBarTelaPrincipal;
    private javax.swing.JMenu mnuCadastro;
    private javax.swing.JMenuItem mnuCadastroDePizzas;
    private javax.swing.JMenu mnuListar;
    private javax.swing.JMenuItem mnuListarPedidos;
    // End of variables declaration//GEN-END:variables
}