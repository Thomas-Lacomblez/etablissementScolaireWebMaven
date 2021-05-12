package eu.ensup.etablissementscolaire;
import eu.ensup.etablissementscolaire.exceptions.DaoException;

import java.util.List;
import java.util.Set;


/**
 * The interface Cours dao.
 */
public interface ICoursDao extends IDao<Cours>
{
    /**
     * Inscription int.
     *
     * @param c the c
     * @param e the e
     * @return the int
     * @throws DaoException the dao exception
     */
    int inscription(Cours c, Etudiant e) throws DaoException;

    /**
     * Gets cours etudiant.
     *
     * @param idEtudiant the id etudiant
     * @return the cours etudiant
     * @throws DaoException the dao exception
     */
    Set<Cours> getCoursEtudiant(int idEtudiant) throws DaoException;

    List<Etudiant> getListEtudiantCours(int idCours) throws DaoException;
}
