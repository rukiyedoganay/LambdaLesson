import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {


        List<String> menu = new ArrayList<>(Arrays.asList("trileçe", "havucDilim", "güvec", "kokorec",
                "küşleme", "arabAşı", "waffle", "künefe"));

        alfabetikBuyukTekrarsiz(menu);
        System.out.println("\n************");
        charSayisiTersSiraliUnique(menu);
        System.out.println("\n************");
        charSayisiBuyukSirali(menu);
        System.out.println("\n************");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n************");
        wIleBaslayanElKontrol(menu);
        System.out.println("\n************");
        xIleBitenElKontrol(menu);
        System.out.println("\n************");
        enUzunEleman(menu);
        System.out.println("\n************");
        ilkElHaricSonHarfSiraliPrint(menu);

    }

    //Task-1: List elemanlarini alfabetik buyuk harf ve  tekrarsiz print ediniz.

    public static void alfabetikBuyukTekrarsiz(List<String> yemek) {

        yemek.
                stream().                   //akış başladı.
                map(String::toUpperCase).   //Buyuk harf task'i gerçekleşti
                sorted().                   //Alfabetik-natural order yapıldı.
                distinct().                 //elemanların tekrarsız olmasını sağladı
                forEach(t -> System.out.print(t + " "));    //print

    }

    //Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz.

    public static void charSayisiTersSiraliUnique(List<String> ikram) {

        ikram.
                stream().                   //akış alındı.
                map(String::length).        //akış güncellendi: kelimelerin uzunluğu olarak güncellendi.
                sorted(Comparator.reverseOrder()). //ters bir şekilde sıralandı.
                distinct().                 //tekrarsız-unique
                forEach(Lambda01::yazdir);  //print

    }

    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..

    public static void charSayisiBuyukSirali(List<String> ikram) {
        ikram.
                stream().       //akış alındı.
                sorted(Comparator.comparing(String::length)). //String ifadeleri karakter sayısına göre k=>b sıralandı
                forEach(Lambda01::yazdir);
    }

    // ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elemanlarının hepsinin karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz

    public static void harfSayisi7denAzKontrol(List<String> ikram) {
        System.out.println(ikram.
                stream().
                allMatch(t -> t.length() <= 7) ? "List elemanları 7 ve daha az harften oluşuyor" :
                "List elemanları 7 harften büyük");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void wIleBaslayanElKontrol(List<String> ikram) {
        System.out.println(ikram.stream().noneMatch(t -> t.startsWith("w")) ? "w ile yemek mi olur " :
                "w ile yemek icat ettik");

    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

    public static void xIleBitenElKontrol(List<String> ikram) {
        System.out.println(ikram.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "maşallah" : "x ile biten yemek olur mu hiç? ");

    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void enUzunEleman(List<String> ikram) {

        Stream<String> sonIsim = ikram.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).reversed()).
                limit(1);
        // limit() metodunun dönen değeri Stream<String> yapıdadır

        System.out.println(Arrays.toString(sonIsim.toArray()));
// sonIsim.toArray() --> Stream olan akış Artray e çevrildi
        // Arrays.toString(sonIsim.toArray()) --> Arrayı string yapıya çeviriyor.
    }


// Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilkElHaricSonHarfSiraliPrint (List<String> ikram){
        ikram.
                stream().//akış sağlandı
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))). //son harfine göre alfabetik sıralandı
                skip(1). //akıştaki ilk eleman hariç tutuldu
                forEach(Lambda01::yazdir);

    }
}
