package com.mikimup.model;

import com.mikimup.database.DBConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Felda Ardelia Oktrianti
 */
public class ProductDAO {

    private DBConnector db;

    public ProductDAO(DBConnector db) {
        this.db = db;
    }

    public List<Product> getAllProducts() throws Exception {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product WHERE jumlahStok > 0";
        try (Connection conn = db.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                products.add(new Product(rs.getInt("idProduct"), rs.getString("namaProduct"),
                        rs.getDouble("harga"), rs.getInt("jumlahStok")));
            }
        }
        return products;
    }

    public void kurangiStok(int idProduct, int qty) throws Exception {
        String query = "UPDATE product SET jumlahStok = jumlahStok - ? WHERE idProduct = ?";
        try (Connection conn = db.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, qty);
            pstmt.setInt(2, idProduct);
            pstmt.executeUpdate();
        }
    }
}
