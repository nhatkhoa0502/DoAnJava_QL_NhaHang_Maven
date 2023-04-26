package GUI;

import BUS.Employee_BUS;
import BUS.FoodCategory_BUS;
import BUS.FoodItem_BUS;
import BUS.Table_BUS;
import DTO.Employee_DTO;
import DTO.FoodCategory_DTO;
import DTO.FoodItem_DTO;
import DTO.Table_DTO;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

public class Manager_GUI extends JPanel {

    DefaultTableModel model = new DefaultTableModel();

    public Manager_GUI() {
        initComponents();
        settingTable();
        setIconForButton();
        renderEmployeeData();        
    }

    private void settingTable() {
        tblData.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblData.getTableHeader().setOpaque(false);
        tblData.getTableHeader().setBackground(new Color(51, 175, 255));
        tblData.getTableHeader().setForeground(new Color(255, 255, 255));
        tblData.setShowGrid(false);//tắt đường viền của bảng        
        tblData.setModel(model);
    }

    private void setIconForButton() {
        String filePath = new File("").getAbsolutePath();
        String pathAdd = filePath.concat("\\src\\main\\java\\icons\\add_25px.png");
        String pathEdit = filePath.concat("\\src\\main\\java\\icons\\edit_25px.png");
        String pathDelete = filePath.concat("\\src\\main\\java\\icons\\delete_25px.png");
        Icon iconAdd = new ImageIcon(pathAdd);
        Icon iconEdit = new ImageIcon(pathEdit);
        Icon iconDelete = new ImageIcon(pathDelete);
        btnAdd.setIcon(iconAdd);
        btnEdit.setIcon(iconEdit);
        btnDelete.setIcon(iconDelete);
    }

    public void renderEmployeeData() {
        // xoa du lieu trong model
        model.setRowCount(0); 
        model.setColumnCount(0);
        
        Vector<Employee_DTO> vectorEmployee = new Vector<>();
        Employee_BUS t = new Employee_BUS();
        vectorEmployee = t.getAllEmployee();
        model.addColumn("ID");
        model.addColumn("Họ tên");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("SĐT");
        model.addColumn("Chức vụ");
        model.addColumn("Ngày vào làm");
        model.addColumn("Lương");
        int id, salary;
        String username, password, name, phoneNumber, permission, startDate;
        for (int i = 0; i < vectorEmployee.size(); i++) {
            id = vectorEmployee.get(i).getId();
            username = vectorEmployee.get(i).getUsername();
            password = vectorEmployee.get(i).getPassword();
            name = vectorEmployee.get(i).getName();
            phoneNumber = vectorEmployee.get(i).getPhoneNumber();
            permission = vectorEmployee.get(i).getPermission().equals("manager") ? "Quản Lý" : "Nhân Viên";
            startDate = vectorEmployee.get(i).getStartDate().toString().split(" ")[0];
            salary = vectorEmployee.get(i).getSalary();
            model.addRow(new Object[]{id, name, username, password, phoneNumber, permission, startDate, salary});
        }
    }

    public void renderFoodCategory() {
        // xoa du lieu trong model
        model.setRowCount(0); 
        model.setColumnCount(0);
        
        Vector<FoodCategory_DTO> vectorFoodCategory = new Vector<>();
        FoodCategory_BUS t = new FoodCategory_BUS();
        vectorFoodCategory = t.getAllFoodCategory();
        model.addColumn("ID");
        model.addColumn("Tên loại");;
        int id;
        String name;
        for (int i = 0; i < vectorFoodCategory.size(); i++) {
            id = vectorFoodCategory.get(i).getId();
            name = vectorFoodCategory.get(i).getName();
            model.addRow(new Object[]{id, name});
        }
    }

