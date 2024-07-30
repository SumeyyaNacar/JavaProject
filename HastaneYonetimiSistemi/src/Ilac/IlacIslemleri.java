package ilac; // Bu sınıfın 'ilac' paketine ait olduğunu belirtir.

import java.util.ArrayList; // ArrayList sınıfını kullanmak için gerekli. Bu sınıf, dinamik olarak büyüyen bir dizi sağlar.
import java.util.List; // List arayüzünü kullanmak için gerekli. List arayüzü, bir dizi gibi davranan bir veri yapısını temsil eder.
import java.util.Scanner; // Kullanıcıdan giriş almak için Scanner sınıfını kullanmak için gerekli. Scanner sınıfı, konsoldan veya dosyalardan veri okumak için kullanılır.

public class IlacIslemleri { // Ilac işlemlerini gerçekleştiren sınıf.
    private List<Ilac> ilaclar; // İlaçları tutmak için bir liste. Bu liste, Ilac nesnelerini içerir.
    private int ilacIdSayac; // İlaç ID'leri için bir sayaç. Bu sayaç, her yeni ilaç eklendiğinde artırılır ve benzersiz ID'ler sağlar.

    public IlacIslemleri() {
        // Yapıcı (constructor) metot, sınıfın bir örneği oluşturulduğunda çalışır.
        // Yapıcı metot, sınıf adıyla aynı adı taşır ve dönüş tipi belirtilmez.
        // Bu metot, genellikle nesnenin başlangıç durumunu ayarlamak için kullanılır.
        ilaclar = new ArrayList<>(); // İlaçlar listesini başlatır. Bu liste, Ilac nesnelerini dinamik olarak depolayacaktır.
        ilacIdSayac = 1; // İlaç ID sayacını 1 olarak başlatır. Her yeni ilaç eklendiğinde bu sayaç artırılacaktır.
    }

    public void ilacEkle() {
        // Yeni ilaç eklemek için bir metot.
        // Bu metot, kullanıcıdan ilaç bilgilerini alır ve yeni bir Ilac nesnesi oluşturur.
        // Oluşturulan ilaç nesnesi, ilaclar listesine eklenir.
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan giriş almak için Scanner nesnesi oluşturur.

        int id = ilacIdSayac++; // İlaç ID'si için mevcut sayaç değerini kullanır ve ardından sayaç değerini artırır.

        System.out.print("İlaç Adı: "); // Kullanıcıdan ilaç adını girmesini ister.
        String isim = scanner.nextLine(); // Kullanıcının girdiği ilaç adını alır.

        System.out.print("İlaç Türü: "); // Kullanıcıdan ilaç türünü girmesini ister.
        String tur = scanner.nextLine(); // Kullanıcının girdiği ilaç türünü alır.

        System.out.print("Kullanım Talimatları: "); // Kullanıcıdan kullanım talimatlarını girmesini ister.
        String kullanimTalimatlari = scanner.nextLine(); // Kullanıcının girdiği kullanım talimatlarını alır.

        System.out.print("Stok Miktarı: "); // Kullanıcıdan stok miktarını girmesini ister.
        int stok = scanner.nextInt(); // Kullanıcının girdiği stok miktarını alır.
        scanner.nextLine(); // Tamponu temizlemek için. Bu, sonraki girişlerin doğru şekilde alınmasını sağlar.

        Ilac ilac = new Ilac(id, isim, tur, kullanimTalimatlari, stok); // Yeni bir Ilac nesnesi oluşturur. Parametreler: ID, isim, tür, kullanım talimatları, stok miktarı.
        ilaclar.add(ilac); // Yeni ilaç nesnesini ilaclar listesine ekler.

        System.out.println("İlaç başarıyla eklendi. İlaç ID: " + id); // Kullanıcıya ilaç ekleme işleminin başarılı olduğunu bildirir.
    }

    public void ilaclariListele() {
        // İlaçları listelemek için bir metot.
        // Bu metot, ilaclar listesindeki tüm ilaçları ekrana yazdırır.
        for (Ilac ilac : ilaclar) { // İlaçlar listesini döngüyle gezer.
            System.out.println("İlaç ID: " + ilac.getId() + ", İsim: " + ilac.getIsim() + ", Tür: " + ilac.getTur() + ", Kullanım Talimatları: " + ilac.getKullanimTalimatlari() + ", Stok: " + ilac.getStok()); // İlaç bilgilerini ekrana yazdırır.
        }
    }

