/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.MessageHandler;

/**
 *
 * @author thomasthimothee
 */
public class Client implements Runnable {

    private final Socket clientSocket;
    private final PrintWriter out;
    private final Scanner in;
    private Map<String, Client> listClients = new HashMap();
    private String name;
    private Boolean isOpen = true;

    public Client(Socket socket, Map<String, Client> listClients) throws IOException {
        this.clientSocket = socket;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new Scanner((clientSocket.getInputStream()));
        this.listClients = listClients;
    }

    @Override
    public void run() {
        while (isOpen) {
            String inputLine = in.nextLine();
            MessageHandler.getMessageHandler().handleMessage(inputLine, this);
        }
    }

    public void close() {
        in.close();
        out.close();
        isOpen = false;
        try {
            clientSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(Client.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<String, Client> getListClients() {
        return listClients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrintWriter getOut() {
        return out;
    }

    public Scanner getIn() {
        return in;
    }
    
    
}
