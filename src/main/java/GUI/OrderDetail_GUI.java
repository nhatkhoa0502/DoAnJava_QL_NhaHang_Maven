package GUI;

import BUS.Customer_BUS;
import BUS.Employee_BUS;
import BUS.FoodCategory_BUS;
import BUS.FoodItem_BUS;
import BUS.Order_BUS;
import BUS.Table_BUS;
import DTO.FoodCategory_DTO;
import DTO.FoodItem_DTO;
import DTO.Order_DTO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import DTO.Table_DTO;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import BUS.OrderItem_BUS;
import DTO.OrderItem_DTO;

public class OrderDetail_GUI extends javax.swing.JFrame {

    Vector<Table_DTO> vectorTable = new Vector<Table_DTO>();
    Vector<FoodCategory_DTO> vectorFoodCategory = new Vector<FoodCategory_DTO>();
    Vector<FoodCategoryPane> vectorFoodCategoryPane = new Vector<FoodCategoryPane>();
    Vector<FoodItem_DTO> vectorFoodItem = new Vector<FoodItem_DTO>();
    Vector<FoodItemPane> vectorFoodItemPane = new Vector<FoodItemPane>();
    Vector<FoodItem_DTO> vectorFoodItemOrder = new Vector<FoodItem_DTO>();
//    Vector<OrderItem_DTO> vectorOrderItem = new Vector<OrderItem_DTO>();

    Order_DTO dataOrder = new Order_DTO();
    Order_BUS orderBUS = new Order_BUS();
    OrderItem_BUS orderItemBUS = new OrderItem_BUS();
    Employee_BUS employeeBUS = new Employee_BUS();
    Customer_BUS customerBUS = new Customer_BUS();
    Table_BUS tableBUS = new Table_BUS();
    FoodItem_BUS foodItemBUS = new FoodItem_BUS();

    Manager_GUI managerGUI;
    String username;

    //contructor test
    public OrderDetail_GUI() {
        this.username = username;
        initComponents();
        setLocationRelativeTo(null);
        addFreeTableForComboBox();
        addType();
        addFoodCategoryPanel();
        addEmployeeName();
        addMaxIdOrder();
        addAllFoodItemPane();
        addEventForFoodCategoryPanel();
    }

    //contructor add
    public OrderDetail_GUI(String username, Manager_GUI managerGUI) {
        this.managerGUI = managerGUI;
        this.username = username;
        initComponents();
        setLocationRelativeTo(null);
        addFreeTableForComboBox();
        addType();
        addFoodCategoryPanel();
        addEmployeeName();
        addMaxIdOrder();
        addAllFoodItemPane();
        addEventForFoodCategoryPanel();
    }

//    //contructor edit
//    public OrderDetail_GUI(Manager_GUI managerGUI, int idOrder) {
//        this.managerGUI = managerGUI;
//        dataOrder.setId(idOrder);
//        initComponents();
//        setLocationRelativeTo(null);
//
//        dataOrder = orderBUS.getDataById(idOrder);
//        System.out.println("dataOrder: " + dataOrder);
//        loadDataOrderOnGUI();
//        addFoodCategoryPanel();
//        addAllFoodItemPane();
//        addEventForFoodCategoryPanel();
//    }

//    private void loadDataOrderOnGUI() {
//        lbIdOrder.setText(dataOrder.getId() + "");
//        lbEmployeeName.setText(employeeBUS.getName(dataOrder.getIdEmployee()));
//        if (dataOrder.getIdCustomer() != 0) {
//            lbCustomerName.setText(customerBUS.getName(dataOrder.getIdCustomer()));
//        }
//        cboTable.addItem(tableBUS.getName(dataOrder.getIdTable()));
//        lbTotalAmount.setText(dataOrder.getTotalAmount() + "");
//        lbDiscount.setText(dataOrder.getDiscount() + "");
//        System.out.println("data order status: " + dataOrder.getStatus());
//        lbStatus.setText(dataOrder.getStatus().trim().equals("paid") ? "Đã thanh toán" : "Bị hủy");
//        cboType.addItem(dataOrder.getType().equals("here") ? "Tại quán" : "Mang về");
//        spnDiscount.setValue(dataOrder.getDiscount());
//        vectorOrderItem = orderItemBUS.getByIdOrder(dataOrder.getId());
//        System.out.println("vetor oder item size: " + vectorOrderItem.size());
//        for (int i = 0; i < vectorOrderItem.size(); i++) {
//            System.out.println("order item: " + vectorOrderItem.get(i).toString());
//            for (int j = 0; j < vectorOrderItem.get(i).getQuantity(); j++) {
//                FoodItem_DTO t = foodItemBUS.getFoodItemById(vectorOrderItem.get(i).getIdFoodItem());
//                pnlOrderItem.add(new OrderItemPanel(t));
//                vectorFoodItemOrder.add(t);
//            }
//        }
//    }

