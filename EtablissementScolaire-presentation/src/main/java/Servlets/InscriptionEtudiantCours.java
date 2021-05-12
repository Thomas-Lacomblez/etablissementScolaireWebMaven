package Servlets;

import eu.ensup.etablissementscolaire.Cours;
import eu.ensup.etablissementscolaire.CoursService;
import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetAllCoursServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetCoursServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.InscriptionCoursServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetEtudiantServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "InscriptionEtudiantCours",
        urlPatterns = "/inscriptionEtudiantCours"
)

public class InscriptionEtudiantCours extends HttpServlet {

    public static final String VUE = "/inscriptionEtudiantCours.jsp";
    public static EtudiantService etudiantService = new EtudiantService();
    public static CoursService coursService = new CoursService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Set<Cours> ListCours = coursService.getAll();

            req.setAttribute("ListCours", ListCours);

            Set<Etudiant> ListEtudiant = etudiantService.getAll();

            req.setAttribute("ListEtudiant", ListEtudiant);
            this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
        } catch (GetAllEtudiantServiceException | GetAllCoursServiceException e) {
            this.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            Etudiant etudiantAInscrire = etudiantService.get(Integer.parseInt(req.getParameter("etudiantSelectedInput")));
            Cours coursInscription = coursService.get(Integer.parseInt(req.getParameter("coursSelectedInput")));

            etudiantAInscrire.setId( Integer.parseInt(req.getParameter("etudiantSelectedInput")) );
            int resultCode = coursService.inscription( coursInscription, etudiantAInscrire );

            if (resultCode == 1) {
                resp.sendRedirect(this.getServletContext().getContextPath() + "/listCours");
            } else {
                this.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            }

        } catch (GetEtudiantServiceException | GetCoursServiceException | InscriptionCoursServiceException e) {


            System.out.println( "e.getMessage() : " + e.getMessage());
            this.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }

    }
}
