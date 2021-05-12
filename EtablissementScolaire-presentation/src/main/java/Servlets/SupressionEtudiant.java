package Servlets;

import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.DeleteEtudiantServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "SupressionEtudiant",
        urlPatterns = "/supressionEtudiant"
)

public class SupressionEtudiant extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id_etudiant = Integer.parseInt(req.getParameter("id"));

            EtudiantService etudiantService = new EtudiantService();

            etudiantService.delete( id_etudiant);

            resp.sendRedirect(this.getServletContext().getContextPath() + "/list");
        } catch (DeleteEtudiantServiceException e) {
            e.printStackTrace();
        }

    }
}
