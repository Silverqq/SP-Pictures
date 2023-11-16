import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {
        String PictUrl = "https://vsegda-pomnim.com/uploads/posts/2022-03/1647671075_14-vsegda-pomnim-com-p-gora-zakan-foto-22.jpg";
        String fileName = "Mountains.png";
        String savePath = "C:\\Users\\Shor\\Documents\\Pictures\\" + fileName;
        downloadPicture(PictUrl, savePath);
    }

    private static void downloadPicture(String pictureFileUrl, String savePath) throws IOException {
        URL url = new URL(pictureFileUrl);
        URLConnection connection = url.openConnection();
        try (InputStream in = new BufferedInputStream(connection.getInputStream());
             FileOutputStream out = new FileOutputStream(savePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}