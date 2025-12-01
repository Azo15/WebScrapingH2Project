package com.proje.database;

import com.proje.model.ScrapedData;
import java.sql.*;

// H2 veritabanı bağlantısı ve temel işlemler
public class DatabaseManager {

    // Bağlantı bilgileri
    private static final String JDBC_URL = "jdbc:h2:~/webscraperdb";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public DatabaseManager() {
        // Gerekirse başlangıç ayarları burada yapılabilir
    }
 
    // Veritabanına bağlanır
    public Connection connect() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            System.out.println("Veritabanına bağlanıldı.");
            return connection;
        } catch (SQLException e) {
            System.err.println("Bağlantı hatası: " + e.getMessage());
            return null;
        }
    }

    // Tabloyu oluşturur (yoksa)
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS SCRAPED_ITEMS (" +
                "ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "TITLE VARCHAR(500), " +
                "URL VARCHAR(1000), " +
                "DETAIL VARCHAR(1000))";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tablo hazır.");
        } catch (SQLException e) {
            System.err.println("Tablo hatası: " + e.getMessage());
        }
    }

    // Veri ekler
    public void insertData(ScrapedData data) {
        String sql = "INSERT INTO SCRAPED_ITEMS (TITLE, URL, DETAIL) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, data.getTitle());
            pstmt.setString(2, data.getUrl());
            pstmt.setString(3, data.getDetail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Kayıt hatası: " + e.getMessage());
        }
    }
}
