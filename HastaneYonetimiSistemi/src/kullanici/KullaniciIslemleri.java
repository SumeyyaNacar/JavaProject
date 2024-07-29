package kullanici;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import randevu.RandevuIslemleri;
import ilac.IlacIslemleri;
import bildirim.BildirimIslemleri;

public class KullaniciIslemleri {
    private List<Kullanici> kullanicilar;
    private int doktorIdSayac;
    private int hastaIdSayac;
    private RandevuIslemleri randevuIslemleri;
    private IlacIslemleri ilacIslemleri;
    private BildirimIslemleri bildirimIslemleri;

    public KullaniciIslemleri() {
        kullanicilar = new ArrayList<>();
        doktorIdSayac = 900;
        hastaIdSayac = 100;
        randevuIslemleri = new RandevuIslemleri(this);
        ilacIslemleri = new IlacIslemleri();
        bildirimIslemleri = new BildirimIslemleri();
    }

    public int kullaniciEkle(Kullanici kullanici) {
        if (kullanici instanceof Doktor) {
            //"Doktor".equals(doktor.getRol()) veya (doktor.getRol().equals("Doktor"))

            //instanceof kelimesi gelen obje o sınıfa ait mi diye bakar.
            // Bunun yerine yukarıda olduğu gibi direk role de bakılabilirdi...


            kullanici.setId(doktorIdSayac++);
        } else if (kullanici instanceof Hasta) {
            kullanici.setId(hastaIdSayac++);
        }
        kullanicilar.add(kullanici);
        return kullanici.getId();
    }

    public void kullanicilariListele() {
        System.out.println("\n**** Kullanıcılar ****");
        for (Kullanici kullanici : kullanicilar) {
            System.out.println("ID: " + kullanici.getId() + ", Adı: " + kullanici.getKullaniciAdi() + ", Rol: " + kullanici.getRol());
        }
    }

    public void kullaniciGuncelle(int id) {
        Scanner scanner = new Scanner(System.in);
        Kullanici kullanici = kullaniciBul(id);

        if (kullanici != null) {
            System.out.print("Yeni Şifre: ");
            String yeniSifre = scanner.nextLine();
            kullanici.setSifre(yeniSifre);
            System.out.println("Kullanıcı şifresi güncellendi.");
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }
    }

    public void kullaniciSil(int id) {
        Kullanici kullanici = kullaniciBul(id);

        if (kullanici != null) {
            kullanicilar.remove(kullanici);
            System.out.println("Kullanıcı silindi.");
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }
    }

    public Kullanici kullaniciBul(int id) {
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici.getId() == id) {
                return kullanici;
            }
        }
        return null;
    }

    public List<Doktor> doktorlariListele() {
        List<Doktor> doktorlar = new ArrayList<>();
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici instanceof Doktor) {
                doktorlar.add((Doktor) kullanici);
            }
        }
        return doktorlar;
    }

    public List<Hasta> hastalariListele() {
        List<Hasta> hastalar = new ArrayList<>();
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici instanceof Hasta) {
                hastalar.add((Hasta) kullanici);
            }
        }
        return hastalar;
    }

    public Kullanici girisYap(String kullaniciAdi, String sifre) {
        for (Kullanici kullanici : kullanicilar) {
            if (kullanici.getKullaniciAdi().equals(kullaniciAdi) && kullanici.getSifre().equals(sifre)) {
                return kullanici;
            }
        }
        return null;
    }

    public void kullaniciGirisi() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Kullanıcı Adı: ");
            String kullaniciAdi = scanner.nextLine();
            System.out.print("Şifre: ");
            String sifre = scanner.nextLine();

            Kullanici kullanici = girisYap(kullaniciAdi, sifre);
            if (kullanici != null) {
                System.out.println("Hoşgeldiniz, " + kullanici.getKullaniciAdi() + "!");
                kullanici.menu();
            } else {
                System.out.println("Geçersiz kullanıcı adı veya şifre.");
            }
        }
    }

    public RandevuIslemleri getRandevuIslemleri() {
        return randevuIslemleri;
    }

    public IlacIslemleri getIlacIslemleri() {
        return ilacIslemleri;
    }

    public BildirimIslemleri getBildirimIslemleri() {
        return bildirimIslemleri;
    }
}
