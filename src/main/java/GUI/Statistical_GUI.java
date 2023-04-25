package GUI;

import BUS.Statistical_BUS;
import DTO.Session_DTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.Timestamp;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Statistical_GUI extends javax.swing.JPanel {

    Vector<Session_DTO> vectorSession = new Vector<Session_DTO>();
    DefaultTableModel model = new DefaultTableModel();

    public Statistical_GUI() {
        initComponents();
        tblSession.setModel(model);
        setIconImg();
        setupHeader(tblProduct);
        setupHeader(tblSession);
        renderSessionData();
    }

    private void setIconImg() {
        String filePath = new File("").getAbsolutePath();

        String pathSoHd = filePath.concat("\\src\\main\\java\\icons\\bill_50px.png");
        String pathDoanhThu = filePath.concat("\\src\\main\\java\\icons\\money_50px.png");
        String pathSoNV = filePath.concat("\\src\\main\\java\\icons\\customer_support_50px.png");
        String pathSoKH = filePath.concat("\\src\\main\\java\\icons\\customer_50px.png");

        lblImgSoHD.setIcon(new ImageIcon(pathSoHd));
        lblImgDoanhThu.setIcon(new ImageIcon(pathDoanhThu));
        lblImgSoNV.setIcon(new ImageIcon(pathSoNV));
        lblImgSoKH.setIcon(new ImageIcon(pathSoKH));
    }

    private void setupHeader(JTable t) {
        t.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        t.getTableHeader().setBackground(new Color(51, 175, 255));
        t.getTableHeader().setForeground(new Color(255, 255, 255));
        t.setShowGrid(false);//tắt đường viền của bảng
    }

    public void renderSessionData() {
        Statistical_BUS t = new Statistical_BUS();
        vectorSession = t.getAllSessionEmployees();
        model.addColumn("IDNV");
        model.addColumn("Tên nhân viên");
        model.addColumn("Số hóa đơn");
        model.addColumn("Ngày bắt đầu");
        model.addColumn("Ngày kết thúc");

        // set width cho cột "IDNV" và cột "số hóa đơn"
        tblSession.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblSession.getColumnModel().getColumn(2).setPreferredWidth(23);

        int IDNV;
        String nameNV;
        Timestamp timeStart, timeEnd;

        for (int i = 0; i < vectorSession.size(); i++) {
            IDNV = vectorSession.get(i).getIdEmployee();
            nameNV = vectorSession.get(i).getNameEmployee();
            timeStart = vectorSession.get(i).getStartTime();
            timeEnd = vectorSession.get(i).getEndTime();
            model.addRow(new Object[]{IDNV, nameNV, i, timeStart, timeEnd});
        }

    }

    public void renderProductData() {

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public JLabel getLbTotalCustomer() {
        return lbTotalCustomer;
    }

    public JLabel getLbTotalEmployee() {
        return lbTotalEmployee;
    }

    public JLabel getLbTotalIncome() {
        return lbTotalIncome;
    }

    public JLabel getLbTotalOrder() {
        return lbTotalOrder;
    }

    public JDateChooser getDateChooserEnd() {
        return dateChooserEnd;
    }

    public JDateChooser getDateChooserStart() {
        return dateChooserStart;
    }

    public JPanel getPnlContent() {
        return pnlContent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dateChooserStart = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dateChooserEnd = new com.toedter.calendar.JDateChooser();
        pnlHead = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblImgSoHD = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbTotalOrder = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblImgDoanhThu = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbTotalIncome = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblImgSoNV = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbTotalEmployee = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lblImgSoKH = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbTotalCustomer = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tblProduct = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSession = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel13.setPreferredSize(new java.awt.Dimension(1008, 150));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(1008, 40));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ngày bắt đầu:");
        jPanel14.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 7, -1, -1));

        dateChooserStart.setDateFormatString("dd/MM/yyyy");
        dateChooserStart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateChooserStart.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel14.add(dateChooserStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 5, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ngày kết thúc:");
        jPanel14.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 7, -1, -1));

        dateChooserEnd.setDateFormatString("dd/MM/yyyy");
        dateChooserEnd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateChooserEnd.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel14.add(dateChooserEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 5, -1, -1));

        jPanel13.add(jPanel14, java.awt.BorderLayout.PAGE_START);

        pnlHead.setPreferredSize(new java.awt.Dimension(1008, 110));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        pnlHead.setLayout(flowLayout1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(245, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 204));
        jPanel1.setForeground(new java.awt.Color(153, 255, 153));
        jPanel1.setMaximumSize(new java.awt.Dimension(100, 100));

        lblImgSoHD.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblImgSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(lblImgSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel2.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Số HD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel3.add(jLabel2, gridBagConstraints);

        lbTotalOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalOrder.setText("14");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel3.add(lbTotalOrder, gridBagConstraints);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        pnlHead.add(jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(245, 100));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(51, 255, 204));
        jPanel5.setMaximumSize(new java.awt.Dimension(100, 100));

        lblImgDoanhThu.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblImgDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(lblImgDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Doanh thu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel6.add(jLabel5, gridBagConstraints);

        lbTotalIncome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalIncome.setText("14,000,000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel6.add(lbTotalIncome, gridBagConstraints);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        pnlHead.add(jPanel4);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(245, 100));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 102, 102));
        jPanel8.setMaximumSize(new java.awt.Dimension(100, 100));

        lblImgSoNV.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblImgSoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(lblImgSoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel7.add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số NV");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel9.add(jLabel8, gridBagConstraints);

        lbTotalEmployee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalEmployee.setText("33");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel9.add(lbTotalEmployee, gridBagConstraints);

        jPanel7.add(jPanel9, java.awt.BorderLayout.CENTER);

        pnlHead.add(jPanel7);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(245, 100));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(0, 204, 204));
        jPanel11.setMaximumSize(new java.awt.Dimension(100, 100));

        lblImgSoKH.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblImgSoKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(lblImgSoKH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel10.add(jPanel11, java.awt.BorderLayout.LINE_START);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Số KH");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel12.add(jLabel11, gridBagConstraints);

        lbTotalCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalCustomer.setText("10+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel12.add(lbTotalCustomer, gridBagConstraints);

        jPanel10.add(jPanel12, java.awt.BorderLayout.CENTER);

        pnlHead.add(jPanel10);

        jPanel13.add(pnlHead, java.awt.BorderLayout.CENTER);

        add(jPanel13, java.awt.BorderLayout.PAGE_START);

        pnlContent.setPreferredSize(new java.awt.Dimension(1008, 530));
        pnlContent.setLayout(null);

        jPanel15.setPreferredSize(new java.awt.Dimension(504, 640));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Thống kê doanh thu theo sản phẩm");
        jPanel15.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProduct.setRowHeight(25);
        jPanel15.add(tblProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 500, 590));

        pnlContent.add(jPanel15);
        jPanel15.setBounds(500, 0, 510, 640);

        jPanel16.setPreferredSize(new java.awt.Dimension(504, 640));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Thống kê phiên làm việc");
        jPanel16.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tblSession.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSession.setRowHeight(25);
        jScrollPane2.setViewportView(tblSession);

        jPanel16.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 490, 590));

        pnlContent.add(jPanel16);
        jPanel16.setBounds(6, 0, 500, 640);

        add(pnlContent, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooserEnd;
    private com.toedter.calendar.JDateChooser dateChooserStart;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTotalCustomer;
    private javax.swing.JLabel lbTotalEmployee;
    private javax.swing.JLabel lbTotalIncome;
    private javax.swing.JLabel lbTotalOrder;
    private javax.swing.JLabel lblImgDoanhThu;
    private javax.swing.JLabel lblImgSoHD;
    private javax.swing.JLabel lblImgSoKH;
    private javax.swing.JLabel lblImgSoNV;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblSession;
    // End of variables declaration//GEN-END:variables
}
