/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagedokter;



import java.awt.event.WindowEvent;
import packagehome.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import packageLogin.JFrameLogin;
import packagehome.JFramehome;
import packagehome.JFramereportclinic;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import packageKoneksi.config;

public class JFrameclinicdataDokter extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection cn = packageKoneksi.config.BukaKoneksi();
    
    
    /**
     * Creates new form JFramehome
     */
    public JFrameclinicdataDokter() {
        initComponents();
        

        
         Tampildatajadwaldokter();
         Tampildataaktivitasdokter();

        SubmenuData.setVisible(true);
        JadwalDokter.setVisible(false);
        aktivitasDokter.setVisible(false);
        try {
            String savedNama = JFrameLogin.getLoggedInNama();
            String savedStatus = JFrameLogin.getLoggedInStatus();
            setNamaStatusLabel(savedNama, savedStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        
        Date tanggal = new Date();

        // Format tanggal yang diinginkan
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        // Mengonversi objek Date menjadi String sesuai format
        String tanggalSebagaiString = dateFormat.format(tanggal);
        
    }
    
    public void setNamaStatusLabel(String nama, String status) {
        if (nama != null && status != null) {
            labelnama.setText(nama);
            labelstatus.setText(status);
        } else {
            // Set label ke nilai default jika nama atau status null
            labelnama.setText("Nama Default");
            labelstatus.setText("Status Default");
        }
}
    
    private void BersihJadwalDokter (){
       date.setDate(null);
       t_keterangan.setText("");
        btn_submit.setText("Submit");
    }
    

    private void Bersihdataaktivitasdokter (){
      tnomor.setText("");
      tname.setText("");
      date1.setDate(null);
      tresep.setText("");
      tinformation.setText("");;
      btnsubmit_1.setText("Submit");
    }
    
    private void Tampildatajadwaldokter(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM jadwal_dokter");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nomor");
            model.addColumn("Date");
            model.addColumn("Keterangan");
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {
                  rs.getString("nomor"),
                  rs.getString("tanggal"),
                  rs.getString("keterangan"),
                };
                model.addRow(data);
                Tabeljadwaldokter.setModel(model);
            }
        } catch (Exception e) {
        }
    }
 
    
    private void Tampildataaktivitasdokter(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM aktivitas_dokter");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("NoRegist Pasien");
            model.addColumn("Name");
            model.addColumn("Date");
            model.addColumn("Prescription drugs");
            model.addColumn("Information");
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {
                  rs.getString("no_registp"),
                  rs.getString("nama"),
                  rs.getString("tanggal"),
                  rs.getString("resep_obat"),
                  rs.getString("keterangan"),
                };
                model.addRow(data);
               tabel_aktivitas.setModel(model);
            }
        } catch (Exception e) {
        }
    }
    
    
     
     private void caridatajadwaldokter(){
            try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * fROM jadwal_dokter WHERE " + cbjadwal.getSelectedItem().toString() + 
                    " LIKE '%" + t_carijadwal.getText() + "%'");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nomor");
            model.addColumn("Date");
            model.addColumn("Keterangan");
            
           
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {
                  rs.getString("nomor"),
                  rs.getString("tanggal"),
                  rs.getString("keterangan")
                };
                model.addRow(data);
                Tabeljadwaldokter.setModel(model);
            }
        } catch (Exception e) {
        }
    }
     
     
     private void caridataaktivitasdokter(){
            try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * fROM aktivitas_dokter WHERE " + cbaktivitas.getSelectedItem().toString() + 
                    " LIKE '%" + t_cariaktivitas.getText() + "%'");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nomor Regist Pasien");
            model.addColumn("Name");
            model.addColumn("Date");
            model.addColumn("Prescription Drugs ");
            model.addColumn("Information");
           
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {
                  rs.getString("no_registp"),
                  rs.getString("nama"),
                  rs.getString("tanggal"),
                  rs.getString("resep_obat"),
                  rs.getString("keterangan")
                };
                model.addRow(data);
                tabel_aktivitas.setModel(model);
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
        jPanel3 = new javax.swing.JPanel();
        SubmenuData = new javax.swing.JPanel();
        label_jadwaldokter = new javax.swing.JLabel();
        label_aktivitasdokter = new javax.swing.JLabel();
        JadwalDokter = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelnama = new javax.swing.JLabel();
        labelstatus = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        date = new org.jdesktop.swingx.JXDatePicker();
        t_keterangan = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabeljadwaldokter = new javax.swing.JTable();
        btn_submit = new rojerusan.RSMaterialButtonRectangle();
        btn_delete = new rojerusan.RSMaterialButtonRectangle();
        btn_cancel = new rojerusan.RSMaterialButtonRectangle();
        jLabel2 = new javax.swing.JLabel();
        cbjadwal = new javax.swing.JComboBox<>();
        t_carijadwal = new javax.swing.JTextField();
        aktivitasDokter = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tinformation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tresep = new javax.swing.JTextField();
        date1 = new org.jdesktop.swingx.JXDatePicker();
        btncancel_1 = new rojerusan.RSMaterialButtonRectangle();
        btnsubmit_1 = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_aktivitas = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        cbaktivitas = new javax.swing.JComboBox<>();
        t_cariaktivitas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tnomor = new javax.swing.JTextField();
        btndeleteaktivitas = new rojerusan.RSMaterialButtonRectangle();
        jPanel2 = new javax.swing.JPanel();
        btn_home = new rojerusan.RSButtonIconD();
        btn_data = new rojerusan.RSButtonIconD();
        btn_report = new rojerusan.RSButtonIconD();
        btn_user = new rojerusan.RSButtonIconD();
        btn_us = new rojerusan.RSButtonIconD();
        btn_logout = new rojerusan.RSButtonIconD();

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

        jPanel3.setBackground(new java.awt.Color(124, 192, 192));
        jPanel3.setForeground(new java.awt.Color(124, 192, 192));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SubmenuData.setBackground(new java.awt.Color(0, 102, 102));
        SubmenuData.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        SubmenuData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SubmenuDataMouseEntered(evt);
            }
        });
        SubmenuData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_jadwaldokter.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        label_jadwaldokter.setForeground(new java.awt.Color(255, 255, 255));
        label_jadwaldokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jadwalDokter.png"))); // NOI18N
        label_jadwaldokter.setText("Doctor's Schedule");
        label_jadwaldokter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_jadwaldokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_jadwaldokterMouseClicked(evt);
            }
        });
        SubmenuData.add(label_jadwaldokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        label_aktivitasdokter.setFont(new java.awt.Font("Lucida Fax", 0, 13)); // NOI18N
        label_aktivitasdokter.setForeground(new java.awt.Color(255, 255, 255));
        label_aktivitasdokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/activitas.png"))); // NOI18N
        label_aktivitasdokter.setText("Doctor's Activity");
        label_aktivitasdokter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label_aktivitasdokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_aktivitasdokterMouseClicked(evt);
            }
        });
        SubmenuData.add(label_aktivitasdokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jPanel3.add(SubmenuData, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 200, 80));

        JadwalDokter.setBackground(new java.awt.Color(124, 192, 192));
        JadwalDokter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 39, -1, -1));

        jLabel11.setFont(new java.awt.Font("Constantia", 1, 13)); // NOI18N
        jLabel11.setText("Nama : ");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 30));

        jLabel12.setFont(new java.awt.Font("Constantia", 1, 13)); // NOI18N
        jLabel12.setText("Status :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 30));

        labelnama.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelnama.setText("jLabel20");
        jPanel4.add(labelnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, 30));

        labelstatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelstatus.setText("jLabel20");
        jPanel4.add(labelstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, 30));

        JadwalDokter.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 550));

        jLabel14.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel14.setText("JADWAL DOKTER");
        JadwalDokter.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel15.setText("Date ");
        JadwalDokter.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel16.setText("Keterangan");
        JadwalDokter.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, -1, -1));
        JadwalDokter.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 390, 30));

        t_keterangan.setBackground(new java.awt.Color(124, 192, 192));
        t_keterangan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 102)));
        JadwalDokter.add(t_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 390, 30));

        jPanel5.setBackground(new java.awt.Color(124, 192, 192));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabeljadwaldokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nomor", "Date", "Keterangan"
            }
        ));
        Tabeljadwaldokter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tabeljadwaldokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabeljadwaldokterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabeljadwaldokter);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 530, 100));

        btn_submit.setBackground(new java.awt.Color(0, 102, 102));
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        jPanel5.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 120, 40));

        btn_delete.setBackground(new java.awt.Color(0, 102, 102));
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel5.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 120, 40));

        btn_cancel.setBackground(new java.awt.Color(0, 102, 102));
        btn_cancel.setText("CANCEL");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel5.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 120, 40));

        jLabel2.setText("Cari Data :");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, -1, -1));

        cbjadwal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nomor", "Date", "Keterangan" }));
        jPanel5.add(cbjadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 250, 30));

        t_carijadwal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_carijadwalKeyPressed(evt);
            }
        });
        jPanel5.add(t_carijadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 270, 30));

        JadwalDokter.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1020, 550));

        jPanel3.add(JadwalDokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        aktivitasDokter.setBackground(new java.awt.Color(124, 192, 192));
        aktivitasDokter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel3.setText("DOCTOR'S ACTIVITY");
        aktivitasDokter.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 200, 20));

        jLabel5.setText("Name :");
        aktivitasDokter.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));
        aktivitasDokter.add(tinformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 380, 30));

        jLabel6.setText("Date :");
        aktivitasDokter.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));
        aktivitasDokter.add(tname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 380, 30));

        jLabel7.setText("Prescription Drugs :");
        aktivitasDokter.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        jLabel17.setText("Information : ");
        aktivitasDokter.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));
        aktivitasDokter.add(tresep, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 380, 30));
        aktivitasDokter.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 380, 30));

        btncancel_1.setBackground(new java.awt.Color(0, 102, 102));
        btncancel_1.setText("Cancel");
        btncancel_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancel_1ActionPerformed(evt);
            }
        });
        aktivitasDokter.add(btncancel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 110, 40));

        btnsubmit_1.setBackground(new java.awt.Color(0, 102, 102));
        btnsubmit_1.setText("Submit");
        btnsubmit_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmit_1ActionPerformed(evt);
            }
        });
        aktivitasDokter.add(btnsubmit_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 110, 40));

        tabel_aktivitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No Regist Pasien", "Name", "Date", "Prescription Drugs ", "Information"
            }
        ));
        tabel_aktivitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_aktivitasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_aktivitas);

        aktivitasDokter.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 610, 200));

        jLabel18.setText("Search");
        aktivitasDokter.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        cbaktivitas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama", "Date", "Prescription Drugs", "Information" }));
        cbaktivitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbaktivitasActionPerformed(evt);
            }
        });
        aktivitasDokter.add(cbaktivitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 270, 40));

        t_cariaktivitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariaktivitasActionPerformed(evt);
            }
        });
        t_cariaktivitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_cariaktivitasKeyPressed(evt);
            }
        });
        aktivitasDokter.add(t_cariaktivitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 320, 40));

        jLabel19.setText("Nomor Regist Pasien :");
        aktivitasDokter.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, 20));
        aktivitasDokter.add(tnomor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 380, 30));

        btndeleteaktivitas.setBackground(new java.awt.Color(0, 102, 102));
        btndeleteaktivitas.setText("Delete");
        btndeleteaktivitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteaktivitasActionPerformed(evt);
            }
        });
        aktivitasDokter.add(btndeleteaktivitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 110, 40));

        jPanel3.add(aktivitasDokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 550));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1250, 550));

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
        btn_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dataMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_dataMouseReleased(evt);
            }
        });
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
      JFramehomeDokter homedokter = new JFramehomeDokter();
      homedokter.show();
      
      this.dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
     JFrameuserclinicdokter userdokter = new JFrameuserclinicdokter();
      userdokter.show();
      
      this.dispose();
    }//GEN-LAST:event_btn_userActionPerformed

    private void btn_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataActionPerformed
        JFrameclinicdataDokter datadokter = new JFrameclinicdataDokter();
        datadokter.show();
        this.dispose();
        SubmenuData.setVisible(!SubmenuData.isVisible());
    }//GEN-LAST:event_btn_dataActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
      JFrameLogin login = new JFrameLogin();
      login.show();
      
      this.dispose();
      JOptionPane.showMessageDialog(null, "Logout Success");
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dataMouseClicked
        SubmenuData.setVisible(true);
    }//GEN-LAST:event_btn_dataMouseClicked

    private void btn_dataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dataMouseReleased
        
    }//GEN-LAST:event_btn_dataMouseReleased

    private void label_jadwaldokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_jadwaldokterMouseClicked
        JadwalDokter.setVisible(true);
        aktivitasDokter.setVisible(false);
        SubmenuData.setVisible(false);
    }//GEN-LAST:event_label_jadwaldokterMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
     dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        int selectedRow = Tabeljadwaldokter.getSelectedRow();
        try {
            st = cn.createStatement();

            if (date.getDate() == null || t_keterangan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Validasi Data", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // Aksi simpan data
            if (btn_submit.getText().equals("Submit")) {
                String sql = "INSERT INTO jadwal_dokter (tanggal, keterangan) VALUES ('" + new SimpleDateFormat("yyyy-MM-dd").format(date.getDate()) +
                            "','" + t_keterangan.getText() + "')";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Anda Berhasil di Simpan");
                Tampildatajadwaldokter();
                BersihJadwalDokter();
            } else {
                String update = "UPDATE jadwal_dokter SET tanggal = '" + new SimpleDateFormat("yyyy-MM-dd").format(date.getDate()) +
                        "', keterangan = '" + t_keterangan.getText() +
                        "' WHERE nomor = '" + Tabeljadwaldokter.getValueAt(selectedRow, 0).toString() + "'";
                st.executeUpdate(update);
                JOptionPane.showMessageDialog(null, "Data Anda Berhasil di Ubah");
                Tampildatajadwaldokter();
                BersihJadwalDokter();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Tambahkan ini untuk melihat detail error pada konsol
        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usActionPerformed
      JFrameAboutUsDokter usdokter = new JFrameAboutUsDokter();
      usdokter.show();
      
      this.dispose();
    }//GEN-LAST:event_btn_usActionPerformed

    private void label_aktivitasdokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_aktivitasdokterMouseClicked
        aktivitasDokter.setVisible(true);
        JadwalDokter.setVisible(false);
        SubmenuData.setVisible(false);
    }//GEN-LAST:event_label_aktivitasdokterMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (date.getDate().equals("")) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Yang Ingin Anda Hapus !");
        } else{
            int jawab = JOptionPane.showConfirmDialog(null, "Data Ini Akan di Hapus , lanjutkan? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab == 0) {
                try {
                    st = cn.createStatement();
                    String sql = "DELETE FROM jadwal_dokter WHERE tanggal = '" + new SimpleDateFormat("yyyy-MM-dd").format(date.getDate())+ "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    BersihJadwalDokter();
                    Tampildatajadwaldokter();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        BersihJadwalDokter();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void TabeljadwaldokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabeljadwaldokterMouseClicked

        int selectedRow = Tabeljadwaldokter.getSelectedRow();

            if (selectedRow >= 0) {
                String tanggal = Tabeljadwaldokter.getValueAt(selectedRow, 1).toString();
                String keterangan = Tabeljadwaldokter.getValueAt(selectedRow, 2).toString();

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    Date selectedDate = sdf.parse(tanggal);

                    // Mengatur nilai tanggal pada DatePicker
                    date.setDate(selectedDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                t_keterangan.setText(keterangan);
                date.setEditable(true);
                btn_submit.setText("Change");
            }
    }//GEN-LAST:event_TabeljadwaldokterMouseClicked

    private void btn_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportActionPerformed
      JFramereportclinicdokter reportdokter = new JFramereportclinicdokter();
      reportdokter.show();
       
       this.dispose();
      SubmenuData.setVisible(!SubmenuData.isVisible());
    }//GEN-LAST:event_btn_reportActionPerformed

    private void btncancel_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancel_1ActionPerformed
        Bersihdataaktivitasdokter();
    }//GEN-LAST:event_btncancel_1ActionPerformed

    private void btnsubmit_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmit_1ActionPerformed
//       int selectedRow = tabel_aktivitas.getSelectedRow();
        try {
            st = cn.createStatement();

            if ( tnomor.getText().equals("") || tname.getText().equals("") || date1.getDate() == null || tresep.getText().equals("") || tinformation.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong", "Validasi Data", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // Aksi simpan data
            if (btnsubmit_1.getText().equals("Submit")) {
                String sql = "INSERT INTO aktivitas_dokter values ('" + tnomor.getText() +
                            "','" + tname.getText() +
                            "','" + new SimpleDateFormat("yyyy-MM-dd").format(date1.getDate()) +
                            "','" + tresep.getText() + "','" + tinformation.getText() + "')";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Anda Berhasil di Simpan");
                Tampildataaktivitasdokter();
                Bersihdataaktivitasdokter();
            } else {
                String update = "UPDATE aktivitas_dokter SET nama = '" + tname.getText() +
                        "', tanggal = '" + new SimpleDateFormat("yyyy-MM-dd").format(date1.getDate()) +
                        "', resep_obat = '" + tresep.getText() +
                        "', keterangan = '" + tinformation.getText() +
                        "' WHERE no_registp = '" + tnomor.getText() + "'";
                st.executeUpdate(update);
                JOptionPane.showMessageDialog(null, "Data Anda Berhasil di Ubah");
                Tampildataaktivitasdokter();
                Bersihdataaktivitasdokter();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Tambahkan ini untuk melihat detail error pada konsol
        }
    }//GEN-LAST:event_btnsubmit_1ActionPerformed

    private void cbaktivitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbaktivitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbaktivitasActionPerformed

    private void t_carijadwalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_carijadwalKeyPressed
       caridatajadwaldokter();
    }//GEN-LAST:event_t_carijadwalKeyPressed

    private void tabel_aktivitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_aktivitasMouseClicked
        int selectedRow = tabel_aktivitas.getSelectedRow();

            if (selectedRow >= 0) {
                String no_registp = tabel_aktivitas.getValueAt(selectedRow, 0).toString();
                String nama = tabel_aktivitas.getValueAt(selectedRow, 1).toString();
                String tanggal = tabel_aktivitas.getValueAt(selectedRow, 2).toString();
                String resep_obat = tabel_aktivitas.getValueAt(selectedRow, 3).toString();
                String keterangan = tabel_aktivitas.getValueAt(selectedRow, 4).toString();

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    Date selectedDate = sdf.parse(tanggal);

                    // Mengatur nilai tanggal pada DatePicker
                    date1.setDate(selectedDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                tnomor.setText(no_registp);
                tname.setText(nama);
                date1.setEditable(true);
                tresep.setText(resep_obat);
                tinformation.setText(keterangan);
                btnsubmit_1.setText("CHANGE");
            }
    }//GEN-LAST:event_tabel_aktivitasMouseClicked

    private void btndeleteaktivitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteaktivitasActionPerformed
        if (tnomor.getText().equals("") || tname.getText().equals("") || date1.getDate().equals("")
                || tresep.getText().equals("") || tinformation.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Yang Ingin Anda Hapus !");
        } else{
            int jawab = JOptionPane.showConfirmDialog(null, "Data Ini Akan di Hapus , lanjutkan? ", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab == 0) {
                try {
                    st = cn.createStatement();
                    String sql = "DELETE FROM aktivitas_dokter WHERE no_registp = '" + tnomor.getText() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    Tampildataaktivitasdokter();
                    Bersihdataaktivitasdokter();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_btndeleteaktivitasActionPerformed

    private void t_cariaktivitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariaktivitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cariaktivitasActionPerformed

    private void t_cariaktivitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariaktivitasKeyPressed
        caridataaktivitasdokter();
    }//GEN-LAST:event_t_cariaktivitasKeyPressed

    private void SubmenuDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuDataMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SubmenuDataMouseEntered

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
            java.util.logging.Logger.getLogger(JFrameclinicdataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameclinicdataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameclinicdataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameclinicdataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameclinicdataDokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JadwalDokter;
    private javax.swing.JPanel SubmenuData;
    private javax.swing.JTable Tabeljadwaldokter;
    private javax.swing.JPanel aktivitasDokter;
    private rojerusan.RSMaterialButtonRectangle btn_cancel;
    private rojerusan.RSButtonIconD btn_data;
    private rojerusan.RSMaterialButtonRectangle btn_delete;
    private rojerusan.RSButtonIconD btn_home;
    private rojerusan.RSButtonIconD btn_logout;
    private rojerusan.RSButtonIconD btn_report;
    private rojerusan.RSMaterialButtonRectangle btn_submit;
    private rojerusan.RSButtonIconD btn_us;
    private rojerusan.RSButtonIconD btn_user;
    private rojerusan.RSMaterialButtonRectangle btncancel_1;
    private rojerusan.RSMaterialButtonRectangle btndeleteaktivitas;
    private rojerusan.RSMaterialButtonRectangle btnsubmit_1;
    private javax.swing.JComboBox<String> cbaktivitas;
    private javax.swing.JComboBox<String> cbjadwal;
    private org.jdesktop.swingx.JXDatePicker date;
    private org.jdesktop.swingx.JXDatePicker date1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_aktivitasdokter;
    private javax.swing.JLabel label_jadwaldokter;
    private javax.swing.JLabel labelnama;
    private javax.swing.JLabel labelstatus;
    private javax.swing.JTextField t_cariaktivitas;
    private javax.swing.JTextField t_carijadwal;
    private javax.swing.JTextField t_keterangan;
    private javax.swing.JTable tabel_aktivitas;
    private javax.swing.JTextField tinformation;
    private javax.swing.JTextField tname;
    private javax.swing.JTextField tnomor;
    private javax.swing.JTextField tresep;
    // End of variables declaration//GEN-END:variables
}
