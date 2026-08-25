package accountmanagementsystem;

public class VadesizHesap extends Hesap {
    private double ekHesapLimiti = 1000.0;

    public VadesizHesap(String hesapNo, String musteriAdi, double bakiye) {
        super(hesapNo, musteriAdi, bakiye); // Üst sınıfın (Hesap) kurucusunu çağırıyoruz
    }

    @Override
    public void paraCek(double miktar) {
        // Bakiye + Ek Limit yetersizse kendi custom exception'ımızı fırlatıyoruz
        if (miktar > bakiye + ekHesapLimiti) {
            throw new YetersizBakiyeException(
                    getHesapNo() + " nolu hesapta ek limit dahil yetersiz bakiye! İstenen: " + miktar
            );
        }
        bakiye -= miktar;
    }

    @Override
    public String raporOlustur() {
        return "[Vadesiz Hesap] No: " + getHesapNo() +
                " | Müşteri: " + getMusteriAdi() +
                " | Bakiye: " + bakiye + " TL";
    }
}