package Servlets;

import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetAllEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.GetEtudiantServiceException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.UpdateEtudiantServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Set;

@WebServlet(
        name = "ModificationEtudiant",
        urlPatterns = "/modificationEtudiant"
)

public class ModificationEtudiant extends HttpServlet {
    public static final String VUE = "/modifcationEtudiantPage.jsp";
    public static EtudiantService etudiantService = new EtudiantService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Set<Etudiant> ListEtudiant = etudiantService.getAll();

            req.setAttribute("ListEtudiant", ListEtudiant);
            this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
        } catch (GetAllEtudiantServiceException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int resultCode = 0;

            Etudiant etudiantTmp = etudiantService.get( Integer.parseInt(req.getParameter("etudiantSelectInput")) );
            Etudiant etudiant = new Etudiant(
                    Integer.parseInt(req.getParameter("etudiantSelectInput")),
                    !req.getParameter("nomE").isEmpty() ? req.getParameter("nomE") : etudiantTmp.getNom(),
                    !req.getParameter("emailE").isEmpty() ? req.getParameter("emailE") : etudiantTmp.getEmail(),
                    !req.getParameter("adresseE").isEmpty() ? req.getParameter("adresseE") : etudiantTmp.getAdresse(),
                    !req.getParameter("phoneE").isEmpty() ? req.getParameter("phoneE") : etudiantTmp.getTelephone(),
                    !req.getParameter("prenomE").isEmpty() ? req.getParameter("prenomE") : etudiantTmp.getPrenom(),
                    etudiantTmp.getMotDePasse(),
                    etudiantTmp.getSalt(),
                    !req.getParameter("ddnE").isEmpty() ? Date.valueOf(req.getParameter("ddnE")) : etudiantTmp.getDateNaissance()
            );

            resultCode = etudiantService.update(etudiant);

            if (resultCode == 0) {
                resp.sendRedirect(this.getServletContext().getContextPath() + "/list");
            } else {
                this.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            }
        } catch (UpdateEtudiantServiceException | GetEtudiantServiceException e) {
            this.getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

}
