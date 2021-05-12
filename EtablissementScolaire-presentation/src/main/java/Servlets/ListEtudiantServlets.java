package Servlets;

import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(
        name = "ListEtudiantServlets",
        urlPatterns = "/list"
)
public class ListEtudiantServlets extends HttpServlet {
    public static final String VUE = "/dashboard.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            EtudiantService etudiantService = new EtudiantService();
            Set<Etudiant> ListEtudiant = etudiantService.getAll();

            req.setAttribute( "ListEtudiant", ListEtudiant );

            Boolean success = Boolean.valueOf(resp.getHeader("success"));

            req.setAttribute("success", success);
            this.getServletContext().getRequestDispatcher( VUE ).forward( req, resp );
        } catch (GetAllEtudiantServiceException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            EtudiantService etudiantService = new EtudiantService();
            Set<Etudiant> LitEtudiant = etudiantService.getAll();
            req.setAttribute( "LitEtudiant", LitEtudiant );
            this.getServletContext().getRequestDispatcher( VUE ).forward( req, resp );
        } catch (GetAllEtudiantServiceException e) {
        }
    }
}
