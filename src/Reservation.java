import java.util.Date;

public class Reservation {

    private String reservateur;
    private Date dateDebut;
    private Date dateFin;
    private long idChambre;

    public Reservation(String reservateur, Date dateDebut, Date dateFin, long idChambre) {
        this.reservateur = reservateur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idChambre = idChambre;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservateur='" + reservateur + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", idChambre=" + idChambre +
                '}';
    }
}
