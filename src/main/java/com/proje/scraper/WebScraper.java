package com.proje.scraper;

import com.proje.database.DatabaseManager;
import com.proje.model.ScrapedData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

// Kitapları web sitesinden çeker ve DB'ye kaydeder
public class WebScraper {

    private final String url = "http://books.toscrape.com/";  // Hedef site
    private final DatabaseManager dbManager;

    public WebScraper(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    // Scrape + Veritabanına kaydet
    public void scrapeAndSave() {
        System.out.println("Scraping başladı...");

        try {
            // Siteye bağlan
            Document document = Jsoup.connect(url).timeout(10000).get();

            // Her kitap için ana CSS seçici
            Elements articles = document.select("article.product_pod");

            int count = 0;

            // Kitapları ayrıştır
            for (Element article : articles) {

                Element titleElement = article.selectFirst("h3 a");
                Element priceElement = article.selectFirst("p.price_color");

                if (titleElement == null || priceElement == null) continue;

                // Verileri al
                String title = titleElement.attr("title");
                String link = url + titleElement.attr("href");
                String detail = priceElement.text();

                // Model nesnesi oluştur
                ScrapedData data = new ScrapedData(title, link, detail);

                // DB'ye kaydet
                dbManager.insertData(data);
                count++;
            }

            System.out.println(count + " veri kaydedildi.");

        } catch (IOException e) {
            System.err.println("Bağlantı hatası: " + e.getMessage());
        }
    }
}
