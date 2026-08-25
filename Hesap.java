package accountmanagementsystem;

public abstract class Hesap implements Raporlanabilir, Comparable<Hesap> {
    private String hesapNo;
    private String musteriAdi;
    protected double bakiye;

    public Hesap(String hesapNo, String musteriAdi, double bakiye) {
        this.hesapNo = hesapNo;
        this.musteriAdi = musteriAdi;
        this.bakiye = bakiye;
    }

    public abstract void paraCek(double miktar);

    public void paraYatir(double miktar) {
        this.bakiye += miktar;
    }

    @Override
    public int compareTo(Hesap diger) {
        return Double.compare(this.bakiye, diger.bakiye);
    }

    public String getHesapNo() {
        return hesapNo;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public double getBakiye() {
        return bakiye;
    }
}