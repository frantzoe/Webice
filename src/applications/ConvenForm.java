package applications;

import collections.Candidacies;
import factories.ConventionFactoryImpl;
import models.Candidacy;
import models.Candidate;
import models.Convention;
import utilities.JParse;
import utilities.Utils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvenForm {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(ConvenForm.class.getCanonicalName());

    /* ********** Declaring Candidacy Variables ********** */
    private static final String CONV_LABEL = "label";
    private static final String CONV_DETAIL = "detail";
    private static final String CONV_SCHED = "scheduled";
    private static final String CONV_POS1 = "position1";
    private static final String CONV_POS2 = "position2";
    private static final String CONV_POS3 = "position3";
    private static final String CONV_POS4 = "position4";

    public Convention create(String pathConventions, HttpServletRequest request) {

        /* ********** Retrieving Convention Parameters ********** */
        final String label = request.getParameter(CONV_LABEL).trim();
        final String detail = request.getParameter(CONV_DETAIL).trim();
        final String scheduled = request.getParameter(CONV_SCHED).trim();
        final String position1 = request.getParameter(CONV_POS1).trim();
        final String position2 = request.getParameter(CONV_POS2).trim();
        final String position3 = request.getParameter(CONV_POS3).trim();
        final String position4 = request.getParameter(CONV_POS4).trim();

        /* ********** TCreating Candidate ********** */
        Convention convention = new Convention();
        convention.setLabel(label);
        convention.setDetail(detail);

        if (!position1.isEmpty()) {
            convention.getPositions().getPosition().add(position1);
        }
        if (!position2.isEmpty()) {
            convention.getPositions().getPosition().add(position2);
        }
        if (!position3.isEmpty()) {
            convention.getPositions().getPosition().add(position3);
        }
        if (!position4.isEmpty()) {
            convention.getPositions().getPosition().add(position4);
        }

        final ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(pathConventions);

        LOGGER.log(Level.INFO, convention.toString());

        conventionFactory.create(convention);

        return convention;
    }
}
