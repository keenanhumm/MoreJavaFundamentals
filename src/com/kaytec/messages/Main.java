package com.kaytec.messages;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String content;
    private boolean empty = true;

    public synchronized String read() {
        while(empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("i was interrupted");
            }
        }
        empty = true;
        notifyAll();
        return content;
    }
    public synchronized void write(String content) {
        while(!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("i was interrupted");
            }
        }
        empty = false;
        this.content = content;
        notifyAll();
    }
}

class Writer implements Runnable {
    public Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String messages[] = {
                "The cat walked",
                "The dog jumped",
                "The squirrel leaps",
                "The frog hopped"
        };
        Random random = new Random();
        for (int i=0; i<messages.length;i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){
                System.out.println("I was interrupted");
            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader (Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()){
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("I was interrupted");
            }
        }

    }
}
