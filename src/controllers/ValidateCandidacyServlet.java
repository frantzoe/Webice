package controllers;

import factories.CandidacyFactoryImpl;
import models.Candidacy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/validatecandidacy")
public class ValidateCandidacyServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(ValidateCandidacyServlet.class.getCanonicalName());
    //**
    private static final String CONVENTIONS = "/conventions.xml";
    //**
    private static final String REDI = "/login";
    private static final String PAGE = "/WEB-INF/administration.jsp";
    //**
    private static final String LOCDIR = "localDirectoryPath";
    //**
    private static final String SESSION = "recruiterSession";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        if (session.getAttribute(SESSION) == null) {
            response.sendRedirect(request.getContextPath() + REDI);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();

        if (session.getAttribute(SESSION) == null) {
            response.sendRedirect(request.getContextPath() + REDI);
        } else {
            final String directory = getServletContext().getInitParameter(LOCDIR);
            final CandidacyFactoryImpl candidacyFactory = new CandidacyFactoryImpl(directory + CANDIDACIES);
            final Candidacy candidacy = candidacyFactory.getOne(request.getParameter("email"), request.getParameter("label"));
            LOGGER.log(Level.INFO, candidacyFactory.getAll().toString());
            candidacyFactory.validate(candidacy);
            getServletContext().getRequestDispatcher(PAGE).forward(request, response);
        }
    }
}
