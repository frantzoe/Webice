package controllers;

import applications.RegistrationForm;
import models.Candidacy;
import models.Convention;
import services.Conventions;
import utilities.JParse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class.getCanonicalName());

    //**
    private static final String PAGE = "/WEB-INF/views/registration.jsp";
    private static final String PATH_CANDIDATES = "/WEB-INF/database/candidates.xml";
    private static final String PATH_CANDIDACIES = "/WEB-INF/database/candidacies.xml";
    private static final String PATH_CONVENTIONS = "/WEB-INF/database/conventions.xml";
    //**
    private static final String FORM = "form";
    private static final String USER = "candidate";

    private Conventions conventions = null;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Executed");

        try {File file = new File(request.getServletContext().getRealPath(PATH_CONVENTIONS));
            conventions = JParse.unmarshal(Conventions.class, file);
        } catch (Exception e) {e.printStackTrace();}

        request.setAttribute("conventions", conventions.getConventions());
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Executed");

        final String label = request.getParameter("choice");
        final RegistrationForm form = new RegistrationForm();
        final Convention convention = conventions.getConventionByLabel(label);
        final Candidacy candidacy = form.register(convention, PATH_CANDIDACIES, request);

        LOGGER.log(Level.INFO, candidacy.toString());

        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
