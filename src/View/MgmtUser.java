/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SQLite;
import Model.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beepxD
 */
public class MgmtUser extends javax.swing.JPanel {

    public SQLite sqlite;
    public DefaultTableModel tableModel;
    public String currentUserRole;
    
    public MgmtUser(SQLite sqlite, String role) {
        initComponents();
        this.sqlite = sqlite;
        currentUserRole = role;
        
        tableModel = (DefaultTableModel)table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        
//        UNCOMMENT TO DISABLE BUTTONS
        switch(role){
            case "client":
                editRoleBtn.setVisible(false);
                deleteBtn.setVisible(false);
                lockBtn.setVisible(false);
                chgpassBtn.setText("CHANGE OWN PASS");
                table.getTableHeader().setVisible(false);
                break;
                
            case "staff":
            case "manager":
                chgpassBtn.setText("CHANGE OWN PASS");
                table.removeColumn(table.getColumnModel().getColumn(1));
                break;
                
            case "admin":
                break;
                
            default:
                editRoleBtn.setVisible(false);
                deleteBtn.setVisible(false);
                lockBtn.setVisible(false);
                chgpassBtn.setVisible(false);
                break;
        }
    }
    
    public void init(){
        //      CLEAR TABLE
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }
        
        //      LOAD CONTENTS
        ArrayList<User> users = sqlite.getUsers();
        ArrayList<User> filteredUsers = new ArrayList<User>();
        //      FILTER OUT USERS BASED ON THE ROLE OF PERSON CURRENTLY LOGGED IN
        switch(currentUserRole){
            case "client":
                break;
                
            case "staff":
                for(int nCtr = 0; nCtr < users.size(); nCtr++){
                    if(users.get(nCtr).getRole() == 1 || 
                       users.get(nCtr).getRole() == 2 ||
                       users.get(nCtr).getRole() == 3){
                        filteredUsers.add(users.get(nCtr));
                    }
                }
                break;
            case "manager":
                for(int nCtr = 0; nCtr < users.size(); nCtr++){
                    if(users.get(nCtr).getRole() == 1 || 
                       users.get(nCtr).getRole() == 2 || 
                       users.get(nCtr).getRole() == 3 ||
                       users.get(nCtr).getRole() == 4){
                        filteredUsers.add(users.get(nCtr));
                    }
                }
                break;
            case "admin":
                for(int nCtr = 0; nCtr < users.size(); nCtr++){
                    if(users.get(nCtr).getRole() == 1 || 
                       users.get(nCtr).getRole() == 2 || 
                       users.get(nCtr).getRole() == 3 || 
                       users.get(nCtr).getRole() == 4 ||
                       users.get(nCtr).getRole() == 5){
                        filteredUsers.add(users.get(nCtr));
                    }
                }
                break;
                
            default:
                break;
        }
        for(int nCtr = 0; nCtr < filteredUsers.size(); nCtr++){
            tableModel.addRow(new Object[]{
                filteredUsers.get(nCtr).getUsername(), 
                filteredUsers.get(nCtr).getPassword(), 
                filteredUsers.get(nCtr).getRole(), 
                filteredUsers.get(nCtr).getLocked()});
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
        editRoleBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        lockBtn = new javax.swing.JButton();
        chgpassBtn = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Role", "Locked"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(160);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        editRoleBtn.setBackground(new java.awt.Color(255, 255, 255));
        editRoleBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editRoleBtn.setText("EDIT ROLE");
        editRoleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoleBtnActionPerformed(evt);
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

        lockBtn.setBackground(new java.awt.Color(255, 255, 255));
        lockBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lockBtn.setText("LOCK/UNLOCK");
        lockBtn.setToolTipText("");
        lockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockBtnActionPerformed(evt);
            }
        });

        chgpassBtn.setBackground(new java.awt.Color(255, 255, 255));
        chgpassBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chgpassBtn.setText("CHANGE PASS");
        chgpassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chgpassBtnActionPerformed(evt);
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
                        .addComponent(editRoleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lockBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(chgpassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(chgpassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editRoleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editRoleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoleBtnActionPerformed
         if(table.getSelectedRow() >= 0 && // selected a row
            (Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) != (Frame.getUser().getRole()) || Frame.getUser().getRole() == 5) && //user is not of the same role as you or you are an admin
            !tableModel.getValueAt(table.getSelectedRow(), 0).toString().equals(Frame.getUser().getUsername())){ //user is not yourself
            String selectedUser = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
            ArrayList<String> options = new ArrayList<String>();
            
            switch(currentUserRole){
                case "client":
                    break;

                case "staff":
                    options.add("1-DISABLED");
                    options.add("2-CLIENT");
                    break;

                case "manager":
                    options.add("1-DISABLED");
                    options.add("2-CLIENT");
                    options.add("3-STAFF");
                    break;

                case "admin":
                    options.add("1-DISABLED");
                    options.add("2-CLIENT");
                    options.add("3-STAFF");
                    options.add("4-MANAGER");
                    options.add("5-ADMIN");
                    break;

                default:
                    break;
            }
            
            JComboBox optionList = new JComboBox(options.toArray());
            
            optionList.setSelectedIndex((int)tableModel.getValueAt(table.getSelectedRow(), 2) - 1);
            
            String result = (String) JOptionPane.showInputDialog(null, "USER: " + tableModel.getValueAt(table.getSelectedRow(), 0), 
                "EDIT USER ROLE", JOptionPane.QUESTION_MESSAGE, null, options.toArray(), options.toArray()[(int)tableModel.getValueAt(table.getSelectedRow(), 2) - 1]);
            
            if(result != null){
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                System.out.println(result.charAt(0));
                
                sqlite.editUserRole(selectedUser, Integer.parseInt(result.charAt(0) + ""));
                sqlite.addLogs("EDIT", selectedUser, "User role edited", new Timestamp(new Date().getTime()).toString());

            }
            
             //      CLEAR TABLE
            for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
                tableModel.removeRow(0);
            }
        
            //      LOAD CONTENTS
            ArrayList<User> users = sqlite.getUsers();
            ArrayList<User> filteredUsers = new ArrayList<User>();
            //      FILTER OUT USERS BASED ON THE ROLE OF PERSON CURRENTLY LOGGED IN
            switch(currentUserRole){
                case "client":
                    break;

                case "staff":
                    for(int nCtr = 0; nCtr < users.size(); nCtr++){
                        if(users.get(nCtr).getRole() == 1 || 
                           users.get(nCtr).getRole() == 2 ||
                           users.get(nCtr).getRole() == 3){
                            filteredUsers.add(users.get(nCtr));
                        }
                    }
                    break;
                case "manager":
                    for(int nCtr = 0; nCtr < users.size(); nCtr++){
                        if(users.get(nCtr).getRole() == 1 || 
                           users.get(nCtr).getRole() == 2 || 
                           users.get(nCtr).getRole() == 3 ||
                           users.get(nCtr).getRole() == 4){
                            filteredUsers.add(users.get(nCtr));
                        }
                    }
                    break;
                case "admin":
                    for(int nCtr = 0; nCtr < users.size(); nCtr++){
                        if(users.get(nCtr).getRole() == 1 || 
                           users.get(nCtr).getRole() == 2 || 
                           users.get(nCtr).getRole() == 3 || 
                           users.get(nCtr).getRole() == 4 ||
                           users.get(nCtr).getRole() == 5){
                            filteredUsers.add(users.get(nCtr));
                        }
                    }
                    break;

                default:
                    break;
            }
            for(int nCtr = 0; nCtr < filteredUsers.size(); nCtr++){
                tableModel.addRow(new Object[]{
                    filteredUsers.get(nCtr).getUsername(), 
                    filteredUsers.get(nCtr).getPassword(), 
                    filteredUsers.get(nCtr).getRole(), 
                    filteredUsers.get(nCtr).getLocked()});
            }
        }
    }//GEN-LAST:event_editRoleBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(table.getSelectedRow() >= 0 && // selected a row
            (Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) != (Frame.getUser().getRole()) || Frame.getUser().getRole() == 5) && //user is not of the same role as you or you are an admin
            !tableModel.getValueAt(table.getSelectedRow(), 0).toString().equals(Frame.getUser().getUsername())){ //user is not yourself
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE USER", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                sqlite.removeUser(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
                sqlite.addLogs("EDIT", tableModel.getValueAt(table.getSelectedRow(), 0).toString(), "User deleted", new Timestamp(new Date().getTime()).toString());

                
                //      CLEAR TABLE
                for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
                    tableModel.removeRow(0);
                }

                //      LOAD CONTENTS
                ArrayList<User> users = sqlite.getUsers();
                ArrayList<User> filteredUsers = new ArrayList<User>();
                //      FILTER OUT USERS BASED ON THE ROLE OF PERSON CURRENTLY LOGGED IN
                switch(currentUserRole){
                    case "client":
                        break;

                    case "staff":
                        for(int nCtr = 0; nCtr < users.size(); nCtr++){
                            if(users.get(nCtr).getRole() == 1 || 
                               users.get(nCtr).getRole() == 2 ||
                               users.get(nCtr).getRole() == 3){
                                filteredUsers.add(users.get(nCtr));
                            }
                        }
                        break;
                    case "manager":
                        for(int nCtr = 0; nCtr < users.size(); nCtr++){
                            if(users.get(nCtr).getRole() == 1 || 
                               users.get(nCtr).getRole() == 2 || 
                               users.get(nCtr).getRole() == 3 ||
                               users.get(nCtr).getRole() == 4){
                                filteredUsers.add(users.get(nCtr));
                            }
                        }
                        break;
                    case "admin":
                        for(int nCtr = 0; nCtr < users.size(); nCtr++){
                            if(users.get(nCtr).getRole() == 1 || 
                               users.get(nCtr).getRole() == 2 || 
                               users.get(nCtr).getRole() == 3 || 
                               users.get(nCtr).getRole() == 4 ||
                               users.get(nCtr).getRole() == 5){
                                filteredUsers.add(users.get(nCtr));
                            }
                        }
                        break;

                    default:
                        break;
                }
                for(int nCtr = 0; nCtr < filteredUsers.size(); nCtr++){
                    tableModel.addRow(new Object[]{
                        filteredUsers.get(nCtr).getUsername(), 
                        filteredUsers.get(nCtr).getPassword(), 
                        filteredUsers.get(nCtr).getRole(), 
                        filteredUsers.get(nCtr).getLocked()});
                }
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void lockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockBtnActionPerformed
        String selectedUser = tableModel.getValueAt(table.getSelectedRow(), 0).toString();
        int lockedVal = Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 3).toString());
        
        if(table.getSelectedRow() >= 0 && // selected a row
            (Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString()) != (Frame.getUser().getRole()) || Frame.getUser().getRole() == 5) && //user is not of the same role as you or you are an admin
            !tableModel.getValueAt(table.getSelectedRow(), 0).toString().equals(Frame.getUser().getUsername())){ //user is not yourself
            String state = "lock";
            if("1".equals(tableModel.getValueAt(table.getSelectedRow(), 3) + "")){
                state = "unlock";
            }
            
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to " + state + " " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "LOCK USER", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                System.out.println(selectedUser + " " + lockedVal);
                
                if(lockedVal == 1){
                    lockedVal = 0;
                }
                else if (lockedVal == 0){
                    lockedVal = 1;
                }
                    
                System.out.println(selectedUser + " " + lockedVal);
                
                sqlite.toggleUserLock(selectedUser, lockedVal);
                sqlite.addLogs("EDIT", selectedUser, "User lock toggled", new Timestamp(new Date().getTime()).toString());               
            }
                //      CLEAR TABLE
            for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
                tableModel.removeRow(0);
            }
        
            //      LOAD CONTENTS
            ArrayList<User> users = sqlite.getUsers();
            ArrayList<User> filteredUsers = new ArrayList<User>();
            //      FILTER OUT USERS BASED ON THE ROLE OF PERSON CURRENTLY LOGGED IN
            switch(currentUserRole){
                case "client":
                    break;

                case "staff":
                    for(int nCtr = 0; nCtr < users.size(); nCtr++){
                        if(users.get(nCtr).getRole() == 1 || 
                           users.get(nCtr).getRole() == 2 ||
                           users.get(nCtr).getRole() == 3){
                            filteredUsers.add(users.get(nCtr));
                        }
                    }
                    break;
                case "manager":
                    for(int nCtr = 0; nCtr < users.size(); nCtr++){
                        if(users.get(nCtr).getRole() == 1 || 
                           users.get(nCtr).getRole() == 2 || 
                           users.get(nCtr).getRole() == 3 ||
                           users.get(nCtr).getRole() == 4){
                            filteredUsers.add(users.get(nCtr));
                        }
                    }
                    break;
                case "admin":
                    for(int nCtr = 0; nCtr < users.size(); nCtr++){
                        if(users.get(nCtr).getRole() == 1 || 
                           users.get(nCtr).getRole() == 2 || 
                           users.get(nCtr).getRole() == 3 || 
                           users.get(nCtr).getRole() == 4 ||
                           users.get(nCtr).getRole() == 5){
                            filteredUsers.add(users.get(nCtr));
                        }
                    }
                    break;

                default:
                    break;
            }
            for(int nCtr = 0; nCtr < filteredUsers.size(); nCtr++){
                tableModel.addRow(new Object[]{
                    filteredUsers.get(nCtr).getUsername(), 
                    filteredUsers.get(nCtr).getPassword(), 
                    filteredUsers.get(nCtr).getRole(), 
                    filteredUsers.get(nCtr).getLocked()});
            }
        }
    }//GEN-LAST:event_lockBtnActionPerformed

    private void chgpassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chgpassBtnActionPerformed
        if(!currentUserRole.equals("admin")){
            JTextField oldPassword = new JPasswordField();
            JTextField newPassword = new JPasswordField();
            JTextField confpass = new JPasswordField();
            
            designer(oldPassword, "OLD PASSWORD");
            designer(newPassword, "NEW PASSWORD");
            designer(confpass, "CONFIRM PASSWORD");
            
            Object[] message = {
                "Enter New Password (Password must have an uppercase character, number, valid symbol and must be 6-50 characters long):", oldPassword, newPassword, confpass
            };

            int result = JOptionPane.showConfirmDialog(null, message, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
            String currentUserPass = sqlite.getUser(Frame.getUser().getUsername()).get(0).getPassword();
            String oldPassTemp = oldPassword.getText();
            
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-512"); 

                byte[] messageDigest = md.digest(oldPassTemp.getBytes()); 

                BigInteger no = new BigInteger(1, messageDigest); 

                oldPassTemp = no.toString(16); 

                while (oldPassTemp.length() < 32) { 
                    oldPassTemp = "0" + oldPassTemp; 
                } 
            } catch (NoSuchAlgorithmException e) { 
                throw new RuntimeException(e); 
            }
            
            System.out.println("CURRENT USER'S PASS: " + currentUserPass);
            System.out.println("INPUT FOR OLD PASS FIELD: " + oldPassTemp);
            
            if(result == JOptionPane.OK_OPTION){ // clicks ok
                if(currentUserPass.equals(oldPassTemp)){ // check if they put the correct current password
                    System.out.println(newPassword.getText());
                    System.out.println(confpass.getText());
                    
                    boolean hasUppercase = false;
                    boolean hasNum = false;
                    boolean hasSymbol = false;
                    boolean passIs6 = true;
                    
                    if(newPassword.getText().matches("(.*)[-+_!@#$%^&*.,?](.*)")){ //check if the password has a symbol
                        hasSymbol = true;
                    }
                    
                    if(oldPassword.toString().length() < 6 && oldPassword.toString().length() > 50){ // check valid password length
                        passIs6 = false;
                    }
                    
                    char[] passwordArray = newPassword.getText().toCharArray();
                    
                    for(int i = 0; i < passwordArray.length; i++){
                        if(Character.isUpperCase(passwordArray[i])){ //check if the password has an uppercase character
                            hasUppercase = true;
                        }

                        if(Character.isDigit(passwordArray[i])){ // check if the password has a number
                            hasNum = true;
                        }
                    }
                    
                    if(hasUppercase && hasNum && hasSymbol && passIs6){ // if password passes all requirements
                        if(newPassword.getText().equals(confpass.getText())){ // if new password and confirmation field has the same input
                            sqlite.changePassword(Frame.getUser().getUsername(), newPassword.getText());
                            sqlite.addLogs("EDIT", Frame.getUser().getUsername(), "User password changed", new Timestamp(new Date().getTime()).toString());
                            System.out.println(Frame.getUser().getUsername() + " changed their password to " + newPassword.getText());
                        } else { // new password and confirm password differ in input
                           JOptionPane.showMessageDialog(null, "Passwords do not match.");
                        }
                    } else { // password does not meet one or more requirements
                       JOptionPane.showMessageDialog(null, "Password must have an uppercase character, number, valid symbol and must be 6-50 characters long.");
                    }
                } else { // password is not equal to current password
                    JOptionPane.showMessageDialog(null, "Old password does not match.");
                }
            }
            
        } else if(table.getSelectedRow() >=0 && currentUserRole.equals("admin")){
            if(!tableModel.getValueAt(table.getSelectedRow(), 0).toString().equals(Frame.getUser().getUsername())){ //editing another user's account
                JTextField adminPassword = new JPasswordField();
                JTextField password = new JPasswordField();
                JTextField confpass = new JPasswordField();
                
                designer(adminPassword, "YOUR PASSWORD FOR VERIFICATION");
                designer(password, "PASSWORD");
                designer(confpass, "CONFIRM PASSWORD");

                Object[] message = {
                    "Enter your own password for verification and enter a New Password for the user (Password must have an uppercase character, number, valid symbol and must be 6-50 characters long):", adminPassword, password, confpass
                };

                int result = JOptionPane.showConfirmDialog(null, message, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);

                if (result == JOptionPane.OK_OPTION) {
                    
                    String adminPassTemp = adminPassword.getText();
            
                    try {
                        MessageDigest md = MessageDigest.getInstance("SHA-512"); 

                        byte[] messageDigest = md.digest(adminPassTemp.getBytes()); 

                        BigInteger no = new BigInteger(1, messageDigest); 

                        adminPassTemp = no.toString(16); 

                        while (adminPassTemp.length() < 32) { 
                            adminPassTemp = "0" + adminPassTemp; 
                        } 
                    } catch (NoSuchAlgorithmException e) { 
                        throw new RuntimeException(e); 
                    }
                    
                    if(adminPassTemp.equals(Frame.getUser().getPassword())){
                        System.out.println(password.getText());
                        System.out.println(confpass.getText());

                        if(password.getText().equals(confpass.getText())){
                            boolean hasUppercase = false;
                                boolean hasNum = false;
                                boolean hasSymbol = false;
                                boolean passIs6 = true;

                                if(password.getText().matches("(.*)[-+_!@#$%^&*.,?](.*)")){ //check if the password has a symbol
                                    hasSymbol = true;
                                }

                                if(password.toString().length() < 6 && password.toString().length() > 50){ // check valid password length
                                    passIs6 = false;
                                }

                                char[] passwordArray = password.getText().toCharArray();

                                for(int i = 0; i < passwordArray.length; i++){
                                    if(Character.isUpperCase(passwordArray[i])){ //check if the password has an uppercase character
                                        hasUppercase = true;
                                    }

                                    if(Character.isDigit(passwordArray[i])){ // check if the password has a number
                                        hasNum = true;
                                    }
                                }

                                if(hasUppercase && hasNum && hasSymbol && passIs6){ // if password passes all requirements
                                    if(password.getText().equals(confpass.getText())){ // if new password and confirmation field has the same input
                                        sqlite.changePassword(Frame.getUser().getUsername(), password.getText());
                                        System.out.println(Frame.getUser().getUsername() + " changed their password to " + password.getText());


                                    } else { // new password and confirm password differ in input
                                       JOptionPane.showMessageDialog(null, "Passwords do not match.");
                                    }
                                } else { // password does not meet one or more requirements
                                   JOptionPane.showMessageDialog(null, "Password must have an uppercase character, number, valid symbol and must be 6-50 characters long.");
                                }


                            } else { // password is not equal to current password
                                JOptionPane.showMessageDialog(null, "Old password does not match.");
                            }


                        //      CLEAR TABLE
                        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
                            tableModel.removeRow(0);
                        }

                        //      LOAD CONTENTS
                        ArrayList<User> users = sqlite.getUsers();
                        ArrayList<User> filteredUsers = new ArrayList<User>();
                        //      FILTER OUT USERS BASED ON THE ROLE OF PERSON CURRENTLY LOGGED IN
                        switch(currentUserRole){
                            case "client":
                                break;

                            case "staff":
                                for(int nCtr = 0; nCtr < users.size(); nCtr++){
                                    if(users.get(nCtr).getRole() == 1 || 
                                       users.get(nCtr).getRole() == 2 ||
                                       users.get(nCtr).getRole() == 3){
                                        filteredUsers.add(users.get(nCtr));
                                    }
                                }
                                break;
                            case "manager":
                                for(int nCtr = 0; nCtr < users.size(); nCtr++){
                                    if(users.get(nCtr).getRole() == 1 || 
                                       users.get(nCtr).getRole() == 2 || 
                                       users.get(nCtr).getRole() == 3 ||
                                       users.get(nCtr).getRole() == 4){
                                        filteredUsers.add(users.get(nCtr));
                                    }
                                }
                                break;
                            case "admin":
                                for(int nCtr = 0; nCtr < users.size(); nCtr++){
                                    if(users.get(nCtr).getRole() == 1 || 
                                       users.get(nCtr).getRole() == 2 || 
                                       users.get(nCtr).getRole() == 3 || 
                                       users.get(nCtr).getRole() == 4 ||
                                       users.get(nCtr).getRole() == 5){
                                        filteredUsers.add(users.get(nCtr));
                                    }
                                }
                                break;

                            default:
                                break;
                        }
                        
                        for(int nCtr = 0; nCtr < filteredUsers.size(); nCtr++){
                            tableModel.addRow(new Object[]{
                                filteredUsers.get(nCtr).getUsername(), 
                                filteredUsers.get(nCtr).getPassword(), 
                                filteredUsers.get(nCtr).getRole(), 
                                filteredUsers.get(nCtr).getLocked()});
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Your password does not match.");
                    } //end of check for admin password validity
            }
        } else {
            JTextField oldPassword = new JPasswordField();
            JTextField newPassword = new JPasswordField();
            JTextField confpass = new JPasswordField();
            designer(oldPassword, "OLD PASSWORD");
            designer(newPassword, "NEW PASSWORD");
            designer(confpass, "CONFIRM PASSWORD");
            
            Object[] message = {
                "Enter New Password (Password must have an uppercase character, number, valid symbol and must be 6-50 characters long):", oldPassword, newPassword, confpass
            };

            int result = JOptionPane.showConfirmDialog(null, message, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
            String currentUserPass = sqlite.getUser(Frame.getUser().getUsername()).get(0).getPassword();
            String oldPassTemp = oldPassword.getText();
            
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-512"); 

                byte[] messageDigest = md.digest(oldPassTemp.getBytes()); 

                BigInteger no = new BigInteger(1, messageDigest); 

                oldPassTemp = no.toString(16); 

                while (oldPassTemp.length() < 32) { 
                    oldPassTemp = "0" + oldPassTemp; 
                } 
            } catch (NoSuchAlgorithmException e) { 
                throw new RuntimeException(e); 
            }
            
            System.out.println("CURRENT USER'S PASS: " + currentUserPass);
            System.out.println("INPUT FOR OLD PASS FIELD: " + oldPassTemp);
            
            if(result == JOptionPane.OK_OPTION){ // clicks ok
                if(currentUserPass.equals(oldPassTemp)){ // check if they put the correct current password
                    System.out.println(newPassword.getText());
                    System.out.println(confpass.getText());
                    
                    boolean hasUppercase = false;
                    boolean hasNum = false;
                    boolean hasSymbol = false;
                    boolean passIs6 = true;
                    
                    if(newPassword.getText().matches("(.*)[-+_!@#$%^&*.,?](.*)")){ //check if the password has a symbol
                        hasSymbol = true;
                    }
                    
                    if(newPassword.toString().length() < 6 && newPassword.toString().length() > 50){ // check valid password length
                        passIs6 = false;
                    }
                    
                    char[] passwordArray = newPassword.getText().toCharArray();
                    
                    for(int i = 0; i < passwordArray.length; i++){
                        if(Character.isUpperCase(passwordArray[i])){ //check if the password has an uppercase character
                            hasUppercase = true;
                        }

                        if(Character.isDigit(passwordArray[i])){ // check if the password has a number
                            hasNum = true;
                        }
                    }
                    
                    if(hasUppercase && hasNum && hasSymbol && passIs6){ // if password passes all requirements
                        if(newPassword.getText().equals(confpass.getText())){ // if new password and confirmation field has the same input
                            sqlite.changePassword(Frame.getUser().getUsername(), newPassword.getText());
                            System.out.println(Frame.getUser().getUsername() + " changed their password to " + newPassword.getText());
                            
                            
                        } else { // new password and confirm password differ in input
                           JOptionPane.showMessageDialog(null, "Passwords do not match.");
                        }
                    } else { // password does not meet one or more requirements
                       JOptionPane.showMessageDialog(null, "Password must have an uppercase character, number, valid symbol and must be 6-50 characters long.");
                    }
                    
                    
                } else { // password is not equal to current password
                    JOptionPane.showMessageDialog(null, "Old password does not match.");
                }
                
                //      CLEAR TABLE
                    for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
                        tableModel.removeRow(0);
                    }

                    //      LOAD CONTENTS
                    ArrayList<User> users = sqlite.getUsers();
                    ArrayList<User> filteredUsers = new ArrayList<User>();
                    //      FILTER OUT USERS BASED ON THE ROLE OF PERSON CURRENTLY LOGGED IN
                    switch(currentUserRole){
                        case "client":
                            break;

                        case "staff":
                            for(int nCtr = 0; nCtr < users.size(); nCtr++){
                                if(users.get(nCtr).getRole() == 1 || 
                                   users.get(nCtr).getRole() == 2 ||
                                   users.get(nCtr).getRole() == 3){
                                    filteredUsers.add(users.get(nCtr));
                                }
                            }
                            break;
                        case "manager":
                            for(int nCtr = 0; nCtr < users.size(); nCtr++){
                                if(users.get(nCtr).getRole() == 1 || 
                                   users.get(nCtr).getRole() == 2 || 
                                   users.get(nCtr).getRole() == 3 ||
                                   users.get(nCtr).getRole() == 4){
                                    filteredUsers.add(users.get(nCtr));
                                }
                            }
                            break;
                        case "admin":
                            for(int nCtr = 0; nCtr < users.size(); nCtr++){
                                if(users.get(nCtr).getRole() == 1 || 
                                   users.get(nCtr).getRole() == 2 || 
                                   users.get(nCtr).getRole() == 3 || 
                                   users.get(nCtr).getRole() == 4 ||
                                   users.get(nCtr).getRole() == 5){
                                    filteredUsers.add(users.get(nCtr));
                                }
                            }
                            break;

                        default:
                            break;
                    }
                    
                    for(int nCtr = 0; nCtr < filteredUsers.size(); nCtr++){
                        tableModel.addRow(new Object[]{
                            filteredUsers.get(nCtr).getUsername(), 
                            filteredUsers.get(nCtr).getPassword(), 
                            filteredUsers.get(nCtr).getRole(), 
                            filteredUsers.get(nCtr).getLocked()});
                    }
            }
        }
        }
    
    }//GEN-LAST:event_chgpassBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chgpassBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editRoleBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lockBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
