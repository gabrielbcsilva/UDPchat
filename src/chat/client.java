/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class client {

    public static void main(String args[]) throws IOException {
        System.out.println("Digite na área do cliente: ");
        Scanner sc = new Scanner(System.in);

// Etapa 1: Crie o objeto de soquete para
        // carregando os dados.
        DatagramSocket ds = new DatagramSocket();

        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;

        // loop enquanto o usuário não entra em "bye"
        while (true) {
            String inp = sc.nextLine();

// converte a entrada String na matriz de bytes.
            buf = inp.getBytes();

           
// Etapa 2: Crie o datagramPacket para enviar
            // os dados.
            DatagramPacket DpSend
             = new DatagramPacket(buf, buf.length, ip, 1234);

            
// Etapa 3: invocar a chamada de envio para realmente enviar
            // os dados.
            ds.send(DpSend);

           
// interrompe o loop se o usuário digitar "bye"
            if (inp.equals("bye")) {
                break;
            }
        }
    }
}
