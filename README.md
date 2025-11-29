📘 Web Scraping H2 Project 

Bu proje, Java, Jsoup ve H2 Database kullanılarak hazırlanmış basit bir web scraping ve veri kaydetme uygulamasıdır. Amaç, örnek bir web sitesinden veri çekip bunları yerel H2 veritabanına kaydetmektir.

🎯 Projenin Amacı

HTML sayfalarından veri çekmek

Jsoup ile CSS seçicileri kullanarak ayrıştırma yapmak

H2 Database üzerinde tablo oluşturmak ve veri eklemek

Java’da temel katmanlı yapıyı göstermek (Model – Database – Scraper – Main)

🛠 Kullanılan Teknolojiler

Java 23

Maven

Jsoup (web scraping için)

H2 Database (dosya tabanlı veritabanı)

📁 Proje Yapısı

ScrapedData → Çekilen veriyi temsil eden model sınıfı

DatabaseManager → H2 bağlantısı, tablo oluşturma, veri ekleme işlemleri

WebScraper → Jsoup ile siteye bağlanır, verileri toplar ve DB'ye kaydeder

Main → Projenin başlangıç noktası

🔍 Veri Kaynağı

Scraping işlemi örnek bir eğitim sitesi üzerinden yapılır:

http://books.toscrape.com

Çekilen bilgiler:

Kitap adı

Kitap sayfası linki

Fiyat

💾 Veritabanı Bilgileri

H2 dosyası: ~/webscraperdb.mv.db
Tablo adı: SCRAPED_ITEMS

Tablo kolonları:

ID (otomatik artan)

TITLE

URL

DETAIL

▶ Nasıl Çalıştırılır?

1. Maven ile derle:

mvn clean install


2. Uygulamayı çalıştır:

mvn exec:java -Dexec.mainClass="org.example.Main"


Program çalıştığında:

Veritabanı bağlantısı kurulur

Tablo oluşturulur

Siteden veri çekilir

Veritabanına kaydedilir

✔ Özet

Bu proje, web scraping mantığını ve H2 üzerinde veri saklamayı öğrenmek isteyenler için sade ve anlaşılır bir örnektir. Daha büyük scraping projeleri için altyapı görevi görebilir.
