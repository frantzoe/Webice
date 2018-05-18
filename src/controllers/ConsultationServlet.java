package controllers;

import models.Convention;
import services.Candidates;
import services.Conventions;
import utilities.JParse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/consultation")
public class ConsultationServlet extends HttpServlet {

    //**
    private static final String PAGE = "/WEB-INF/views/consultation.jsp";
    private static final String PATH = "/WEB-INF/database/conventions.xml";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hey There Boi");
        Conventions conventions = null;
        try {
            //**
            File file = new File(request.getServletContext().getRealPath(PATH));
            //**
            conventions = JParse.unmarshal(Conventions.class, file);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(conventions);

        request.setAttribute("conventions", conventions.getConventions());

        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //**
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //**
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
