package com.mycompany.rat.maze;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class InterFace extends JFrame {

    public InterFace() {
        initComponents();
    }

    private void initComponents() {

        InterFace = new javax.swing.JLayeredPane();
        input = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maze");
        InterFace.setBackground(new java.awt.Color(255, 255, 255));
        InterFace.setOpaque(true);

        input.addActionListener(evt -> inputActionPerformed(evt));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 24));
        jButton1.setText("Enter");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18));
        jLabel1.setText("Enter Number");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\OneDrive\\Documents\\NetBeansProjects\\rat-maze\\src\\main\\java\\com\\mycompany\\icon\\rat.jpg"));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 50));
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("rat maze ");

        InterFace.setLayer(input, javax.swing.JLayeredPane.DEFAULT_LAYER);
        InterFace.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        InterFace.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        InterFace.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        InterFace.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout InterFaceLayout = new javax.swing.GroupLayout(InterFace);
        InterFace.setLayout(InterFaceLayout);
        InterFaceLayout.setHorizontalGroup(
                InterFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InterFaceLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(InterFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(InterFaceLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(InterFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(InterFaceLayout.createSequentialGroup()
                                                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(InterFaceLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        InterFaceLayout.setVerticalGroup(
                InterFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(InterFaceLayout.createSequentialGroup()
                                .addGroup(InterFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(InterFaceLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(101, 101, 101)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(InterFaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(InterFaceLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(InterFace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(InterFace)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int n = Integer.parseInt(input.getText());
        Maze mazeView = new Maze(n);
        mazeView.setVisible(true);
        dispose(); // Close the current interface
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new InterFace().setVisible(true));
    }

    private javax.swing.JLayeredPane InterFace;
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
}