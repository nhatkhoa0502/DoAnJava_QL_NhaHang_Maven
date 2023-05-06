package GUI;

import BUS.FoodCategory_BUS;
import BUS.FoodItem_BUS;
import DTO.FoodCategory_DTO;
import DTO.FoodItem_DTO;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddFoodItemForm extends javax.swing.JFrame {

    private Vector<FoodCategory_DTO> vectorFoodCategory = new Vector<>();
    private Manager_GUI managerGUI;
    FoodItem_DTO foodItem;

    public AddFoodItemForm(Manager_GUI managerGUI) {
        this.managerGUI = managerGUI;
        initComponents();
        setLocationRelativeTo(null);

        FoodCategory_BUS t = new FoodCategory_BUS();
        vectorFoodCategory = t.getAllFoodCategory();
        addFoodCategoryToForm();
    }

    public AddFoodItemForm(Manager_GUI managerGUI, FoodItem_DTO foodItem) {
        this.foodItem = foodItem;
        this.managerGUI = managerGUI;
        initComponents();
        setLocationRelativeTo(null);
        btnOK.setText("Sửa");

        txtName.setText(foodItem.getName());
        txtDescription.setText(foodItem.getDescription());
        txtUnitName.setText(foodItem.getUnitName());
        txtUnitPrice.setText(foodItem.getUnitPrice() + "");

        FoodCategory_BUS t = new FoodCategory_BUS();
        vectorFoodCategory = t.getAllFoodCategory();
        changeToFirstLocationById(foodItem.getIdCategory());
        addFoodCategoryToForm();
    }

    private void changeToFirstLocationById(int id) {
        FoodCategory_DTO temp = new FoodCategory_DTO();
        for (int i = 0; i < vectorFoodCategory.size(); i++) {
            if (vectorFoodCategory.get(i).getId() == id) {
                temp = vectorFoodCategory.get(i);
                vectorFoodCategory.remove(i);
                break;
            }
        }
        vectorFoodCategory.add(0, temp);
    }

    private void addFoodCategoryToForm() {
        for (int i = 0; i < vectorFoodCategory.size(); i++) {
            cboCategory.addItem(vectorFoodCategory.get(i).getName());
        }
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnOK() {
        return btnOK;
    }

    public void setBtnOK(JButton btnOK) {
        this.btnOK = btnOK;
    }

    public JLabel getLbTitle() {
        return lbTitle;
    }

    public void setLbTitle(JLabel lbTitle) {
        this.lbTitle = lbTitle;
    }

    public JTextField getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(JTextField txtDescription) {
        this.txtDescription = txtDescription;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtUnitName() {
        return txtUnitName;
    }

    public void setTxtUnitName(JTextField txtUnitName) {
        this.txtUnitName = txtUnitName;
    }

    public JTextField getTxtUnitPrice() {
        return txtUnitPrice;
    }

    public void setTxtUnitPrice(JTextField txtUnitPrice) {
        this.txtUnitPrice = txtUnitPrice;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtUnitName = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        cboCategory = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 350));

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Thêm món ăn");
        jPanel1.add(lbTitle, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));
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

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Tên món:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Mô tả:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel5.setText("Tên đơn vị:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Giá:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Loại món:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtDescription, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtUnitName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(txtUnitPrice, gridBagConstraints);

        cboCategory.setActionCommand("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cboCategory, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String name = txtName.getText();
        String unitName = txtUnitName.getText();
        String unitPrice = txtUnitPrice.getText();
        String description = txtDescription.getText();
        String strCategory = (String) cboCategory.getSelectedItem();

        FoodItem_BUS t = new FoodItem_BUS();
        if (name.equals("") && unitName.equals("") && unitPrice.equals("")) {
            JOptionPane.showMessageDialog(null, "Tên, tên đơn vị, giá là bắt buộc", "Output", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //trường hợp thêm
        if (foodItem == null) {
            foodItem = new FoodItem_DTO(name, description, unitName, Integer.parseInt(unitPrice));
            if (t.insert(foodItem, strCategory)) {
                JOptionPane.showMessageDialog(null, "Thêm thành công", "Output", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {//trường hợp sửa            
            foodItem.setName(name);
            foodItem.setDescription(description);
            foodItem.setUnitName(unitName);
            foodItem.setUnitPrice(Integer.parseInt(unitPrice));
            FoodCategory_BUS foodCategoryBUS = new FoodCategory_BUS();
            foodItem.setIdCategory(foodCategoryBUS.getId(strCategory));
            if (t.update(foodItem)) {
                JOptionPane.showMessageDialog(null, "Sửa thành công", "Output", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        managerGUI.renderFoodItem();
        setVisible(false);
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox cboCategory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtUnitName;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
