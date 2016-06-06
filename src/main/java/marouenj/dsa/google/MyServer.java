package marouenj.dsa.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {

    public static void main(String[] args) {
        int port = 5000;
        ServerSocket ssoc = null;
        Socket soc = null;
        BufferedReader in = null;
        try {
            ssoc = new ServerSocket(port);
            System.out.println("Server waiting for client connections on port " + port + "...");
            //
            soc = ssoc.accept();
            in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            InetAddress addr_dest = soc.getInetAddress();
            int port_dest = soc.getPort();
            System.out.println("Connection established with " + addr_dest + ":" + port_dest + "...");
            // 1
            int[] prices = deserialise_1(in.readLine(), '#');
            if (prices == null)
                System.out.println("Badly formatted data.");
            else {
                System.out.print("[ " + prices[0]);
                for (int i = 1; i < prices.length; i++)
                    System.out.print(", " + prices[i]);
                System.out.println(" ]");
            }
            // 2
            System.out.println(deserialise_2(in.readLine()));
            // 3
            System.out.println(deserialise_3(in.readLine()));
            // 4 consider the look-up table
            //System.out.println(deserialise_4(in.readLine()));
            // 5
            System.out.println(deserialise_5(in.readLine()));

            in.close();
            soc.close();
            ssoc.close();
        } catch (IOException e) {
        }
    }

    /*
     * deserializes an int[] from a formatted string. count#n1#n2#n3# --> int[] = {n1, n2, n3}
     */
    public static int[] deserialise_1(String buf, char delimiter) {
        if (buf == null)
            return null;
        int i = parse_delimiter(buf, delimiter);
        if (i == -1)
            return null;
        int nbre = Integer.parseInt(buf.substring(0, i));
        //
        int[] prices = new int[nbre];
        for (int j = 0; j < nbre; j++) {
            buf = buf.substring(i + 1);
            i = parse_delimiter(buf, delimiter);
            if (i == -1)
                return null;
            prices[j] = Integer.parseInt(buf.substring(0, i));
        }
        return prices;
    }

    /*
     * deserializes a string of a particular length (specified in the header).
     */
    public static String deserialise_2(String buf) {
        if (buf == null || buf.length() < 5)
            return null;
        int msg_length = parse_int(buf);
        if (msg_length < 0 || 4 + msg_length > buf.length())
            return null;
        return buf.substring(4, 4 + msg_length);
    }

    /*
     * deserializes multiple string transmit over a single stream of data (number and length or each are specified in headers).
     */
    public static ArrayList<String> deserialise_3(String buf) {
        if (buf == null)
            return null;
        int nbre = parse_int(buf);
        if (nbre < 1)
            return null;
        buf = buf.substring(4);
        ArrayList<String> msgS = new ArrayList<String>(nbre);
        for (int i = 0; i < nbre; i++) {
            String msg = deserialise_2(buf);
            if (msg == null)
                return null;
            msgS.add(msg);
            if (msg.length() < buf.length())
                buf = buf.substring(4 + msg.length());
        }
        return msgS;
    }

    public static String deserialise_5(String buf) {
        if (buf == null)
            return null;
        int length = parse_int(buf);
        if (length < 1)
            return null;
        buf = buf.substring(4);
        char[] output = new char[length];
        for (int i = 0, j = -1; i < length; i++) {
            int start_at = ((i % 4) * 6) % 8;
            char c6 = 0;
            if (start_at == 0) {
                c6 = (char) (buf.charAt(++j) >>> 2);
            } else if (start_at == 6) {
                c6 = (char) ((buf.charAt(j) & 3) << 4 | buf.charAt(++j) >>> 4);
            } else if (start_at == 4) {
                c6 = (char) ((buf.charAt(j) & 15) << 2 | buf.charAt(++j) >>> 6);
            } else { // if start_at == 2
                c6 = (char) (buf.charAt(j) & 63);
            }
            if (is_digit_deserial(c6)) {
                output[i] = (char) (48 + ((c6 & 31) - 27));
            } else {
                output[i] = (char) (64 + c6);
            }
        }
        //
        return new String(output);
    }


    /*
     * returns the index of the first occurrence of a particular delimiter.
     * -1 otherwise.
     */
    public static int parse_delimiter(String str, char delimiter) {
        if (str == null)
            return -1;
        int i = -1;
        while (++i < str.length() && str.charAt(i) != delimiter)
            ;
        if (i == str.length())
            return -1;
        return i;
    }

    /*
     * returns an integer that makes up the first four characters of the string.
     * -1 otherwise.
     */
    public static int parse_int(String str) {
        if (str == null || str.length() < 4)
            return -1;
        int n = 0;
        for (int i = 0; i < 4; i++) {
            n |= ((int) str.charAt(i)) << i * 8;
        }
        return n;
    }

    public static boolean is_digit_deserial(char c) {
        return (c & 31) > 26;
    }
}
