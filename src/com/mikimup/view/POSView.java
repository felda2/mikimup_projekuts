package com.mikimup.view;

import com.mikimup.model.Product;
import javax.swing.*;
import java.awt.*;

/**
 * @author Felda Ardelia Oktrianti
 */
public class POSView extends JFrame {

    public JComboBox<Product> cbProduct = new JComboBox<>();
    public JTextField txtQty = new JTextField(5);
    public JButton btnBayar = new JButton("Bayar (Prepaid)");
    public JTextArea txtStruk = new JTextArea(8, 30);

    public POSView() {
        setTitle("Mikimup POS - MVP");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        add(new JLabel("Pilih Produk:"));
        add(cbProduct);
        add(new JLabel("Qty:"));
        add(txtQty);
        add(btnBayar);

        txtStruk.setEditable(false);
        add(new JScrollPane(txtStruk));
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
