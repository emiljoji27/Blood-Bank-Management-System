package Project;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Result extends javax.swing.JFrame {

    String arr[]=new String[5];
    public Result(){
        try {
            initComponents();
            table_1.setEnabled(false);
            int no=1;
            DefaultTableModel table_model_1=(DefaultTableModel)table_1.getModel();
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection("jdbc:postgresql://db.uttlgnvcihhdcbhxzdpg.supabase.co/postgres", "postgres", "bloodbank@1841");
            
            PreparedStatement sta;
            int x;
            String query = "SELECT * FROM req_history where req_id=?";
            sta=connection.prepareStatement(query);
            sta.setInt(1, Utility.req_id);
            ResultSet rs = sta.executeQuery();
            rs.next();
            String name=rs.getString("name");
            String district=rs.getString("district");
            String blood_group=rs.getString("blood_group");
            
            if(blood_group.equals("A+"))
                query = "SELECT profile.name,profile.blood_group,contact_details.mobile,contact_details.address,contact_details.district,profile.username FROM profile NATURAL JOIN contact_details where profile.blood_group IN ('O-','O+','A-','A+') AND profile.username=contact_details.username";
            else if(blood_group.equals("A-"))
                query = "SELECT profile.name,profile.blood_group,contact_details.mobile,contact_details.address,contact_details.district,profile.username FROM profile NATURAL JOIN contact_details where profile.blood_group IN ('O-','A-') AND profile.username=contact_details.username";
            else if(blood_group.equals("B+"))
                query = "SELECT profile.name,profile.blood_group,contact_details.mobile,contact_details.address,contact_details.district,profile.username FROM profile NATURAL JOIN contact_details where profile.blood_group IN ('O-','O+','B-','B+') AND profile.username=contact_details.username";
            else if(blood_group.equals("B-"))
                query = "SELECT profile.name,profile.blood_group,contact_details.mobile,contact_details.address,contact_details.district,profile.username FROM profile NATURAL JOIN contact_details where profile.blood_group IN ('O-','B-') AND profile.username=contact_details.username";
            else if(blood_group.equals("AB-"))
                query = "SELECT profile.name,profile.blood_group,contact_details.mobile,contact_details.address,contact_details.district,profile.username FROM profile NATURAL JOIN contact_details where profile.blood_group IN ('O-','A-','B-','AB-') AND profile.username=contact_details.username";
            else if(blood_group.equals("O-"))
                query = "SELECT profile.name,profile.blood_group,contact_details.mobile,contact_details.address,contact_details.district,profile.username FROM profile NATURAL JOIN contact_details where profile.blood_group IN ('O-') AND profile.username=contact_details.username";
            else if(blood_group.equals("AB+"))
                query = "SELECT profile.name,profile.blood_group,contact_details.mobile,contact_details.address,contact_details.district,profile.username FROM profile NATURAL JOIN contact_details where profile.blood_group IN ('O-','O+','A-','A+','B+','B-','AB+','AB-') AND profile.username=contact_details.username";
            else 
                query = "SELECT profile.name,profile.blood_group,contact_details.mobile,contact_details.address,contact_details.district,profile.username FROM profile NATURAL JOIN contact_details where profile.blood_group IN ('O-','O+') AND profile.username=contact_details.username";
            
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs=st.executeQuery(query);
            int num=1;
            while(rs.next())
            {
             if(rs.getString(5).equals(district))
             {
               String data[]={num+"",rs.getString(1),rs.getString(2),rs.getInt(3)+"",rs.getString(5),rs.getString(4)};
               table_model_1.addRow(data);
               arr[num-1]=rs.getString(6);
               num++;
             }
            }
            rs.first();
            rs.previous();
            while(rs.next() && num<6)
            {
               if(rs.getString(5).equals(district))
                   continue;
               String data[]={num+"",rs.getString(1),rs.getString(2),rs.getInt(3)+"",rs.getString(5),rs.getString(4)};
               table_model_1.addRow(data);
               arr[num-1]=rs.getString(6);
               num++;
            }
            connection.close();
            }
        catch (Exception ex) {
            Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_1 = new javax.swing.JTable();
        number = new javax.swing.JComboBox<>();
        request = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DONOR DETAILS");

        table_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No.", "Name", "Blood Group", "Phone", "District", "Address"
            }
        ));
        jScrollPane1.setViewportView(table_1);

        number.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4","5" }));

        request.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        request.setText("REQUEST");
        request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("HOMEPAGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(request, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(request, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void requestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestActionPerformed
       int s_no=Integer.parseInt(number.getSelectedItem().toString());
       String u_name=arr[s_no];
       try
       {
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection("jdbc:postgresql://db.uttlgnvcihhdcbhxzdpg.supabase.co/postgres", "postgres", "bloodbank@1841");
            
            PreparedStatement sta;
            String query = "insert into profile_req values(?,?,?)";
            sta=connection.prepareStatement(query);
            sta.setString(1, u_name);
            sta.setInt(2, Utility.req_id);
            sta.setString(3, "Pending");
            sta.executeUpdate();
            connection.close();
            new Homepage().setVisible(true);
            this.setVisible(false);
       }
       catch(Exception e)
       {
           
       }
       
    }//GEN-LAST:event_requestActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Homepage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> number;
    private javax.swing.JButton request;
    private javax.swing.JTable table_1;
    // End of variables declaration//GEN-END:variables
}
