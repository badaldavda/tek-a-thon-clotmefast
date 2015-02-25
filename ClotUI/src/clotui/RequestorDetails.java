/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clotui;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Badal
 */
public class RequestorDetails extends javax.swing.JFrame {

    /**
     * Creates new form RequestorDetails
     */
    public RequestorDetails() {
        initComponents();
        
        showpane();
        
        
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
        myTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        donorSelect = new javax.swing.JTable();
        btnSend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Requestor ID", "Name", "Number", "Blood Group", "Nearest Railway Station"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(myTable);

        donorSelect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,  new Boolean(true)},
                {null, null, null, null,  new Boolean(false)},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Donor ID", "Name", "Age", "Phone Number", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(donorSelect);

        btnSend.setText("Send");
        btnSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSendMouseClicked(evt);
            }
        });

        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane3.setViewportView(txtarea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSend)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnSend)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myTableMouseClicked
        // TODO add your handling code here:
            try{
                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                final String DB_URL = "jdbc:mysql://localhost/cmf";

        //  Database credentials
                final String USER = "root";
                final String PASS = "";
                
                  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    
                int row = myTable.getSelectedRow();
                String myTable_click3=(myTable.getModel().getValueAt(row, 1).toString());
                String myTable_click4=(myTable.getModel().getValueAt(row, 2).toString());
                String myTable_click1=(myTable.getModel().getValueAt(row, 3).toString());
                String myTable_click2=(myTable.getModel().getValueAt(row, 4).toString());
                String sms = "Think Foundation:\nBlood Needed for "+myTable_click3+" Blood Group "+myTable_click1+", near "+myTable_click2+" give a missed call at xxxx-xxx-xxx-xxx ";
                System.out.println(sms);
                txtarea.setLineWrap(rootPaneCheckingEnabled);
                txtarea.setText(sms);
                
                String sql="select DonorID,Name,Age,PhoneNo from donor where BloodGroup='"+myTable_click1+"' AND NRS='"+myTable_click2+"'";
                Statement stmt = conn.prepareStatement(sql);
                ResultSet rs= stmt.executeQuery(sql);
                DefaultTableModel dtm = new DefaultTableModel(){
                 @Override
                    public Class<?> getColumnClass(int col) {
                    if(col == 4){
                    return Boolean.class;
                    }
                    return super.getColumnClass(col);
                    };
                };
                 Vector data_columns = new Vector();                 
                 Vector data_rows = new Vector();
                
                data_columns.addElement("DonorID");
                data_columns.addElement("Name");
                data_columns.addElement("Age");
                data_columns.addElement("Phone Number");
                data_columns.addElement("Select");
                
                dtm.setColumnIdentifiers(data_columns);
                
                while(rs.next())
                {
                data_rows= new Vector();
                        for(int i=1;i<=4;i++)
                        {
                            data_rows.addElement(rs.getString(i));
                        }
                           data_rows.add(4,false);

                        dtm.addRow(data_rows);
                        
                }
                    
                donorSelect.setModel(dtm);
            }
            catch(Exception e)
            {
                 System.out.println(Arrays.toString(e.getStackTrace()));
       
                 System.out.println(e);
            }
    }//GEN-LAST:event_myTableMouseClicked

    private void btnSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseClicked
        // TODO add your handling code here:
        try{
                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                final String DB_URL = "jdbc:mysql://localhost/cmf";

        //  Database credentials
                final String USER = "root";
                final String PASS = "";
                
                  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                  int row = myTable.getSelectedRow();
                  String myTable_click0 = (myTable.getModel().getValueAt(row, 1).toString());
                  //Statement stmt = conn.prepareStatement();
                  
                  ArrayList<String> selectedRows;
            selectedRows = new ArrayList<>();
                  for(int i = 0; i < donorSelect.getRowCount();i++)
                  {
                      if((Boolean)donorSelect.getValueAt(i, 4))
                      {
                          System.out.println(donorSelect.getValueAt(i,0));
                          boolean add = selectedRows.add((String)donorSelect.getValueAt(i, 0));
                          System.out.println(add);
                      }
                  }
            for (String selectedRow : selectedRows) {
                System.out.println(selectedRow);
            }
                  
        
        
        
        
        
        
        }         
        catch(Exception e)
        {
             System.out.println(Arrays.toString(e.getStackTrace()));
       
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(null,e, "Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSendMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RequestorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestorDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequestorDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JTable donorSelect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable myTable;
    private javax.swing.JTextArea txtarea;
    // End of variables declaration//GEN-END:variables
        private void showpane() {

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/cmf";

        //  Database credentials
        final String USER = "root";
        final String PASS = "";
        try{
            
        
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT ReqId,Name,Contact,BloodGroup,NRS FROM requestor ORDER BY ReqId DESC");
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel dtm = new DefaultTableModel();
                    
                    Vector data_columns = new Vector();                 
                    Vector data_rows = new Vector();
                        data_columns.addElement("Requestor ID");
                        data_columns.addElement("Name");
                        data_columns.addElement("Contact");
                        data_columns.addElement("Blood Group");
                        data_columns.addElement("Nearest Railway Station");
                        
                    
                    dtm.setColumnIdentifiers(data_columns);
                    
                    while(rs.next())
                    {
                        data_rows= new Vector();
                        for(int i=1;i<=5;i++)
                        {
                        data_rows.addElement(rs.getString(i));
                        }
                        dtm.addRow(data_rows);
                    }
                    myTable.setModel(dtm);
                    
        }
        catch(SQLException | HeadlessException e)
    {
        System.out.println(Arrays.toString(e.getStackTrace()));
        System.out.println(e);
    }
    }

    }

