import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        boolean appRun = true; // Variable indiquant que le client doit continuer à tourner

        Stub stub = new Stub("127.0.0.1", 10000); // On crée notre objet de communication avec le serveur en lui indiquant l'adresse et le port du serveur
        while(appRun){
            stub.main("DIV", 4, 5); // envoie d'une commande de type division au serveur avec les chiffres 4 et 5

            // - On peut ici implémenter un système de demande dans le terminal de la commande à lancer au serveur - //

            appRun = false;
        }
        stub.endServer(); // envoie de la commande d'arrêt du serveur
    }
}