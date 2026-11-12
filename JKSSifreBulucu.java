import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Scanner;

public class JksSifreBulucu {
    public static void main(String[] args) {
        String keystoreYolu = "dosyaniz.jks"; // Buraya JKS dosyanızın adını yazın
        String kelimeListesi = "kelimeler.txt"; // Şifre tahminlerinizin olduğu dosya

        try (Scanner scanner = new Scanner(new File(kelimeListesi))) {
            System.out.println("Şifreler deneniyor, lütfen bekleyin...");
            while (scanner.hasNextLine()) {
                String denenenSifre = scanner.nextLine().trim();
                if (denenenSifre.isEmpty()) continue;
                
                try (FileInputStream fis = new FileInputStream(keystoreYolu)) {
                    KeyStore ks = KeyStore.getInstance("JKS");
                    ks.load(fis, denenenSifre.toCharArray());
                    
                    // Eğer üstteki satır hata vermezse şifre doğrudur
                    System.out.println("\nBAŞARILI! ŞİFRE BULUNDU: " + denenenSifre);
                    return;
                } catch (Exception e) {
                    // Şifre yanlışsa sessizce bir sonraki kelimeye geç
                }
            }
            System.out.println("Maalesef şifre bu listede bulunamadı.");
        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }
}