public class Chambre {

    private int id;
    private String localisation;
    private int categorie;
    private boolean etat;

    public Chambre(int id, String localisation, int categorie, boolean etat) {
        this.id = id;
        this.localisation = localisation;
        this.categorie = categorie;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "id=" + id +
                ", localisation='" + localisation + '\'' +
                ", categorie=" + categorie +
                ", etat=" + (etat ? "Disponible" : "Réservée") +
                '}';
    }
}
