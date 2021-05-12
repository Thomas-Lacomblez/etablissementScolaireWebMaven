package Servlets;

import eu.ensup.etablissementscolaire.Responsable;
import eu.ensup.etablissementscolaire.ResponsableService;
import eu.ensup.etablissementscolaire.exception.CredentialException;
import eu.ensup.etablissementscolaire.exception.EmailFormatException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(
        name = "ConnectionServlets",
        urlPatterns = "/connection"
)

public class ConnectionServlets extends HttpServlet {

    public static final String VUE = "/dashboard.jsp";
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public ConnectionServlets() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* */
        try {
           ResponsableService responsableService = new ResponsableService();
            String emailUser = req.getParameter("email");
            String pssdUser = req.getParameter("motdepasse");
            validate(emailUser);

            Responsable user = responsableService.getCredentialByEmail(emailUser);

            //Vérification du mot de passe et l'adresse mail
            //throw new NoSuchAlgorithmException();
            responsableService.validAuthentification(user, String.valueOf( pssdUser ));
            req.getSession().setAttribute("user", user);

            //this.getServletContext().getRequestDispatcher( VUE ).forward( req, resp );
            resp.sendRedirect("/etablissement/list");
        } catch (EmailFormatException | CredentialException | NoSuchAlgorithmException excep) {
            System.out.println( excep.getMessage() );

            this.getServletContext().getRequestDispatcher( "/error.jsp" ).forward( req, resp );
        }
    }
    public static void validate(String emailStr) throws EmailFormatException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        if(!matcher.find() ) {
            throw new EmailFormatException();
        }
    }
}
