package GUI;

import DTO.FoodCategory_DTO;
import javax.swing.JLabel;

public class FoodCategoryPane extends javax.swing.JPanel {

    FoodCategory_DTO foodCategory;
          
    public FoodCategoryPane(FoodCategory_DTO fc) {
        this.foodCategory = fc;
        initComponents();
        lbName.setText(fc.getName());
    }

    public FoodCategory_DTO getFoodCategory() {
        return foodCategory;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(150, 50));
        setPreferredSize(new java.awt.Dimension(150, 50));
        setLayout(new java.awt.GridBagLayout());

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 0, 0));
        lbName.setText("Topping");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        add(lbName, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables

}
