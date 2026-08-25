package accountmanagementsystem;
import java.io.IOException;
import java.nio.file.*; // Path, Files ve StandardOpenOption sınıflarını kapsar
import java.util.*;     // ArrayList, Collections, Date, HashMap, List, Map sınıflarını kapsar

public class BankaServisi {
    private Map<String,Hesap> hesaplar = new HashMap<>();
    //hashmap kullanıyoruz çünkü key value ile değer tutucaz
    // İşlem geçmişini yazacağımız dosyanın diskteki adresini tanımlıyoruz.nio
    private Path logYolu = Path.of("banka_islemleri.txt");

    public void hesapEkle(Hesap hesap){
        hesaplar.put(hesap.getHesapNo(), hesap);
        System.out.println(hesap.getHesapNo()+"nolu hesap sisteme eklendi!");
        islemLogla("Yeni hesap eklendi: " + hesap.getHesapNo() + " - " + hesap.getMusteriAdi());
    }

    public void paraCekIslemi(String hesapNo,double miktar){
        Hesap arananHesap =hesaplar.get(hesapNo);
        if (arananHesap == null) {
            System.err.println("hata"+hesapNo+"numaralı hesap sistemde bulunamadı!");
            return;
        }

        try{
            arananHesap.paraCek(miktar);
            System.out.println("başarılı :  "+miktar+"Tl çekildi.  Kalan bakiye : "+arananHesap.getBakiye());
        }catch (YetersizBakiyeException e){
            System.err.println("işlem başarısız:"+e.getMessage());
        }
    }
    public void bakiyeyeGoreListele(){
        List<Hesap> hesapListesi = new ArrayList<>(hesaplar.values());
        Collections.sort(hesapListesi);
        System.out.println("\n =======Bakiyeye göre sıalı hesaplar======");
        for (Hesap h:hesapListesi){
            System.out.println(h.raporOlustur());
        }
    }

    private void islemLogla(String mesaj){
        try {
            if (!Files.exists(logYolu)){
                Files.createFile(logYolu);
            }

            String logSatiri= new Date()+"-"+mesaj+"\n";

            Files.writeString(logYolu,logSatiri,StandardOpenOption.APPEND);// append sayesinde eski işlem korunur yeni işelmler üstüne eklenşr.
        }catch (IOException e){
            System.err.println("log yazılırken hata oluştu "+e.getMessage());
        }

    }

    public void hesapDetayGoster(String hesapNo){
        Hesap arananHesap = hesaplar.get(hesapNo);
        if (arananHesap== null){
            System.out.println("Hata : "+hesapNo+"  numaralı hesap bulunamadı!");
            return;
        }
        System.out.println("\n ------Hesap Detayı----------");
        System.out.println(arananHesap.raporOlustur());
        islemLogla("Hesap detayı görüntülendi "+hesapNo);

    }


}
