package kullanici;

import java.util.ArrayList; // ArrayList sınıfını içe aktarma
import java.util.List; // List arayüzünü içe aktarma
import java.util.Scanner; // Kullanıcıdan veri almak için Scanner sınıfını içe aktarma

// KullaniciIslemleri sınıfı, kullanıcıların yönetimi ile ilgili işlemleri gerçekleştirir.
public class KullaniciIslemleri {
    // List bir Collection türüdür ve bir arayüzdür. List'ler, sıralı bir koleksiyon sağlar ve
    // elemanlara indekslerle erişim sağlar. List arayüzünün çeşitli gerçekleştirimleri vardır,
    // en yaygın olanları ArrayList ve LinkedList'tir.

    private List<Kullanici> kullanicilar; // Sistemdeki tüm kullanıcıların listesi
    private int doktorIdSayac; // Doktor ID sayaç, doktor idleri 100 den başlasın
    private int hastaIdSayac; // Hasta ID sayaç, hasta idleri 900 den başlasın mesela...

    // KullaniciIslemleri sınıfının kurucusu
    // Kurucu metod, sınıfın değişkenlerini başlatır.
    public KullaniciIslemleri() {
        // ArrayList, List arayüzünü gerçekleştiren bir sınıftır.
        // ArrayList, dinamik olarak boyutlanabilen bir dizi sağlar.
        // Veri ekledikçe veya çıkardıkça boyutu otomatik olarak ayarlanır.
        kullanicilar = new ArrayList<>(); // Kullanıcı listesini başlatma
        doktorIdSayac = 900; // Doktor ID sayacını başlatma
        hastaIdSayac = 100; // Hasta ID sayacını başlatma

        //Dikkat bu bir kurucu metot kullanıcı listesini burada başlatıyoruz ki her seferinde bir nesne ile bunu yapmayalım.
        // Bu class çağrıldığında, tetiklendiğinde, ilk çalıcak yer burası
    }

    // Yeni bir kullanıcı ekleme işlemi
    // Bu metod, yeni bir kullanıcı oluşturur ve kullanıcı listesine ekler.
    // Kullanıcının rolüne göre (Doktor veya Hasta) ID atar.
    public int kullaniciEkle(Kullanici kullanici ) {
        // Bu metot bir parametre alıyor ancak bu parametre bir veri tipi değil.
        // String isim yazsaydık bizden bir isim girmemizi isterdi....
        // Ancak biz Kullanici kullanici (String isim1 ile aynı mantık) yazdık.
        // String bir classtır, bu clastan bir değişken türettiğimizde (isim1) artık o değişken o clasta izin verilen özelliklere, metorlara erişir.
        // isim1. yaptığımda bazı metotlar gelir.


        // Burada Kullanici kullanici yazdığımızda bu metot parametre istemez yani bana bir şey ver demez.
        // Java bunun "Kullanici" clasında erişilmek üzere oluşturulan bir nesne olduğunu anlar.
        // kullanici, Kullanici clası türünde olduğu için artık kullanici. yaptığımda metotlar gelir.
        // Bu metoda parametre olarak bunu verdiğimde metodun içinde bu nesne ile  o clastaki metotları kullanırım.

        // Bunu yapmasaydım metot içerisinde Kullanici kullanici=New Kullanici().... diye obje yaratmam gerekirdi, her seferinde bunu yapmak yerine bu daha iyi bir kullanımdır.



        try {
            // instanceof operatörü, bir nesnenin belirli bir sınıfa ait olup olmadığını kontrol eder.
            // Bu bir ek bilgidir bu equals ile aynı işlemi yapar equals ile de yapabiliriz.
            // İki kullanımında örneği vardır.
            // Bu operatör, polymorphism  kavramıyla birlikte kullanılır.
            // Bunu bir ifadeden ziyade bir yetenek gibi düşünelim. Bu yeteneğe sahip olan bir nesne (polymorphism)   birden fazla formda olabilir, kod kısmında daha iyi anlaşılacaktır.

            // Bu durumda, kullanıcının Doktor veya Hasta olup olmadığını kontrol ederiz.

            //Kullanıcı eklenirken id ataması yapmalıyız;

            if (kullanici instanceof Doktor) { // Eğer kullanıcı Doktor ise

                // kullanici.getClass().equals(Doktor.class) // Aynı işlemi yapar....


                kullanici.setId(doktorIdSayac++); // Doktor ID sayacını kullanarak ID atar ve sayaç değerini artırır
                //Yukarda başlangıç değerini vermiştik...
            } else if (kullanici instanceof Hasta) { // Eğer kullanıcı Hasta ise
                kullanici.setId(hastaIdSayac++); // Hasta ID sayacını kullanarak ID atar ve sayaç değerini artırır.
            }
            kullanicilar.add(kullanici); // Kullanıcıyı listeye ekler.
            return kullanici.getId(); // Kullanıcının ID'sini döndürür.
        } catch (Exception e) {
            System.err.println("Kullanıcı eklenirken bir hata oluştu: " + e.getMessage());
            throw e; // Hata durumunda istisna fırlatılır.
        }
    }

