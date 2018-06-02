package controllers;

import collections.Conventions;
import factories.ConventionFactoryImpl;
import models.Convention;
import utilities.JParse;
import utilities.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/consultation")
public class ConsultServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(ConsultServlet.class.getCanonicalName());

    //**
    private static final String LOCDIR = "localDirectoryPath";
    //**
    private static final String CONVENTIONS = "/conventions.xml";
    //**
    private static final String PAGE = "/WEB-INF/views/consultation.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String directory = getServletContext().getInitParameter(LOCDIR);

        final ConventionFactoryImpl conventionFactory = new ConventionFactoryImpl(directory + CONVENTIONS);

        request.setAttribute("conventions", conventionFactory.getAll());

        LOGGER.log(Level.INFO, Utils.hash("password"));
        LOGGER.log(Level.INFO, Utils.hash("wordpass"));

        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
