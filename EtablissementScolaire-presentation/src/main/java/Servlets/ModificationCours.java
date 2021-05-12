package Servlets;

import eu.ensup.etablissementscolaire.Cours;
import eu.ensup.etablissementscolaire.CoursService;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetAllCoursServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.GetCoursServiceException;
import eu.ensup.etablissementscolaire.exception.coursExceptions.UpdateCoursServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "ModificationCours",
        urlPatterns = "/modificationCours"
)

public class ModificationCours extends HttpServlet {
    public static final String VUE = "/modifcationCoursPage.jsp";
    public static CoursService coursService = new CoursService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Set<Cours> ListCours = coursService.getAll();

            req.setAttribute("ListCours", ListCours);
            this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
        } catch (GetAllCoursServiceException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int resultCode = 0;

            Cours coursTmp = coursService.get( Integer.parseInt(req.getParameter("coursSelectInput")) );
            Cours cours = new Cours(
                    Integer.parseInt( req.getParameter("coursSelectInput") ),
                    !req.getParameter("themeC").isEmpty() ? req.getParameter("themeC") : coursTmp.getTheme(),
                    !req.getParameter("nbHeuresC").isEmpty() ? Integer.parseInt(req.getParameter("nbHeuresC")) : coursTmp.getNbHeures()
                    );

            resultCode = coursService.update(cours);

            if (resultCode >= 1) {
                resp.sendRedirect(this.getServletContext().getContextPath() + "/listCours");
            } else {
                this.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        } catch (GetCoursServiceException | UpdateCoursServiceException e) {
        }
    }

}
