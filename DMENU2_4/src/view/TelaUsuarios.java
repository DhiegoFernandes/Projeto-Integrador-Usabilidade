/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import conexao.ProdutosDAO;
import conexao.UsuariosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import negocio.Usuario;

public class TelaUsuarios extends javax.swing.JFrame {

    public TelaUsuarios() throws SQLException {
        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) tblListaUsuarios.getModel();
        tblListaUsuarios.setRowSorter(new TableRowSorter(modelo));

    }

    public void LerParaTabelaPorProduto() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblListaUsuarios.getModel();
        model.setNumRows(0);

        UsuariosDAO usuarios = new UsuariosDAO();

//Gera a lista de pizzas localmente, que sera preenchida
        List<Usuario> listaDeUsuarios;
        listaDeUsuarios = new ArrayList<>();

//pega (Obtem) a lista de pizzas atraves do atendente
        listaDeUsuarios = usuarios.listaTodosOsUsuarios();
        //for (Pedido pz : pDAO.buscaPorPedido(numPedido)) {
        for (Usuario UsuarioLocal : listaDeUsuarios) {

            model.addRow(new Object[]{
                UsuarioLocal.getIdusuario(),
                UsuarioLocal.getUsuario(),
                UsuarioLocal.getSenha(),
                UsuarioLocal.getTipoacesso(),
                UsuarioLocal.getStatus(),});
        }

    }

    public void Limpar() {

        ((DefaultTableModel) tblListaUsuarios.getModel()).setRowCount(0);

        // Limpando campos Text
        txtUsuario.setText("");
        txtSenha.setText("");
        rdoGrupo1.clearSelection();
        txtDesativarID.setText("");

        //Deixando o focu no primeiro campo
        txtUsuario.requestFocus();
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
        pnlGlobal = new javax.swing.JPanel();
        pnlTabelaConsulta = new javax.swing.JScrollPane();
        tblListaUsuarios = new javax.swing.JTable();
        pnlSuperior = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblTipoAcesso = new javax.swing.JLabel();
        rdoAdmin = new javax.swing.JRadioButton();
        rdoPadrao = new javax.swing.JRadioButton();
        btnAdicionar = new javax.swing.JButton();
        pnlInferior = new javax.swing.JPanel();
        btnDesativar = new javax.swing.JButton();
        txtDesativarID = new javax.swing.JTextField();
        lblAtivarDesativar = new javax.swing.JLabel();
        btnAtivar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuários");

        tblListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idusuario", "usuario", "senha", "tipoacesso", "status"
            }
        ));
        pnlTabelaConsulta.setViewportView(tblListaUsuarios);

        lblSenha.setText("Senha");

        lblUsuario.setText("Usuário");

        lblTipoAcesso.setText("Tipo de acesso");

        rdoGrupo1.add(rdoAdmin);
        rdoAdmin.setText("Admin");

        rdoGrupo1.add(rdoPadrao);
        rdoPadrao.setText("Padrão");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoAcesso)
                    .addGroup(pnlSuperiorLayout.createSequentialGroup()
                        .addComponent(rdoAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoPadrao)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionar)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(lblTipoAcesso)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoAdmin)
                        .addComponent(btnAdicionar)
                        .addComponent(rdoPadrao)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnDesativar.setText("Desativar");
        btnDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesativarActionPerformed(evt);
            }
        });

        txtDesativarID.setBackground(new java.awt.Color(255, 51, 51));

        lblAtivarDesativar.setText("Ativar/Desativar por ID");

        btnAtivar.setText("Ativar");
        btnAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtivarActionPerformed(evt);
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

        javax.swing.GroupLayout pnlInferiorLayout = new javax.swing.GroupLayout(pnlInferior);
        pnlInferior.setLayout(pnlInferiorLayout);
        pnlInferiorLayout.setHorizontalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar)
                .addGap(96, 96, 96)
                .addGroup(pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInferiorLayout.createSequentialGroup()
                        .addComponent(btnAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDesativar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInferiorLayout.createSequentialGroup()
                        .addComponent(lblAtivarDesativar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesativarID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInferiorLayout.setVerticalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInferiorLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAtivarDesativar)
                    .addComponent(txtDesativarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesativar)
                    .addComponent(btnAtivar)
                    .addComponent(btnLimpar)
                    .addComponent(btnListar))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTabelaConsulta)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTabelaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(485, 384));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed

        try {
            LerParaTabelaPorProduto();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        Limpar();

    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        Usuario user = new Usuario();

        try {
            String usuario;
            String tipoAcesso = null;
            String senha;

            //validando campos
            if (txtUsuario.getText().length() < 1) {
                JOptionPane.showMessageDialog(null, "Preencha o campo usuário!");
                txtUsuario.requestFocus();
            } else if (txtSenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha o campo senha!");
                txtSenha.requestFocus();
            } else {

                if (rdoAdmin.isSelected()) {
                    tipoAcesso = "administrador";
                }

                if (rdoPadrao.isSelected()) {
                    tipoAcesso = "atendente";
                }

                usuario = txtUsuario.getText();
                usuario = usuario.toLowerCase();//faz o usuario ficar em letras minusculas

                senha = txtSenha.getText();

                user.setUsuario(usuario);
                user.setSenha(senha);
                user.setTipoacesso(tipoAcesso);
                String status = "ativado";//##### COMO PADRÃO, O USUARIO SERÁ CRIADO ATIVADO  ######
                user.setStatus(status);

                UsuariosDAO userDAO = new UsuariosDAO();

                userDAO.insereUsuario(user);
                JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");

                //limparTelaCadastro();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarActionPerformed

        try {

            if (txtDesativarID.getText().length() < 1) {
                JOptionPane.showMessageDialog(null, "Preencha o campo alterar!");
                txtUsuario.requestFocus();
            } else {
                int idusuario;
                idusuario = Integer.parseInt(txtDesativarID.getText());

                UsuariosDAO userDAO = new UsuariosDAO();
                Usuario user = new Usuario();

                //fazendo a chamada do metodo para buscar por id
                userDAO.buscaPorID(idusuario, user);

                user.setStatus("desativado");//######DESATIVA O USUARIO#####
                userDAO.atualizaUsuario(user);//chama o metodo de atualizacao

                //Mensagem de retorno ao usuario
                JOptionPane.showMessageDialog(null, "Usuário desativado com sucesso!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_btnDesativarActionPerformed

    private void btnAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivarActionPerformed

        if (txtDesativarID.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "Preencha o campo alterar!");
            txtUsuario.requestFocus();
        } else {
            int idusuario;
            idusuario = Integer.parseInt(txtDesativarID.getText());

            UsuariosDAO userDAO = new UsuariosDAO();
            Usuario user = new Usuario();

            //fazendo a chamada do metodo para buscar por id
            userDAO.buscaPorID(idusuario, user);

            user.setStatus("ativado");//######ATIVA O USUARIO#####
            try {
                userDAO.atualizaUsuario(user);//chama o metodo de atualizacao
            } catch (SQLException ex) {
                Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Mensagem de retorno ao usuario
            JOptionPane.showMessageDialog(null, "Usuário ativado com sucesso!");
        }


    }//GEN-LAST:event_btnAtivarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtivar;
    private javax.swing.JButton btnDesativar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel lblAtivarDesativar;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTipoAcesso;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JScrollPane pnlTabelaConsulta;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.ButtonGroup rdoGrupo1;
    private javax.swing.JRadioButton rdoPadrao;
    private javax.swing.JTable tblListaUsuarios;
    private javax.swing.JTextField txtDesativarID;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}