import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp extends JFrame {

    private String clientCommand;
    private ServerSocket welcomeSocket;
    private final int PORT = 5555;

    protected ServerApp() {
        this.setSize(800, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //
        while (true) {
            try {
                Socket connectionSocket = welcomeSocket.accept();

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                inFromClient.readLine();

                outToClient.writeBytes("abc");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createApp() {

    }
}
