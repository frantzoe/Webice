package controllers;

import applications.LoginForm;
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
    private static final String PAGE = "/WEB-INF/views/login.jsp";
    private static final String NEXT = "/WEB-INF/views/administration.jsp";
    //**
    private static final String FORM = "form";
    private static final String USER = "recruiter";
    private static final String SESSION = "recruiterSession";

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Executed");
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Executed");

        final LoginForm form = new LoginForm();

        final Recruiter recruiter = form.login(request);

        final HttpSession session = request.getSession();

        request.setAttribute(FORM, form);
        request.setAttribute(USER, recruiter);

        if (recruiter != null) {
            session.setAttribute(SESSION, recruiter);
            getServletContext().getRequestDispatcher(NEXT).forward(request, response);
            LOGGER.log(Level.INFO, recruiter.toString());
        } else {
            session.setAttribute(SESSION, null);
            getServletContext().getRequestDispatcher(PAGE).forward(request, response);
        }
    }
}
