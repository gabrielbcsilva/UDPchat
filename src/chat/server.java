package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class server {

    public static void main(String[] args) throws IOException {

// Etapa 1: Crie um soquete para comunicar na porta 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];

        DatagramPacket DpReceive = null;
        while (true) {

// Etapa 2: crie um DatgramPacket para receber os dados.
            DpReceive = new DatagramPacket(receive, receive.length);

// Etapa 3: revise os dados no buffer de bytes.
            ds.receive(DpReceive);

            System.out.println("Clients say: " + ds.getLocalSocketAddress() + " Msg:  " + data(receive));

// Saia do servidor se o cliente enviar "tchau"
            if (data(receive).toString().equals("bye")) {
                System.out.println("Client sent bye.....EXITING");
                break;
            }

// Limpe o buffer após cada mensagem.
            receive = new byte[65535];
        }
    }

// Um ​​método utilitário para converter a matriz de bytes
    // dados em uma representação de string.
    public static StringBuilder data(byte[] a) {
        if (a == null) {
            return null;
        }
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