    public void ilacGuncelle() {
        // İlaç bilgilerini güncellemek için bir metot.
        // Bu metot, kullanıcıdan güncellenecek ilaç ID'sini alır ve ilgili ilaç nesnesini bulur.
        // Eğer ilaç bulunursa, kullanıcıdan yeni ilaç bilgilerini alır ve ilgili alanları günceller.
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan giriş almak için Scanner nesnesi oluşturur.

        System.out.print("Güncellenecek İlaç ID: "); // Kullanıcıdan güncellenecek ilaç ID'sini girmesini ister.
        int id = scanner.nextInt(); // Kullanıcının girdiği ilaç ID'sini alır.
        scanner.nextLine(); // Tamponu temizlemek için.

        Ilac ilac = ilacBul(id); // Belirtilen ID'ye sahip ilaç nesnesini bulur.
        if (ilac != null) { // Eğer ilaç bulunduysa güncelleme işlemlerine başlar.
            System.out.print("Yeni İlaç Adı: "); // Kullanıcıdan yeni ilaç adını girmesini ister.
            String yeniIsim = scanner.nextLine(); // Kullanıcının girdiği yeni ilaç adını alır.
            System.out.print("Yeni İlaç Türü: "); // Kullanıcıdan yeni ilaç türünü girmesini ister.
            String yeniTur = scanner.nextLine(); // Kullanıcının girdiği yeni ilaç türünü alır.
            System.out.print("Yeni Kullanım Talimatları: "); // Kullanıcıdan yeni kullanım talimatlarını girmesini ister.
            String yeniKullanimTalimatlari = scanner.nextLine(); // Kullanıcının girdiği yeni kullanım talimatlarını alır.
            System.out.print("Yeni Stok Miktarı: "); // Kullanıcıdan yeni stok miktarını girmesini ister.
            int yeniStok = scanner.nextInt(); // Kullanıcının girdiği yeni stok miktarını alır.
            scanner.nextLine(); // Tamponu temizlemek için.

            ilac.setIsim(yeniIsim); // İlaç adını günceller.
            ilac.setTur(yeniTur); // İlaç türünü günceller.
            ilac.setKullanimTalimatlari(yeniKullanimTalimatlari); // Kullanım talimatlarını günceller.
            ilac.setStok(yeniStok); // Stok miktarını günceller.

            System.out.println("İlaç bilgileri güncellendi."); // Kullanıcıya ilaç bilgilerin güncellendiğini bildirir.
        } else { // Eğer ilaç bulunamadıysa kullanıcıya bildirir.
            System.out.println("İlaç bulunamadı.");
        }
    }

    public void ilacSil() {
        // İlaç silmek için bir metot.
        // Bu metot, kullanıcıdan silinecek ilaç ID'sini alır ve ilgili ilaç nesnesini bulur.
        // Eğer ilaç bulunursa, ilgili ilaç nesnesini ilaclar listesinden kaldırır.
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan giriş almak için Scanner nesnesi oluşturur.

        System.out.print("Silinecek İlaç ID: "); // Kullanıcıdan silinecek ilaç ID'sini girmesini ister.
        int id = scanner.nextInt(); // Kullanıcının girdiği ilaç ID'sini alır.
        scanner.nextLine(); // Tamponu temizlemek için.

        Ilac ilac = ilacBul(id); // Belirtilen ID'ye sahip ilaç nesnesini bulur.
        if (ilac != null) { // Eğer ilaç bulunduysa silme işlemini gerçekleştirir.
            ilaclar.remove(ilac); // İlaç nesnesini listeden kaldırır.
            System.out.println("İlaç başarıyla silindi."); // Kullanıcıya ilaç silme işleminin başarılı olduğunu bildirir.
        } else { // Eğer ilaç bulunamadıysa kullanıcıya bildirir.
            System.out.println("İlaç bulunamadı.");
        }
    }

    private Ilac ilacBul(int id) {
        // Belirli bir ID'ye sahip ilaç nesnesini bulmak için özel bir metot.
        // Bu metot, ilaclar listesini döngüyle gezer ve belirtilen ID'ye sahip ilaç nesnesini bulur.
        for (Ilac ilac : ilaclar) { // İlaçlar listesini döngüyle gezer.
            if (ilac.getId() == id) { // ID'yi kontrol eder ve eşleşen ilaç nesnesini döndürür.
                return ilac; // İlaç bulundu.
            }
        }
        return null; // İlaç bulunamadıysa null döner.
    }

    public List<Ilac> getIlaclar() {
        // İlaçlar listesini döndüren bir metot.
        return ilaclar; // İlaçlar listesini döner.
    }
}
