import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

public class ClientApp extends JFrame {

    private String serverCommand;
    private final int PORT = 5555;

    protected ClientApp() {
        this.setSize(800, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        try {
            Socket clientSocket = new Socket("192.168.1.1", 5555);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            inFromUser.readLine();

            outToServer.writeBytes("abc");

            inFromServer.readLine();

            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createApp() {

    }
}
