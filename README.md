# JKS Şifre Bulucu

Bu Java programı, bir JKS anahtar deposunun **depo şifresini** verdiğiniz aday şifre listesinde arar. Listedeki şifreleri sırayla dener ve ilk eşleşmeyi ekrana yazar. Bu yöntem yalnızca elinizdeki aday listesinde bulunan şifreleri bulabilir; şifreyi kendiliğinden üretmez.

> Programı yalnızca size ait olan veya üzerinde deneme yapma izniniz bulunan JKS dosyalarında kullanın. JKS dosyası ve aday şifre listenizi paylaşmayın.

## Gerekenler

- Windows, macOS veya Linux bilgisayar
- Java geliştirme kiti (JDK). `javac` komutu JDK ile gelir; yalnızca Java çalışma ortamı (JRE) yeterli değildir.
- Denenecek JKS dosyası
- Her satırında bir şifre adayı bulunan metin dosyası
- Projeyi GitHub'dan klonlayacaksanız Git; ZIP ile indirecekseniz Git gerekmez

Java'nın kurulu olduğunu doğrulamak için Komut İstemi veya PowerShell'de şu komutları çalıştırın:

```text
java -version
javac -version
```

Her iki komut da sürüm bilgisi göstermelidir. Komut tanınmıyorsa JDK kurup `java` ve `javac` komutlarının PATH üzerinden erişilebilir olduğundan emin olun.

## GitHub'dan indirme

Git kuruluysa, GitHub sayfasındaki depo adresini kopyalayıp aşağıdaki komutta `<depo-adresi>` yerine koyun:

```text
git clone <depo-adresi>
cd <indirilen-depo-klasörü>
```

Bu klasörde `JksSifreBulucu.java` bulunmalıdır.

## JKS dosyasını ve şifre listesini hazırlama

1. JKS dosyanızı ve aday listenizi `JksSifreBulucu.java` ile aynı klasöre koyun. Bu örnekte dosya adları `dosyaniz.jks` ve `kelimeler.txt` olarak kullanılıyor.
2. `kelimeler.txt` dosyasını düz metin düzenleyicide açın. Her satıra bir olası şifre yazın:

   ```text
   ilk-sifre-tahmini
   ikinci-sifre-tahmini
   baska-bir-tahmin
   ```

3. Dosya adlarınız veya konumlarınız farklıysa `JksSifreBulucu.java` dosyasını açın ve baştaki şu iki satırı düzenleyin:

   ```java
   String keystoreYolu = "dosyaniz.jks";
   String kelimeListesi = "kelimeler.txt";
   ```

   Aynı klasördeki dosyalar için yalnızca dosya adını yazabilirsiniz. Başka bir konum kullanıyorsanız tam yolu yazın; Windows'ta örneğin `"C:/Belgeler/anahtar.jks"` biçimi kullanılabilir. Her satırdaki dosya adını ve yolu kendi dosyanızla eşleştirin.

## Derleme ve çalıştırma

Komut satırında `JksSifreBulucu.java` dosyasının bulunduğu klasördeyken:

1. Kaynak dosyayı derleyin:

   ```text
   javac -encoding UTF-8 JksSifreBulucu.java
   ```

   Başarılı derleme sonunda aynı klasörde `JksSifreBulucu.class` oluşur.

2. Programı çalıştırın:

   ```text
   java JksSifreBulucu
   ```

3. Program adayları sırayla dener. Eşleşme bulursa `BAŞARILI! ŞİFRE BULUNDU` mesajını ve ilk eşleşen adayı gösterir. Listedeki hiçbir aday doğru değilse şifrenin listede bulunamadığını bildirir.

## Sorun giderme

- **`javac` veya `java` tanınmıyor:** JDK kurulumunu ve PATH ayarını kontrol edin.
- **Şifre bulunamadı mesajı:** Aday listenizin doğru olduğundan ve satırlarda olası şifrenin bulunduğundan emin olun. Program her satırın başındaki ve sonundaki boşlukları siler.
- **Dosya adı/konumu hatası:** Kaynak dosyadaki `keystoreYolu` ve `kelimeListesi` değerlerini kontrol edin. Bu program, adayları denerken JKS dosyasını açma hatalarını da şifre hatası gibi sessizce geçer; yanlış JKS yolu bu nedenle “şifre bulunamadı” sonucuna yol açabilir.
- **Dosya biçimi:** Kod `JKS` türündeki anahtar depolarını açar; başka bir depo türüyle çalışması garanti değildir.

Program depo şifresini kontrol eder. Özel anahtar girişlerinin ayrıca belirlenmiş şifrelerini kontrol etmez.
