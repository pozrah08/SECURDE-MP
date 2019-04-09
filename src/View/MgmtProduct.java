/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SQLite;
import Model.Product;
import Utilities.Security;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beepxD
 */
public class MgmtProduct extends javax.swing.JPanel {
    public SQLite sqlite;
    public DefaultTableModel tableModel;
    
    public MgmtProduct(SQLite sqlite, String role) {
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel)table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

//        UNCOMMENT TO DISABLE BUTTONS 
        switch(role){
            case "client":
                addBtn.setVisible(false);
                editBtn.setVisible(false);
                deleteBtn.setVisible(false);
                break;
                
            case "staff": purchaseBtn.setVisible(false);
                break;
            case "manager": purchaseBtn.setVisible(false);
                break;
            case "admin": purchaseBtn.setVisible(false);
                break;
                
            default:
                purchaseBtn.setVisible(false);
                addBtn.setVisible(false);
                editBtn.setVisible(false);
                deleteBtn.setVisible(false);
                break;
        }
    }

    public void init(){
        //      CLEAR TABLE
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }
        
//      LOAD CONTENTS
        ArrayList<Product> products = sqlite.getProduct();
        for(int nCtr = 0; nCtr < products.size(); nCtr++){
            tableModel.addRow(new Object[]{
                products.get(nCtr).getName(), 
                products.get(nCtr).getStock(), 
                products.get(nCtr).getPrice()});
        }
    }
    
    public void designer(JTextField component, String text){
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        purchaseBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Stock", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        purchaseBtn.setBackground(new java.awt.Color(255, 255, 255));
        purchaseBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        purchaseBtn.setText("PURCHASE");
        purchaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editBtn.setText("EDIT");
        editBtn.setToolTipText("");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(purchaseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            JTextField stockFld = new JTextField("0");
            designer(stockFld, "PRODUCT STOCK");

            Object[] message = {
                "How many " + tableModel.getValueAt(table.getSelectedRow(), 0) + " do you want to purchase?", stockFld
            };

            int result = JOptionPane.showConfirmDialog(null, message, "PURCHASE PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
            if (result == JOptionPane.OK_OPTION) {
                int stock = Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 1).toString());
                int toBuy = Integer.parseInt(stockFld.getText());
                
                if(toBuy > 0){
                    if( stock > 0 && stock >= toBuy){
                        String product = tableModel.getValueAt(table.getSelectedRow(), 0).toString();

                        sqlite.addHistory(Frame.getUser().getUsername(), product, toBuy, new Timestamp(new Date().getTime()).toString());
                        sqlite.updateProduct(product, product, stock - toBuy, Double.parseDouble(tableModel.getValueAt(table.getSelectedRow(), 2).toString()));

                        //      CLEAR TABLE
                        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
                            tableModel.removeRow(0);
                        }

                        //      LOAD CONTENTS
                        ArrayList<Product> products = sqlite.getProduct();
                        for(int nCtr = 0; nCtr < products.size(); nCtr++){
                            tableModel.addRow(new Object[]{
                                products.get(nCtr).getName(), 
                                products.get(nCtr).getStock(), 
                                products.get(nCtr).getPrice()});
                        }

                    }else{
                        String errorMsg = "Not enough " + tableModel.getValueAt(table.getSelectedRow(), 0).toString() + " on stock.";
                        JOptionPane.showMessageDialog(null, errorMsg);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                }
                
                System.out.println(stockFld.getText());
            }
        }
    }//GEN-LAST:event_purchaseBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        JTextField nameFld = new JTextField();
        JTextField stockFld = new JTextField();
        JTextField priceFld = new JTextField();

        designer(nameFld, "PRODUCT NAME");
        designer(stockFld, "PRODUCT STOCK");
        designer(priceFld, "PRODUCT PRICE");

        Object[] message = {
            "Insert New Product Details:", nameFld, stockFld, priceFld
        };

        int result = JOptionPane.showConfirmDialog(null, message, "ADD PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

        if (result == JOptionPane.OK_OPTION) {
            if(Integer.parseInt(stockFld.getText()) > 0 && Double.parseDouble(priceFld.getText()) > 0){
                System.out.println(nameFld.getText());
                System.out.println(stockFld.getText());
                System.out.println(priceFld.getText());
               
                ArrayList<Product> nProducts = sqlite.getProduct();
                Boolean productExists = false;
                
                for(int i =0; i< nProducts.size(); i++){
                    if(nProducts.get(i).getName().toLowerCase().equals(nameFld.getText().trim().toLowerCase())){
                        productExists = true;
                    }
                }
                
                if(!productExists){
                    sqlite.addProduct(Security.cleanString(nameFld.getText().trim()), Integer.parseInt(stockFld.getText()), Double.parseDouble(priceFld.getText()));
                    sqlite.addLogs("EDIT", Frame.getUser().getUsername(), "User added product", new Timestamp(new Date().getTime()).toString());

                    //      CLEAR TABLE
                    for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
                        tableModel.removeRow(0);
                    }

                    //      LOAD CONTENTS
                    ArrayList<Product> products = sqlite.getProduct();
                    for(int nCtr = 0; nCtr < products.size(); nCtr++){
                        tableModel.addRow(new Object[]{
                            products.get(nCtr).getName(), 
                            products.get(nCtr).getStock(), 
                            products.get(nCtr).getPrice()});
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Product already exists.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            }
            
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            JTextField nameFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 0) + "");
            JTextField stockFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 1) + "");
            JTextField priceFld = new JTextField(tableModel.getValueAt(table.getSelectedRow(), 2) + "");

            designer(nameFld, "PRODUCT NAME");
            designer(stockFld, "PRODUCT STOCK");
            designer(priceFld, "PRODUCT PRICE");

            Object[] message = {
                "Edit Product Details:", nameFld, stockFld, priceFld
            };

            int result = JOptionPane.showConfirmDialog(null, message, "EDIT PRODUCT", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

            if (result == JOptionPane.OK_OPTION) {
                System.out.println(nameFld.getText());
                System.out.println(stockFld.getText());
                System.out.println(priceFld.getText());
                
                sqlite.updateProduct(tableModel.getValueAt(table.getSelectedRow(), 0).toString(), nameFld.getText(), Integer.parseInt(stockFld.getText()), Double.parseDouble(priceFld.getText()));
                sqlite.addLogs("EDIT", Frame.getUser().getUsername(), "User edited product", new Timestamp(new Date().getTime()).toString());
                
                //      CLEAR TABLE
                for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
                    tableModel.removeRow(0);
                }

                //      LOAD CONTENTS
                ArrayList<Product> products = sqlite.getProduct();
                for(int nCtr = 0; nCtr < products.size(); nCtr++){
                    tableModel.addRow(new Object[]{
                        products.get(nCtr).getName(), 
                        products.get(nCtr).getStock(), 
                        products.get(nCtr).getPrice()});
                }
            }
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE PRODUCT", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                sqlite.removeProduct(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
                sqlite.addLogs("EDIT", Frame.getUser().getUsername(), "User deleted product", new Timestamp(new Date().getTime()).toString());
            
                //      CLEAR TABLE
                for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
                    tableModel.removeRow(0);
                }

                 //      LOAD CONTENTS
                ArrayList<Product> products = sqlite.getProduct();
                for(int nCtr = 0; nCtr < products.size(); nCtr++){
                    tableModel.addRow(new Object[]{
                        products.get(nCtr).getName(), 
                        products.get(nCtr).getStock(), 
                        products.get(nCtr).getPrice()});
                }
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton purchaseBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
