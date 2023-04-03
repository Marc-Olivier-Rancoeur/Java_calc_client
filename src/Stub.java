import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Stub {

    // Définition de nos éléments privés de la classe
    private final InetAddress address;
    private final int port;

    public Stub(String adresse, int port) throws UnknownHostException { // Construction de la classe avec l'adresse du serveur et son port
        this.address = InetAddress.getByName(adresse);
        this.port = port;
    }

    public void main(String commande, int chiffre1, int chiffre2) throws IOException, ClassNotFoundException { // méthode principale de la classe permettant de lancer une commande au serveur via le réseau

        Socket socket = new Socket(address, port); // Création du socket
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream()); // Création de l'objet d'envoie de la requête
        outputStream.writeObject(new Message(commande, chiffre1, chiffre2)); // Envoie de la requête avec un objet de type Message

        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream()); // Réception de la réponse du serveur
        String message = (String)inputStream.readObject(); // On récupère la réponse de type String
        System.out.println("Réponse : " + message.substring(4)); // Les 4 premiers caractères sont inutiles "RES:"

        outputStream.close(); // On termine la communication
        inputStream.close();
        socket.close();
    }

    public void endServer() throws IOException { // méthode appelée pour terminer le serveur

        Socket socket = new Socket(address, port);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(new Message("exit", 0, 0)); // On envoie la commande exit au serveur lui demandant l'arrêt

        outputStream.close(); // on libère tout
        socket.close();
    }
}
