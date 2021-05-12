package Servlets;


import eu.ensup.etablissementscolaire.Etudiant;
import eu.ensup.etablissementscolaire.EtudiantService;
import eu.ensup.etablissementscolaire.exception.CredentialException;
import eu.ensup.etablissementscolaire.exception.etudiantExceptions.AddEtudiantServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet(
        name = "FormServlet",
        urlPatterns = "/form"
)

public class FormServlet extends HttpServlet {
    public FormServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Etudiant etudiant = new Etudiant(req.getParameter("nomE"), req.getParameter("emailE"), req.getParameter("adresseE"),req.getParameter("phoneE"), req.getParameter("prenomE"), req.getParameter("passwordE"), "4d45d5d5df4d5d55d5d4f5d5", Date.valueOf(req.getParameter("ddnE")) );
            EtudiantService etudiantService = new EtudiantService();
            int resultCode = 0;

            resultCode = etudiantService.create(etudiant);
            if (resultCode == 0) {

               /* resp.setHeader("success", "true" );
                System.out.println( "resp.getHeader(\"success\") : " + resp.getHeader("success") );
                System.out.println("dans redirection");
                req.setAttribute( "etudiant", etudiant );*/

                resp.sendRedirect( this.getServletContext().getContextPath() + "/list");
                //getRequestDispatcher( "/list" ).include(req, resp); //.forward( req, resp );
            } else {
                this.getServletContext().getRequestDispatcher( "/error.jsp" ).forward( req, resp );
            }
        } catch (AddEtudiantServiceException | CredentialException e) {
        }
    }
}