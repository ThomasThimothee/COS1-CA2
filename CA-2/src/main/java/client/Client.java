/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thomasthimothee
 */
public class Client implements Runnable {

    private final Socket clientSocket;
    private final PrintWriter out;
    private final Scanner in;
    private List<Client> listClients;

    public Client(Socket socket, List<Client> listClients) throws IOException {
        this.clientSocket = socket;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new Scanner((clientSocket.getInputStream()));
        this.listClients = listClients;
    }

    @Override
    public void run() {
        String command;
        String target;
        String userName;
        String message;
        while (true) {
            message = in.nextLine();
            String[] splitMessage;
            splitMessage = message.split(":");
            String messageToCustomer = "";
            switch (splitMessage.length) {
                case 1:
                    if (splitMessage[0].equals("LOGOUT")) {
                        //do logout thing
                    } else {
                        //wrong command
                    }
                    break;
                case 2:
                    command = splitMessage[0];
                    userName = splitMessage[1];
                    switch (command) {
                        case "LOGIN":
                            //do login thing
                            break;
                        default:
                            //wrong command
                            break;
                    }
                    break;
                case 3:
                    command = splitMessage[0];
                    target = splitMessage[1];
                    message = splitMessage[2];
                    switch (command) {
                        case "MSG":
                            // do send message
                            break;
                        default:
                            //wrong command
                            break;
                    }
                    break;
                default:
                    //wrong message
                    break;
            }
        }
    }

    private void close() {
        in.close();
        out.close();
        try {
            clientSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(Client.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
