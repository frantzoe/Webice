package controllers;

import applications.RegistForm;
import collections.Conventions;
import factories.ConventionFactoryImpl;
import models.Candidacy;
import models.Convention;
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

@WebServlet(urlPatterns = "/registration")
public class RegistServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(RegistServlet.class.getCanonicalName());

    //**
    private static final String LOCDIR = "localDirectoryPath";
    //**
    private static final String CANDIDATES = "/candidates.xml";
    private static final String CANDIDACIES = "/candidacies.xml";
    private static final String CONVENTIONS = "/conventions.xml";
    //**
    private static final String PAGE = "/WEB-INF/views/registration.jsp";
    private static final String REDI = "/WEB-INF/confirmation.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String directory = getServletContext().getInitParameter(LOCDIR);

        ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(directory + CONVENTIONS);

        request.setAttribute("conventions", conventionFactory.getAll());

        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String directory = getServletContext().getInitParameter(LOCDIR);

        final RegistForm form = new RegistForm();

        final String label = request.getParameter("choice");

        final Candidacy candidacy = form.register(label, request, directory + CONVENTIONS, directory + CANDIDATES,  directory + CANDIDACIES);

        request.setAttribute("candidate", candidacy.getCandidate());

        getServletContext().getRequestDispatcher(REDI).forward(request, response);
    }
}
