package applications;

import factories.ConventionFactoryImpl;
import models.Convention;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class ConvenForm {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(ConvenForm.class.getCanonicalName());

    /* ********** Declaring Candidacy Variables ********** */
    private static final String CONV_LABEL = "label";
    private static final String CONV_DETAIL = "detail";
    private static final String CONV_SCHED = "scheduled";
    private static final String CONV_PLACE = "place";
    private static final String CONV_POS1 = "position1";
    private static final String CONV_POS2 = "position2";
    private static final String CONV_POS3 = "position3";
    private static final String CONV_POS4 = "position4";

    /**
     * Sets the value of the surname property.
     *
     * @param request
     *     allowed object is
     *     {@link String }
     *
     */
    public Convention create(HttpServletRequest request, String pathConventions) {

        /* ********** Retrieving Convention Parameters ********** */
        final String label = request.getParameter(CONV_LABEL).trim();
        final String detail = request.getParameter(CONV_DETAIL).trim();
        final String scheduled = request.getParameter(CONV_SCHED).trim();
        final String place = request.getParameter(CONV_PLACE);
        final String position1 = request.getParameter(CONV_POS1).trim();
        final String position2 = request.getParameter(CONV_POS2).trim();
        final String position3 = request.getParameter(CONV_POS3).trim();
        final String position4 = request.getParameter(CONV_POS4).trim();

        /* ********** TCreating Convention ********** */
        Convention convention = new Convention();
        convention.setLabel(label);
        convention.setDetail(detail);
        convention.setPlace(place);
        convention.setImage("example-event08.jpg");
        convention.setScheduled(scheduled);

        if (!position1.isEmpty()) {
            Convention.Positions positions = new Convention.Positions();
            positions.getPosition().add(position1);
            convention.setPositions(positions);
        }
        if (!position2.isEmpty()) {
            Convention.Positions positions = new Convention.Positions();
            positions.getPosition().add(position2);
            convention.setPositions(positions);
        }
        if (!position3.isEmpty()) {
            Convention.Positions positions = new Convention.Positions();
            positions.getPosition().add(position3);
            convention.setPositions(positions);
        }
        if (!position4.isEmpty()) {
            Convention.Positions positions = new Convention.Positions();
            positions.getPosition().add(position4);
            convention.setPositions(positions);
        }

        final ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(pathConventions);

        conventionFactory.create(convention);

        return convention;
    }
}
