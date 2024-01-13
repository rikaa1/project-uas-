/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagehome;



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

public class JFrameuserclinic extends javax.swing.JFrame {
    
    public Statement st;
    public ResultSet rs;
    Connection cn = packageKoneksi.config.BukaKoneksi();

    
    /**
     * Creates new form JFramehome
     */
    public JFrameuserclinic() {
        initComponents();
        
       TampilAddAdmin();
       Tampildatapotekeruser();
       Tampildatadokter();
       TampilAllUser();
        
        
        Submenuuser.setVisible(true);
        paneluser.setVisible(true);
        panel_adduser.setVisible(false);
        panel_admin.setVisible(false);
        panel_apoteker.setVisible(false);
        panel_dokter.setVisible(false);
        panel_alluser.setVisible(false);
        
    }
    
    private void Bersihadduser (){
      t_idpegawaiuser.setText("");
      t_nameuser.setText("");
      t_phonenumberuser.setText("");
      t_emailuser.setText("");
      t_addressuser.setText("");
      jstatususer.setSelectedIndex(-1);
      t_usernameuser.setText("");
      t_passworduser.setText("");
      
      btn_canceladduser.setText("Cancel");
    }
    
    private void BersihAllUser (){
      t_IdPegawaiAllUser.setText("");
      t_nameAllUser.setText("");
      t_phonenumberAllUser.setText("");
      t_emailAllUser.setText("");
      t_addressAllUser.setText("");
      jstatusAllUser.setSelectedIndex(-1);
      t_usernameAllUser.setText("");
      t_passwordAllUser.setText("");
    }
    
    
    private void BersihAddAdmin (){
      t_idpegawaiuser.setText("");
      t_nameuser.setText("");
      t_phonenumberuser.setText("");
      t_emailuser.setText("");
      t_addressuser.setText("");
      jstatususer.setSelectedIndex(-1);
      t_usernameuser.setText("");
      t_passworduser.setText("");
    }
    
    private void BersihAktivasiAdmin(){
        t_idpegawaiadmin.setText("");
    }
    
