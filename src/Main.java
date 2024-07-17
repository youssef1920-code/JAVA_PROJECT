import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Message> messages = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Chambre> chambres = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();

        // Utilisateurs par défaut
        users.add(new User("Youssef", "Ghannouchi", 1235489789L, "azerty123", 14567));
        users.add(new User("John", "Doe", 9876543210L, "password", 98765));

        // Chambres disponibles
        chambres.add(new Chambre(1, "1ere etage", 5, false));
        chambres.add(new Chambre(2, "1ere etage", 5, false));
        chambres.add(new Chambre(3, "2ere etage", 3, true));
        chambres.add(new Chambre(4, "3ere etage", 2, true));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans notre espace\n");
        System.out.println("Veuillez choisir l'une des options :");
        System.out.println("1 - Se connecter");
        System.out.println("2 - Créer un compte");
        System.out.println("3 - Interface administrateur");

        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            Services.login(users, chambres, messages, reservations, scanner);
        } else if (option == 2) {
            Services.addAccountAdmin(users, scanner);
        } else if (option == 3) {
            Admin.adminMenu(users, chambres, messages, reservations, scanner);
        } else {
            System.out.println("Option invalide, programme terminé.");
        }

        scanner.close();
    }
}
