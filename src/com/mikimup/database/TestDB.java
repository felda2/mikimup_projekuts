package com.mikimup.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Felda Ardelia Oktrianti
 */
public class TestDB {

    public static void main(String[] args) {
        DBConnector db = new MySQLConnection();

        System.out.println("Memulai pengujian koneksi database...");

        try (Connection conn = db.getConnection()) {
            if (conn != null) {
                System.out.println("==========================================");
                System.out.println("✅ KONEKSI DATABASE BERHASIL!");
                System.out.println("==========================================");

                // Membaca data dari tabel product
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM product");

                System.out.println("\nData Produk di Database 'mikimup_db':");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("idProduct")
                            + " | Menu: " + rs.getString("namaProduct")
                            + " | Harga: Rp" + rs.getInt("harga")
                            + " | Stok: " + rs.getInt("jumlahStok"));
                }
                System.out.println("==========================================");
            }
        } catch (Exception e) {
            System.out.println("==========================================");
            System.out.println("❌ KONEKSI GAGAL: " + e.getMessage());
            System.out.println("==========================================");
            System.out.println("Tips Penanganan Error:");
            System.out.println("1. Pastikan Service MySQL sudah aktif.");
            System.out.println("2. Pastikan database 'mikimup_db' sudah dibuat.");
            System.out.println("3. Pastikan file mysql-connector-j.jar sudah dimasukkan ke Libraries NetBeans.");
        }
    }
}
