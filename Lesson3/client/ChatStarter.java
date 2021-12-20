package com.company.client;




import com.company.client.comunication.ClientCommunication;
import com.company.client.gui.ChatFrame;
import com.company.logs.LogsFiles;

import java.util.function.Consumer;


public class ChatStarter {

    private final ChatFrame frame;
    private final ClientCommunication communication;
    private String nick = "";
    private final LogsFiles logsFiles;

    public ChatStarter() {

        communication = new ClientCommunication();
        logsFiles = new LogsFiles();



        Consumer <String> outboxMessageConsumer = outboundMessage -> {
            communication.sendMessage(outboundMessage);
        };


        frame = new ChatFrame(outboxMessageConsumer);
           new Thread(()-> {
               while (true) {
                   String inboxMessage = communication.receiveMessage();
                   if (inboxMessage.startsWith("/authok")) {
                       nick = inboxMessage.split("\\s+")[1];
                       logsFiles.setFile(inboxMessage, nick);
                       frame.getInboundMessageConsumer().accept("* Вы авторизованы как: " + nick + "\n");
                       //socket.setSoTimeout(0);
                       //break;
                   }
                   else {
                   frame.getInboundMessageConsumer().accept(inboxMessage);
                       logsFiles.setFile(inboxMessage, nick);}
               }
           }).start();

    }
}
