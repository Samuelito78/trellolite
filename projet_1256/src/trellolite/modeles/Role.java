package trellolite.modeles;

/**
 * L'énumération Role définit les différents rôles qu'un utilisateur peut avoir dans le système Trellolite.
 * Un utilisateur peut être un administrateur, un membre ou un spectateur.
 * 
 * @author Mohamed Telli
 */
public enum Role {
    administrateur, // Un administrateur a généralement des droits complets sur un projet.
    
    membre, // Un membre a des droits limités, souvent définis par l'administrateur.

    spectateur // Un spectateur peut généralement voir le projet mais ne peut pas le modifier.
}
