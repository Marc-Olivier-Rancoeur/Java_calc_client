import java.io.Serial;
import java.io.Serializable;

public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1; // Serial version UID implémenté pour définir la version partagée de la classe.

    private final String commande;
    private final int chiffre1;
    private final int chiffre2;

    public Message(String commande, int chiffre1, int chiffre2){ // définition du constructeur de la classe Message
        this.commande = commande;
        this.chiffre1 = chiffre1;
        this.chiffre2 = chiffre2;
    }

    // Définition des getters de la classe Message
    public String getCommande(){
        return this.commande;
    }
    public int getChiffre1(){
        return this.chiffre1;
    }
    public int getChiffre2(){
        return this.chiffre2;
    }
}