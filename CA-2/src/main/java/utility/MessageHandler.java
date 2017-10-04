package utility;

import client.Client;

/**
 *
 * @author mathiasjepsen
 */
public class MessageHandler {

    private static MessageHandler mh;

    public static MessageHandler getMessageHandler() {
        if (mh == null) {
            mh = new MessageHandler();
        }
        return mh;
    }

    public synchronized void handleMessage(String inputLine, Client client) {
        String[] splitMessage = inputLine.split(":");
        String command;
        String target;
        String userName;
        String message;
        switch (splitMessage.length) {
            case 1:
                if (splitMessage[0].equals("LOGOUT") && inputLine.substring(inputLine.length() - 1).equals(":")) {
                    logout(client);
                } else {
                    //wrong command
                }
                break;
            case 2:
                command = splitMessage[0];
                userName = splitMessage[1];
                switch (command) {
                    case "LOGIN":
                        if (!userName.substring(userName.length() - 1).equals(":")) {
                            if (!userName.contains(",")) {
                                login(userName, client);
                            }
                        } else {
                            // Handle error
                        }
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
                        if (!message.substring(message.length() - 1).equals(":")) {
                            String[] persons = target.split(",");

                            for (String person : persons) {
                                if (client.getListClients().get(person) != null) {
                                    sendMessage(message, client, client.getListClients().get(person));
                                }
                            }

                        }
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

    public void sendMessage(String message, Client client, Client otherClient) {
        String output = "MSGRES:" + client.getName() + ":" + message;
        otherClient.getOut().println(output);
        client.getOut().println("Message sent to user: " + otherClient.getName());
    }

    public void logout(Client client) {
        client.getListClients().remove(client.getName());
        client.close();
    }

    public void login(String userName, Client client) {
        if (client.getListClients().get(userName) == null) {
            client.setName(userName);
            client.getListClients().put(userName, client);
         
            client.getOut().println("CLIENTLIST: " + client.printNames());
        } else {
            // Handle error
        }
    }
}
