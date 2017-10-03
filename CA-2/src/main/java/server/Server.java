/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.Client;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author thomasthimothee
 */
public class Server {
      private static int PORT = 8081;
    private static String IP = "0.0.0.0";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket;
        ExecutorService es = Executors.newFixedThreadPool(1084);
        List<Client> listClients = new ArrayList();
        

        serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(IP, PORT));

        while (true) {
            Socket socket = serverSocket.accept();
            Client client = new Client(socket, listClients);
            listClients.add(client);
            es.execute(client);
        }
    }
}