    // Tüm kullanıcıları listeleme işlemi
    // Bu metod, sistemdeki tüm kullanıcıları listeler ve her bir kullanıcının ID, adı ve rolü gibi bilgilerini ekrana yazdırır.
    public void kullanicilariListele() {
        for (Kullanici kullanici : kullanicilar) {
            System.out.println("ID: " + kullanici.getId() + ", Adı: " + kullanici.getKullaniciAdi() + ", Rol: " + kullanici.getRol());
        }

        // AŞAĞIDA BU KODUN LAMBDA HALİ VARDIR. Bu tür ifadeleri lambda ile de yazacağız ki pekişşin bilgilerimiz.
        //kullanicilar.forEach(kullanici -> System.out.println("ID: " + kullanici.getId() +
        // ", Adı: " + kullanici.getKullaniciAdi() + ", Rol: " + kullanici.getRol()));
    }

    // Kullanıcı güncelleme işlemi
    // Bu metod, belirli bir kullanıcının şifresini günceller.
    public void kullaniciGuncelle(int id) {
        // Bu metot parametre alır yani bura güncellenecek kullanıcı id'si girecek.
        // Burada kullanıcı güncelle metodu çağırılacaktır.
        // O metod ID'ye göre kullanıcıyı bulur.

        // Ancak biz ek olarak, "kullanici != null" ifadesini kullanacağız,
        // Metoda verdiğimiz id sonucunda kullanıcı bulunamayabilir, belki de o kullanıcı yok.
        // Bu nedenle biz ekstra içi dolu mu geldi boş mu geldi kontrol etmelitiz.
        // Bu ifade kullanıcı nesnesinin null olup olmadığını kontrol eder.
        // Bunu neden yapıyoruz= Null kontrolü, NullPointerException hatalarını önlemek için önemlidir.
        // Eğer kullanici null ise, bu kullanıcı ID'ye sahip bir kullanıcı bulunamadığını gösterir.
        // Eğer değilse işlemi yapar

        // İşte bir örnek
        //  if (kullanici != null) {
        //     Burada işlemi yapan kod olacak.
        //     }
        //  } else {
        System.out.println("Kullanıcı bulunamadı.");
        //  }


    }

    // Kullanıcı silme işlemi
    // Bu metod, belirli bir kullanıcıyı sistemden siler.
    public void kullaniciSil(int id) {
        // Bu metot parametre alır yani bura güncellenecek kullanıcı id'si girecek.
        // Kullanıcı silme ve güncelleme işlemleri benzerdir. Yine kullanıcı var mı yokmu diye bakacağız, null gelmiyorsa işlem yapacağız.
    }

    // Kullanıcıyı ID'ye göre bulma işlemi
    // Bu metod, belirli bir ID'ye sahip kullanıcıyı bulur ve döndürür.
    public Kullanici kullaniciBul(int id) {
        // Metotda parametre olarak girilen id taranacak ve bulunacak burada yine null kontrolu yapılacak....
        return null; // İle kullanıcı bulunamazsa null döndereceğiz ve ek olarak null ise kullanıcı bulunamadı mesajı göstereceğiz..
    }

    // Doktorları listeleme işlemi
    // Bu metod, sistemdeki tüm doktorları listeler ve döndürecektir.
    public List<Doktor> doktorlariListele() {
        // Bu metot içerisinde kullanıcılar  listesini başlatacağız
        // Sonra kullanıcılar listesinde döneceğiz ve kullanıcı doktor ise burada doktor listesine eklenecek..
        // Örnek
        List<Doktor> doktorlar = new ArrayList<>();

        // Doktorlar listesini döndürürmediğimiz için şuan hata görüyorsunuz..
        return  doktorlar;
    }

    // Hastaları listeleme işlemi
    // Bu metod, sistemdeki tüm hastaları listeler ve döndürür.
    public List<Hasta> hastalariListele() {
        // Yukarıdaki ile aynı mantıktadır...
        //Örnek..
        List<Hasta> hastalar = new ArrayList<>(); // Hasta listesini başlatır.
        // Yine burada kullanıcı hasta ise hastalar listesine atacağız....

        return hastalar; // Hastalar listesini döndürür.
    }

    // Kullanıcı giriş yapma işlemi
    // Bu metod, kullanıcı adı ve şifreyi kontrol eder ve doğru ise kullanıcıyı döndürür.
    public Kullanici girisYap(String kullaniciAdi, String sifre) {

        // Metot iki parametre alıyor, bunlar dışarıdan ana ekranda girilen kullanıcı ve şifre olacak.

        // Biz bu gelenler, liste içinde var mı kontrol edeceğiz ve ona göre giriş yapacak.

        // İşte bir örnek.

        // for (Kullanici kullanici : kullanicilar) {
        //     if (kullanici.getKullaniciAdi().equals(kullaniciAdi) && kullanici.getSifre().equals(sifre)) {
        //        return kullanici; // Kullanıcı adı ve şifre doğru ise kullanıcıyı döndürür.
        //     }
        //  }


        return null; // Kullanıcı adı veya şifre yanlış ise null döndürür.
    }
}