/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import conexao.MesasDAO;
import conexao.PedidosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import negocio.Mesa;
import negocio.Pedido;

public class TelaPedidos extends javax.swing.JFrame {

    public TelaPedidos() throws SQLException {
        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) tblListaPedidos.getModel();
        tblListaPedidos.setRowSorter(new TableRowSorter(modelo));

        //para popular o combobox
        MesasDAO mDAO = new MesasDAO();

        for (Mesa r : mDAO.ListaTodasAsMesas()) {
            cboMesa.addItem(r);
        }

    }

    public void LerParaTabelaPorPedido() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblListaPedidos.getModel();
        model.setNumRows(0);

        PedidosDAO ped = new PedidosDAO();

        //Gera a lista de pedidos localmente, que sera preenchida
        List<Pedido> listaDePedidos;
        listaDePedidos = new ArrayList<>();

        //pega (Obtem) a lista de pedidos atraves 
        listaDePedidos = ped.ListaTodosOsPedidos();
        //for (Pedido pz : pDAO.buscaPorPedido(numPedido)) {
        for (Pedido pedLocal : listaDePedidos) {

            model.addRow(new Object[]{
                pedLocal.getIdPedido(),
                pedLocal.getStatus(),
                pedLocal.getPrecoTotal(),
                pedLocal.getIdMesa(),});
        }

    }

    public void Limpar() {

        ((DefaultTableModel) tblListaPedidos.getModel()).setRowCount(0);

        // Limpando campos Text
        txtProduto.setText("");
        txtMesa.setText("");
        rdoGrupo1.clearSelection();
        txtExcluirID.setText("");

        //Deixando o focu no primeiro campo
        txtProduto.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGrupo1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlTabelaConsulta = new javax.swing.JScrollPane();
        tblListaPedidos = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        txtExcluirID = new javax.swing.JTextField();
        cboMesa = new javax.swing.JComboBox();
        btnListar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedidos");

        jLabel3.setText("Mesa");

        jLabel5.setText("Excluir por ID");

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

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Cria pedido");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        txtExcluirID.setBackground(new java.awt.Color(255, 51, 51));

        cboMesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));

        btnListar1.setText("Fecha Pedido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTabelaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExcluirID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnListar1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(cboMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar1))
                .addGap(47, 47, 47)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExcluirID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnExcluir)
                    .addComponent(btnListar))
                .addGap(35, 35, 35)
                .addComponent(pnlTabelaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(485, 384));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed

        try {
            LerParaTabelaPorPedido();
        } catch (SQLException ex) {
            Logger.getLogger(TelaPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnListarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        Limpar();

    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        Pedido ped = new Pedido();

        try {
            int mesa;

                //fazendo um casting para carpturar o atributo mesa
                Mesa mes = (Mesa) cboMesa.getSelectedItem();

                //Atribuindo o ID da revenda quando o nome da revenda é selecionado
                mesa = mes.getIdMesa();
                // #antigo# codAtendente = Integer.parseInt(txtAtendente.getText());

                ped.setIdMesa(mesa);
                

                PedidosDAO pedDAO = new PedidosDAO();

                pedDAO.InserePedido(ped);
                JOptionPane.showMessageDialog(null, "Pedido criado com sucesso!");

                //limparTelaCadastro();
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        try {

            if (txtExcluirID.getText().length() < 1) {
                JOptionPane.showMessageDialog(null, "Preencha o campo excluir!");
                txtProduto.requestFocus();
            } else {
                int id;
                id = Integer.parseInt(txtExcluirID.getText());

                UsuariosDAO userDAO = new UsuariosDAO();

                //fazendo a chamada do metodo para excluir pedido pelo seu ID
                userDAO.deletarPorId(id);

                //Mensagem de retorno ao usuario
                JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnListar1;
    private javax.swing.JComboBox cboMesa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane pnlTabelaConsulta;
    private javax.swing.ButtonGroup rdoGrupo1;
    private javax.swing.JTable tblListaPedidos;
    private javax.swing.JTextField txtExcluirID;
    // End of variables declaration//GEN-END:variables
}
