import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Services {

    // Méthode pour ajouter un compte utilisateur
    public static void addAccountAdmin(ArrayList<User> users, Scanner scanner) {
        System.out.println("Bienvenue dans notre hôtel. Veuillez saisir votre nom : ");
        String name = scanner.nextLine();
        System.out.println("Veuillez saisir votre prénom : ");
        String lastName = scanner.nextLine();
        System.out.println("Veuillez saisir votre numéro de téléphone : ");
        long phone = Long.parseLong(scanner.nextLine());
        System.out.println("Veuillez saisir votre identifiant : ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Veuillez saisir votre mot de passe : ");
        String password = scanner.nextLine();

        User newUser = new User(name, lastName, phone, password, id);
        users.add(newUser);

        System.out.println("Le compte a été créé avec succès.");
        System.out.println("Veuillez choisir l'une des options :");
        System.out.println("1 - Se connecter");
        System.out.println("2 - Créer un compte");
    }

    // Méthode pour consulter les réservations
    public static void showReservations(ArrayList<Reservation> reservations) {
        System.out.println("Liste des réservations :");
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation n'a été effectuée.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    // Méthode pour consulter l'état des chambres
    public static void showChambres(ArrayList<Chambre> chambres) {
        System.out.println("État des chambres :");
        if (chambres.isEmpty()) {
            System.out.println("Aucune chambre disponible.");
        } else {
            for (Chambre chambre : chambres) {
                System.out.println(chambre);
            }
        }
    }

    // Méthode pour vérifier l'existence d'un utilisateur
    public static boolean checkUser(ArrayList<User> users, long id, String password) {
        for (User user : users) {
            if (user.getId() == id && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Méthode pour effectuer une réservation
    public static void makeReservation(ArrayList<Chambre> chambres, ArrayList<Reservation> reservations, long login, Scanner scanner) {
        showChambres(chambres);
        System.out.println("Quelle chambre souhaitez-vous réserver? Entrez l'ID de la chambre : ");
        long id = Long.parseLong(scanner.nextLine());

        Chambre chambre = findChambreById(chambres, id);

        if (chambre != null && !chambre.isEtat()) {
            // Simulation de la date de début et de fin pour l'exemple
            long now = System.currentTimeMillis();
            Reservation reservation = new Reservation("User " + login, new Date(now), new Date(now + 86400000), id);
            reservations.add(reservation);
            chambre.setEtat(true);
            System.out.println("Réservation effectuée avec succès !");
        } else {
            System.out.println("La chambre avec l'ID " + id + " n'existe pas ou n'est pas disponible.");
        }
    }

    // Méthode pour trouver une chambre par son ID
    private static Chambre findChambreById(ArrayList<Chambre> chambres, long id) {
        for (Chambre chambre : chambres) {
            if (chambre.getId() == id) {
                return chambre;
            }
        }
        return null;
    }

    // Méthode pour gérer le login
    public static void login(ArrayList<User> users, ArrayList<Chambre> chambres, ArrayList<Message> messages, ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("Bienvenue, veuillez saisir votre identifiant : ");
        long login = Long.parseLong(scanner.nextLine());
        System.out.println("Veuillez saisir votre mot de passe : ");
        String password = scanner.nextLine();

        while (!checkUser(users, login, password)) {
            System.out.println("Identifiant ou mot de passe incorrect. Veuillez réessayer.");
            System.out.println("Veuillez saisir votre identifiant : ");
            login = Long.parseLong(scanner.nextLine());
            System.out.println("Veuillez saisir votre mot de passe : ");
            password = scanner.nextLine();
        }

        System.out.println("Bienvenue " + login);

        int choix = 0;

        while (choix != 4) {
            System.out.println("Veuillez choisir une option :");
            System.out.println("1 - Consulter le catalogue des chambres libres");
            System.out.println("2 - Effectuer une réservation");
            System.out.println("3 - Consulter mes réservations");
            System.out.println("4 - Se déconnecter");

            choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    showChambres(chambres);
                    break;
                case 2:
                    makeReservation(chambres, reservations, login, scanner);
                    break;
                case 3:
                    showReservations(reservations);
                    break;
                case 4:
                    System.out.println("Déconnexion...");
                    Services.login(users, chambres, messages, reservations, scanner);
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }
}
