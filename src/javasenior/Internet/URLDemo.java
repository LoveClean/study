package javasenior.Internet;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL网络编程
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/17 20:40
 */
public class URLDemo {
    public static void main(String[] args) {
        HttpsURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL("http://yuanfudashi.com/");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());

            urlConnection = (HttpsURLConnection) url.openConnection();

            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            fileOutputStream = new FileOutputStream("urltest.hpf");

            byte[] buffer = new byte[1024];
            int len;
            while (true) {
                len = inputStream.read(buffer);
                if (len == -1) {
                    break;
                }
                fileOutputStream.write(buffer, 0, len);
            }
            System.out.println("下载完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            urlConnection.disconnect();
        }
    }
}
