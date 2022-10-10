/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package duanmau.GiaoDien;

import duanmau.DAO.ChuyenDeDAO;
import duanmau.DAO.HocVienDAO;
import duanmau.DAO.KhoaHocDAO;
import duanmau.DAO.NguoiHocDAO;
import duanmau.Help.Dialog;
import duanmau.Help.Login;
import duanmau.entity.ChuyenDe;
import duanmau.entity.HocVien;
import duanmau.entity.KhoaHoc;
import duanmau.entity.NguoiHoc;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class Quanlihocvien extends javax.swing.JDialog {

    /**
     * Creates new form Quanlichuyende
     */
    ChuyenDeDAO cddao = new ChuyenDeDAO();
    KhoaHocDAO khdao = new KhoaHocDAO();
    HocVienDAO hvdao = new HocVienDAO();
    NguoiHocDAO nhdao = new NguoiHocDAO();
    public int rowhv = -1;
    public int rownh = -1;

    public Quanlihocvien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        setLocationRelativeTo(null);
        this.fillComboxCD();
        this.updateStatus();

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
        tab = new javax.swing.JTabbedPane();
        hocvien = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhocvien = new javax.swing.JTable();
        btnxoa = new javax.swing.JButton();
        btncapnhat = new javax.swing.JButton();
        nguoihoc = new javax.swing.JPanel();
        timkiem = new javax.swing.JPanel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblnguoihoc = new javax.swing.JTable();
        btnthem = new javax.swing.JButton();
        chuyende = new javax.swing.JPanel();
        cbchuyende = new javax.swing.JComboBox<>();
        khoahoc = new javax.swing.JPanel();
        cbkhoahoc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lí học viên");
        setIconImage(new ImageIcon(getClass().getResource("/duanmau/image/icon/logo.jpg")).getImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Quản lí Học viên");

        tblhocvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã người học", "Mã học viên", "Họ và tên ", "Điểm"
            }
        ));
        tblhocvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhocvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhocvien);
        if (tblhocvien.getColumnModel().getColumnCount() > 0) {
            tblhocvien.getColumnModel().getColumn(0).setMinWidth(50);
            tblhocvien.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblhocvien.getColumnModel().getColumn(0).setMaxWidth(100);
            tblhocvien.getColumnModel().getColumn(1).setMinWidth(180);
            tblhocvien.getColumnModel().getColumn(1).setPreferredWidth(180);
            tblhocvien.getColumnModel().getColumn(1).setMaxWidth(200);
            tblhocvien.getColumnModel().getColumn(2).setMinWidth(180);
            tblhocvien.getColumnModel().getColumn(2).setPreferredWidth(180);
            tblhocvien.getColumnModel().getColumn(2).setMaxWidth(200);
            tblhocvien.getColumnModel().getColumn(4).setMinWidth(100);
            tblhocvien.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblhocvien.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        btnxoa.setText("Xóa khỏi khóa học");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btncapnhat.setText("Cập nhật điểm");
        btncapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hocvienLayout = new javax.swing.GroupLayout(hocvien);
        hocvien.setLayout(hocvienLayout);
        hocvienLayout.setHorizontalGroup(
            hocvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hocvienLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hocvienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnxoa)
                .addGap(88, 88, 88)
                .addComponent(btncapnhat)
                .addGap(42, 42, 42))
        );
        hocvienLayout.setVerticalGroup(
            hocvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hocvienLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hocvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoa)
                    .addComponent(btncapnhat))
                .addGap(18, 18, 18))
        );

        tab.addTab("Học viên", hocvien);

        timkiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Tìm kiếm  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(153, 153, 255))); // NOI18N

        txttimkiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });

        btntimkiem.setText("Tìm kiếm");

        javax.swing.GroupLayout timkiemLayout = new javax.swing.GroupLayout(timkiem);
        timkiem.setLayout(timkiemLayout);
        timkiemLayout.setHorizontalGroup(
            timkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timkiemLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        timkiemLayout.setVerticalGroup(
            timkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timkiemLayout.createSequentialGroup()
                .addGroup(timkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btntimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblnguoihoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã người học", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Email"
            }
        ));
        tblnguoihoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnguoihocMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblnguoihoc);

        btnthem.setText("Thêm vào khóa học");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nguoihocLayout = new javax.swing.GroupLayout(nguoihoc);
        nguoihoc.setLayout(nguoihocLayout);
        nguoihocLayout.setHorizontalGroup(
            nguoihocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nguoihocLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(nguoihocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nguoihocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnthem)
                .addGap(89, 89, 89))
        );
        nguoihocLayout.setVerticalGroup(
            nguoihocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nguoihocLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnthem)
                .addGap(116, 116, 116))
        );

        tab.addTab("Người học", nguoihoc);

        chuyende.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chuyên đề", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 153, 102))); // NOI18N

        cbchuyende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbchuyendeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chuyendeLayout = new javax.swing.GroupLayout(chuyende);
        chuyende.setLayout(chuyendeLayout);
        chuyendeLayout.setHorizontalGroup(
            chuyendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chuyendeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbchuyende, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        chuyendeLayout.setVerticalGroup(
            chuyendeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chuyendeLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cbchuyende, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        khoahoc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khóa học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 153, 102))); // NOI18N

        cbkhoahoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkhoahocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout khoahocLayout = new javax.swing.GroupLayout(khoahoc);
        khoahoc.setLayout(khoahocLayout);
        khoahocLayout.setHorizontalGroup(
            khoahocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khoahocLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbkhoahoc, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        khoahocLayout.setVerticalGroup(
            khoahocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, khoahocLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cbkhoahoc, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(khoahoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chuyende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(khoahoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbchuyendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbchuyendeActionPerformed
        // TODO add your handling code here:
        fillComboxKH();
    }//GEN-LAST:event_cbchuyendeActionPerformed

    private void cbkhoahocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkhoahocActionPerformed
        // TODO add your handling code here:
        fillTableHV();
    }//GEN-LAST:event_cbkhoahocActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        this.addHocVien();
    }//GEN-LAST:event_btnthemActionPerformed

    private void tblhocvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhocvienMouseClicked
        // TODO add your handling code here:   
        this.rowhv = tblhocvien.getSelectedRow();
        this.updateStatus();
    }//GEN-LAST:event_tblhocvienMouseClicked

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        this.removeHocVien();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btncapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatActionPerformed
        // TODO add your handling code here:
        this.updateGrade();
    }//GEN-LAST:event_btncapnhatActionPerformed

    private void tblnguoihocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnguoihocMouseClicked
        // TODO add your handling code here:
        this.rownh = tblnguoihoc.getSelectedRow();
        this.updateStatus();
    }//GEN-LAST:event_tblnguoihocMouseClicked

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
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Quanlihocvien dialog = new Quanlihocvien(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncapnhat;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbchuyende;
    private javax.swing.JComboBox<String> cbkhoahoc;
    private javax.swing.JPanel chuyende;
    private javax.swing.JPanel hocvien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel khoahoc;
    private javax.swing.JPanel nguoihoc;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tblhocvien;
    private javax.swing.JTable tblnguoihoc;
    private javax.swing.JPanel timkiem;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables

    void fillComboxCD() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbchuyende.getModel();
        model.removeAllElements();
        List<ChuyenDe> lst = cddao.SelectAll();
        for (ChuyenDe cd : lst) {
            model.addElement(cd);
        }
        this.fillComboxKH();
    }

    void fillComboxKH() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbkhoahoc.getModel();
        model.removeAllElements();
        ChuyenDe chuyende = (ChuyenDe) cbchuyende.getSelectedItem();
        if (chuyende != null) {
            List<KhoaHoc> lst = khdao.selectByCD(chuyende.getMaCD());
            for (KhoaHoc kh : lst) {
                model.addElement(kh);
            }
            this.fillTableHV();
        }
    }

    void fillTableHV() {
        DefaultTableModel model = (DefaultTableModel) tblhocvien.getModel();
        model.setRowCount(0);
        KhoaHoc kh = (KhoaHoc) cbkhoahoc.getSelectedItem();
        if (kh != null) {
            List<HocVien> lst = hvdao.selectByKhoaHoc(kh.getMaKH());
            for (int i = 0; i < lst.size(); i++) {
                HocVien hv = lst.get(i);
                String hoten = nhdao.SelectID(hv.getMaNH()).getHoten();
                model.addRow(new Object[]{i + 1, hv.getMaNH(), hv.getMaHV(), hoten, hv.getGrade()});
            }
            this.fillTableNH();
        }
    }

    void fillTableNH() {
        DefaultTableModel model = (DefaultTableModel) tblnguoihoc.getModel();
        model.setRowCount(0);
        KhoaHoc kh = (KhoaHoc) cbkhoahoc.getSelectedItem();
        String key = txttimkiem.getText();
        List<NguoiHoc> lst = nhdao.selectNotinKhoahoc(kh.getMaKH(), key);
        for (NguoiHoc nh : lst) {
            model.addRow(new Object[]{
                nh.getMaNH(), nh.getHoten(), nh.isGioiTinh() ? "Nam" : "Nữ",
                nh.getNgaySinh(), nh.getDienThoai(), nh.getEmail()
            });
        }
    }

    void addHocVien() {
        KhoaHoc kh = (KhoaHoc) cbkhoahoc.getSelectedItem();
        for (int row : tblnguoihoc.getSelectedRows()) {
            HocVien hv = new HocVien();
            hv.setMaKH(kh.getMaKH());
            hv.setGrade(0);
            hv.setMaNH(String.valueOf(tblnguoihoc.getValueAt(row, 0)));
            hvdao.Insert(hv);
        }
        this.fillTableHV();
        this.tab.setSelectedIndex(0);
    }

    void removeHocVien() {
        if (!Login.isManager()) {
            Dialog.Message(this, "Bạn không có quyền xóa học viên!");
        } else {
            if (Dialog.Confirm(this, "Bạn có muốn xóa các học viên được chọn ?")) {
                for (int row : tblhocvien.getSelectedRows()) {
                    String mahv = String.valueOf(tblhocvien.getValueAt(row, 0));
                    hvdao.Remove(mahv);
                }
                this.fillTableHV();
            }
        }
    }

    void updateGrade() {
        for (int i = 0; i < tblhocvien.getRowCount(); i++) {
            String mahv = String.valueOf(tblhocvien.getValueAt(i, 2));
            HocVien hv = hvdao.SelectID(mahv);
            float diem = Float.parseFloat(String.valueOf(tblhocvien.getValueAt(i, 4)));
            if (diem < 0 || diem > 11) {
                Dialog.Message(this, "Vui lòng kiểm tra lại giá trị điểm không nhỏ hơn 0 và vượt quá 10");
                return;
            } else {
                hv.setGrade(diem);
            }
            hvdao.Update(hv);
        }
        Dialog.Message(this, "Cập nhật điểm thành công");
    }

    void updateStatus() {
        if (this.rowhv <= -1) {
            btnxoa.setEnabled(false);
            btncapnhat.setEnabled(false);
        } else {
            btnxoa.setEnabled(true);
            btncapnhat.setEnabled(true);
        }
        if (this.rownh <= -1) {
            btnthem.setEnabled(false);
        } else {
            btnthem.setEnabled(true);
        }
    }

}
