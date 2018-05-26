package controllers;

import collections.Candidacies;
import factories.CandidacyFactoryImpl;
import factories.ConventionFactory;
import factories.ConventionFactoryImpl;
import utilities.JParse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/administration")
public class AdminServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(AdminServlet.class.getCanonicalName());

    //**
    private static final String LOCDIR = "localDirectoryPath";
    //**
    private static final String CANDIDACIES = "/candidacies.xml";
    private static final String CONVENTIONS = "/conventions.xml";

    //**
    private static final String REDI = "/login";
    private static final String PAGE = "/WEB-INF/administration.jsp";
    //**
    private static final String SESSION = "recruiterSession";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Executed");

        final String directory = getServletContext().getInitParameter(LOCDIR);

        final HttpSession session = request.getSession();

        final CandidacyFactoryImpl candidacyFactory = new CandidacyFactoryImpl(directory + CANDIDACIES);
        final ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(directory + CONVENTIONS);

        request.setAttribute("candidacies", candidacyFactory.getAll());
        request.setAttribute("conventions", conventionFactory.getAll());

        if (session.getAttribute(SESSION) == null) {
            response.sendRedirect(request.getContextPath() + REDI);
        } else {
            LOGGER.log(Level.INFO, candidacyFactory.getAll().toString());
            getServletContext().getRequestDispatcher(PAGE).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //**
        LOGGER.log(Level.INFO, "Executed");
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
