package com.mikimup;

import com.mikimup.controller.ProductController;
import com.mikimup.model.Product;
import com.mikimup.view.POSView;

public class Main {

    public static void main(String[] args) {
        ProductController controller = new ProductController();
        POSView view = new POSView();

        view.txtStruk.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

        refreshComboBox(controller, view);

        view.btnBayar.addActionListener(e -> processPayment(controller, view));

        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private static void processPayment(ProductController controller, POSView view) {
        Product product = (Product) view.cbProduct.getSelectedItem();
        String qtyText = view.txtQty.getText().trim();

        if (product == null || qtyText.isEmpty()) {
            view.showMessage("Pilih produk dan masukkan jumlah!");
            return;
        }

        try {
            int qty = Integer.parseInt(qtyText);
            if (controller.processCheckout(product, qty)) {
                cetakStruk(view, product, qty);
                refreshComboBox(controller, view);
            } else {
                view.showMessage("Transaksi Gagal! Stok tidak cukup.");
            }
        } catch (NumberFormatException ex) {
            view.showMessage("Input Qty harus berupa angka!");
        }
    }

    private static void cetakStruk(POSView view, Product p, int qty) {
        double total = p.getHarga() * qty;
        String struk = String.format(
                "=== BUKTI TRANSAKSI MIKIMUP ===\nProduk\t\t: %s\nJumlah\t\t: %d\nTotal Bayar\t: Rp %,.0f\nStatus\t\t: LUNAS (Prepaid)\n===============================\n",
                p.getNamaProduct(), qty, total).replace(',', '.');

        view.txtStruk.setText(struk);
        view.txtQty.setText("");
    }

    private static void refreshComboBox(ProductController controller, POSView view) {
        view.cbProduct.removeAllItems();
        controller.loadAllProducts().forEach(view.cbProduct::addItem);
    }
}
