package GUI;

import BUS.Table_BUS;
import DTO.Table_DTO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddTableForm extends javax.swing.JFrame {

    private Manager_GUI managerGUI;
    private Table_DTO tableDTO;

    //contructor sửa bàn
    public AddTableForm(Manager_GUI managerGUI, Table_DTO tableDTO) {
        this.tableDTO = tableDTO;
        this.managerGUI = managerGUI;
        initComponents();
        setLocationRelativeTo(null);

        txtName.setText(tableDTO.getName());
        if (tableDTO.getStatus().equals("free")) {
            cbbStatus.addItem("Trống");
            cbbStatus.addItem("Đang phục vụ");
        } else {
            cbbStatus.addItem("Đang phục vụ");
            cbbStatus.addItem("Trống");
        }
        btnOK.setText("Sửa");
    }

    //contructor thêm bàn
    public AddTableForm(Manager_GUI managerGUI) {
        this.managerGUI = managerGUI;
        initComponents();
        setLocationRelativeTo(null);

        cbbStatus.addItem("Trống");
        cbbStatus.addItem("Đang phục vụ");
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnOK() {
        return btnOK;
    }

    public JLabel getLbTitle() {
        return lbTitle;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbbStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(283, 30));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Thêm bàn mới");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(lbTitle, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(283, 50));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnOK.setText("Thêm");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnOK, gridBagConstraints);

        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnCancel, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 17, 198, -1));

        jLabel2.setText("Tên bàn:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, -1, -1));

        jLabel1.setText("Trạng thái:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        jPanel3.add(cbbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 180, 20));

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        
        if (txtName.getText() == null || txtName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên bàn không được để trống", "Output", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Table_BUS t = new Table_BUS();
            if (tableDTO == null) {//trường hợp thêm
                if (t.insert(txtName.getText(), (String) cbbStatus.getSelectedItem())) {
                    JOptionPane.showMessageDialog(null, "Thêm bàn thành công", "Output", JOptionPane.INFORMATION_MESSAGE);
                    managerGUI.renderTable();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm bàn thất bại", "Output", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {//trường hợp sửa
                tableDTO.setName(txtName.getText());
                tableDTO.setStatus((String) cbbStatus.getSelectedItem()); 
                if(t.update(tableDTO)){
                    JOptionPane.showMessageDialog(null, "Sửa thành công", "Output", JOptionPane.INFORMATION_MESSAGE);
                    managerGUI.renderTable();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Sửa thất bại", "Output", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