    private void initDataOrder() {
        Employee_BUS emBUS = new Employee_BUS();
        dataOrder.setIdEmployee(emBUS.getId(username));
        int idOrder = Integer.parseInt(lbIdOrder.getText());
        dataOrder.setId(idOrder);
        if (vectorTable.size() > 0) {
            int idTable = vectorTable.get(cboTable.getSelectedIndex()).getId();
            dataOrder.setIdTable(idTable);
        }
        int total = Integer.parseInt(lbTotalAmount.getText());
        dataOrder.setTotalAmount(total);
        int disCount = Integer.parseInt(lbDiscount.getText());
        dataOrder.setDiscount(disCount);
        String type = cboType.getSelectedIndex() == 0 ? "here" : "takeaway";
        dataOrder.setType(type);
        Date now = new Date();
        Timestamp orderDate = new Timestamp(now.getTime());
        dataOrder.setOrderDate(orderDate);
    }

    private double sumMoney() {
        int sum = 0;
        dataOrder.setDiscount(Integer.parseInt(spnDiscount.getValue().toString()));
        double disCount = Double.parseDouble(spnDiscount.getValue().toString());
        disCount = disCount / 100;
        System.out.println("giam gia: " + disCount);
        for (int i = 0; i < vectorFoodItemOrder.size(); i++) {
            sum += vectorFoodItemOrder.get(i).getUnitPrice();
        }
        return sum - (sum * disCount);
    }

    private void addFoodItemPane() {
        pnlFoodItem.removeAll();
        FoodItemPane temp;
        for (int i = 0; i < vectorFoodItem.size(); i++) {
            System.out.println("food item : " + vectorFoodItem.get(i));
            temp = new FoodItemPane(vectorFoodItem.get(i));
            vectorFoodItemPane.add(temp);
            pnlFoodItem.add(temp);
        }
        pnlFoodItem.setVisible(false);
        pnlFoodItem.setVisible(true);
        addEventForVectorFoodItemPane();
    }

    private void addFoodItemPane(int id) {
        pnlFoodItem.removeAll();
        FoodItemPane temp;
        for (int i = 0; i < vectorFoodItem.size(); i++) {
            if (vectorFoodItem.get(i).getIdCategory() == id) {
                System.out.println("test: " + vectorFoodItem.get(i));
                temp = new FoodItemPane(vectorFoodItem.get(i));
                vectorFoodItemPane.add(temp);
                pnlFoodItem.add(temp);
            }
        }
        pnlFoodItem.setVisible(false);
        pnlFoodItem.setVisible(true);
        addEventForVectorFoodItemPane();
    }

    private void addAllFoodItemPane() {
        FoodItem_BUS foodItemBUS = new FoodItem_BUS();
        vectorFoodItem = foodItemBUS.getAllFoodItem();
        addFoodItemPane();
    }

