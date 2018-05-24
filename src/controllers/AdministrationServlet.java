package controllers;

import collections.Candidacies;
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

@WebServlet(urlPatterns = "/administration")
public class AdministrationServlet extends HttpServlet {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(AdministrationServlet.class.getCanonicalName());

    //**
    private static final String PAGE = "/WEB-INF/views/administration.jsp";
    private static final String PATH = "/WEB-INF/database/candidacies.xml";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Executed");

        //**
        Candidacies candidacies = null;

        try {
            //**
            File file = new File(request.getServletContext().getRealPath(PATH));
            //**
            candidacies = JParse.unmarshal(Candidacies.class, file);

            LOGGER.log(Level.INFO, candidacies.toString());

        } catch (Exception e) {
            e.printStackTrace();

            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        request.setAttribute("candidacies", candidacies != null ? candidacies.getCandidacy() : null);
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //**
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
