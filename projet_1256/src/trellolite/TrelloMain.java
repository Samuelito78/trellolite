package trellolite;

import trellolite.modeles.*;

import java.util.ArrayList;

public class TrelloMain {
    public static void main(String[] args) {
        // Création des Utilisateurs
        Utilisateur user1 = new Utilisateur(1,"Dupont", "Jean", "j.dupont@gmail.com", "password", Role.membre, new ArrayList<>(), new ArrayList<>());
        Utilisateur user2 = new Utilisateur(2,"Durand", "Pierre", "p.durand@gmail.com", "password", Role.administrateur, new ArrayList<>(), new ArrayList<>());

        // Création de Commentaires
        Commentaire comment1 = new Commentaire(user1, "Ceci est un commentaire", 20230519, null);
        Commentaire comment2 = new Commentaire(user2, "Ceci est un autre commentaire", 20230519, null);

        // Ajout des commentaires aux utilisateurs correspondants
        user1.ajouterComm(comment1);
        user2.ajouterComm(comment2);

        // Création de Cartes
        Carte carte1 = new Carte("Carte 1", "Description de la carte 1", 20230518, 20230520, new ArrayList<>(), new ArrayList<>(), null);
        Carte carte2 = new Carte("Carte 2", "Description de la carte 2", 20230518, 20230520, new ArrayList<>(), new ArrayList<>(), null);

        // Création d'Etiquettes
        Etiquette etiqu1 = new Etiquette("Etiquette 1", "Rouge", new ArrayList<>());
        Etiquette etiqu2 = new Etiquette("Etiquette 2", "Vert", new ArrayList<>());

        // Ajout des cartes aux étiquettes
        etiqu1.ajouterCarte(carte1);
        etiqu2.ajouterCarte(carte2);

        // Création de Listes
        Liste liste1 = new Liste("Liste 1", new ArrayList<>(), null);
        Liste liste2 = new Liste("Liste 2", new ArrayList<>(), null);

        // Ajout des cartes aux listes
        liste1.ajouterCarte(carte1);
        liste2.ajouterCarte(carte2);

        // Création de Tableaux
        Tableau tableau1 = new Tableau("Tableau 1", "Description du tableau 1", 20230518, 20230520, new ArrayList<>(), null);
        Tableau tableau2 = new Tableau("Tableau 2", "Description du tableau 2", 20230518, 20230520, new ArrayList<>(), null);

        // Ajout des listes aux tableaux
        tableau1.ajouterListe(liste1);
        tableau2.ajouterListe(liste2);

        // Création de Projets
        Projet projet1 = new Projet("Projet 1", "Type du projet 1", "Description du projet 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Projet projet2 = new Projet("Projet 2", "Type du projet 2", "Description du projet 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        // Ajout des tableaux aux projets
        projet1.ajouterTableau(tableau1);
        projet2.ajouterTableau(tableau2);

        // Création de Réunions
        Reunion reunion1 = new Reunion("Reunion 1", projet1, new ArrayList<>());
        Reunion reunion2 = new Reunion("Reunion 2", projet2, new ArrayList<>());

        // Ajout des utilisateurs aux réunions
        reunion1.ajouterUser(user1);
        reunion2.ajouterUser(user2);

        // Ajout des réunions aux utilisateurs
        user1.ajouterReunion(reunion1);
        user2.ajouterReunion(reunion2);

        // Vérification des éléments ajoutés
        System.out.println("Nombre de commentaires de l'utilisateur: " + user1.getComm().size());
        System.out.println("Nombre de réunions de l'utilisateur: " + user1.getReunion().size());
        System.out.println("Nombre d'étiquettes de la carte: " + carte1.getEtiquettes().size());
        System.out.println("Nombre de commentaires de la carte: " + carte1.getComm().size());
        System.out.println("Nombre de cartes de l'étiquette: " + etiqu1.getCartes().size());
        System.out.println("Nombre de cartes de la liste: " + liste1.getCartes().size());
        System.out.println("Nombre de listes du tableau: " + tableau1.getListe().size());
        System.out.println("Nombre de tableaux du projet: " + projet1.getTableaux().size());
        System.out.println("Nombre de utilisateurs du projet: " + projet1.getUtilisateurs().size());
        System.out.println("Nombre de admins du projet: " + projet1.getAdmin().size());
        System.out.println("Nombre de réunions du projet: " + projet1.getReunions().size());
        System.out.println("Nombre de utilisateurs de la réunion: " + reunion1.getUtilisateurs().size());
    }
}
