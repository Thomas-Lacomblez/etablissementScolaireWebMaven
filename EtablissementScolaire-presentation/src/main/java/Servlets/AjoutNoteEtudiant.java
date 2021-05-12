package Servlets;

import eu.ensup.etablissementscolaire.*;
import eu.ensup.etablissementscolaire.exception.ServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetAllCoursServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "AjoutNoteEtudiant",
        urlPatterns = "/ajoutNoteEtudiant"
)

public class AjoutNoteEtudiant extends HttpServlet {
    public static EtudiantService etudiantService = new EtudiantService();
    public static CoursService coursService = new CoursService();
    public static NoteEleveService noteEleveService = new NoteEleveService();
    public static MatiereService matiereService = new MatiereService();

    public static final String VUE = "/AjoutNoteEtudiant.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Set<Cours> ListCours = null;

            Set<Matiere> listeMatiere = matiereService.getAll();
            req.setAttribute("listeMatiere", listeMatiere);

            Set<Etudiant> ListEtudiant = etudiantService.getAll();

            req.setAttribute("ListEtudiant", ListEtudiant);
            this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
        } catch (GetAllEtudiantServiceException | GetAllCoursServiceException e) {
            this.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Etudiant etudiantAInscrire = etudiantService.get(Integer.parseInt(req.getParameter("etudiantSelectedInput")));

            Matiere MatiereInscription = matiereService.get(Integer.parseInt(req.getParameter("matiereSelectedInput")));

            NoteEleve noteEleve = new NoteEleve(1, Integer.parseInt(req.getParameter("noteE")) );
            noteEleveService.addNoteEleve(noteEleve, etudiantAInscrire, MatiereInscription);

            resp.sendRedirect("/etablissement/list");
        } catch (ServiceException e) {
            this.getServletContext().getRequestDispatcher( "/error.jsp" ).forward( req, resp );
        }
    }
}
