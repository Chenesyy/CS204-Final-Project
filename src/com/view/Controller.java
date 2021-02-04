package com.view;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.*;

public class Controller extends javax.swing.JFrame {

    //JLabel label;
    String budget;
    int W = 0;
    public Controller() {
        initComponents();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    public Controller(int input) throws FileNotFoundException {
        initComponents();
        File KSfile = new File("Knapsack.txt");
        Scanner read = new Scanner(KSfile);
        W = input;
        //sa file, (1) Items, (2) Value, (3) Weight
        String[] items = read.nextLine().split(" ");

        String[] value = read.nextLine().split(" ");
        int n = value.length;
        int[] val = new int[n];

        for (int i = 0; i < value.length; i++) {
            val[i] = Integer.parseInt(value[i]);
        }

        String[] weight = read.nextLine().split(" ");
        int m = weight.length;
        int[] wt = new int[m];

        for (int i = 0; i < weight.length; i++) {
            wt[i] = Integer.parseInt(weight[i]);
        }

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < items.length; i++) {
            map.put(wt[i], items[i]);
        }
        
        HashMap<Integer, Integer> wtval = new HashMap<Integer, Integer>();
            for (int i = 0; i < wt.length; i++) {
                wtval.put(wt[i], val[i]);
        }
        
        KSresult ks = new KSresult(W, wt, val, n, map, wtval);
        ks.setVisible(true);
        ks.setExtendedState(ks.getExtendedState() | JFrame.MAXIMIZED_BOTH);
 //       new KSresult(W, wt, val, n, map).setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
