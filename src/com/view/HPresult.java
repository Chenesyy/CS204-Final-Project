package com.view;

import javax.swing.JFrame;

public class HPresult extends javax.swing.JFrame {

    public HPresult() {
        initComponents();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
    
    public void Main(String pattern, String source) {
        HPresult hss = new HPresult();
        char[] patt = pattern.toLowerCase().toCharArray();
        char[] src = source.toLowerCase().toCharArray();
        int pos = hss.Horspool(patt, src);
        
        if (pos == -1) {
            msg.setText("<html>SORRY, I COULD NOT FIND WHAT<br> YOU WERE LOOKING FOR.. :( </html>");
        } else {
            msg.setText("<html>I HAVE FOUND " + pos + " AVAILABLE DISH(ES)<br> FOR: " + pattern.toUpperCase() + "</html>");
        }
    }

    public int Horspool(char[] p, char[] t) {
        HPresult hss = new HPresult();
        int[] shift = hss.shiftTable(p);
        int counter = 0;
        int i = p.length - 1;
        int m = p.length;
        int k;

        while (i <= t.length - 1) {
            k = 0;
            while ((k <= m - 1) && (p[m - 1 - k] == t[i - k])) {
                k = k + 1;
            }
            if (k == m) {
                counter++;
		i = i + shift[t[i]];
                //return i - m + 1;
            } else {
                i = i + shift[t[i]];
            }
        }
        if (counter > 0)
            return counter;
        else
            return -1;
    }

    public int[] shiftTable(char[] p) { 
        int[] s = new int[500];	
        int m = p.length;

        for (int i = 0; i < s.length; i++) {
            s[i] = m; //yung buonf shift table value muna is yng pattern length
        }
        for (int j = 0; j <= m - 2; j++) {
            s[p[j]] = m - 1 - j; //ito na yung shifts ng mga letters, the rest is yng pattern length
        }
        return s;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        msg = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 720));
        jPanel1.setLayout(null);

        msg.setFont(new java.awt.Font("Baskerville Old Face", 0, 49)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 222, 0));
        msg.setText("jLabel2");
        jPanel1.add(msg);
        msg.setBounds(110, 140, 920, 280);

        Back.setBackground(new java.awt.Color(153, 153, 153));
        Back.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Back.setText("Again");
        Back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        jPanel1.add(Back);
        Back.setBounds(650, 620, 90, 40);

        label.setFont(new java.awt.Font("Baskerville Old Face", 0, 49)); // NOI18N
        label.setForeground(new java.awt.Color(255, 222, 0));
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/images/blank.png"))); // NOI18N
        jPanel1.add(label);
        label.setBounds(0, 0, 1370, 720);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Search srch = new Search();
        srch.setVisible(true);
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
            java.util.logging.Logger.getLogger(HPresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HPresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HPresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HPresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HPresult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel msg;
    // End of variables declaration//GEN-END:variables
}
