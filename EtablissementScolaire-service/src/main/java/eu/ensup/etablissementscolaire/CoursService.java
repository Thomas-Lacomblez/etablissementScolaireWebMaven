package eu.ensup.etablissementscolaire;

import eu.ensup.etablissementscolaire.exception.ServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.*;
import eu.ensup.etablissementscolaire.exceptions.DaoException;

import java.util.List;
import java.util.Set;


/**
 * The type Cours service.
 */
public class CoursService implements ICoursService {
    private final ICoursDao coursDao = new CoursDao();
    @Override
    public int create(Cours cours) throws AddCoursServiceException {
        try{
            return coursDao.create(cours) ;
        }catch (DaoException e) {
            throw new AddCoursServiceException();
        }

    }

    @Override
    public int update(Cours cours) throws UpdateCoursServiceException {
        System.out.println("cours.getId() inside coursService 11111 : " + cours.getId());
        try{

            return coursDao.update(cours) ;
        }catch (DaoException e) {
            throw new UpdateCoursServiceException();
        }
    }

    @Override
    public int delete(int id) throws DeleteCoursServiceException {
        try{
            return coursDao.delete(id) ;
        }catch (DaoException e) {
            throw new DeleteCoursServiceException();
        }
    }

    @Override
    public Cours get(int id) throws GetCoursServiceException {
        try{
            return coursDao.get(id) ;
        }catch (DaoException e) {
            throw new GetCoursServiceException();
        }
    }

    @Override
    public Set<Cours> getAll() throws GetAllCoursServiceException {
        try{
            //System.out.println(" insde getAll CoursService ");
            Set<Cours> listCours = coursDao.getAll();

            listCours.stream().forEach(c -> {
                System.out.println("here");
                try {
                    System.out.println("here 2 ");
                    System.out.println("c.getEtudiants().size() 1 : " + c.getEtudiants().size() );
                    c.setEtudiants( coursDao.getListEtudiantCours(c.getId()) );
                    System.out.println("c.getEtudiants().size() 2 : " + c.getEtudiants().size() );
                } catch (Exception e) {
                }
            });
            //System.out.println( "listCours.iterator().next().getEtudiants().size() in coursService: " + listCours.iterator().next().getEtudiants().size() );
            return listCours;
        } catch (DaoException e) {
            System.out.println( " inside catch coursService.getAll() ");
            throw new GetAllCoursServiceException();
        }
    }

    @Override
    public int inscription(Cours c, Etudiant e) throws InscriptionCoursServiceException {
        try{
            return coursDao.inscription(c, e);
        }catch (DaoException data) {
            data.printStackTrace();
            throw new InscriptionCoursServiceException();
        }
    }

    @Override
    public Set<Cours> getCoursEtudiant(int idEtudiant) throws GetCoursEtudiantServiceException {
        try{
            return coursDao.getCoursEtudiant(idEtudiant);
        }catch (DaoException e) {
            throw new GetCoursEtudiantServiceException();
        }
    }

    @Override
    public List<Etudiant> getListEtudiantCours(int idCours) throws ServiceException {
        try{
            return coursDao.getListEtudiantCours( idCours );
        }catch (DaoException e) {
            throw new GetCoursEtudiantServiceException();
        }
    }

}
