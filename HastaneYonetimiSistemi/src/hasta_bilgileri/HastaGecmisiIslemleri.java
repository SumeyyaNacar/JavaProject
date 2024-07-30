package hasta_bilgileri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bu sınıf, hasta bilgilerini (öykü ve ilaç geçmişi) yönetmek için kullanılır.
 * Hastaların öykü ve ilaç geçmişlerini saklamak ve görüntülemek için çeşitli
 * yöntemler içerir.
 */
public class HastaGecmisiIslemleri {
    // HashMap, anahtar (hastaId) ve değer (String listesi) çiftlerini saklar.
    // Burada anahtar hastaId'dir ve bu anahtara karşılık gelen değer, hastanın öykülerinin bir listesidir.
    private Map<Integer, List<String>> oykuGecmisi;

    // Aynı şekilde, bu HashMap de anahtar (hastaId) ve değer (String listesi) çiftlerini saklar.
    // Bu sefer değer, hastanın ilaç geçmişlerinin bir listesidir.
    private Map<Integer, List<String>> ilacGecmisi;

    /**
     * Bu, sınıfın yapıcısıdır (constructor). Sınıfın bir örneği oluşturulduğunda
     * öykü ve ilaç geçmişleri için yeni HashMap nesneleri oluşturur.
     */
    public HastaGecmisiIslemleri() {
        // Hastaların öykü geçmişlerini saklamak için yeni bir HashMap oluşturulur.
        this.oykuGecmisi = new HashMap<>();

        // Hastaların ilaç geçmişlerini saklamak için yeni bir HashMap oluşturulur.
        this.ilacGecmisi = new HashMap<>();
    }

    /**
     * Bu yöntem, belirtilen hastaId ve öyküyü kullanarak hastanın öyküsünü ekler.
     */
    public void yeniOykuEkle(int hastaId, String oyku) {
        // Eğer oykuGecmisi map'inde hastaId anahtarı yoksa,
        if (!oykuGecmisi.containsKey(hastaId)) {
            // hastaId anahtarına karşılık gelen yeni bir ArrayList oluşturulur ve map'e eklenir.
            oykuGecmisi.put(hastaId, new ArrayList<>());
        }
        // hastaId anahtarına karşılık gelen listeye yeni öykü eklenir.
        oykuGecmisi.get(hastaId).add(oyku);
    }

    /**
     * Bu yöntem, belirtilen hastaId ve ilacı kullanarak hastanın ilaç geçmişine ilaç ekler.
     */
    public void yeniIlacEkle(int hastaId, String ilac) {
        // Eğer ilacGecmisi map'inde hastaId anahtarı yoksa,
        if (!ilacGecmisi.containsKey(hastaId)) {
            // hastaId anahtarına karşılık gelen yeni bir ArrayList oluşturulur ve map'e eklenir.
            ilacGecmisi.put(hastaId, new ArrayList<>());
        }
        // hastaId anahtarına karşılık gelen listeye yeni ilaç eklenir.
        ilacGecmisi.get(hastaId).add(ilac);
    }

    /**
     * Bu yöntem, belirtilen hastaId'ye ait tüm öyküleri görüntüler.
     */
    public List<String> hastaOykusunuGoruntule(int hastaId) {
        // Eğer oykuGecmisi map'inde hastaId anahtarı varsa,
        if (oykuGecmisi.containsKey(hastaId)) {
            // hastaId anahtarına karşılık gelen öyküler listesi döndürülür.
            return oykuGecmisi.get(hastaId);
        }
        // Aksi takdirde, boş bir liste döndürülür.
        return new ArrayList<>();
    }

    /**
     * Bu yöntem, belirtilen hastaId'ye ait tüm ilaç geçmişini görüntüler.
     */
    public List<String> hastaIlacGecmisiniGoruntule(int hastaId) {
        // Eğer ilacGecmisi map'inde hastaId anahtarı varsa,
        if (ilacGecmisi.containsKey(hastaId)) {
            // hastaId anahtarına karşılık gelen ilaçlar listesi döndürülür.
            return ilacGecmisi.get(hastaId);
        }
        // Aksi takdirde, boş bir liste döndürülür.
        return new ArrayList<>();
    }

    /**
     * Bu yöntem, belirtilen hastaId'ye ait tüm reçeteleri (ilaç geçmişini) görüntüler.
     */
    public List<String> hastaReceteleriniGoruntule(int hastaId) {
        // hastaIlacGecmisiniGoruntule yöntemini çağırarak hastanın ilaç geçmişi döndürülür.
        return hastaIlacGecmisiniGoruntule(hastaId);
    }
}
