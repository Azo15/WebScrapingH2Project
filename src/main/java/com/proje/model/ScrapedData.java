package com.proje.model;

// Scraping sonrası her bir kitap/veri için model sınıfı
public class ScrapedData {

    private String title;   // Kitap adı
    private String url;     // Kitap linki
    private String detail;  // Fiyat gibi ek bilgi

    // Veri nesnesi oluşturur
    public ScrapedData(String title, String url, String detail) {
        this.title = title;
        this.url = url;
        this.detail = detail;
    }

    // Basit getter metodları
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDetail() {
        return detail;
    }

    // Konsolda kolay görüntüleme
    @Override
    public String toString() {
        return "Başlık: " + title + " | URL: " + url + " | Detay: " + detail;
    }
}
