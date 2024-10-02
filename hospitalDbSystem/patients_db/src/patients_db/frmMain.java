
package patients_db;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;


public class frmMain extends javax.swing.JFrame {

    // MySQL database connection details
    private static final String username = "root";
    private static final String password = "pass";
    private static final String dataConn = "jdbc:mysql://localhost:3306/patients_db";

    Connection sqlconn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    
    // Constructor
    public frmMain() {
        initComponents();
    }

    // Function: updateDB
    // Description: Connects to the database and retrieves data to update the GUI components
    public void updateDB() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a connection to the database
            sqlconn = DriverManager.getConnection(dataConn, username, password);
            
            // Prepare a SELECT query to retrieve data from the patients_records table
            pst = sqlconn.prepareStatement("SELECT * FROM patients_records");
            
            // Execute the query and retrieve the result set
            rs = pst.executeQuery();
            
            // Get the metadata of the result set
            ResultSetMetaData stData = rs.getMetaData();
            
            // Get the number of columns in the result set
            q = stData.getColumnCount();
            
            // Get the table model for jTable1 component
            DefaultTableModel recordTable = (DefaultTableModel) jTable1.getModel();
            
            // Clear the existing rows in the table
            recordTable.setRowCount(0);
            
            // Iterate through the result set and add data to the table
            while (rs.next()) {
                Vector columnData = new Vector();
                for (i = 1; i <= q; i++) {
                    // Add data from specific columns to the vector
                    columnData.add(rs.getString("FirstName"));
                    columnData.add(rs.getString("LastName"));
                    columnData.add(rs.getString("DateofBirth"));
                    columnData.add(rs.getString("Email"));
                    columnData.add(rs.getString("VisitReason"));
                    columnData.add(rs.getString("Gender"));
                }
                // Add the vector as a new row to the table
                recordTable.addRow(columnData);
            }
        } catch (Exception ex) {
            // Display an error message if an exception occurs
            JOptionPane.showMessageDialog(null, ex);
        }
    }

   //=================================END Function====================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtLName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDoB = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtFName = new javax.swing.JTextField();
        txtVR = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Patients System");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 51, 255)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Gender");

        txtLName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtLName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 4));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Last Name");

        txtGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 4));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Date of Birth");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Visit Reason");

        txtDoB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDoB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 4));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 4));

        txtFName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 4));

        txtVR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtVR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255), 4));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDoB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtVR, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtVR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btnUpdate.setBackground(new java.awt.Color(0, 51, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText(" Update Data");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Date of Birth", "Email", "Visit Reason", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnDelete.setBackground(new java.awt.Color(0, 51, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete Data");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 51, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add New Data");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(0, 51, 255));
        btnPrint.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print Data ");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 51, 255));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset ");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jbtnExit.setBackground(new java.awt.Color(0, 51, 255));
        jbtnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbtnExit.setForeground(new java.awt.Color(255, 255, 255));
        jbtnExit.setText("Exit");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        btnView.setBackground(new java.awt.Color(0, 51, 255));
        btnView.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnView.setForeground(new java.awt.Color(255, 255, 255));
        btnView.setText("View Data");
        btnView.setActionCommand("view");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(21, 21, 21)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jbtnExit)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 333, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd)
                    .addComponent(btnPrint)
                    .addComponent(btnReset)
                    .addComponent(btnView))
                .addGap(11, 11, 11)
                .addComponent(jbtnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private JFrame frame;

// Event handler for jbtnExit button
    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
frame = new JFrame("Exit");
    
    // Display a confirmation dialog asking if the user wants to exit
    if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "MySQL Connector", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        // If the user chooses to exit, terminate the program
        System.exit(0);}
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
// Clear all texts in the text fields
     txtFName.setText("");
     txtLName.setText("");
     txtGender.setText("");
     txtDoB.setText("");
     txtEmail.setText("");
     txtVR.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
         
    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establish a connection to the database
        sqlconn = DriverManager.getConnection(dataConn, username, password);
        
        // Prepare an INSERT statement to add a new record to the patients_records table
        pst = sqlconn.prepareStatement("INSERT INTO patients_records (FirstName, LastName, DateofBirth, Email, VisitReason, Gender) VALUES (?,?,?,?,?,?)");
        
        // Set the values for the parameters in the prepared statement
        
        // Set the first name parameter
        pst.setString(1, txtFName.getText());
        
        // Set the last name parameter
        pst.setString(2, txtLName.getText());
        
        // Set the date of birth parameter
        pst.setString(3, txtDoB.getText());
        
        // Set the email parameter
        pst.setString(4, txtEmail.getText());
        
        // Set the visit reason parameter
        pst.setString(5, txtVR.getText());
        
        // Set the gender parameter
        pst.setString(6, txtGender.getText());
        
        // Execute the INSERT statement to add the new record
        pst.executeUpdate();
        
        // Display a success message
        JOptionPane.showMessageDialog(this, "Record Added");
        
        // Update the table with the latest data from the database
        updateDB();
    } catch (ClassNotFoundException ex) {
        // Log and handle ClassNotFoundException
        java.util.logging.Logger.getLogger(Patients_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        // Log and handle SQLException
        java.util.logging.Logger.getLogger(Patients_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }


    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
     try {
    // Load the MySQL JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Establish a connection to the database
    sqlconn = DriverManager.getConnection(dataConn, username, password);
    
    // Prepare an UPDATE statement to update an existing record in the patients_records table
    pst = sqlconn.prepareStatement("UPDATE patients_records SET FirstName = ?, LastName = ?, DateofBirth = ?, Email = ?, VisitReason = ?, Gender = ? WHERE FirstName = ?");
    
    // Set the values for the parameters in the prepared statement
    
    // Set the first name parameter
    pst.setString(1, txtFName.getText());
    
    // Set the last name parameter
    pst.setString(2, txtLName.getText());
    
    // Set the date of birth parameter
    pst.setString(3, txtDoB.getText());
    
    // Set the email parameter
    pst.setString(4, txtEmail.getText());
    
    // Set the visit reason parameter
    pst.setString(5, txtVR.getText());
    
    // Set the gender parameter
    pst.setString(6, txtGender.getText());
    
    // Set the value for the FirstName parameter in the WHERE clause
    pst.setString(7, txtFName.getText());
    
    // Execute the UPDATE statement to update the existing record
    pst.executeUpdate();
    
    // Display a success message
    JOptionPane.showMessageDialog(this, "Record Updated");
    
    // Update the table with the latest data from the database
    updateDB();
} catch (ClassNotFoundException ex) {
    // Log and handle ClassNotFoundException
    java.util.logging.Logger.getLogger(Patients_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (SQLException ex) {
    // Log and handle SQLException
    java.util.logging.Logger.getLogger(Patients_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      // Get the table model for jTable1
DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();

// Get the index of the selected row in the JTable
int selectedRow = jTable1.getSelectedRow();

// Retrieve the values from the selected row in the JTable and set them in the corresponding text fields

// Set the value of the first name text field
txtFName.setText(RecordTable.getValueAt(selectedRow, 0).toString());

// Set the value of the last name text field
txtLName.setText(RecordTable.getValueAt(selectedRow, 1).toString());

// Set the value of the date of birth text field
txtDoB.setText(RecordTable.getValueAt(selectedRow, 2).toString());

// Set the value of the email text field
txtEmail.setText(RecordTable.getValueAt(selectedRow, 3).toString());

// Set the value of the visit reason text field
txtVR.setText(RecordTable.getValueAt(selectedRow, 4).toString());

// Set the value of the gender text field
txtGender.setText(RecordTable.getValueAt(selectedRow, 5).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
   // Create a header message format for printing
MessageFormat header = new MessageFormat("Printing in progress");

// Create a footer message format for printing
MessageFormat footer = new MessageFormat("Page(0, number, Integer)");

try {
    // Print the content of the JTable with the specified header and footer
    jTable1.print(JTable.PrintMode.NORMAL, header, footer);
} catch (java.awt.print.PrinterException e) {
    // Handle any printer exceptions
    System.err.format("No Printer found ", e.getMessage());
}

    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       // Get the table model for jTable1
DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();

// Get the index of the selected row in the JTable
int selectedRow = jTable1.getSelectedRow();

try {
    // Display a confirmation dialog to confirm deleting items
    deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete items", "Warning", JOptionPane.YES_NO_OPTION);
    
    if (deleteItem == JOptionPane.YES_OPTION) {
        // Load the MySQL JDBC driver and establish a connection to the database
        Class.forName("com.mysql.cj.jdbc.Driver");
        sqlconn = DriverManager.getConnection(dataConn, username, password);
        
        // Prepare a DELETE statement to delete the record from the patients_records table
        pst = sqlconn.prepareStatement("DELETE FROM patients_records WHERE FirstName = ?");
        
        // Retrieve the value of the FirstName column from the selected row
        String firstName = (String) RecordTable.getValueAt(selectedRow, 0); // Assuming the first column is the FirstName
        
        // Set the value for the FirstName parameter in the DELETE statement
        pst.setString(1, firstName);
        
        // Execute the DELETE statement to delete the record from the database
        pst.executeUpdate();
        
        // Display a success message
        JOptionPane.showMessageDialog(this, "Record deleted");
        
        // Update the table with the latest data from the database
        updateDB();
        
        // Clear the text fields
        txtFName.setText("");
        txtLName.setText("");
        txtDoB.setText("");
        txtEmail.setText("");
        txtVR.setText("");
        txtGender.setText("");
    }
} catch (ClassNotFoundException ex) {
    // Log and handle ClassNotFoundException
    java.util.logging.Logger.getLogger(Patients_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (SQLException ex) {
    // Handle SQLException by printing the error
    System.err.println(ex);
}
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
    try {
    // Load the MySQL JDBC driver and establish a connection to the database
    Class.forName("com.mysql.cj.jdbc.Driver");
    sqlconn = DriverManager.getConnection(dataConn, username, password);
    
    // Prepare a SELECT statement to retrieve all records from the patients_records table
    pst = sqlconn.prepareStatement("SELECT * FROM patients_records");
    
    // Execute the SELECT statement and retrieve the result set
    ResultSet rs = pst.executeQuery();
    
    // Create the column names array
    
    // Get the metadata of the result set
    ResultSetMetaData rsmd = rs.getMetaData();
    
    // Get the number of columns in the result set
    int columnCount = rsmd.getColumnCount();
    
    // Create an array to store the column names
    String[] columnNames = new String[columnCount];
    
    // Iterate through the columns and retrieve their names
    for (int i = 1; i <= columnCount; i++) {
        columnNames[i - 1] = rsmd.getColumnName(i);
    }
    
    // Create the data array
    
    // Create an ArrayList to store the rows of data
    ArrayList<Object[]> data = new ArrayList<>();
    
    // Iterate through the result set and retrieve the data for each row
    while (rs.next()) {
        // Create an array to store the values of each column in the row
        Object[] row = new Object[columnCount];
        
        // Iterate through the columns and retrieve their values
        for (int i = 1; i <= columnCount; i++) {
            row[i - 1] = rs.getObject(i);
        }
        
        // Add the row to the data ArrayList
        data.add(row);
    }
    
    // Create the DefaultTableModel with the data and column names
    
    // Convert the data ArrayList to a 2D array
    Object[][] dataArray = data.toArray(new Object[0][0]);
    
    // Create a new DefaultTableModel with the data and column names
    DefaultTableModel model = new DefaultTableModel(dataArray, columnNames);
    
    // Set the model to the JTable
    jTable1.setModel(model);
    
} catch (ClassNotFoundException ex) {
    // Log and handle ClassNotFoundException
    java.util.logging.Logger.getLogger(Patients_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (SQLException ex) {
    // Log and handle SQLException
    java.util.logging.Logger.getLogger(Patients_db.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}

    
    }//GEN-LAST:event_btnViewActionPerformed

   
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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JTextField txtDoB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtVR;
    // End of variables declaration//GEN-END:variables

    

  

}
