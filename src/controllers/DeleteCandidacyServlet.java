package controllers;

import factories.*;
import models.Candidacy;
import models.Candidate;
import models.Convention;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/deletcandidacy")
public class DeleteCandidacyServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(DeleteCandidacyServlet.class.getCanonicalName());

    //**
    private static final String LOCDIR = "localDirectoryPath";
    //**
    private static final String CANDIDACIES = "/candidacies.xml";
    //**
    private static final String SESSION = "recruiterSession";
    //**
    private static final String REDI = "/login";
    private static final String PAGE = "/WEB-INF/administration.jsp";

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();

        if (session.getAttribute(SESSION) == null) {
            response.sendRedirect(request.getContextPath() + REDI);
        } else {
            final String directory = getServletContext().getInitParameter(LOCDIR);
            final CandidacyFactoryImpl candidacyFactory = new CandidacyFactoryImpl(directory + CANDIDACIES);
            final Candidacy candidacy = candidacyFactory.getOne(request.getParameter("email"), request.getParameter("label"));
            LOGGER.log(Level.INFO, candidacyFactory.getAll().toString());
            candidacyFactory.delete(candidacy);
            getServletContext().getRequestDispatcher(PAGE).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        if (session.getAttribute(SESSION) == null) {
            response.sendRedirect(request.getContextPath() + REDI);
        }
    }
}
