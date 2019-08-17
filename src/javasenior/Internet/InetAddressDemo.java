package javasenior.Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/17 14:50
 */
public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.10.14");
            System.out.println(inetAddress);

            InetAddress inetAddress2 = InetAddress.getByName("www.yuanfudashi.com");
            System.out.println(inetAddress2);

            InetAddress inetAddress3 = InetAddress.getByName("localhost");
            System.out.println(inetAddress3);

            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress4);
            String hostName = inetAddress4.getHostName();
            String hostAddress = inetAddress4.getHostAddress();
            System.out.println(hostName + hostAddress);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
