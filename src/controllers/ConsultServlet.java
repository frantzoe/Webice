package controllers;

import collections.Conventions;
import utilities.JParse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/consultation")
public class ConsultServlet extends HttpServlet {

    //**
    private static final String PAGE = "/WEB-INF/views/consultation.jsp";
    private static final String PATH = "/conventions.xml";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //**
        Conventions conventions = null;

        try {
            //**
            File file = new File(request.getServletContext().getRealPath(PATH));
            //**
            conventions = JParse.unmarshal(Conventions.class, file);

            System.out.println(conventions.getConvention());

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("conventions", conventions != null ? conventions.getConvention() : null);
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //**
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }
}
