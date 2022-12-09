package com.example.klient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    OutputStream outputStream = null;
    InputStream inputStream = null;
    Socket socket = null;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField address;

    @FXML
    private Button connect;

    @FXML
    private TextField num1;

    @FXML
    private TextField port;

    @FXML
    private TextArea result;

    @FXML
    private Button sendData;

    @FXML
    void initialize() {
        address.setText("127.0.0.1");
        connect.setOnAction(actionEvent -> {
            {
                try
                {
                    socket = new Socket(InetAddress.getByName(address.getText()), Integer.parseInt(port.getText()));
                    result.setText("You are now connected to the server");
                } catch (IOException e) {
                    result.setText("Server is not found");
                }
                num1.setEditable(true);

            }
        });
        sendData.setOnAction(actionEvent -> {
            {
                try
                {
                    inputStream= socket.getInputStream();
                    outputStream=socket.getOutputStream();
                    DataInputStream in = new DataInputStream(inputStream); // Создание потока для чтения данных от клиента
                    DataOutputStream out = new DataOutputStream(outputStream); // Создание потока для отправки данных от клиента
                    String infoKL, infoSRV;
                    infoKL=num1.getText();
                    out.writeUTF(infoKL);
                    out.flush();
                    infoSRV=in.readUTF();
                    result.setText(infoSRV);

                } catch (IOException e) {

                }
            }
        });
    }
}
