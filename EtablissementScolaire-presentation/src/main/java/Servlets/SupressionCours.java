package Servlets;

import eu.ensup.etablissementscolaire.CoursService;
import eu.ensup.etablissementscolaire.exception.coursExceptions.DeleteCoursServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "SupressionCours",
        urlPatterns = "/supressionCours"
)

public class SupressionCours extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id_cours = Integer.parseInt(req.getParameter("id"));

            CoursService CoursService = new CoursService();

            CoursService.delete( id_cours);

            resp.sendRedirect(this.getServletContext().getContextPath() + "/list");
        } catch ( DeleteCoursServiceException e) {
            e.printStackTrace();
        }

    }
}
