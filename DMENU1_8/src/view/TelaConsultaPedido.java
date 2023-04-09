/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import conexao.AtendentesDAO;
import java.sql.SQLException;
import conexao.PedidosDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import negocio.Pedido;

/**
 *
 * @author Dhiego
 */
public class TelaConsultaPedido extends javax.swing.JFrame {

    public TelaConsultaPedido() {
        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) tblListaPedidos.getModel();
        tblListaPedidos.setRowSorter(new TableRowSorter(modelo));
        
        
    }

    public void LerParaTabelaPorPedido(int numPedido) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblListaPedidos.getModel();
        model.setNumRows(0);
        PedidosDAO pDAO = new PedidosDAO();

        for (Pedido pz : pDAO.buscaPorPedido(numPedido)) {

            model.addRow(new Object[]{
                pz.getIdPedido(),
                pz.getStatus(),
                pz.getPrecoTotal(),
                pz.getIdMesa(),});
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

        pnlBotoes14 = new javax.swing.JPanel();
        lblConsultaPedido = new javax.swing.JLabel();
        txtConsultaPedido = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        pnlTabelaConsulta = new javax.swing.JScrollPane();
        tblListaPedidos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblConsultaPedido.setText("Consulta por Pedido:");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoes14Layout = new javax.swing.GroupLayout(pnlBotoes14);
        pnlBotoes14.setLayout(pnlBotoes14Layout);
        pnlBotoes14Layout.setHorizontalGroup(
            pnlBotoes14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoes14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotoes14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBotoes14Layout.createSequentialGroup()
                        .addComponent(txtConsultaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar))
                    .addComponent(lblConsultaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlBotoes14Layout.setVerticalGroup(
            pnlBotoes14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoes14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblConsultaPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBotoes14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsultaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar)
                    .addComponent(btnLimpar))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tblListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idPedido", "status", "precoTotal", "idMesa"
            }
        ));
        pnlTabelaConsulta.setViewportView(tblListaPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBotoes14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTabelaConsulta))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBotoes14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(pnlTabelaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        setSize(new java.awt.Dimension(495, 386));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

        try {
            if (txtConsultaPedido.getText().length() < 1){
                JOptionPane.showMessageDialog(null, "Preencha o campo consulta!");
            }else{
                LerParaTabelaPorPedido(Integer.parseInt(txtConsultaPedido.getText()));
            }    
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        ((DefaultTableModel) tblListaPedidos.getModel()).setRowCount(0);
        txtConsultaPedido.setText("");
        txtConsultaPedido.requestFocus();

    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel lblConsultaPedido;
    private javax.swing.JPanel pnlBotoes14;
    private javax.swing.JScrollPane pnlTabelaConsulta;
    private javax.swing.JTable tblListaPedidos;
    private javax.swing.JTextField txtConsultaPedido;
    // End of variables declaration//GEN-END:variables
}