    private void addEventForFoodCategoryPanel() {
        for (int i = 0; i < vectorFoodCategoryPane.size(); i++) {
            final int temp = i;
            vectorFoodCategoryPane.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    FoodCategory_DTO t = vectorFoodCategoryPane.get(temp).getFoodCategory();
                    addFoodItemPane(t.getId());
                }
            });
        }
    }

    private void addEventForVectorFoodItemPane() {
        for (int i = 0; i < vectorFoodItemPane.size(); i++) {
            final int temp = i;
            vectorFoodItemPane.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    FoodItem_DTO t = vectorFoodItemPane.get(temp).getFoodItem();
                    vectorFoodItemOrder.add(t);
                    pnlOrderItem.add(new OrderItemPanel(t));
                    pnlOrderItem.setVisible(false);
                    pnlOrderItem.setVisible(true);
                }
            });
        }
    }

    private void addMaxIdOrder() {
        Order_BUS t = new Order_BUS();
        int maxId = t.getMaxIdOrder();
        ++maxId;
        lbIdOrder.setText("" + maxId);
    }

    private void addEmployeeName() {
        Employee_BUS employeeBUS = new Employee_BUS();
        String employeeName = employeeBUS.getName(username);
        System.out.println("employeeName GUI: " + employeeName);
        lbEmployeeName.setText(employeeName);
    }

    private void addFreeTableForComboBox() {
        vectorTable = tableBUS.getTableFree();
        for (int i = 0; i < vectorTable.size(); i++) {
            cboTable.addItem(vectorTable.get(i).getName());
        }
    }

    private void addType() {
        cboType.addItem("Tại quán");
        cboType.addItem("Mang về");
    }

    private void addFoodCategoryPanel() {
        FoodCategory_BUS fcBUS = new FoodCategory_BUS();
        vectorFoodCategory = fcBUS.getAllFoodCategory();
        FoodCategoryPane temp;
        for (int i = 0; i < vectorFoodCategory.size(); i++) {
            temp = new FoodCategoryPane(vectorFoodCategory.get(i));
            vectorFoodCategoryPane.add(temp);
            pnlFoodCategory.add(temp);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlTop = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        pnlLeft = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spnDiscount = new javax.swing.JSpinner();
        cboTable = new javax.swing.JComboBox();
        cboType = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        lbIdOrder = new javax.swing.JLabel();
        lbEmployeeName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnInforCustomer = new javax.swing.JButton();
        btnPaid = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbTotalAmount = new javax.swing.JLabel();
        lbDiscount = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbCustomerName = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbCash = new javax.swing.JLabel();
        lbChange = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlOrderItem = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        pnlFoodCategory = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlFoodItem = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 640));

        pnlTop.setPreferredSize(new java.awt.Dimension(1500, 40));
        pnlTop.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Chi tiết hóa đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        pnlTop.add(lbTitle, gridBagConstraints);

        getContentPane().add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pnlLeft.setPreferredSize(new java.awt.Dimension(250, 600));
        pnlLeft.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chỉnh sửa thông tin"));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 200));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Nhân viên:");
        jLabel2.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Bàn:");
        jLabel3.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Loại hóa đơn:");
        jLabel4.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel4, gridBagConstraints);
        jPanel3.add(jLabel5, new java.awt.GridBagConstraints());

        jLabel6.setText("Giảm giá(%):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel6, gridBagConstraints);

        spnDiscount.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(spnDiscount, gridBagConstraints);

        cboTable.setPreferredSize(new java.awt.Dimension(65, 22));
        cboTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTableActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cboTable, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cboType, gridBagConstraints);

        jLabel17.setText("Mã HD:");
        jLabel17.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel17, gridBagConstraints);

        lbIdOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbIdOrder.setText("001");
        lbIdOrder.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbIdOrder, gridBagConstraints);

        lbEmployeeName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbEmployeeName.setForeground(new java.awt.Color(255, 0, 0));
        lbEmployeeName.setText("Nhật Khoa");
        lbEmployeeName.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbEmployeeName, gridBagConstraints);

        pnlLeft.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 175));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOK.setText("Lưu");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanel4.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, 109, -1));

        btnInforCustomer.setText("Thông tin KH");
        btnInforCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInforCustomerActionPerformed(evt);
            }
        });
        jPanel4.add(btnInforCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, 109, -1));

        btnPaid.setText("Thanh Toán");
        btnPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaidActionPerformed(evt);
            }
        });
        jPanel4.add(btnPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 49, 111, -1));

        btnCancel.setText("Hủy Hóa Đơn");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 82, 111, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Tổng:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 73, -1, -1));

        jLabel9.setText("Giảm Giá:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 103, -1, -1));

        lbTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalAmount.setForeground(new java.awt.Color(255, 0, 0));
        lbTotalAmount.setText("0");
        jPanel5.add(lbTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 71, 80, -1));

        lbDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDiscount.setForeground(new java.awt.Color(255, 0, 0));
        lbDiscount.setText("0");
        jPanel5.add(lbDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 101, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("VND");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("%");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 101, -1, -1));

        jLabel18.setText("Tiền thối:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        lbCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCustomerName.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(lbCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 120, 20));

        jLabel19.setText("Trạng thái:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 43, -1, -1));

        lbStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 0, 0));
        lbStatus.setText("Chưa thanh toán");
        jPanel5.add(lbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 41, -1, -1));

        jLabel20.setText("Tên khách hàng: ");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel21.setText("Tiền khách đưa:");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        lbCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbCash.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(lbCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 80, 20));

        lbChange.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbChange.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(lbChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 100, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("VND");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("VND");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 250, 280));

        pnlLeft.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlLeft, java.awt.BorderLayout.LINE_START);

        pnlRight.setBackground(new java.awt.Color(102, 102, 0));
        pnlRight.setPreferredSize(new java.awt.Dimension(525, 600));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách món đã đặt"));
        jPanel6.setPreferredSize(new java.awt.Dimension(525, 800));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(525, 600));

        pnlOrderItem.setMaximumSize(new java.awt.Dimension(515, 5000));
        pnlOrderItem.setPreferredSize(new java.awt.Dimension(515, 1000));
        jScrollPane1.setViewportView(pnlOrderItem);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        getContentPane().add(pnlRight, java.awt.BorderLayout.LINE_END);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlFoodCategory.setPreferredSize(new java.awt.Dimension(150, 600));
        pnlFoodCategory.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        pnlCenter.add(pnlFoodCategory, java.awt.BorderLayout.LINE_START);

        jPanel14.setOpaque(false);
        jPanel14.setPreferredSize(new java.awt.Dimension(625, 600));

        jScrollPane2.setBackground(new java.awt.Color(153, 153, 0));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(625, 600));

        pnlFoodItem.setMaximumSize(new java.awt.Dimension(615, 10000));
        pnlFoodItem.setMinimumSize(new java.awt.Dimension(615, 1000));
        pnlFoodItem.setName(""); // NOI18N
        pnlFoodItem.setPreferredSize(new java.awt.Dimension(615, 1000));
        pnlFoodItem.setRequestFocusEnabled(false);
        pnlFoodItem.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane2.setViewportView(pnlFoodItem);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlCenter.add(jPanel14, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaidActionPerformed
        int sumMoney = (int) sumMoney();
        String numStr = JOptionPane.showInputDialog("Thành tiền: " + sumMoney + "\nNhập số tiền khách đưa: ");
        if (numStr != "") {
            int cash = Integer.parseInt(numStr);
            String mess = "Thành tiền: " + sumMoney + "\nKhách trả: " + cash + "\nTiền thối: " + (cash - sumMoney);
            JOptionPane.showMessageDialog(null, mess, "Thanh Toán", JOptionPane.INFORMATION_MESSAGE);
            dataOrder.setCash(cash);
            dataOrder.setChange(cash - sumMoney);
            dataOrder.setType("paid");
            lbStatus.setText("Đã thanh toán");
            lbStatus.setForeground(Color.GREEN);
            lbTotalAmount.setText(sumMoney + "");
            lbDiscount.setText(dataOrder.getDiscount() + "");
            lbCash.setText(cash+"");
            lbChange.setText((cash - sumMoney)+"");
        }
    }//GEN-LAST:event_btnPaidActionPerformed

    private void btnInforCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInforCustomerActionPerformed
        String phoneNumberCustomer = JOptionPane.showInputDialog("Nhập SĐT khách hàng: ");
        if (phoneNumberCustomer != null) {
            Customer_BUS t = new Customer_BUS();
            if (t.getId(phoneNumberCustomer) == 0) {
                String nameCustomer = JOptionPane.showInputDialog("Nhập tên khách hàng: ");
                lbCustomerName.setText(nameCustomer);
                t.insert(nameCustomer, phoneNumberCustomer);
                dataOrder.setIdCustomer(t.getMaxId());
                System.out.println("data order id customer: " + dataOrder.getIdCustomer());
            } else {
                int id = t.getId(phoneNumberCustomer);
                dataOrder.setIdCustomer(id);
                lbCustomerName.setText(t.getName(id));
                System.out.println("data order id customer: " + dataOrder.getIdCustomer());
            }
        }
    }//GEN-LAST:event_btnInforCustomerActionPerformed


    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        System.out.println("data order cash: " + dataOrder.getCash());
        if (dataOrder.getCash() != 0) {
            initDataOrder();
            dataOrder.setStatus("paid");
            System.out.println("data order: " + dataOrder.toString());                        
            orderBUS.insertData(dataOrder);
            orderItemBUS.inserData(dataOrder.getId(), vectorFoodItemOrder);                         
            Table_BUS t = new Table_BUS();
            t.changeTableToServing(dataOrder.getIdTable()); 
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Lưu thành công!", "Output", JOptionPane.INFORMATION_MESSAGE);
            managerGUI.renderOrder();
        } else {
            JOptionPane.showMessageDialog(null, "Thanh toán trước khi lưu!", "Output", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnOKActionPerformed

    //test
    private void cboTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTableActionPerformed
//        System.out.println("combox box selected: " + cboTable.getSelectedIndex());
//        System.out.println("vector combox box selected: " + vectorTable.get(cboTable.getSelectedIndex()).getName());
//        for (int i = 0; i < vectorFoodItemOrder.size(); i++) {
//            System.out.println("food item order: " + vectorFoodItemOrder.get(i));
//        }
//        orderItemBUS.inserData(dataOrder.getId(), vectorFoodItemOrder);
    }//GEN-LAST:event_cboTableActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        initDataOrder();
        dataOrder.setStatus("cancel");
        orderBUS.insertData(dataOrder);
//        orderItemBUS.inserData(dataOrder.getId(), vectorFoodItemOrder);
        setVisible(false);
        JOptionPane.showMessageDialog(null, "Hủy thành công!", "Output", JOptionPane.INFORMATION_MESSAGE);
        managerGUI.renderOrder();
    }//GEN-LAST:event_btnCancelActionPerformed

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnOK() {
        return btnOK;
    }

    public JButton getBtnPaid() {
        return btnPaid;
    }

    public JButton getBtnShipManager() {
        return btnInforCustomer;
    }

    public JComboBox<String> getCboType() {
        return cboType;
    }

    public JLabel getLbIdOrder() {
        return lbIdOrder;
    }

    public JLabel getLbTitle() {
        return lbTitle;
    }

    public JPanel getPnlFoodCategory() {
        return pnlFoodCategory;
    }

    public JPanel getPnlFoodItem() {
        return pnlFoodItem;
    }

    public JPanel getPnlOrderItem() {
        return pnlOrderItem;
    }

    public JSpinner getSpnDiscount() {
        return spnDiscount;
    }

    public JLabel getLbEmployeeName() {
        return lbEmployeeName;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnInforCustomer;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnPaid;
    private javax.swing.JComboBox cboTable;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCash;
    private javax.swing.JLabel lbChange;
    private javax.swing.JLabel lbCustomerName;
    private javax.swing.JLabel lbDiscount;
    private javax.swing.JLabel lbEmployeeName;
    private javax.swing.JLabel lbIdOrder;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTotalAmount;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlFoodCategory;
    private javax.swing.JPanel pnlFoodItem;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlOrderItem;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JSpinner spnDiscount;
    // End of variables declaration//GEN-END:variables

}
