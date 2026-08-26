# Account Management System (Banka Hesap Yönetim Sistemi)

Java OOP (Nesne Yönelimli Programlama) prensipleri, özel istisnalar (custom exceptions) ve dosya loglama mekanizması kullanılarak geliştirilmiş konsol tabanlı bir banka hesap yönetim sistemidir.

---

## Proje Özellikleri

* **Hesap Yönetimi:** Müşteri hesaplarının eklenmesi, bakiye takibi ve detay sorgulaması.
* **Para Çekme & Yatırma:** Ek hesap limitli para çekme desteği ve bakiye güncellemeleri.
* **Özel İstisna Yönetimi (Custom Exception):** Yetersiz bakiye durumlarında `YetersizBakiyeException` fırlatılması.
* **Otomatik Sıralama:** Hesapların bakiyelerine göre küçükten büyüğe sıralanabilmesi (`Comparable` arayüzü ile).
* **Dosya Loglama (Java NIO):** Yapılan işlemlerin (hesap ekleme, detay sorgulama) `banka_islemleri.txt` dosyasına tarih ve zaman damgasıyla kaydedilmesi.

---

## Kullanılan Teknolojiler ve Mimari

* **Dil:** Java 8+
* **Koleksiyonlar (Collections):** `HashMap` (Hızlı erişim ve arama için), `ArrayList`
* **Java NIO (`java.nio.file`):** Dosya oluşturma ve satır ekleme (`StandardOpenOption.APPEND`) işlemleri için.
* **OOP Konseptleri:**
  * **Abstraction:** `Hesap` soyut sınıfı ve `Raporlanabilir` arayüzü.
  * **Inheritance:** `VadesizHesap` sınıfının `Hesap` sınıfından türetilmesi.
  * **Polymorphism & Interface:** `Raporlanabilir` ve `Comparable` arayüz uyarlamaları.

---

## Proje Sınıf Yapısı

```text
accountmanagementsystem/
│
├── BankaServisi.java              # Hesap işlemlerinin ve loglamanın yönetildiği servis
├── Hesap.java                     # Temel hesap niteliklerini tutan soyut (abstract) sınıf
├── VadesizHesap.java              # Ek hesap limitli vadesiz hesap türevi
├── Raporlanabilir.java            # Raporlama yeteneği kazandıran interface
├── YetersizBakiyeException.java   # Bakiye yetersizliğinde fırlatılan özel istisna
└── Main.java                      # Uygulamanın çalıştırma ve test noktası
