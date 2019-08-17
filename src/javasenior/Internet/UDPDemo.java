package javasenior.Internet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/**
 * UDP
 *
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/17 18:13
 */
public class UDPDemo {
    public static void main(String[] args) {
        System.out.println("***********");
    }

    static void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发送的导弹";
        byte[] buffer = str.getBytes();
        InetAddress localHost = InetAddress.getByName("127.0.0.1");
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length, localHost, 9090);

        socket.send(datagramPacket);

        socket.close();
    }

    private static void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
    }
}
