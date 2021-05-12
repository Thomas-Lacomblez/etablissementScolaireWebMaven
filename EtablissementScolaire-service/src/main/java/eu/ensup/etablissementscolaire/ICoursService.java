package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exception.ServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetCoursEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.InscriptionCoursServiceException;

import java.util.List;
import java.util.Set;

/**
 * The interface Cours service.
 */
public interface ICoursService extends IService<Cours>
{
    /**
     * Inscription int.
     *
     * @param c the c
     * @param e the e
     * @return the int
     */
    int inscription(Cours c, Etudiant e) throws ServiceException, InscriptionCoursServiceException;

    /**
     * Gets cours etudiant.
     *
     * @param idEtudiant the id etudiant
     * @return the cours etudiant
     * @throws ServiceException the service exception
     */
    Set<Cours> getCoursEtudiant(int idEtudiant) throws  ServiceException, GetCoursEtudiantServiceException;


    List<Etudiant> getListEtudiantCours(int idCours) throws ServiceException;
}
