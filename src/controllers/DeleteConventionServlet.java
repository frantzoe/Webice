package controllers;

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

@WebServlet(urlPatterns = "/deleteconvention")
public class DeleteConventionServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(DeleteConventionServlet.class.getCanonicalName());

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
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String directory = getServletContext().getInitParameter(LOCDIR);

        final HttpSession session = request.getSession();

        final ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(directory + CONVENTIONS);

        LOGGER.log(Level.INFO, conventionFactory.getAll().toString());

        if (session.getAttribute(SESSION) == null) {
            response.sendRedirect(request.getContextPath() + REDI);
        } else {
            LOGGER.log(Level.INFO, conventionFactory.getAll().toString());
            conventionFactory.delete(request.getParameter("label"));
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
