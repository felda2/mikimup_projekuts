package com.mikimup.model;

/**
 * @author Felda Ardelia Oktrianti
 */
public class Product {

    private int idProduct;
    private String namaProduct;
    private double harga;
    private int jumlahStok;

    public Product(int idProduct, String namaProduct, double harga, int jumlahStok) {
        this.idProduct = idProduct;
        this.namaProduct = namaProduct;
        this.harga = harga;
        this.jumlahStok = jumlahStok;
    }

    // Getter
    public int getIdProduct() {
        return idProduct;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public double getHarga() {
        return harga;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    @Override
    public String toString() {
        return namaProduct + " - Rp" + harga + " (Stok: " + jumlahStok + ")";
    }

    public void setJumlahStok(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
