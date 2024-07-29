package randevu;

import kullanici.Doktor;
import kullanici.Kullanici;
import kullanici.KullaniciIslemleri;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RandevuIslemleri {
    private List<Randevu> randevular; // Randevuları saklayan liste
    private int randevuIdSayac; // Randevu ID'lerini otomatik artırmak için sayaç
    private KullaniciIslemleri kullaniciIslemleri; // Kullanıcı işlemlerini yönetmek için referans

    // RandevuIslemleri constructor metodu
    public RandevuIslemleri(KullaniciIslemleri kullaniciIslemleri) {
        this.kullaniciIslemleri = kullaniciIslemleri;
        randevular = new ArrayList<>(); // Randevuları saklayacak listeyi başlatma
        randevuIdSayac = 1; // Randevu ID sayaç başlangıcı
    }

    // Doktorları listeleyen metod
    public List<Doktor> doktorlariListele() {
        return kullaniciIslemleri.doktorlariListele(); // Kullanıcı işlemleri aracılığıyla doktor listesini döndürme
    }

    // Yeni randevu oluşturma metodu
    public void yeniRandevuOlusturma(int hastaId) {
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan giriş almak için Scanner nesnesi

        try {
            List<Doktor> doktorlar = doktorlariListele(); // Doktorları listeleme
            System.out.println("\n**** Doktorlar ve Branşları ****");
            for (Doktor doktor : doktorlar) {
                System.out.println("ID: " + doktor.getId() + ", Adı: " + doktor.getKullaniciAdi() + ", Branş: " + doktor.getBrans());
            }

            System.out.print("Doktor ID: ");
            int doktorId = scanner.nextInt(); // Kullanıcıdan doktor ID'si alma
            scanner.nextLine(); // Satır sonu karakterini temizleme

            // Seçilen doktoru bulma
            Doktor secilenDoktor = null;
            for (Doktor doktor : doktorlar) {
                if (doktor.getId() == doktorId) {
                    secilenDoktor = doktor;
                    break;
                }
            }

            // Lambda ile seçilen doktoru bulma alternatifi
            // Doktor secilenDoktor = doktorlar.stream()
            //        .filter(doktor -> doktor.getId() == doktorId)
            //        .findFirst()
            //        .orElse(null);


            //doktorlar.stream() doktorlar listesi üzerinde bir Stream (akış) başlatır.
            //Stream, veri üzerinde bir dizi işlem yapmamıza olanak tanıyan bir veri akışıdır.

            //.filter(doktor -> doktor.getId() == doktorId)
//            filter metodu, Stream üzerinde belirli bir kriteri karşılayan öğeleri seçmek için kullanılır.
//                    Bu örnekte, doktor nesnesinin getId() metodu ile döndürülen ID'sinin, doktorId değişkenine eşit olup olmadığını kontrol eden bir lambda ifadesi kullanıyoruz.
//            doktor -> doktor.getId() == doktorId lambda ifadesi, her bir doktor nesnesi için doktor.getId() == doktorId ifadesini değerlendirir.
//            Sadece bu koşulu sağlayan öğeler Stream'de kalır, diğerleri elenir.

            //.findFirst()
//            findFirst metodu, Stream'deki ilk öğeyi bulur ve döner.
//            Eğer Stream boş değilse, ilk öğeyi içeren bir Optional nesnesi döner.

            //orElse (Alternatif Değer):
            //orElse metodu, Optional nesnesinden değeri döner.
            //Eğer Optional bir değer içeriyorsa, bu değer döner. Eğer boşsa, orElse metodu parametre olarak verilen değeri döner.

            //Bu kod parçası, doktorlar listesindeki doktorların ID'lerini kontrol ederek, doktorId ile eşleşen ilk doktoru bulur.
            // Eğer böyle bir doktor varsa, secilenDoktor değişkenine atanır. Eğer böyle bir doktor bulunamazsa, secilenDoktor null olarak atanır.

//
            if (secilenDoktor == null) {
                System.out.println("Geçersiz Doktor ID!");
                return;
            }

            System.out.println("\n**** Uygun Saatler ****");
            List<String> uygunSaatler = getUygunSaatler(secilenDoktor); // Uygun saatleri listeleme
            for (String saat : uygunSaatler) {
                System.out.println(saat);
            }

            System.out.print("Saat (ss:dd): ");
            String saat = scanner.nextLine(); // Kullanıcıdan saat alma

            if (!uygunSaatler.contains(saat)) {
                System.out.println("Seçtiğiniz saat uygun değil.");
                return;
            }

            System.out.print("Tarih (gg/aa/yyyy): ");
            String tarih = scanner.nextLine(); // Kullanıcıdan tarih alma

            if (!isValidDate(tarih)) { // Geçerli tarih kontrolü
                System.out.println("Geçmişe yönelik randevu alınamaz.");
                return;
            }

            System.out.print("Randevuyu alan kişinin adı: ");
            String randevuyuAlanAdi = scanner.nextLine(); // Kullanıcıdan adı alma

            System.out.print("Randevuyu alan kişinin soyadı: ");
            String randevuyuAlanSoyadi = scanner.nextLine(); // Kullanıcıdan soyadı alma

            // Yeni randevu oluşturma
            Randevu yeniRandevu = new Randevu(randevuIdSayac++, hastaId, doktorId, secilenDoktor.getBrans(), tarih, saat, randevuyuAlanAdi, randevuyuAlanSoyadi);
            randevular.add(yeniRandevu); // Yeni randevuyu listeye ekleme

            System.out.println("Randevu başarıyla eklendi.");
        } catch (Exception e) {
            System.out.println("Randevu oluşturulurken bir hata oluştu: " + e.getMessage());
        }
    }

    // Tarih geçerliliğini kontrol eden metod
    private boolean isValidDate(String tarih) {

        // SimpleDateFormat sınıfı, belirli bir formattaki tarihleri parse etmek ve formatlamak için kullanılır.


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Tarih formatını belirleme
        // Burada, "dd/MM/yyyy" formatında bir tarih parse edeceğimizi belirtiyoruz.

        try {
            // Kullanıcıdan alınan tarih string'ini, belirttiğimiz formatta bir Date nesnesine dönüştürüyoruz.
            Date randevuTarihi = sdf.parse(tarih); // String tarih değerini Date nesnesine dönüştürme

            // `new Date()` ifadesi, şu anki tarih ve saat bilgilerini içeren bir Date nesnesi oluşturur.


            Date bugun = new Date(); // Bugünün tarihini alma
            // Yani `bugun` değişkeni, şu anki anı temsil eder.

            return !randevuTarihi.before(bugun); // Randevu tarihinin bugünden önce olup olmadığını kontrol etme
            // `randevuTarihi.before(bugun)` ifadesi, `randevuTarihi`nin `bugun`dan önce olup olmadığını kontrol eder.
            // Eğer `randevuTarihi`, `bugun`dan önceyse bu ifade `true` döner.
            // `before` metodu, bir tarih diğerinden önceyse true, değilse false döner.

            // `!randevuTarihi.before(bugun)` ifadesi ile bu kontrolün tersini yapıyoruz.
            // Yani `randevuTarihi`nin `bugun`dan önce olmadığı (eşit veya sonra olduğu) durumlarda `true` döner.
            // Bu, randevu tarihinin geçerli olup olmadığını kontrol etmemizi sağlar.
            // Geçmiş tarihlerde randevu alınmasını engellemek için bu kontrol yapılır.

        } catch (ParseException e) {
            System.out.println("Geçersiz tarih formatı."); // Hatalı tarih formatı mesajı
            return false;
        }
    }

    // Uygun saatleri getiren metod
    private List<String> getUygunSaatler(Doktor doktor) {
        List<String> uygunSaatler = new ArrayList<>(); // Uygun saatleri saklamak için liste
        for (int i = 9; i < 18; i++) {
            uygunSaatler.add(i + ":00"); // Sabah 9'dan akşam 6'ya kadar saatleri ekleme
        }
        for (Randevu randevu : randevular) {
            if (randevu.getDoktorId() == doktor.getId()) {
                uygunSaatler.remove(randevu.getSaat()); // Doktorun daha önce alınmış saatlerini listeden çıkarma
            }
        }
        return uygunSaatler;

        // Lambda ile alternatif uygun saatler bulma yöntemi
        // randevular.stream()
        //         .filter(randevu -> randevu.getDoktorId() == doktor.getId())
        //         .forEach(randevu -> uygunSaatler.remove(randevu.getSaat()));
        // return uygunSaatler;
    }

    // Tüm randevuları listeleyen metod
    public void randevulariListele() {
        try {
            if (randevular.isEmpty()) {
                System.out.println("Randevu bulunamadı.");
                return;
            }

            for (Randevu randevu : randevular) {
                System.out.println("Randevu ID: " + randevu.getId() + ", Hasta ID: " + randevu.getHastaId() + ", Doktor ID: "
                        + randevu.getDoktorId() + ", Tarih: " + randevu.getTarih() + ", Saat: " + randevu.getSaat());
            }
        } catch (Exception e) {
            System.out.println("Randevular listelenirken bir hata oluştu: " + e.getMessage());
        }
    }

    // Belirli bir kullanıcının randevularını listeleyen metod
    public void randevulariListele(int kullaniciId) {
        try {
            boolean randevuBulundu = false;
            for (Randevu randevu : randevular) {
                if (randevu.getHastaId() == kullaniciId) {
                    System.out.println("Randevu ID: " + randevu.getId() + ", Hasta ID: " + randevu.getHastaId() + ", Doktor ID: " + randevu.getDoktorId() + ", Tarih: " + randevu.getTarih() + ", Saat: " + randevu.getSaat());
                    randevuBulundu = true;
                }
            }

            // Lambda ile alternatif randevu bulma yöntemi
            // boolean randevuBulundu = randevular.stream()
            //        .filter(randevu -> randevu.getHastaId() == kullaniciId)
            //        .peek(randevu -> System.out.println("Randevu ID: " + randevu.getId() + ", Hasta ID: " + randevu.getHastaId() + ", Doktor ID: " + randevu.getDoktorId() + ", Tarih: " + randevu.getTarih() + ", Saat: " + randevu.getSaat()))
            //        .count() > 0;

            if (!randevuBulundu) {
                System.out.println("Randevu bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Randevular listelenirken bir hata oluştu: " + e.getMessage());
        }
    }

    // Belirli bir randevunun detaylarını gösteren metod
    public void randevuDetaylari(int randevuId) {
        try {
            Randevu randevu = randevuBul(randevuId); // Randevuyu ID ile bulma
            if (randevu != null) {
                System.out.println("Randevu Detayları:");
                System.out.println("Randevu ID: " + randevu.getId());
                System.out.println("Hasta ID: " + randevu.getHastaId());
                System.out.println("Doktor ID: " + randevu.getDoktorId());
                System.out.println("Doktor Branş: " + randevu.getBrans());
                System.out.println("Tarih: " + randevu.getTarih());
                System.out.println("Saat: " + randevu.getSaat());
                System.out.println("Randevuyu Alan: " + randevu.getRandevuyuAlanAdi() + " " + randevu.getRandevuyuAlanSoyadi());
            } else {
                System.out.println("Randevu bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Randevu detayları görüntülenirken bir hata oluştu: " + e.getMessage());
        }
    }

    // Belirli bir randevuyu güncelleyen metod
    public void randevuGuncelle(int randevuId) {
        try {
            Randevu randevu = randevuBul(randevuId); // Randevuyu ID ile bulma
            if (randevu != null) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Yeni Tarih (gg/aa/yyyy): ");
                String yeniTarih = scanner.nextLine(); // Kullanıcıdan yeni tarih alma

                if (!isValidDate(yeniTarih)) { // Geçerli tarih kontrolü
                    System.out.println("Geçmişe yönelik randevu alınamaz.");
                    return;
                }

                System.out.print("Yeni Saat (ss:dd): ");
                String yeniSaat = scanner.nextLine(); // Kullanıcıdan yeni saat alma

                Kullanici kullanici = kullaniciIslemleri.kullaniciBul(randevu.getDoktorId()); // Doktoru bulma
                if (kullanici instanceof Doktor) {
                    Doktor doktor = (Doktor) kullanici;
                    if (!getUygunSaatler(doktor).contains(yeniSaat)) { // Uygun saat kontrolü
                        System.out.println("Seçtiğiniz saat uygun değil.");
                        return;
                    }
                } else {
                    System.out.println("Geçersiz doktor ID.");
                    return;
                }

                randevu.setTarih(yeniTarih); // Randevunun tarihini güncelleme
                randevu.setSaat(yeniSaat); // Randevunun saatini güncelleme

                System.out.println("Randevu başarıyla güncellendi.");
            } else {
                System.out.println("Randevu bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Randevu güncellenirken bir hata oluştu: " + e.getMessage());
        }
    }

    // Belirli bir randevuyu silen metod
    public void randevuSil(int randevuId) {
        try {
            Randevu randevu = randevuBul(randevuId); // Randevuyu ID ile bulma
            if (randevu != null) {
                randevular.remove(randevu); // Randevuyu listeden silme
                System.out.println("Randevu başarıyla silindi.");
            } else {
                System.out.println("Randevu bulunamadı.");
            }
        } catch (Exception e) {
            System.out.println("Randevu silinirken bir hata oluştu: " + e.getMessage());
        }
    }

    // Randevu ID ile randevuyu bulma metodu
    private Randevu randevuBul(int randevuId) {
        for (Randevu randevu : randevular) {
            if (randevu.getId() == randevuId) {
                return randevu;
            }
        }

        // Lambda ile alternatif randevu bulma yöntemi
        // return randevular.stream()
        //         .filter(randevu -> randevu.getId() == randevuId)
        //         .findFirst()
        //         .orElse(null);
        return null;
    }
}
