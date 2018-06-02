package applications;

import collections.Recruiters;
import factories.RecruiterFactoryImpl;
import models.Recruiter;
import utilities.JParse;
import utilities.Utils;

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

    public Recruiter login(HttpServletRequest request, String pathRecruiters) {

        /* ********** Retrieving Recruiter Parameters ********** */
        final String username = request.getParameter(USER_MAIL).trim();
        final String password = request.getParameter(USER_PASS).trim();

        RecruiterFactoryImpl recruiterFactory = new RecruiterFactoryImpl(pathRecruiters);

        Recruiter recruiter = recruiterFactory.getOne(username);

        if (recruiter != null && recruiter.getPassword().equals(Utils.hash(password))) {
            return recruiter;
        }

        return null;
    }
}
