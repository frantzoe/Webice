package controllers;

import applications.ConvenForm;
import factories.CandidacyFactoryImpl;
import factories.ConventionFactoryImpl;
import models.Convention;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/createconvention")
public class CreateConventionServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(CreateConventionServlet.class.getCanonicalName());
    //**
    private static final String LOCDIR = "localDirectoryPath";
    //**
    private static final String CONVENTIONS = "/conventions.xml";
    private static final String CANDIDACIES = "/candidacies.xml";
    //**
    private static final String SESSION = "recruiterSession";
    //**
    private static final String REDI = "/login";
    private static final String PAGE = "/WEB-INF/administration.jsp";
    //**
    private static final Integer TAB = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        if (session.getAttribute(SESSION) == null) {
            response.sendRedirect(request.getContextPath() + REDI);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();

        if (session.getAttribute(SESSION) == null) {
            response.sendRedirect(request.getContextPath() + REDI);
        } else {
            final String directory = getServletContext().getInitParameter(LOCDIR);

            final ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(directory + CONVENTIONS);
            final CandidacyFactoryImpl candidacyFactory = new CandidacyFactoryImpl(directory + CANDIDACIES);

            final ConvenForm form = new ConvenForm();
            form.create(request, directory + CONVENTIONS);

            request.setAttribute("tab", TAB);
            request.setAttribute("candidacies", candidacyFactory.getAll());
            request.setAttribute("conventions", conventionFactory.getAll());

            getServletContext().getRequestDispatcher(PAGE).forward(request, response);
        }
    }
}
