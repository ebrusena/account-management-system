package accountmanagementsystem;

public class Main {
    static void main(String[] args) {
        BankaServisi banka = new BankaServisi();

        System.out.println("------Banka servisi başlatıldı----------");


        Hesap h1 = new VadesizHesap("TR 101", "Ebru Sena",3000);
        Hesap h2 = new VadesizHesap("Tr 102","Zişan Günaydın",20887);
        Hesap h3 = new VadesizHesap("Tr 103","Elif Nisa",390);

        banka.hesapEkle(h1); // Hesapları Banka Sistemine (Map'e) Ekliyoruz
        banka.hesapEkle(h2);
        banka.hesapEkle(h3);

        System.out.println("\n ---------İşlemler Başlatılıyor----------");
         banka.paraCekIslemi("TR 101",200);
         banka.paraCekIslemi("TR 103", 400);

         banka.bakiyeyeGoreListele();

        System.out.println("\n--- TEK HESAP SORGULAMA ---");

        // Var olan bir hesabı sorguluyoruz
        banka.hesapDetayGoster("TR 101");

        // Olmayan bir hesabı sorguluyoruz (Hata mesajını görmek için)
        banka.hesapDetayGoster("TR999");
        banka.hesapDetayGoster("Tr 103");
    }
}
