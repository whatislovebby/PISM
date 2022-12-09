package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        ServerSocket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {

            socket = new ServerSocket(1024);
            System.out.println("Waiting fot the client");

            while (true) {
                Socket client = socket.accept();
                System.out.println("=============================");
                System.out.println("Client connected");

                inputStream = client.getInputStream(); //получили входной поток для чтения данных
                outputStream = client.getOutputStream();//получили выходной поток для записи данных

                DataInputStream in = new DataInputStream(inputStream);
                DataOutputStream out = new DataOutputStream(outputStream);

                String infoSRV = in.readUTF();
                System.out.println("Server received number "+infoSRV);

                String result = null;

                int x=Integer.parseInt(infoSRV);
                switch (x){
                    case 74001:
                        result=  "1) ПИСм, 2)ОБТС, 3)ММММРМРМР, 4)ТВИМС\0";
                        break;

                    case 74002:
                        result= "1) МИ, 2)МК, 3)ИМЭК, \0";
                        break;

                    case 74004:
                        result= "Пар нет отдыхайте\0";
                        break;

//                    case 3:
//                        result=  "The result is 'three'\0";
//                        break;
//
//                    case 4:
//                        result=  "The result is 'four'\0";
//                        break;
//
//                    case 5:
//                        result= "The result is 'five'\0";
//                        break;
//
//                    case 6:
//                        result= "The result is 'six'\0";
//                        break;
//
//                    case 7:
//                        result=  "The result is 'seven'\0";
//                        break;
//
//                    case 8:
//                        result=  "The result is 'eight'\0";
//                        break;
//
//                    case 9:
//                        result=  "The result is 'nine'\0";
//                        break;
//
//                    case 10:
//                        result= "The result is 'ten'\0";
//                        break;

                    default:
                        result="Error! Group not found";
                        break;
                }
                infoSRV=result;
                out.writeUTF(infoSRV);
                System.out.println("Server sent a sentence "+infoSRV);

                    }
                } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}
