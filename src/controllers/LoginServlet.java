package controllers;

import applications.LoginForm;
import factories.CandidacyFactory;
import factories.CandidacyFactoryImpl;
import factories.ConventionFactoryImpl;
import models.Candidacy;
import models.Recruiter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getCanonicalName());

    //**
    private static final String LOCDIR = "localDirectoryPath";
    //**
    private static final String CANDIDACIES = "/candidacies.xml";
    private static final String CONVENTIONS = "/conventions.xml";
    //**
    private static final String PAGE = "/WEB-INF/views/login.jsp";
    private static final String NEXT = "/WEB-INF/administration.jsp";
    //**
    private static final String SESSION = "recruiterSession";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Executed");
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Executed");

        final String directory = getServletContext().getInitParameter(LOCDIR);

        final LoginForm form = new LoginForm();

        final Recruiter recruiter = form.login(request);

        final HttpSession session = request.getSession();

        final CandidacyFactoryImpl candidacyFactory = new CandidacyFactoryImpl(directory + CANDIDACIES);
        final ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(directory + CONVENTIONS);

        request.setAttribute("candidacies", candidacyFactory.getAll());
        request.setAttribute("conventions", conventionFactory.getAll());

        LOGGER.log(Level.INFO, candidacyFactory.getAll().toString());

        /*request.setAttribute(FORM, form);
        request.setAttribute(USER, recruiter);*/

        if (recruiter != null) {
            LOGGER.log(Level.INFO, recruiter.toString());
            session.setAttribute(SESSION, recruiter);
            getServletContext().getRequestDispatcher(NEXT).forward(request, response);
        } else {
            session.setAttribute(SESSION, null);
            getServletContext().getRequestDispatcher(PAGE).forward(request, response);
        }
    }
}