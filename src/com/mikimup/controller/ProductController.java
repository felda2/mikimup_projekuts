package com.mikimup.controller;

import com.mikimup.database.MySQLConnection;
import com.mikimup.model.Product;
import com.mikimup.model.ProductDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Felda Ardelia Oktrianti
 */
public class ProductController {

    private final ProductDAO productDAO;

    public ProductController() {
        this.productDAO = new ProductDAO(new MySQLConnection());
    }

    public List<Product> loadAllProducts() {
        try {
            return productDAO.getAllProducts();
        } catch (Exception e) {
            System.err.println("Gagal memuat produk dari database: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean processCheckout(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            return false;
        }

        if (product.getJumlahStok() < quantity) {
            return false;
        }

        try {
            productDAO.kurangiStok(product.getIdProduct(), quantity);
            product.setJumlahStok(product.getJumlahStok() - quantity);
            return true;
        } catch (Exception e) {
            System.err.println("Gagal memproses transaksi: " + e.getMessage());
            return false;
        }
    }
}
