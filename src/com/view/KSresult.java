package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class KSresult extends javax.swing.JFrame {

    public KSresult() {
        initComponents();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    public KSresult(int W, int wt[], int val[], int n, HashMap<Integer, String> map, HashMap<Integer, Integer> wv) {
        initComponents();
        int i, w;
        int total = 0;
        int counter = 0;
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<Integer> price = new ArrayList<Integer>();
        ArrayList<Integer> ratings = new ArrayList<Integer>();
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] 
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w += 50) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        // stores the result of Knapsack 
        int res = K[n][W];
        int rate = res;

        w = W;
        for (i = n; i > 0 && res > 0; i--) {

            // either the result comes from the top 
            // (K[i-1][w]) or from (val[i-1] + K[i-1] 
            // [w-wt[i-1]]) as in Knapsack table. If 
            // it comes from the latter one/ it means 
            // the item is included. 
            if (res == K[i - 1][w]) {
                continue;
            } else {

                // This item is included. 
                items.add(map.get(wt[i - 1]).replaceAll("_", " ")); //gets item name
                price.add(wt[i - 1]); //gets item price
                ratings.add(wv.get(wt[i - 1])); //gets item ratings
                total += wt[i - 1]; //gets the total price/cost
                counter++; //para malaman ilang items ang kasama

                // Since this weight is included its 
                // value is deducted 
                res = res - val[i - 1];
                w = w - wt[i - 1];
            }
        }        
        //ilalagay mga data sa table
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[3];
        for (i = 0; i < items.size(); i++) {
            row[0] = items.get(i);
            row[1] = ratings.get(i);
            row[2] = price.get(i);
            model.addRow(row);
        }
        
        //designs of table
        table.setBackground(Color.decode("#620000"));
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setBackground(Color.decode("#620000"));
        table.setGridColor(Color.decode("#ffffff"));
        table.setForeground(Color.decode("#ffffff"));
        jScrollPane1.setBackground(Color.decode("#620000"));
        table.setRowHeight(60);
        jScrollPane1.setOpaque(false);
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        table.setShowGrid(true);
        
        value.setText("TOTAL MEAL VALUE: " + rate + "/" + counter * 10); //total rating and over quantity of items * 10
        totalLabel.setText("TOTAL COST: " + total); //Total price of items included
        rating.setText("OVERALL MEAL RATING: " + rate/counter); //Overall rating, total rating/number of items
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        value = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        rating = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel2.setPreferredSize(new java.awt.Dimension(1366, 720));
        jPanel2.setLayout(null);

        value.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        value.setForeground(new java.awt.Color(250, 198, 14));
        value.setText("jLabel1");
        jPanel2.add(value);
        value.setBounds(380, 430, 300, 60);

        totalLabel.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(250, 198, 14));
        totalLabel.setText("jLabel4");
        jPanel2.add(totalLabel);
        totalLabel.setBounds(380, 490, 540, 60);

        rating.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        rating.setForeground(new java.awt.Color(250, 198, 14));
        rating.setText("jLabel1");
        jPanel2.add(rating);
        rating.setBounds(380, 550, 270, 60);

        Back.setBackground(new java.awt.Color(153, 153, 153));
        Back.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Back.setText("Again");
        Back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel2.add(Back);
        Back.setBounds(650, 620, 90, 40);

        table.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food", "Rating", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setSelectionBackground(new java.awt.Color(71, 4, 4));
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(120, 190, 920, 220);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/images/ks.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(1366, 720));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, -30, 1370, 770);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Main mn = new Main();
        mn.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(KSresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KSresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KSresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KSresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KSresult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rating;
    private javax.swing.JTable table;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel value;
    // End of variables declaration//GEN-END:variables
}
