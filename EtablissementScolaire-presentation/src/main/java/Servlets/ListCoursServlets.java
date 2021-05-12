package Servlets;

import eu.ensup.etablissementscolaire.Cours;
import eu.ensup.etablissementscolaire.CoursDao;
import eu.ensup.etablissementscolaire.CoursService;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetAllCoursServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "ListCoursServlets",
        urlPatterns = "/listCours"
)

public class ListCoursServlets extends HttpServlet {

    public static final String VUE = "/listCours.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CoursService coursService = new CoursService();
            CoursDao coursDao = new CoursDao();
            Set<Cours> listCours = coursService.getAll();
            int id_cours = listCours.iterator().next().getId();

            this.getServletContext().getRequestDispatcher( VUE ).forward( req, resp );

        } catch (GetAllCoursServiceException e) {
            System.out.println( "e.getMessage() : " + e.getMessage() );
        }
    }
}
