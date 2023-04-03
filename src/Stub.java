import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Stub {
    private static InetAddress address;
    private static int port;

    public Stub(String adresse, int port) throws UnknownHostException {
        Stub.address = InetAddress.getByName(adresse);
        Stub.port = port;
    }

    public void main(String commande, int chiffre1, int chiffre2) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(address, port);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(commande + ":" + chiffre1 + "-" + chiffre2);
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        String message = (String)inputStream.readObject();
        System.out.println("Réponse : " + message);
        outputStream.close();
        inputStream.close();
        socket.close();
    }

    public void endServer() throws IOException, ClassNotFoundException {
        Socket socket = new Socket(address, port);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject("exit");
        outputStream.close();
        socket.close();
    }
}
