package applications;

import collections.Recruiters;
import models.Recruiter;
import utilities.JParse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginForm {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(LoginForm.class.getCanonicalName());

    /* ********** Declaring Candidacy Variables ********** */
    private static final String USER_MAIL = "email";
    private static final String USER_PASS = "password";
    private static final String PATH_RECRUITERS = "/WEB-INF/database/recruiter.xml";

    public Recruiter login(HttpServletRequest request) {

        /* ********** Retrieving Recruiter Parameters ********** */
        final String username = request.getParameter(USER_MAIL).trim();
        final String password = request.getParameter(USER_PASS).trim();

        LOGGER.log(Level.INFO, request.getServletContext().getRealPath(PATH_RECRUITERS));

        Recruiter recruiter = null;

        try {
            File file = new File(request.getServletContext().getRealPath(PATH_RECRUITERS));
            Recruiters recruiters = JParse.unmarshal(Recruiters.class, file);
            for (Recruiter r : recruiters.getRecruiter()) {
                if (r.getEmail().equals(username) && r.getPassword().equals(password)) {
                    recruiter = r;
                    LOGGER.log(Level.INFO, recruiter.toString());
                }
            }
        } catch (Exception e) {e.printStackTrace();}

        return recruiter;
    }
}