     private void BersihDokter(){
        IdPegawaiDokter.setText("");
        tSpesialist.setText("");
    }
    private void caridataAlluser(){
            try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * fROM klinik_user WHERE " + cmbcariUser.getSelectedItem().toString() + 
                    " LIKE '%" + t_cariAllUser.getText() + "%'");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Id Pegawai");
            model.addColumn("Nama");
            model.addColumn("Telepon");
            model.addColumn("Email");
            model.addColumn("Alamat");
            model.addColumn("Status");
            model.addColumn("Username");
            model.addColumn("Password");
            
            
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
                  rs.getString("username"),
                  rs.getString("password"),
                };
                model.addRow(data);
                TableallUser.setModel(model);
            }
        } catch (Exception e) {
        }
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
    
    private void TampilAddAdmin(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM admin");
            
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
                Tabel_admin.setModel(model);
            }
        } catch (Exception e) {
        }
    }
    
    private void Tampildatapotekeruser(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM apoteker");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Apoteker");
            model.addColumn("Nama");
            model.addColumn("Telepon");
            model.addColumn("Alamat");
            model.addColumn("Email");
            model.addColumn("Shift");
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
                  rs.getString("shift"),
                };
                model.addRow(data);
               tbl_apotekeruser.setModel(model);
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
            model.addColumn("Username");
            model.addColumn("Password");
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
                  rs.getString("username"),
                  rs.getString("password"),
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
        panel_alluser = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        t_IdPegawaiAllUser = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        t_nameAllUser = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        t_phonenumberAllUser = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        t_emailAllUser = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        t_addressAllUser = new javax.swing.JTextField();
        jstatusAllUser = new rojerusan.RSComboMetro();
        jLabel21 = new javax.swing.JLabel();
        t_usernameAllUser = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        t_passwordAllUser = new javax.swing.JPasswordField();
        btn_changeUser = new rojerusan.RSMaterialButtonRectangle();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableallUser = new javax.swing.JTable();
        btn_deleteUser = new rojerusan.RSMaterialButtonRectangle();
        jLabel31 = new javax.swing.JLabel();
        cmbcariUser = new javax.swing.JComboBox<>();
        t_cariAllUser = new javax.swing.JTextField();
        btn_bersihuser = new rojerusan.RSMaterialButtonRectangle();
        Submenuuser = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel_adduser = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        t_idpegawaiuser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_nameuser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t_phonenumberuser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        t_emailuser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        t_addressuser = new javax.swing.JTextField();
        jstatususer = new rojerusan.RSComboMetro();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        t_usernameuser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        t_passworduser = new javax.swing.JPasswordField();
        btn_regist = new rojerusan.RSMaterialButtonRectangle();
        jLabel13 = new javax.swing.JLabel();
        btn_canceladduser = new rojerusan.RSMaterialButtonRectangle();
        panel_dokter = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        IdPegawaiDokter = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tSpesialist = new javax.swing.JTextField();
        submitdokter = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dokteruser = new javax.swing.JTable();
        panel_admin = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        t_idpegawaiadmin = new javax.swing.JTextField();
        aktivasi_admin = new rojerusan.RSMaterialButtonRectangle();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_admin = new javax.swing.JTable();
        panel_apoteker = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        t_idapotekeruser = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        t_shiftuser = new javax.swing.JComboBox<>();
        btnsubmitapoteker = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_apotekeruser = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
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

        panel_alluser.setBackground(new java.awt.Color(124, 192, 192));
        panel_alluser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel15.setText("All Data User");
        panel_alluser.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        jLabel16.setText("Id Pegawai");
        panel_alluser.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        t_IdPegawaiAllUser.setBackground(new java.awt.Color(124, 192, 192));
        t_IdPegawaiAllUser.setForeground(new java.awt.Color(153, 153, 153));
        t_IdPegawaiAllUser.setText(" enter id pegawai...");
        t_IdPegawaiAllUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_IdPegawaiAllUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_IdPegawaiAllUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_IdPegawaiAllUserFocusLost(evt);
            }
        });
        panel_alluser.add(t_IdPegawaiAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 180, 40));

        jLabel17.setText("Name");
        panel_alluser.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        t_nameAllUser.setBackground(new java.awt.Color(124, 192, 192));
        t_nameAllUser.setForeground(new java.awt.Color(153, 153, 153));
        t_nameAllUser.setText(" enter your name..");
        t_nameAllUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_nameAllUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_nameAllUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_nameAllUserFocusLost(evt);
            }
        });
        panel_alluser.add(t_nameAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 170, 40));

        jLabel18.setText("Phone Number");
        panel_alluser.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        t_phonenumberAllUser.setBackground(new java.awt.Color(124, 192, 192));
        t_phonenumberAllUser.setForeground(new java.awt.Color(153, 153, 153));
        t_phonenumberAllUser.setText(" enter phone number..");
        t_phonenumberAllUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_phonenumberAllUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_phonenumberAllUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_phonenumberAllUserFocusLost(evt);
            }
        });
        panel_alluser.add(t_phonenumberAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 170, 40));

        jLabel19.setText("Email");
        panel_alluser.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        t_emailAllUser.setBackground(new java.awt.Color(124, 192, 192));
        t_emailAllUser.setForeground(new java.awt.Color(153, 153, 153));
        t_emailAllUser.setText(" enter email..");
        t_emailAllUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_emailAllUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_emailAllUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_emailAllUserFocusLost(evt);
            }
        });
        panel_alluser.add(t_emailAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 170, 40));

        jLabel20.setText("Address");
        panel_alluser.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, -1));

        t_addressAllUser.setBackground(new java.awt.Color(124, 192, 192));
        t_addressAllUser.setForeground(new java.awt.Color(153, 153, 153));
        t_addressAllUser.setText(" enter address..");
        t_addressAllUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_addressAllUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_addressAllUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_addressAllUserFocusLost(evt);
            }
        });
        t_addressAllUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_addressAllUserActionPerformed(evt);
            }
        });
        panel_alluser.add(t_addressAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 170, 40));

        jstatusAllUser.setBackground(new java.awt.Color(124, 192, 192));
        jstatusAllUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        jstatusAllUser.setForeground(new java.awt.Color(153, 153, 153));
        jstatusAllUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Dokter", "Apoteker" }));
        jstatusAllUser.setColorArrow(new java.awt.Color(0, 102, 102));
        jstatusAllUser.setColorFondo(new java.awt.Color(124, 192, 192));
        jstatusAllUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jstatusAllUserActionPerformed(evt);
            }
        });
        panel_alluser.add(jstatusAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 200, 40));

        jLabel21.setText("Username");
        panel_alluser.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        t_usernameAllUser.setBackground(new java.awt.Color(124, 192, 192));
        t_usernameAllUser.setForeground(new java.awt.Color(153, 153, 153));
        t_usernameAllUser.setText(" enter username..");
        t_usernameAllUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_usernameAllUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_usernameAllUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_usernameAllUserFocusLost(evt);
            }
        });
        panel_alluser.add(t_usernameAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 200, 40));

        jLabel28.setText("Password");
        panel_alluser.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        t_passwordAllUser.setBackground(new java.awt.Color(124, 192, 192));
        t_passwordAllUser.setText("isipassword");
        t_passwordAllUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_passwordAllUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_passwordAllUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_passwordAllUserFocusLost(evt);
            }
        });
        panel_alluser.add(t_passwordAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 200, 40));

        btn_changeUser.setBackground(new java.awt.Color(0, 102, 102));
        btn_changeUser.setText("Change");
        btn_changeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeUserActionPerformed(evt);
            }
        });
        panel_alluser.add(btn_changeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 140, 50));

        jLabel29.setText("Status");
        panel_alluser.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));

        TableallUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Pegawai", "Nama", "Telepon", "Email", "Alamat", "Status", "Username", "Password"
            }
        ));
        TableallUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableallUserMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableallUser);

        panel_alluser.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 161, 660, 360));

        btn_deleteUser.setBackground(new java.awt.Color(0, 102, 102));
        btn_deleteUser.setText("Delete");
        btn_deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteUserActionPerformed(evt);
            }
        });
        panel_alluser.add(btn_deleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 140, 50));

        jLabel31.setText("Cari Data :");
        panel_alluser.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        cmbcariUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pegawai", "Nama", "Telepon", "Email", "Alamat", "Status", "Username", "Password" }));
        panel_alluser.add(cmbcariUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 122, 180, 30));

        t_cariAllUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_cariAllUserKeyPressed(evt);
            }
        });
        panel_alluser.add(t_cariAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 380, 30));

        btn_bersihuser.setBackground(new java.awt.Color(0, 102, 102));
        btn_bersihuser.setText("Cancel");
        btn_bersihuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bersihuserActionPerformed(evt);
            }
        });
        panel_alluser.add(btn_bersihuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 140, 50));

        jPanel3.add(panel_alluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        Submenuuser.setBackground(new java.awt.Color(0, 102, 102));
        Submenuuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        Submenuuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SubmenuuserMouseEntered(evt);
            }
        });
        Submenuuser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jadwalDokter.png"))); // NOI18N
        label1.setText("Admin User");
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });
        Submenuuser.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

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
        Submenuuser.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        label3.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/apoteker.png"))); // NOI18N
        label3.setText("Pharmacist's User");
        label3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label3MouseClicked(evt);
            }
        });
        Submenuuser.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

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
        Submenuuser.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/adduser.png"))); // NOI18N
        jLabel2.setText("Add New User");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        Submenuuser.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel3.add(Submenuuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 200, 170));

        panel_adduser.setBackground(new java.awt.Color(124, 192, 192));
        panel_adduser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Id Pegawai");
        panel_adduser.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        t_idpegawaiuser.setBackground(new java.awt.Color(124, 192, 192));
        t_idpegawaiuser.setForeground(new java.awt.Color(153, 153, 153));
        t_idpegawaiuser.setText(" enter id pegawai...");
        t_idpegawaiuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_idpegawaiuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_idpegawaiuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_idpegawaiuserFocusLost(evt);
            }
        });
        panel_adduser.add(t_idpegawaiuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 180, 40));

        jLabel5.setText("Name");
        panel_adduser.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));

        t_nameuser.setBackground(new java.awt.Color(124, 192, 192));
        t_nameuser.setForeground(new java.awt.Color(153, 153, 153));
        t_nameuser.setText(" enter your name..");
        t_nameuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_nameuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_nameuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_nameuserFocusLost(evt);
            }
        });
        panel_adduser.add(t_nameuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 170, 40));

        jLabel6.setText("Phone Number");
        panel_adduser.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, -1, -1));

        t_phonenumberuser.setBackground(new java.awt.Color(124, 192, 192));
        t_phonenumberuser.setForeground(new java.awt.Color(153, 153, 153));
        t_phonenumberuser.setText(" enter phone number..");
        t_phonenumberuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_phonenumberuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_phonenumberuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_phonenumberuserFocusLost(evt);
            }
        });
        panel_adduser.add(t_phonenumberuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 170, 40));

        jLabel7.setText("Email");
        panel_adduser.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));

        t_emailuser.setBackground(new java.awt.Color(124, 192, 192));
        t_emailuser.setForeground(new java.awt.Color(153, 153, 153));
        t_emailuser.setText(" enter email..");
        t_emailuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_emailuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_emailuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_emailuserFocusLost(evt);
            }
        });
        panel_adduser.add(t_emailuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 170, 40));

        jLabel9.setText("Address");
        panel_adduser.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, -1, -1));

        t_addressuser.setBackground(new java.awt.Color(124, 192, 192));
        t_addressuser.setForeground(new java.awt.Color(153, 153, 153));
        t_addressuser.setText(" enter address..");
        t_addressuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_addressuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_addressuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_addressuserFocusLost(evt);
            }
        });
        t_addressuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_addressuserActionPerformed(evt);
            }
        });
        panel_adduser.add(t_addressuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 170, 40));

        jstatususer.setBackground(new java.awt.Color(124, 192, 192));
        jstatususer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        jstatususer.setForeground(new java.awt.Color(153, 153, 153));
        jstatususer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Dokter", "Apoteker" }));
        jstatususer.setColorArrow(new java.awt.Color(0, 102, 102));
        jstatususer.setColorFondo(new java.awt.Color(124, 192, 192));
        jstatususer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jstatususerActionPerformed(evt);
            }
        });
        panel_adduser.add(jstatususer, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 200, 40));

        jLabel10.setText("Status");
        panel_adduser.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, -1, -1));

        jLabel11.setText("Username");
        panel_adduser.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, -1, -1));

        t_usernameuser.setBackground(new java.awt.Color(124, 192, 192));
        t_usernameuser.setForeground(new java.awt.Color(153, 153, 153));
        t_usernameuser.setText(" enter username..");
        t_usernameuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_usernameuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_usernameuserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_usernameuserFocusLost(evt);
            }
        });
        panel_adduser.add(t_usernameuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 200, 40));

        jLabel3.setText("Password");
        panel_adduser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, -1, -1));

        t_passworduser.setBackground(new java.awt.Color(124, 192, 192));
        t_passworduser.setText("isipassword");
        t_passworduser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_passworduser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_passworduserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_passworduserFocusLost(evt);
            }
        });
        panel_adduser.add(t_passworduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 200, 40));

        btn_regist.setBackground(new java.awt.Color(0, 102, 102));
        btn_regist.setText("Register");
        btn_regist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registActionPerformed(evt);
            }
        });
        panel_adduser.add(btn_regist, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 140, 50));

        jLabel13.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel13.setText("JOIN WITH US !");
        panel_adduser.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        btn_canceladduser.setBackground(new java.awt.Color(0, 102, 102));
        btn_canceladduser.setText("Cancel");
        btn_canceladduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_canceladduserActionPerformed(evt);
            }
        });
        panel_adduser.add(btn_canceladduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 140, 50));

        jPanel3.add(panel_adduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

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

        panel_admin.setBackground(new java.awt.Color(124, 192, 192));
        panel_admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("Id Pegawai");
        panel_admin.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        t_idpegawaiadmin.setBackground(new java.awt.Color(124, 192, 192));
        t_idpegawaiadmin.setForeground(new java.awt.Color(153, 153, 153));
        t_idpegawaiadmin.setText(" enter id pegawai...");
        t_idpegawaiadmin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        t_idpegawaiadmin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_idpegawaiadminFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_idpegawaiadminFocusLost(evt);
            }
        });
        panel_admin.add(t_idpegawaiadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 220, 40));

        aktivasi_admin.setBackground(new java.awt.Color(0, 102, 102));
        aktivasi_admin.setText("Aktivasi");
        aktivasi_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktivasi_adminActionPerformed(evt);
            }
        });
        panel_admin.add(aktivasi_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 140, 50));

        jLabel22.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel22.setText("ADMIN USER");
        panel_admin.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        Tabel_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Pegawai", "Name", "Phone Number", "Email", "Address", "Status", "Username", "Password"
            }
        ));
        jScrollPane1.setViewportView(Tabel_admin);

        panel_admin.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 860, -1));

        jPanel3.add(panel_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        panel_apoteker.setBackground(new java.awt.Color(124, 192, 192));
        panel_apoteker.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setText("Id Apoteker :");
        panel_apoteker.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        t_idapotekeruser.setBackground(new java.awt.Color(124, 192, 192));
        t_idapotekeruser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        panel_apoteker.add(t_idapotekeruser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 250, 30));

        jLabel27.setText("Shift :");
        panel_apoteker.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        t_shiftuser.setBackground(new java.awt.Color(124, 192, 192));
        t_shiftuser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagi ( 08:00 pagi - 17:00 sore)", "Malam ( 17:00 sore - 08:00 pagi)" }));
        t_shiftuser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        panel_apoteker.add(t_shiftuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 250, 40));

        btnsubmitapoteker.setBackground(new java.awt.Color(0, 102, 102));
        btnsubmitapoteker.setText("Submit");
        btnsubmitapoteker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitapotekerActionPerformed(evt);
            }
        });
        panel_apoteker.add(btnsubmitapoteker, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 130, 40));

        tbl_apotekeruser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Apoteker", "Nama", "Telepon", "Alamat", "Email", "Shift"
            }
        ));
        jScrollPane3.setViewportView(tbl_apotekeruser);

        panel_apoteker.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 780, -1));

        jLabel30.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jLabel30.setText("Apoteker USER");
        panel_apoteker.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        jPanel3.add(panel_apoteker, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        paneluser.setBackground(new java.awt.Color(124, 192, 192));
        paneluser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(paneluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1250, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
      JFramehome home = new JFramehome();
      home.show();
      
      this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
        Submenuuser.setVisible(!Submenuuser.isVisible());
    }//GEN-LAST:event_btn_userActionPerformed

    private void btn_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataActionPerformed
      JFrameclinicdata data = new JFrameclinicdata();
      data.show();
      
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
      
      this.dispose();
    }//GEN-LAST:event_btn_usActionPerformed

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked
        panel_dokter.setVisible(true);
        panel_admin.setVisible(false);
        panel_adduser.setVisible(false);
        panel_apoteker.setVisible(false);
        paneluser.setVisible(false);
        panel_alluser.setVisible(false);
        
        Submenuuser.setVisible(!Submenuuser.isVisible());
    }//GEN-LAST:event_label2MouseClicked

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        panel_admin.setVisible(true);
        panel_adduser.setVisible(false);
        panel_dokter.setVisible(false);
        panel_apoteker.setVisible(false);
        paneluser.setVisible(false);
        panel_alluser.setVisible(false);
        
        Submenuuser.setVisible(!Submenuuser.isVisible());
    }//GEN-LAST:event_label1MouseClicked

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
         JFramereportclinic report = new JFramereportclinic();
          report.show();
        
        this.dispose();
    }//GEN-LAST:event_btn_reportActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        panel_adduser.setVisible(true);
        panel_admin.setVisible(false);
        panel_dokter.setVisible(false);
        panel_apoteker.setVisible(false);
        paneluser.setVisible(false);
        panel_alluser.setVisible(false);
        
       Submenuuser.setVisible(!Submenuuser.isVisible());
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_registActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registActionPerformed
       String id_pegawai = t_idpegawaiuser.getText();
       String name = t_nameuser.getText();
       String phonenumber = t_phonenumberuser.getText();
       String email = t_emailuser.getText();
       String address = t_addressuser.getText();
       String status = jstatususer.getSelectedItem().toString();
       String username = t_usernameuser.getText();
       String password = t_passworduser.getText();
       
        if(id_pegawai.isEmpty() || name.isEmpty() || phonenumber.isEmpty() || email.isEmpty() || address.isEmpty() || status.isEmpty() || username.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua Kolom Harus Diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            // Query untuk insert data ke dalam tabel apoteker dengan menggunakan data dari klinik_user
            String sql = "INSERT INTO klinik_user (id_pegawai, nama, telepon, email, alamat, status, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            Connection cn = config.BukaKoneksi();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setString(1, id_pegawai);
            pstmt.setString(2, name);
            pstmt.setString(3, phonenumber);
            pstmt.setString(4, email);  
            pstmt.setString(5, address);
            pstmt.setString(6, status); 
            pstmt.setString(7, username);
            pstmt.setString(8, password); // Ubah sesuai dengan kolom primary key yang sesuai di klinik_user

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Anda Berhasil di Simpan");
            BersihAddAdmin();
            TampilAllUser();
            panel_alluser.setVisible(true);
            panel_apoteker.setVisible(false);
            panel_admin.setVisible(false);
            panel_adduser.setVisible(false);
            panel_dokter.setVisible(false);
            paneluser.setVisible(false);
        
            Submenuuser.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_registActionPerformed

    private void t_passworduserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passworduserFocusLost
        String password = t_passworduser.getText();
        if(password.equals("") ||password.equals("isipassword")) {
            t_passworduser.setText("isipassword");
        }
    }//GEN-LAST:event_t_passworduserFocusLost

    private void t_passworduserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passworduserFocusGained
        String password = t_passworduser.getText();
        if(password.equals("isipassword")){
            t_passworduser.setText("");
        }
    }//GEN-LAST:event_t_passworduserFocusGained

    private void t_usernameuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameuserFocusLost
        String usernamee = t_usernameuser.getText();
        if(usernamee.equals("") ||usernamee.equals(" enter username..")) {
            t_usernameuser.setText(" enter username..");
        }
    }//GEN-LAST:event_t_usernameuserFocusLost

    private void t_usernameuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameuserFocusGained
        String usernamee = t_usernameuser.getText();
        if(usernamee.equals(" enter username..")){
            t_usernameuser.setText("");
        }
    }//GEN-LAST:event_t_usernameuserFocusGained

    private void jstatususerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jstatususerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jstatususerActionPerformed

    private void t_addressuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_addressuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_addressuserActionPerformed

    private void t_addressuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_addressuserFocusLost
        String address = t_addressuser.getText();
        if(address.equals("") ||address.equals(" enter address..")) {
            t_addressuser.setText(" enter address..");
        }
    }//GEN-LAST:event_t_addressuserFocusLost

    private void t_addressuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_addressuserFocusGained
        String address = t_addressuser.getText();
        if(address.equals(" enter address..")){
            t_addressuser.setText("");
        }
    }//GEN-LAST:event_t_addressuserFocusGained

    private void t_emailuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_emailuserFocusLost
        String email = t_emailuser.getText();
        if(email.equals("") ||email.equals(" enter email..")) {
            t_emailuser.setText(" enter email..");
        }
    }//GEN-LAST:event_t_emailuserFocusLost

    private void t_emailuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_emailuserFocusGained
        String email = t_emailuser.getText();
        if(email.equals(" enter email..")){
            t_emailuser.setText("");
        }
    }//GEN-LAST:event_t_emailuserFocusGained

    private void t_phonenumberuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_phonenumberuserFocusLost
        String number = t_phonenumberuser.getText();
        if(number.equals("") ||number.equals(" enter phone number..")) {
            t_phonenumberuser.setText(" enter phone number..");
        }
    }//GEN-LAST:event_t_phonenumberuserFocusLost

    private void t_phonenumberuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_phonenumberuserFocusGained
        String number = t_phonenumberuser.getText();
        if(number.equals(" enter phone number..")){
            t_phonenumberuser.setText("");
        }
    }//GEN-LAST:event_t_phonenumberuserFocusGained

    private void t_nameuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nameuserFocusLost
        String name = t_nameuser.getText();
        if(name.equals("") ||name.equals(" enter your name..")) {
            t_nameuser.setText(" enter your name..");
        }
    }//GEN-LAST:event_t_nameuserFocusLost

    private void t_nameuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nameuserFocusGained
        String name = t_nameuser.getText();
        if(name.equals(" enter your name..")){
            t_nameuser.setText("");
        }
    }//GEN-LAST:event_t_nameuserFocusGained

    private void t_idpegawaiuserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_idpegawaiuserFocusLost
        String id_pegawai = t_idpegawaiuser.getText();
        if(id_pegawai.equals("") ||t_idpegawaiuser.equals(" enter id pegawai...")) {
            t_idpegawaiuser.setText(" enter id pegawai...");
        }
    }//GEN-LAST:event_t_idpegawaiuserFocusLost

    private void t_idpegawaiuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_idpegawaiuserFocusGained
        String id_pegawai = t_idpegawaiuser.getText();
        if(id_pegawai.equals(" enter id pegawai...")){
            t_idpegawaiuser.setText("");
        }
    }//GEN-LAST:event_t_idpegawaiuserFocusGained

    private void t_idpegawaiadminFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_idpegawaiadminFocusGained
        String id_pegawai = t_idpegawaiadmin.getText();
        if(id_pegawai.equals(" enter id pegawai...")){
            t_idpegawaiadmin.setText("");
        }
    }//GEN-LAST:event_t_idpegawaiadminFocusGained

    private void t_idpegawaiadminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_idpegawaiadminFocusLost
        String id_pegawai = t_idpegawaiadmin.getText();
        if(id_pegawai.equals("") || id_pegawai.equals(" enter id pegawai...")) {
            t_idpegawaiadmin.setText(" enter id pegawai...");
        }
    }//GEN-LAST:event_t_idpegawaiadminFocusLost

    private void aktivasi_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktivasi_adminActionPerformed
       String id_pegawai = t_idpegawaiadmin.getText();
        if(id_pegawai.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua Kolom Harus Diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            // Query untuk insert data ke dalam tabel apoteker dengan menggunakan data dari klinik_user
            String sql = "INSERT INTO admin (id_pegawai, nama, telepon, email, alamat, status)" +
                        "SELECT ?, nama, telepon, email, alamat, status FROM klinik_user WHERE id_pegawai = ?";
            Connection cn = config.BukaKoneksi();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setString(1, id_pegawai);
            pstmt.setString(2, id_pegawai);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Anda Berhasil di Simpan");
            
            TampilAddAdmin();
            BersihAktivasiAdmin();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_aktivasi_adminActionPerformed

    private void btnsubmitapotekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitapotekerActionPerformed
        String idapoteker = t_idapotekeruser.getText();
        String selectedshift = (String) t_shiftuser.getSelectedItem();

        if(idapoteker.isEmpty() || selectedshift.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua Kolom Harus Diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Query untuk insert data ke dalam tabel apoteker dengan menggunakan data dari klinik_user
            String sql = "INSERT INTO apoteker (id_pegawai, nama, telepon, alamat, email, shift) " +
            "SELECT ?, nama, telepon, alamat, email, ? FROM klinik_user WHERE id_pegawai = ?";

            Connection cn = config.BukaKoneksi();
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setString(1, idapoteker);
            pstmt.setString(2, selectedshift);
            pstmt.setString(3, idapoteker);  // Ubah sesuai dengan kolom primary key yang sesuai di klinik_user

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Anda Berhasil di Simpan");
            Tampildatapotekeruser(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnsubmitapotekerActionPerformed

    private void label3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3MouseClicked
        panel_apoteker.setVisible(true);
        panel_admin.setVisible(false);
        panel_adduser.setVisible(false);
        panel_dokter.setVisible(false);
        paneluser.setVisible(false);
        panel_alluser.setVisible(false);
        
        Submenuuser.setVisible(!Submenuuser.isVisible());
    }//GEN-LAST:event_label3MouseClicked

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
        panel_alluser.setVisible(true);
        panel_apoteker.setVisible(false);
        panel_admin.setVisible(false);
        panel_adduser.setVisible(false);
        panel_dokter.setVisible(false);
        paneluser.setVisible(false);
        
        Submenuuser.setVisible(!Submenuuser.isVisible());
    }//GEN-LAST:event_label4MouseClicked

    private void SubmenuuserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuuserMouseEntered

    }//GEN-LAST:event_SubmenuuserMouseEntered

    private void btn_canceladduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_canceladduserActionPerformed
       Bersihadduser();
    }//GEN-LAST:event_btn_canceladduserActionPerformed

    private void t_IdPegawaiAllUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_IdPegawaiAllUserFocusGained
        String id_pegawai = t_IdPegawaiAllUser.getText();
        if(id_pegawai.equals(" enter id pegawai...")){
            t_IdPegawaiAllUser.setText("");
        }
    }//GEN-LAST:event_t_IdPegawaiAllUserFocusGained

    private void t_IdPegawaiAllUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_IdPegawaiAllUserFocusLost
        String id_pegawai = t_IdPegawaiAllUser.getText();
        if(id_pegawai.equals("") ||t_IdPegawaiAllUser.equals(" enter id pegawai...")) {
            t_IdPegawaiAllUser.setText(" enter id pegawai...");
        }
    }//GEN-LAST:event_t_IdPegawaiAllUserFocusLost

    private void t_nameAllUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nameAllUserFocusGained
        String name = t_nameAllUser.getText();
        if(name.equals(" enter your name..")){
            t_nameAllUser.setText("");
        }
    }//GEN-LAST:event_t_nameAllUserFocusGained

    private void t_nameAllUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nameAllUserFocusLost
        String name = t_nameAllUser.getText();
        if(name.equals("") ||name.equals(" enter your name..")) {
            t_nameAllUser.setText(" enter your name..");
        }
    }//GEN-LAST:event_t_nameAllUserFocusLost

    private void t_phonenumberAllUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_phonenumberAllUserFocusGained
        String number = t_phonenumberAllUser.getText();
        if(number.equals(" enter phone number..")){
            t_phonenumberAllUser.setText("");
        }
    }//GEN-LAST:event_t_phonenumberAllUserFocusGained

    private void t_phonenumberAllUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_phonenumberAllUserFocusLost
        String number = t_phonenumberAllUser.getText();
        if(number.equals("") ||number.equals(" enter phone number..")) {
            t_phonenumberAllUser.setText(" enter phone number..");
        }
    }//GEN-LAST:event_t_phonenumberAllUserFocusLost

    private void t_emailAllUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_emailAllUserFocusGained
        String email = t_emailAllUser.getText();
        if(email.equals(" enter email..")){
            t_emailAllUser.setText("");
        }
    }//GEN-LAST:event_t_emailAllUserFocusGained

    private void t_emailAllUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_emailAllUserFocusLost
        String email = t_emailAllUser.getText();
        if(email.equals("") ||email.equals(" enter email..")) {
            t_emailAllUser.setText(" enter email..");
        }
    }//GEN-LAST:event_t_emailAllUserFocusLost

    private void t_addressAllUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_addressAllUserFocusGained
        String address = t_addressAllUser.getText();
        if(address.equals(" enter address..")){
            t_addressAllUser.setText("");
        }
    }//GEN-LAST:event_t_addressAllUserFocusGained

    private void t_addressAllUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_addressAllUserFocusLost
        String address = t_addressAllUser.getText();
        if(address.equals("") ||address.equals(" enter address..")) {
            t_addressAllUser.setText(" enter address..");
        }
    }//GEN-LAST:event_t_addressAllUserFocusLost

    private void t_addressAllUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_addressAllUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_addressAllUserActionPerformed

    private void jstatusAllUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jstatusAllUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jstatusAllUserActionPerformed

    private void t_usernameAllUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameAllUserFocusGained
        String usernamee = t_usernameAllUser.getText();
        if(usernamee.equals(" enter username..")){
            t_usernameAllUser.setText("");
        }
    }//GEN-LAST:event_t_usernameAllUserFocusGained

    private void t_usernameAllUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameAllUserFocusLost
        String usernamee = t_usernameAllUser.getText();
        if(usernamee.equals("") ||usernamee.equals(" enter username..")) {
            t_usernameAllUser.setText(" enter username..");
        }
    }//GEN-LAST:event_t_usernameAllUserFocusLost

    private void t_passwordAllUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordAllUserFocusGained
        String password = t_passwordAllUser.getText();
        if(password.equals("isipassword")){
            t_passwordAllUser.setText("");
        }
    }//GEN-LAST:event_t_passwordAllUserFocusGained

    private void t_passwordAllUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordAllUserFocusLost
        String password = t_passwordAllUser.getText();
        if(password.equals("") ||password.equals("isipassword")) {
            t_passwordAllUser.setText("isipassword");
        }
    }//GEN-LAST:event_t_passwordAllUserFocusLost

    private void btn_changeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeUserActionPerformed
        int selectedRow = TableallUser.getSelectedRow();
        String selectSatuan = (String) jstatusAllUser.getSelectedItem();
        try {
            st = cn.createStatement();

            if (t_IdPegawaiAllUser.getText().equals("") ||  t_nameAllUser.getText().equals("") ||  t_phonenumberAllUser.getText().equals("") ||
                    t_emailAllUser.getText().equals("") ||  t_addressAllUser.getText().equals("") ||  jstatusAllUser.getSelectedItem().equals("")
                    || t_usernameAllUser.getText().equals("") || t_passwordAllUser.getPassword().equals("") ) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Validasi Data", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // Aksi simpan data
            if (btn_changeUser.getText().equals("Change")) {
                String sql = "UPDATE klinik_user SET nama = '" + t_nameAllUser.getText() +
                        "', telepon = '" + t_phonenumberAllUser.getText() +
                        "', email = '" +  t_emailAllUser.getText() +
                        "', alamat = '" + t_addressAllUser.getText() +
                        "', status = '" +jstatusAllUser.getSelectedItem().toString()+
                        "', username = '" + t_usernameAllUser.getText() +
                        "', password = '" + t_passwordAllUser.getText()+
                        "' WHERE id_pegawai = '" + t_IdPegawaiAllUser.getText() + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Anda Berhasil di Ubah");
                TampilAllUser();
                BersihAllUser();
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }//GEN-LAST:event_btn_changeUserActionPerformed

    private void btn_deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteUserActionPerformed
         String selectSatuan = (String) jstatusAllUser.getSelectedItem();
        
        if (t_IdPegawaiAllUser.getText().equals("") || t_nameAllUser.getText().equals("") || t_phonenumberAllUser.getText().equals("")
                || t_emailAllUser.getText().equals("") || t_addressAllUser.getText().equals("") || jstatusAllUser.getSelectedItem().equals("") || 
                t_usernameAllUser.getText().equals("") || t_passwordAllUser.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Yang Ingin Anda Hapus !");
        } else{
            int jawab = JOptionPane.showConfirmDialog(null, "Data Ini Akan di Hapus , lanjutkan? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab == 0) {
                try {
                    st = cn.createStatement();
                    String sql = "DELETE FROM klinik_user WHERE id_pegawai = '" + t_IdPegawaiAllUser.getText() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    TampilAllUser();
                    BersihAllUser();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btn_deleteUserActionPerformed

    private void TableallUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableallUserMouseClicked
         int selectedRow = TableallUser.getSelectedRow();

            if (selectedRow != -1) {
                t_IdPegawaiAllUser.setText(TableallUser.getValueAt(selectedRow, 0).toString());
                t_nameAllUser.setText(TableallUser.getValueAt(selectedRow, 1).toString());
                t_phonenumberAllUser.setText(TableallUser.getValueAt(selectedRow, 2).toString());
                t_emailAllUser.setText(TableallUser.getValueAt(selectedRow, 3).toString());
                t_addressAllUser.setText(TableallUser.getValueAt(selectedRow, 4).toString());
                Object selectedValue = TableallUser.getValueAt(selectedRow, 5);
                jstatusAllUser.setSelectedItem(selectedValue);
                t_usernameAllUser.setText(TableallUser.getValueAt(selectedRow, 6).toString());
                t_passwordAllUser.setText(TableallUser.getValueAt(selectedRow, 7).toString());

                t_IdPegawaiAllUser.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(this, "Silakan pilih data terlebih dahulu");
}

    }//GEN-LAST:event_TableallUserMouseClicked

    private void t_cariAllUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariAllUserKeyPressed
        caridataAlluser();
    }//GEN-LAST:event_t_cariAllUserKeyPressed

    private void btn_bersihuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bersihuserActionPerformed
       BersihAllUser();
    }//GEN-LAST:event_btn_bersihuserActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameuserclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameuserclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameuserclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameuserclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new JFrameuserclinic().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdPegawaiDokter;
    private javax.swing.JPanel Submenuuser;
    private javax.swing.JTable Tabel_admin;
    private javax.swing.JTable TableallUser;
    private rojerusan.RSMaterialButtonRectangle aktivasi_admin;
    private rojerusan.RSMaterialButtonRectangle btn_bersihuser;
    private rojerusan.RSMaterialButtonRectangle btn_canceladduser;
    private rojerusan.RSMaterialButtonRectangle btn_changeUser;
    private rojerusan.RSButtonIconD btn_data;
    private rojerusan.RSMaterialButtonRectangle btn_deleteUser;
    private rojerusan.RSButtonIconD btn_home;
    private rojerusan.RSButtonIconD btn_logout;
    private rojerusan.RSMaterialButtonRectangle btn_regist;
    private rojerusan.RSButtonIconD btn_report;
    private rojerusan.RSButtonIconD btn_us;
    private rojerusan.RSButtonIconD btn_user;
    private rojerusan.RSMaterialButtonRectangle btnsubmitapoteker;
    private javax.swing.JComboBox<String> cmbcariUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private rojerusan.RSComboMetro jstatusAllUser;
    private rojerusan.RSComboMetro jstatususer;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JPanel panel_adduser;
    private javax.swing.JPanel panel_admin;
    private javax.swing.JPanel panel_alluser;
    private javax.swing.JPanel panel_apoteker;
    private javax.swing.JPanel panel_dokter;
    private javax.swing.JPanel paneluser;
    private rojerusan.RSMaterialButtonRectangle submitdokter;
    private javax.swing.JTextField tSpesialist;
    private javax.swing.JTextField t_IdPegawaiAllUser;
    private javax.swing.JTextField t_addressAllUser;
    private javax.swing.JTextField t_addressuser;
    private javax.swing.JTextField t_cariAllUser;
    private javax.swing.JTextField t_emailAllUser;
    private javax.swing.JTextField t_emailuser;
    private javax.swing.JTextField t_idapotekeruser;
    private javax.swing.JTextField t_idpegawaiadmin;
    private javax.swing.JTextField t_idpegawaiuser;
    private javax.swing.JTextField t_nameAllUser;
    private javax.swing.JTextField t_nameuser;
    private javax.swing.JPasswordField t_passwordAllUser;
    private javax.swing.JPasswordField t_passworduser;
    private javax.swing.JTextField t_phonenumberAllUser;
    private javax.swing.JTextField t_phonenumberuser;
    private javax.swing.JComboBox<String> t_shiftuser;
    private javax.swing.JTextField t_usernameAllUser;
    private javax.swing.JTextField t_usernameuser;
    private javax.swing.JTable tbl_apotekeruser;
    private javax.swing.JTable tbl_dokteruser;
    // End of variables declaration//GEN-END:variables
}
