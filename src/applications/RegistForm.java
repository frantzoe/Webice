package applications;

import factories.CandidacyFactoryImpl;
import factories.CandidateFactoryImpl;
import factories.ConventionFactoryImpl;
import models.Candidacy;
import models.Candidate;
import utilities.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistForm {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(RegistForm.class.getCanonicalName());

    /* ********** Declaring Candidacy Variables ********** */
    private static final String USER_FNAME = "surname";
    private static final String USER_LNAME = "forename";
    private static final String USER_GENDER = "gender";
    private static final String USER_BIRTH = "birthday";
    private static final String USER_EMAIL = "email";
    private static final String USER_PHONE = "telephone";
    private static final String USER_MOTIV = "motivation";
    private static final String USER_CHOICES = "choices";

    /* ********** Declaring Quiz Variables ********** */
    private static final String QUESTION1 = "question-1";
    private static final String QUESTION2 = "question-2";
    private static final String QUESTION3 = "question-3";
    private static final String QUESTION4 = "question-4";
    private static final String QUESTION5 = "question-5";
    private static final String QUESTION6 = "question-6";

    public Candidacy register(String label, HttpServletRequest request, String pathCoventions, String pathCandidates, String pathCandidacies) {

        /* ********** Retrieving Candidate Parameters ********** */
        final String surname = request.getParameter(USER_LNAME).trim();
        final String forename = request.getParameter(USER_FNAME).trim();
        final String email = request.getParameter(USER_EMAIL).trim();
        final String gender = request.getParameter(USER_GENDER).trim();
        final String birthday = request.getParameter(USER_BIRTH).trim();
        final String telephone = request.getParameter(USER_PHONE).trim();

        /* ********** Retrieving Candidacy Parameters ********** */
        final String motivation = request.getParameter(USER_MOTIV).trim();
        final String[] choices = request.getParameterValues(USER_CHOICES);

        /* ********** Retrieving Quiz Parameters ********** */
        final String question1 = request.getParameter(QUESTION1).trim();
        final String question2 = request.getParameter(QUESTION2).trim();
        final String question3 = request.getParameter(QUESTION3).trim();
        final String question4 = request.getParameter(QUESTION4).trim();
        final String question5 = request.getParameter(QUESTION5).trim();
        final String question6 = request.getParameter(QUESTION6).trim();

        CandidateFactoryImpl candidateFactory = new CandidateFactoryImpl(pathCandidates);
        CandidacyFactoryImpl candidacyFactory = new CandidacyFactoryImpl(pathCandidacies);
        ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(pathCoventions);

        /* ********** TCreating Candidate ********** */
        Candidate candidate = new Candidate();
        candidate.setSurname(surname);
        candidate.setForename(forename);
        candidate.setGender(gender);
        candidate.setBirthday(birthday);
        candidate.setTelephone(telephone);
        candidate.setEmail(email);
        candidate.setPersonality(Utils.getPersonality(question1, question2, question3, question4, question5, question6));

        /* ********** Creating Candidacy ********** */
        Candidacy candidacy = new Candidacy();
        candidacy.setCandidate(candidate);
        candidacy.setConvention(conventionFactory.getOne(label));
        candidacy.setMotivation(motivation);
        candidacy.setValidated(false);

        int count = 1;

        for (String choice : choices) {
            if (!choice.trim().isEmpty() && count == 1) {
                candidacy.setChoiceOne(choice);
                count++;
            } else if (!choice.trim().isEmpty() && count == 2) {
                candidacy.setChoiceTwo(choice);
            }
        }

        candidateFactory.create(candidate);
        candidacyFactory.create(candidacy);

        LOGGER.log(Level.INFO, candidacy.toString());

        return candidacy;
    }
}
