import java.util.ArrayList;
import java.util.Scanner;

public class Admin{

    public static void adminMenu(ArrayList<User> users, ArrayList<Chambre> chambres, ArrayList<Message> messages, ArrayList<Reservation> reservations, Scanner scanner) {
        int choix = 0;

        while (choix != 5) {
            System.out.println("Interface administrateur - Veuillez choisir une option :");
            System.out.println("1 - Consulter les réservations");
            System.out.println("2 - Consulter l'état des chambres");
            System.out.println("3 - Consulter les messages");
            System.out.println("4 - Consulter la liste des utilisateurs");
            System.out.println("5 - Quitter");

            choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    Services.showReservations(reservations);
                    break;
                case 2:
                    Services.showChambres(chambres);
                    break;
                case 3:
                    System.out.println("Liste des messages :");
                    for (Message message : messages) {
                        System.out.println(message);
                    }
                    break;
                case 4:
                    System.out.println("Liste des utilisateurs :");
                    for (User user : users) {
                        System.out.println(user);
                    }
                    break;
                case 5:
                    System.out.println("Déconnexion de l'interface administrateur...");
                    Services.login(users, chambres, messages, reservations, scanner);
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }
}