    public void renderFoodItem() {
        // xoa du lieu trong model
        model.setRowCount(0); 
        model.setColumnCount(0);
        
        Vector<FoodItem_DTO> vectorFoodItem = new Vector<>();
        FoodItem_BUS t = new FoodItem_BUS();
        vectorFoodItem = t.getAllFoodItem();
        model.addColumn("ID");
        model.addColumn("Tên món");
        model.addColumn("Mô tả");
        model.addColumn("Link ảnh");
        model.addColumn("Tên dơn vị");
        model.addColumn("Giá đơn vị");
        model.addColumn("Mã loại");
        int id, unitPrice, idCategory;
        String name, description, urlImage, unitName;
        for (int i = 0; i < vectorFoodItem.size(); i++) {
            id = vectorFoodItem.get(i).getId();
            name = vectorFoodItem.get(i).getName();
            description = vectorFoodItem.get(i).getDescription();
            urlImage = vectorFoodItem.get(i).getUrlImage();
            unitName = vectorFoodItem.get(i).getUnitName();
            unitPrice = vectorFoodItem.get(i).getUnitPrice();
            idCategory = vectorFoodItem.get(i).getIdCategory();
            model.addRow(new Object[]{id, name, description, urlImage, unitName, unitPrice, idCategory});
        }
    }
 
    public void renderTable() {
        // xoa du lieu trong model
        model.setRowCount(0); 
        model.setColumnCount(0);
        
        Vector<Table_DTO> vectorTable = new Vector<>();
        Table_BUS t = new Table_BUS();
        vectorTable = t.getAllTable();
        model.addColumn("ID");
        model.addColumn("Tên bàn");
        model.addColumn("Trạng thái");
        int id;
        String name, status;
        for (int i = 0; i < vectorTable.size(); i++) {
            id = vectorTable.get(i).getId();
            name = vectorTable.get(i).getName();
            status = vectorTable.get(i).getName();                 
            model.addRow(new Object[]{id, name, status});
        }
    }
 //-----------------------------------------------------------------------------------------------------------------   
    public void renderCustomer() {
        // xoa du lieu trong model
        model.setRowCount(0); 
        model.setColumnCount(0);
                
    }
    
    public void renderOrder() {
        // xoa du lieu trong model
        model.setRowCount(0); 
        model.setColumnCount(0);
                
    }
    
    public void renderStatistical() {
        // xoa du lieu trong model
        model.setRowCount(0); 
        model.setColumnCount(0);
                
    }
//-----------------------------------------------------------------------------------------------------------------
    public JComboBox<String> getCboSearchField() {
        return cboSearchField;
    }

    public void setCboSearchField(JComboBox<String> cboSearchField) {
        this.cboSearchField = cboSearchField;
    }

    public JTextField getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    //Lấy các nút để set event
    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JTable getTblData() {
        return tblData;
    }

    // Lấy id các hàng đc chọn
    public int[] getSelectedIds() {

        int selectedRows[] = tblData.getSelectedRows();
        int selectedIds[] = new int[selectedRows.length];
        for (int i = 0; i < selectedRows.length; i++) {
            int selectedRow = selectedRows[i];
            int id = (int) tblData.getValueAt(selectedRow, 0);
            selectedIds[i] = id;
        }
        return selectedIds;
    }

    // Lấy id hàng chọn đầu
    public int getSelectedId() {

        int selectedRow = tblData.getSelectedRow();
        if (selectedRow < 0) {
            return -1;
        }
        int id = (int) tblData.getValueAt(selectedRow, 0);
        return id;
    }

//    public void renderTable() {
//        tableModel.setNumRows(0);
//        try {
//            for (T item : tableData) {
//                tableModel.addRow(item.toRowTable());
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        cboSearchField = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 204));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setPreferredSize(new java.awt.Dimension(1008, 680));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setOpaque(false);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
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
        tblData.setFocusable(false);
        tblData.setRowHeight(30);
        tblData.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblData);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Xóa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 15, 5);
        jPanel1.add(btnDelete, gridBagConstraints);

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Sửa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 15, 5);
        jPanel1.add(btnEdit, gridBagConstraints);

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Thêm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 15, 5);
        jPanel1.add(btnAdd, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 10));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1008, 50));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setText("Search");
        txtSearch.setAlignmentX(0.0F);
        txtSearch.setAlignmentY(0.0F);
        txtSearch.setBorder(null);
        txtSearch.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel2.add(txtSearch);

        cboSearchField.setMinimumSize(new java.awt.Dimension(100, 25));
        cboSearchField.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel2.add(cboSearchField);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cboSearchField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
