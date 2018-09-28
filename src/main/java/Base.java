import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class Base {



    private static String encodeFileToBase64Binary(File file) {
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encode(bytes).toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encodedfile;
    };

    public static void main(String args[]) {
        File f = new File("C:\\Users\\anton\\Pictures\\Wallpaper\\wallhaven-117939.jpg");
        String encodstring = encodeFileToBase64Binary(f);
        System.out.println(encodstring);
        File g = new File("C:\\Users\\anton\\Pictures\\Wallpaper\\wallhaven-729.jpg");
        String encodstring2 = encodeFileToBase64Binary(f);
        System.out.println(encodstring2);
    }
}
