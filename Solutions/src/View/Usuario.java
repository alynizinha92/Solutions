/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author aline
 */
import java.sql.*;
import DAO.ModuloConexao;
import javax.swing.JOptionPane;

public class Usuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form Usuario
     */
    public Usuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void consultar(){
    String sql = "select * from usuario where cod_usuario = ? ";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1,txtUsuID.getText());
            rs=pst.executeQuery();
            if (rs.next()) {
                txtUsuNome.setText(rs.getString(2));
                txtUsuFone.setText(rs.getString(3));
                txtUsuLogin.setText(rs.getString(4));
                txtUsuSenha.setText(rs.getString(5));
                cboUsuperfil.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null,"Usuário não cadastrado");
                
                txtUsuNome.setText(null);
                txtUsuFone.setText(null);
                txtUsuLogin.setText(null);
                txtUsuSenha.setText(null);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //criando metodo para adicionar usuarios
    private void adicionar(){
        String sql = "insert into usuario(cod_usuario, nome_usuario, fone_usuario, login_usuario, senha_usuario, perfil_usuario) values (?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtUsuID.getText());
            pst.setString(2,txtUsuNome.getText());
            pst.setString(3,txtUsuFone.getText());
            pst.setString(4,txtUsuLogin.getText());
            pst.setString(5,txtUsuSenha.getText());
            pst.setString(6,cboUsuperfil.getSelectedItem().toString());
            //validacão dos campos obrigatórios
            if ((txtUsuID.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtUsuLogin.getText().isEmpty()) || (txtUsuSenha.getText().isEmpty())){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios");
            } else {
            
            int adicionado = pst.executeUpdate();
            // a linha abaixo serve para o entendimento da lógica
            //System.out.println(adicionado);
            if(adicionado > 0){
                JOptionPane.showMessageDialog(null,"Usuario adicionado com sucesso");
                txtUsuID.setText(null);
                txtUsuNome.setText(null);
                txtUsuFone.setText(null);
                txtUsuLogin.setText(null);
                txtUsuSenha.setText(null);
                
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }    
    }
    //criando metodos para alterar dados do usuario
    private void alterar(){
    String sql = "update usuario set nome_usuario=?,fone_usuario=?,login_usuario=?,senha_usuario=?,perfil_usuario=? where cod_usuario=? ";    
        try {
        pst=conexao.prepareStatement(sql);
        pst.setString(1,txtUsuNome.getText());
        pst.setString(2,txtUsuFone.getText());
        pst.setString(3,txtUsuLogin.getText());
        pst.setString(4,txtUsuSenha.getText());
        pst.setString(5,cboUsuperfil.getSelectedItem().toString());
        pst.setString(6,txtUsuID.getText());
        
        //validacão dos campos obrigatórios
            if ((txtUsuID.getText().isEmpty()) || (txtUsuNome.getText().isEmpty()) || (txtUsuLogin.getText().isEmpty()) || (txtUsuSenha.getText().isEmpty())){
             JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios");
            
            } else {
            
            int adicionado = pst.executeUpdate();
            // a linha abaixo serve para o entendimento da lógica
            //System.out.println(adicionado);
            if(adicionado > 0){
            JOptionPane.showMessageDialog(null,"Dados do usuario alterados com sucesso");
            txtUsuID.setText(null);
            txtUsuNome.setText(null);
            txtUsuFone.setText(null);
            txtUsuLogin.setText(null);
            txtUsuSenha.setText(null);
                
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }    
    }
    //criando o metodo rsponsavel pela remocao de usuarios
        private void remover(){
        int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja remover este usuario","Atenção",JOptionPane.YES_NO_OPTION);
            if (confirma==JOptionPane.YES_OPTION) {
                String sql ="delete from usuario where cod_usuario=?";
                try {
                    pst=conexao.prepareStatement(sql);
                    pst.setString(1,txtUsuID.getText());
            int apagado = pst.executeUpdate();
            if (apagado>0){
            JOptionPane.showMessageDialog(null,"Usuário removido com sucesso");
            txtUsuID.setText(null);
            txtUsuNome.setText(null);
            txtUsuFone.setText(null);
            txtUsuLogin.setText(null);
            txtUsuSenha.setText(null);
                
            }
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
                }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuID = new javax.swing.JTextField();
        txtUsuNome = new javax.swing.JTextField();
        txtUsuLogin = new javax.swing.JTextField();
        txtUsuSenha = new javax.swing.JTextField();
        cboUsuperfil = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtUsuFone = new javax.swing.JTextField();
        btnUsuRead = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnUsuCreate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(640, 492));

        jLabel1.setText("ID:");

        jLabel2.setText("*Nome:");

        jLabel3.setText("*Login:");

        jLabel4.setText("*Senha:");

        jLabel5.setText("*Perfil:");

        cboUsuperfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "user" }));

        jLabel6.setText("Fone:");

        btnUsuRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/read.png"))); // NOI18N
        btnUsuRead.setToolTipText("Consultar");
        btnUsuRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuReadActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        jButton3.setToolTipText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButton4.setToolTipText("Deletar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnUsuCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/create.png"))); // NOI18N
        btnUsuCreate.setToolTipText("Adicionar");
        btnUsuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuCreateActionPerformed(evt);
            }
        });

        jLabel7.setText("*Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                        .addComponent(btnUsuRead, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtUsuSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .addComponent(txtUsuFone, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboUsuperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(8, 8, 8))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuNome)
                                .addGap(8, 8, 8)))
                        .addContainerGap(76, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUsuID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtUsuFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboUsuperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuRead, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        setBounds(0, 0, 640, 492);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuReadActionPerformed
        // chama o método Consultar
        consultar();
    }//GEN-LAST:event_btnUsuReadActionPerformed

    private void btnUsuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCreateActionPerformed
        //chama o método adicionar
        adicionar();
    }//GEN-LAST:event_btnUsuCreateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // chama o método alterar
        alterar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // chama o metodo deletar
        remover();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuCreate;
    private javax.swing.JButton btnUsuRead;
    private javax.swing.JComboBox cboUsuperfil;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUsuFone;
    private javax.swing.JTextField txtUsuID;
    private javax.swing.JTextField txtUsuLogin;
    private javax.swing.JTextField txtUsuNome;
    private javax.swing.JTextField txtUsuSenha;
    // End of variables declaration//GEN-END:variables
}
