import java.util.Scanner;

public class MaDate {
    // 🔹 Attributs privés
    private int jour;
    private int mois;
    private int annee;

    // 🔹 Constructeur sans paramètre (optionnel)
    public MaDate() {
        this.jour = 1;
        this.mois = 1;
        this.annee = 2000;
    }

    // 🔹 Constructeur avec 3 paramètres
    public MaDate(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    // 🔹 Constructeur avec 1 paramètre (initialiser l’année)
    public MaDate(int annee) {
        this.jour = 1;
        this.mois = 1;
        this.annee = annee;
    }

    // 🔹 Getters et setters
    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    // 🔹 toString : pour afficher la date sous forme jour/mois/année
    @Override
    public String toString() {
        return jour + "/" + mois + "/" + annee;
    }

    // 🔹 Méthode pour savoir si une année est bissextile
    private boolean estBissextile(int annee) {
        return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
    }

    // 🔹 Méthode pour obtenir le nombre de jours d’un mois donné
    private int nbJoursDansMois(int mois, int annee) {
        switch (mois) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return estBissextile(annee) ? 29 : 28;
            default:
                return 0;
        }
    }

    // 🔹 ajouterUnJour
    public void ajouterUnJour() {
        jour++;
        int joursDansMois = nbJoursDansMois(mois, annee);

        if (jour > joursDansMois) {
            jour = 1;
            mois++;
            if (mois > 12) {
                mois = 1;
                annee++;
            }
        }
    }

    // 🔹 ajouterPlusieursJours
    public void ajouterPlusieursJours(int n) {
        for (int i = 0; i < n; i++) {
            ajouterUnJour();
        }
    }

    // 🔹 ajouterUnMois
    public void ajouterUnMois() {
        mois++;
        if (mois > 12) {
            mois = 1;
            annee++;
        }

        // Si le jour n’existe pas dans le nouveau mois (ex: 31 avril)
        int joursDansMois = nbJoursDansMois(mois, annee);
        if (jour > joursDansMois) {
            jour = joursDansMois;
        }
    }

    // 🔹 ajouterUnAn
    public void ajouterUnAn() {
        annee++;
        // Ajuster pour le cas du 29 février
        if (mois == 2 && jour == 29 && !estBissextile(annee)) {
            jour = 28;
        }
    }

    // 🔹 Programme principal (test)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Créer trois dates
        MaDate d1 = new MaDate(12, 5, 2025);
        MaDate d2 = new MaDate(1, 1, 2023);
        MaDate d3 = new MaDate(2050); // constructeur avec un seul paramètre

        // Modifier via setters
        d2.setJour(28);
        d2.setMois(2);
        d2.setAnnee(2024);

        // Afficher les dates initiales
        System.out.println("Date 1 : " + d1);
        System.out.println("Date 2 : " + d2);
        System.out.println("Date 3 : " + d3);

        // Menu
        System.out.println("\n=== MENU ===");
        System.out.println("1. Ajouter un jour");
        System.out.println("2. Ajouter plusieurs jours");
        System.out.println("3. Ajouter un mois");
        System.out.println("4. Ajouter une année");
        System.out.print("Choix : ");
        int choix = sc.nextInt();

        System.out.print("Quelle date voulez-vous modifier (1, 2 ou 3) ? ");
        int num = sc.nextInt();

        MaDate dateChoisie;
        if (num == 1) dateChoisie = d1;
        else if (num == 2) dateChoisie = d2;
        else dateChoisie = d3;

        switch (choix) {
            case 1:
                dateChoisie.ajouterUnJour();
                break;
            case 2:
                System.out.print("Combien de jours à ajouter ? ");
                int n = sc.nextInt();
                dateChoisie.ajouterPlusieursJours(n);
                break;
            case 3:
                dateChoisie.ajouterUnMois();
                break;
            case 4:
                dateChoisie.ajouterUnAn();
                break;
            default:
                System.out.println("Choix invalide !");
        }

    }
}