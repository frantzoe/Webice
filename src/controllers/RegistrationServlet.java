package controllers;

import applications.RegistrationForm;
import models.Candidate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    //**
    private static final String PAGE = "/WEB-INF/views/registration.jsp";
    private static final String PATH = "/WEB-INF/database/candidates.xml";
    //**
    private static final String FORM = "form";
    private static final String USER = "candidate";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //**
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //**
        RegistrationForm form = new RegistrationForm();
        //**
        Candidate candidate = form.register(PATH, request);
        //**
        request.setAttribute(FORM, form);
        request.setAttribute(USER, candidate);
        //**
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
