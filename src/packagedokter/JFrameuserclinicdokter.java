/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagedokter;



import packagehome.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import packageKoneksi.config;
import packageLogin.JFrameLogin;
import packagehome.JFrameclinicdata;
import packagehome.JFramehome;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JFrameuserclinicdokter extends javax.swing.JFrame {
    
    public Statement st;
    public ResultSet rs;
    Connection cn = packageKoneksi.config.BukaKoneksi();

    
    /**
     * Creates new form JFramehome
     */
    public JFrameuserclinicdokter() {
        initComponents();
        
       Tampildatadokter();
       TampilAllUser();
        
        
        Submenuuser.setVisible(true);
        paneluser.setVisible(true);
        panel_dokter.setVisible(false);
        panel_alluser.setVisible(false);
        
    }
    



     private void BersihDokter(){
        IdPegawaiDokter.setText("");
        tSpesialist.setText("");
    }
    
    private void Tampildatadokter(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM dokter");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id Dokter");
            model.addColumn("Nama");
            model.addColumn("Telepon");
            model.addColumn("Alamat");
            model.addColumn("Email");
            model.addColumn("Spesialis");
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {
                  rs.getString("id_pegawai"),
                  rs.getString("nama"),
                  rs.getString("telepon"),
                  rs.getString("alamat"),
                  rs.getString("email"),
                  rs.getString("spesialis"),
                };
                model.addRow(data);
                tbl_dokteruser.setModel(model);
            }
        } catch (Exception e) {
        }
    }
    
    
    private void TampilAllUser(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM klinik_user");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id Pegawai");
            model.addColumn("Nama");
            model.addColumn("Telepon");
            model.addColumn("Email");
            model.addColumn("Alamat");
            model.addColumn("Status");
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {
                  rs.getString("id_pegawai"),
                  rs.getString("nama"),
                  rs.getString("telepon"),
                  rs.getString("email"),
                  rs.getString("alamat"),
                  rs.getString("status"),
                };
                model.addRow(data);
                TableallUser.setModel(model);
            }
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_home = new rojerusan.RSButtonIconD();
        btn_data = new rojerusan.RSButtonIconD();
        btn_report = new rojerusan.RSButtonIconD();
        btn_user = new rojerusan.RSButtonIconD();
        btn_us = new rojerusan.RSButtonIconD();
        btn_logout = new rojerusan.RSButtonIconD();
        jPanel3 = new javax.swing.JPanel();
        Submenuuser = new javax.swing.JPanel();
        label2 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        panel_alluser = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableallUser = new javax.swing.JTable();
        panel_dokter = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        IdPegawaiDokter = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tSpesialist = new javax.swing.JTextField();
        submitdokter = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dokteruser = new javax.swing.JTable();
        paneluser = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clinic.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("STKaiti", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Welcome to Healthy-Connect");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 490, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 180));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_home.setBackground(new java.awt.Color(165, 165, 165));
        btn_home.setForeground(new java.awt.Color(0, 0, 0));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/homee.png"))); // NOI18N
        btn_home.setText("Home ");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 51));

        btn_data.setBackground(new java.awt.Color(165, 165, 165));
        btn_data.setForeground(new java.awt.Color(0, 0, 0));
        btn_data.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/data.png"))); // NOI18N
        btn_data.setText("Clinic Data");
        btn_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dataActionPerformed(evt);
            }
        });
        jPanel2.add(btn_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, 50));

        btn_report.setBackground(new java.awt.Color(165, 165, 165));
        btn_report.setForeground(new java.awt.Color(0, 0, 0));
        btn_report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/report.png"))); // NOI18N
        btn_report.setText("Report Clinic");
        btn_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportActionPerformed(evt);
            }
        });
        jPanel2.add(btn_report, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, 50));

        btn_user.setBackground(new java.awt.Color(165, 165, 165));
        btn_user.setForeground(new java.awt.Color(0, 0, 0));
        btn_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/i_user.png"))); // NOI18N
        btn_user.setText("User Clinic");
        btn_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userActionPerformed(evt);
            }
        });
        jPanel2.add(btn_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, 50));

        btn_us.setBackground(new java.awt.Color(165, 165, 165));
        btn_us.setForeground(new java.awt.Color(0, 0, 0));
        btn_us.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/us.png"))); // NOI18N
        btn_us.setText("About US");
        btn_us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usActionPerformed(evt);
            }
        });
        jPanel2.add(btn_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, -1, 50));

        btn_logout.setBackground(new java.awt.Color(165, 165, 165));
        btn_logout.setForeground(new java.awt.Color(0, 0, 0));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        jPanel2.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 200, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1250, 50));

        jPanel3.setBackground(new java.awt.Color(124, 192, 192));
        jPanel3.setForeground(new java.awt.Color(124, 192, 192));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Submenuuser.setBackground(new java.awt.Color(0, 102, 102));
        Submenuuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        Submenuuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SubmenuuserMouseEntered(evt);
            }
        });
        Submenuuser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label2.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/activitas.png"))); // NOI18N
        label2.setText("Doctor's User");
        label2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });
        Submenuuser.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        label4.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/alluser.png"))); // NOI18N
        label4.setText("All User Data");
        label4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label4MouseClicked(evt);
            }
        });
        Submenuuser.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jPanel3.add(Submenuuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 200, 80));

        panel_alluser.setBackground(new java.awt.Color(124, 192, 192));
        panel_alluser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel15.setText("All Data User");
        panel_alluser.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        TableallUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Pegawai", "Nama", "Telepon", "Email", "Alamat", "Status"
            }
        ));
        TableallUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableallUserMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableallUser);

        panel_alluser.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 1100, -1));

        jPanel3.add(panel_alluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        panel_dokter.setBackground(new java.awt.Color(124, 192, 192));
        panel_dokter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel23.setText("Doctor User ");
        panel_dokter.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        jLabel24.setText("Id Pegawai");
        panel_dokter.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));
        panel_dokter.add(IdPegawaiDokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 230, 30));

        jLabel25.setText("Spelisialist ");
        panel_dokter.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));
        panel_dokter.add(tSpesialist, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 230, 30));

        submitdokter.setBackground(new java.awt.Color(0, 102, 102));
        submitdokter.setText("Submit");
        submitdokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitdokterActionPerformed(evt);
            }
        });
        panel_dokter.add(submitdokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 120, 40));

        tbl_dokteruser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Dokter", "Nama", "Telepon", "Alamat", "Email", "Spesialis"
            }
        ));
        jScrollPane2.setViewportView(tbl_dokteruser);

        panel_dokter.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 850, -1));

        jPanel3.add(panel_dokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        paneluser.setBackground(new java.awt.Color(124, 192, 192));
        paneluser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(paneluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1250, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
      JFramehomeDokter homedokter = new JFramehomeDokter();
      homedokter.show();
      Submenuuser.setVisible(!Submenuuser.isVisible());
      this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
      JFrameuserclinicdokter userdokter = new JFrameuserclinicdokter();
      userdokter.show();
      
      this.dispose();        
      Submenuuser.setVisible(!Submenuuser.isVisible());
    }//GEN-LAST:event_btn_userActionPerformed

    private void btn_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataActionPerformed
      JFrameclinicdata data = new JFrameclinicdata();
      data.show();
      Submenuuser.setVisible(!Submenuuser.isVisible());
      this.dispose();
    }//GEN-LAST:event_btn_dataActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
      JFrameLogin login = new JFrameLogin();
      login.show();
      
      this.dispose();
      JOptionPane.showMessageDialog(null, "Logout Success");
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
     dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btn_usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usActionPerformed
      JFrameAboutUs us = new JFrameAboutUs();
      us.show();
      Submenuuser.setVisible(!Submenuuser.isVisible());
      this.dispose();
    }//GEN-LAST:event_btn_usActionPerformed

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked
        panel_dokter.setVisible(true);
        paneluser.setVisible(false);
        panel_alluser.setVisible(false);
        
        Submenuuser.setVisible(false);
    }//GEN-LAST:event_label2MouseClicked

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
      JFramereportclinicdokter reportdokter = new JFramereportclinicdokter();
      reportdokter.show();
       Submenuuser.setVisible(!Submenuuser.isVisible());
       this.dispose();
    }//GEN-LAST:event_btn_reportActionPerformed

    private void submitdokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitdokterActionPerformed
        String IdPegawai = IdPegawaiDokter.getText();
        String Status = tSpesialist.getText();

        if(IdPegawai.isEmpty() || Status.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua Kolom Harus Diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Query untuk insert data ke dalam tabel apoteker dengan menggunakan data dari klinik_user
            String sql = "INSERT INTO dokter (id_pegawai, nama, telepon, alamat, email, spesialis) " +
            "SELECT ?, nama, telepon, alamat, email, ? FROM klinik_user WHERE id_pegawai = ?";

            Connection cn = config.BukaKoneksi();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setString(1, IdPegawai);
            pstmt.setString(2, Status);
            pstmt.setString(3, IdPegawai);  // Ubah sesuai dengan kolom primary key yang sesuai di klinik_user

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Anda Berhasil di Simpan");
            Tampildatadokter();
            BersihDokter();
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }//GEN-LAST:event_submitdokterActionPerformed

    private void label4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label4MouseClicked
        panel_alluser.setVisible(true);;
        panel_dokter.setVisible(false);
        paneluser.setVisible(false);
        
        Submenuuser.setVisible(false);
    }//GEN-LAST:event_label4MouseClicked

    private void SubmenuuserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuuserMouseEntered
        Submenuuser.setVisible(true);
    }//GEN-LAST:event_SubmenuuserMouseEntered

    private void TableallUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableallUserMouseClicked
    }//GEN-LAST:event_TableallUserMouseClicked

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
            java.util.logging.Logger.getLogger(JFrameuserclinicdokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameuserclinicdokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameuserclinicdokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameuserclinicdokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameuserclinicdokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdPegawaiDokter;
    private javax.swing.JPanel Submenuuser;
    private javax.swing.JTable TableallUser;
    private rojerusan.RSButtonIconD btn_data;
    private rojerusan.RSButtonIconD btn_home;
    private rojerusan.RSButtonIconD btn_logout;
    private rojerusan.RSButtonIconD btn_report;
    private rojerusan.RSButtonIconD btn_us;
    private rojerusan.RSButtonIconD btn_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label4;
    private javax.swing.JPanel panel_alluser;
    private javax.swing.JPanel panel_dokter;
    private javax.swing.JPanel paneluser;
    private rojerusan.RSMaterialButtonRectangle submitdokter;
    private javax.swing.JTextField tSpesialist;
    private javax.swing.JTable tbl_dokteruser;
    // End of variables declaration//GEN-END:variables
}
