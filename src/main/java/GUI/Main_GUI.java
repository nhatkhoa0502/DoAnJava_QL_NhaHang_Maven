package GUI;

import BUS.Employee_BUS;
import BUS.Statistical_BUS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import GUI.Manager_GUI;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Main_GUI extends javax.swing.JFrame {
    
    private String username;
    private String password;

    private Vector<MenuItem> vectorMenuItem = new Vector<>();
    private Manager_GUI managerGUI;
    private Statistical_GUI statiscalGUI = new Statistical_GUI();
    private Employee_BUS employeeBUS = new Employee_BUS();
    private Statistical_BUS statisticalBUS = new Statistical_BUS();
    

    public Main_GUI(String username, String password) {
        
        this.username = username;
        this.password = password;
        managerGUI = new Manager_GUI(vectorMenuItem,username);
        
        initComponents();
        addMenuItem();
        addEventForMenuItem();
        addName();
        statisticalBUS.writeLoginTime(username,password);
        
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panelLayout.add(managerGUI, BorderLayout.CENTER);
        panelLayout.add(statiscalGUI, BorderLayout.WEST);
        statiscalGUI.setVisible(false);

        setVisible(true);
    }
    
    
    private void addName() {
        lbName.setText(employeeBUS.getName(username, password));
    }

    private void addMenuItem() {
        String filePath = new File("").getAbsolutePath();

        String pathQLNV = filePath.concat("\\src\\main\\java\\icons\\user_groups_25px.png");
        String pathLoaiMon = filePath.concat("\\src\\main\\java\\icons\\cardboard_box_25px.png");
        String pathMonAn = filePath.concat("\\src\\main\\java\\icons\\food_25px.png");
        String pathBan = filePath.concat("\\src\\main\\java\\icons\\table_25px.png");
        String pathKH = filePath.concat("\\src\\main\\java\\icons\\user_25px.png");
        String pathDDH = filePath.concat("\\src\\main\\java\\icons\\purchase_order_25px.png");
        String pathThongKe = filePath.concat("\\src\\main\\java\\icons\\increase_25px.png");

        Icon iconQLNV = new ImageIcon(pathQLNV);
        Icon iconLoaiMon = new ImageIcon(pathLoaiMon);
        Icon iconMonAn = new ImageIcon(pathMonAn);
        Icon iconBan = new ImageIcon(pathBan);
        Icon iconKH = new ImageIcon(pathKH);
        Icon iconDDH = new ImageIcon(pathDDH);
        Icon iconThongKe = new ImageIcon(pathThongKe);

        if (employeeBUS.isManager(username, password)) {
            vectorMenuItem.add(new MenuItem("qlnv", iconQLNV, "Quản lý nhân viên"));
            vectorMenuItem.add(new MenuItem("qllm", iconLoaiMon, "Quản lý loại món"));
            vectorMenuItem.add(new MenuItem("qlma", iconMonAn, "Quản lý món ăn"));                        
        }
        vectorMenuItem.add(new MenuItem("qlb", iconBan, "Quản lý bàn"));
        vectorMenuItem.add(new MenuItem("qlkh", iconKH, "Quản lý khách hàng"));
        vectorMenuItem.add(new MenuItem("qlddh", iconDDH, "Quản lý đơn đặt hàng"));
        if (employeeBUS.isManager(username, password)) {
            vectorMenuItem.add(new MenuItem("thongke", iconThongKe, "Thống kê"));
        }

        vectorMenuItem.get(0).setActive(true);//trang mặc định
        renderManagerForm(vectorMenuItem.get(0));
        vectorMenuItem.get(0).setBackground(new Color(187, 187, 187));
        vectorMenuItem.get(0).getLbMenuName().setForeground(new Color(255, 255, 255));
    }

    private void addEventForMenuItem() {
        //dùng vòng lặp để thêm từng menuItem vào panel
        for (int i = 0; i < vectorMenuItem.size(); i++) {
            //thêm từng phần tử
            panelSideBar.add(vectorMenuItem.get(i));
            final int index = i;
            //thêm sự kiện khi click
            vectorMenuItem.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setActiveFalseForAllMenuItem();
                    vectorMenuItem.get(index).setActive(true);
                    System.out.println("============");
                    for (int i = 0; i < vectorMenuItem.size(); i++) {
                        System.out.println("test: " + vectorMenuItem.get(i).isActive());
                        if (vectorMenuItem.get(i).isActive()) {
                            renderManagerForm(vectorMenuItem.get(i));
                            vectorMenuItem.get(i).setBackground(new Color(187, 187, 187));
                            vectorMenuItem.get(i).getLbMenuName().setForeground(new Color(255, 255, 255));
                        } else {
                            vectorMenuItem.get(i).setBackground(new Color(255, 255, 255));
                            vectorMenuItem.get(i).getLbMenuName().setForeground(new Color(60, 63, 65));
                        }
                    }
                    System.out.println("============");
                }

//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    vectorMenuItem.get(index).setBackground(new Color(187, 187, 187));
//                    vectorMenuItem.get(index).getLbMenuName().setForeground(new Color(255, 255, 255));
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    vectorMenuItem.get(index).setBackground(new Color(255, 255, 255));
//                    vectorMenuItem.get(index).getLbMenuName().setForeground(new Color(60, 63, 65));
//                }                
            });
        }
    }

    private void renderManagerForm(MenuItem menuItem) {
        if (menuItem.getId().equals("qlnv")) {
            managerGUI.setVisible(true);
            statiscalGUI.setVisible(false);
            managerGUI.renderEmployeeData();
        } else if (menuItem.getId().equals("qllm")) {
            managerGUI.setVisible(true);
            statiscalGUI.setVisible(false);
            managerGUI.renderFoodCategory();
        } else if (menuItem.getId().equals("qlma")) {
            managerGUI.setVisible(true);
            statiscalGUI.setVisible(false);
            managerGUI.renderFoodItem();
        } else if (menuItem.getId().equals("qlb")) {
            managerGUI.setVisible(true);
            statiscalGUI.setVisible(false);
            managerGUI.renderTable();
        } else if (menuItem.getId().equals("qlkh")) {
            managerGUI.setVisible(true);
            statiscalGUI.setVisible(false);
            managerGUI.renderCustomer();
        } else if (menuItem.getId().equals("qlddh")) {
            managerGUI.setVisible(true);
            statiscalGUI.setVisible(false);
            managerGUI.renderOrder();
        } else if (menuItem.getId().equals("thongke")) {
            managerGUI.setVisible(false);
            statiscalGUI.setVisible(true);
        }
    }

    private void setActiveFalseForAllMenuItem() {
        for (int i = 0; i < vectorMenuItem.size(); i++) {
            vectorMenuItem.get(i).setActive(false);
        }
    }
  
    public JButton getBtnLogout() {
        return btnLogout;
    }

    public JLabel getLbName() {
        return lbName;
    }

    public JPanel getPanelLayout() {
        return panelLayout;
    }

    public JPanel getPanelSideBar() {
        return panelSideBar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelLeft = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        panelSideBar = new javax.swing.JPanel();
        panelLayout = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang quản lý");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1500, 680));

        panelLeft.setPreferredSize(new java.awt.Dimension(200, 680));
        panelLeft.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(153, 153, 153));
        panelHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        panelHeader.setForeground(new java.awt.Color(255, 255, 255));
        panelHeader.setPreferredSize(new java.awt.Dimension(200, 50));
        panelHeader.setLayout(new java.awt.GridBagLayout());

        lbName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 255, 255));
        lbName.setText("Nguyễn Văn A");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        panelHeader.add(lbName, gridBagConstraints);

        btnLogout.setText("Thoát");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusable(false);
        btnLogout.setRequestFocusEnabled(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        panelHeader.add(btnLogout, gridBagConstraints);

        panelLeft.add(panelHeader, java.awt.BorderLayout.PAGE_START);
        panelLeft.add(panelSideBar, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelLeft, java.awt.BorderLayout.LINE_START);

        panelLayout.setMaximumSize(new java.awt.Dimension(1030, 680));
        panelLayout.setMinimumSize(new java.awt.Dimension(1020, 680));
        panelLayout.setPreferredSize(new java.awt.Dimension(200, 680));
        panelLayout.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelLayout, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        statisticalBUS.writeLogoutTime();
        setVisible(false);        
        new Login_GUI().setVisible(true);
        System.out.println("Dang xuat thanh cong!");
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel lbName;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelLayout;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelSideBar;
    // End of variables declaration//GEN-END:variables

//    public JPanel getPanelSideBar() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
}
