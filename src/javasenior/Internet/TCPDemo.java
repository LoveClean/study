package javasenior.Internet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/17 16:16
 */
public class TCPDemo {
    public static void main(String[] args) {
        // 开启服务器
        server();
    }

    static void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8899);

            outputStream = socket.getOutputStream();
            outputStream.write("你好，我是客服mm".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(8899);
            accept = serverSocket.accept();

            inputStream = accept.getInputStream();

            // 1.转化流：防止乱码
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

            byte[] bytes = new byte[10];
            int len;
            while (true) {
                len = inputStream.read(bytes);
                if (len == -1) {
                    break;
                }
                // 2.
                byteArrayOutputStream.write(bytes,0,len);

//                String s = new String(bytes, 0, len);
//                System.out.println(byteArrayOutputStream);
            }
            // 3.
            System.out.println(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
