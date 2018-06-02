package controllers;

import factories.CandidacyFactoryImpl;
import factories.ConventionFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/deletecandidacy")
public class DeleteCandidacyServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(DeleteCandidacyServlet.class.getCanonicalName());

    //**
    private static final String LOCDIR = "localDirectoryPath";
    //**
    private static final String CONVENTIONS = "/conventions.xml";
    private static final String CANDIDACIES = "/candidacies.xml";
    //**
    private static final String REDI = "/login";
    private static final String PAGE = "/WEB-INF/administration.jsp";
    //**
    private static final String SESSION = "recruiterSession";
    //**
    private static final Integer TAB = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();

        if (session.getAttribute(SESSION) == null) {
            response.sendRedirect(request.getContextPath() + REDI);
        } else {
            final String directory = getServletContext().getInitParameter(LOCDIR);

            final ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(directory + CONVENTIONS);
            final CandidacyFactoryImpl candidacyFactory = new CandidacyFactoryImpl(directory + CANDIDACIES);

            candidacyFactory.delete(request.getParameter("email"), request.getParameter("label"));

            request.setAttribute("tab", TAB);
            request.setAttribute("candidacies", candidacyFactory.getAll());
            request.setAttribute("conventions", conventionFactory.getAll());

            getServletContext().getRequestDispatcher(PAGE).forward(request, response);
        }
    }
}
