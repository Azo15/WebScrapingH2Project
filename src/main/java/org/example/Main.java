package org.example;

import com.proje.database.DatabaseManager;
import com.proje.scraper.WebScraper;

public class Main {
    public static void main(String[] args) {

        System.out.println("Proje başladı...");

        // Veritabanı yöneticisini oluştur
        DatabaseManager dbManager = new DatabaseManager();

        // Tabloyu hazırla
        dbManager.createTable();

        // Scraper başlat
        WebScraper scraper = new WebScraper(dbManager);

        // Scraping + Kaydetme
        scraper.scrapeAndSave();

        System.out.println("Tüm işlemler tamamlandı.");
    }
}
