package applications;

import collections.Candidacies;
import models.Candidacy;
import models.Candidate;
import models.Convention;
import utilities.JParse;
import utilities.Utils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationForm {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(RegistrationForm.class.getCanonicalName());

    /* ********** Declaring Candidacy Variables ********** */
    private static final String USER_FNAME = "surname";
    private static final String USER_LNAME = "forename";
    private static final String USER_GENDER = "gender";
    private static final String USER_BIRTH = "birthday";
    private static final String USER_EMAIL = "email";
    private static final String USER_PHONE = "telephone";
    private static final String USER_ADDR = "street";
    private static final String USER_CITY = "city";
    private static final String USER_ZIP = "zip";
    private static final String USER_MOTIV = "motivation";
    private static final String USER_CHOICE = "choice";

    /* ********** Declaring Quiz Variables ********** */
    private static final String QUESTION1 = "question-1";
    private static final String QUESTION2 = "question-2";
    private static final String QUESTION3 = "question-3";
    private static final String QUESTION4 = "question-4";
    private static final String QUESTION5 = "question-5";
    private static final String QUESTION6 = "question-6";

    public Candidacy register(Convention convention, String pathCandidacies, HttpServletRequest request) {

        /* ********** Retrieving Candidate Parameters ********** */
        final String surname = request.getParameter(USER_LNAME).trim();
        final String forename = request.getParameter(USER_FNAME).trim();
        final String email = request.getParameter(USER_EMAIL).trim();
        final String gender = request.getParameter(USER_GENDER).trim();
        final String birthday = request.getParameter(USER_BIRTH).trim();
        final String telephone = request.getParameter(USER_PHONE).trim();

        /* ********** Retrieving Candidacy Parameters ********** */
        final String motivation = request.getParameter(USER_MOTIV).trim();
        final String choice = request.getParameter(USER_CHOICE).trim();

        /* ********** Retrieving Quiz Parameters ********** */
        final String question1 = request.getParameter(QUESTION1).trim();
        final String question2 = request.getParameter(QUESTION2).trim();
        final String question3 = request.getParameter(QUESTION3).trim();
        final String question4 = request.getParameter(QUESTION4).trim();
        final String question5 = request.getParameter(QUESTION5).trim();
        final String question6 = request.getParameter(QUESTION6).trim();

        /* ********** TCreating Candidate ********** */
        Candidate candidate = new Candidate();
        candidate.setSurname(surname);
        candidate.setForename(forename);
        candidate.setGender(gender);
        candidate.setBirthday(birthday);
        candidate.setTelephone(telephone);
        candidate.setEmail(email);
        candidate.setPersonality(Utils.getPersonality(question1, question2, question3, question4, question5, question6));
        /*
        String address = request.getParameter(USER_ADDR);
        String city = request.getParameter(USER_CITY);
        String zip = request.getParameter(USER_ZIP);
        String motivation = request.getParameter(USER_MOTIV);
        */

        /* ********** Creating Candidacy ********** */
        Candidacy candidacy = new Candidacy();
        candidacy.setCandidate(candidate);
        candidacy.setConvention(convention);
        candidacy.setMotivation(motivation);
        candidacy.setValidated(false);

        LOGGER.log(Level.INFO, candidacy.toString());
        LOGGER.log(Level.INFO, request.getServletContext().getRealPath(pathCandidacies));

        try {
            File file = new File(request.getServletContext().getRealPath(pathCandidacies));
            Candidacies candidacies = JParse.unmarshal(Candidacies.class, file);
            candidacies.addCandidacy(candidacy);
            JParse.marshal(candidacies, file);
        } catch (Exception e) {e.printStackTrace();}

        LOGGER.log(Level.INFO, candidacy.toString());

        return candidacy;
    }
}
