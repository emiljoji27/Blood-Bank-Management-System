package Project;

import java.sql.*;
import javax.swing.JOptionPane;

class Login extends javax.swing.JFrame {
    public Login()
    {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username_1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        password_1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText(" Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 131, 95, 35));

        username_1.setText(" ");
        username_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_1ActionPerformed(evt);
            }
        });
        jPanel1.add(username_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 190, 35));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText(" Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 184, 95, 35));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("       LOGIN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 42, 162, 71));

        login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 105, 42));
        jPanel1.add(password_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 190, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void username_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_1ActionPerformed

    }//GEN-LAST:event_username_1ActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String username=username_1.getText();
        String password=password_1.getText();
         try 
                {
                    String driver = "org.postgresql.Driver";
                    Class.forName(driver);
                    Connection connection = DriverManager.getConnection("jdbc:postgresql://db.uttlgnvcihhdcbhxzdpg.supabase.co/postgres", "postgres", "bloodbank@1841");
                    
                    String query = "select * from login_cred where username=?";
                    PreparedStatement sta = connection.prepareStatement(query);
                    sta.setString(1, username.trim());
                    ResultSet rs=sta.executeQuery();
                    if(rs.next())
                    {
                        if(password.equals(rs.getString(2)))
                        {
                            Profile.main(null);
                            this.setVisible(false);
                            Utility.username=rs.getString(1);
                        }
                        else
                            JOptionPane.showMessageDialog(login, "INCORRECT PASSWORD");
                    }
                    else
                        JOptionPane.showMessageDialog(login, "INVALID USERNAME");
                }
         catch(Exception e)
         {
             
         }
    }//GEN-LAST:event_loginActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password_1;
    private javax.swing.JTextField username_1;
    // End of variables declaration//GEN-END:variables
}
