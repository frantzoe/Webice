package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet
public class RegistrationServlet extends HttpServlet {

    private static final String PAGE = "/WEB-INF/views/registration.jsp";

    private static final String FORM = "reg_form";
    private static final String USER = "reg_user";

    private static final String ERRORS = "reg_errors";
    private static final String RESULT = "reg_result";

    private static final String USER_FNAME = "user_first_name";
    private static final String USER_LNAME = "user_last_name";
    private static final String USER_GENDER = "user_gender";
    private static final String USER_BIRTH = "user_birthday";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_PHONE = "user_telephone";
    private static final String USER_PLACE = "user_address";
    private static final String USER_MOTIV = "user_motivation";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(req, resp);
        getServletContext().getRequestDispatcher(PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp);

        String result;
        Map<String, String> errors = new HashMap<>();

        String lastName = request.getParameter(USER_LNAME);
        String firstName = request.getParameter(USER_FNAME);
        String email = request.getParameter(USER_EMAIL);
        String gender = request.getParameter(USER_GENDER);
        String birthday = request.getParameter(USER_BIRTH);
        String telephone = request.getParameter(USER_PHONE);
        String address = request.getParameter(USER_PLACE);
        String motivation = request.getParameter(USER_MOTIV);

        //**
        try {
            validateName(lastName);
        } catch (Exception e) {
            errors.put(USER_LNAME, e.getMessage());
        }

        //**
        try {
            validateName(firstName);
        } catch (Exception e) {
            errors.put(USER_FNAME, e.getMessage());
        }

        //**
        try {
            validateEmail(email);
        } catch (Exception e) {
            errors.put(USER_EMAIL, e.getMessage());
        }

        //**
        if (errors.isEmpty()) {
            result = "Succès!";
        } else {
            result = "Échec";
        }

        //**
        request.setAttribute(ERRORS, errors);
        request.setAttribute(RESULT, result);

        //**
        getServletContext().getRequestDispatcher(PAGE).forward( request, response );
    }

    private void validateName(String name) throws Exception {
        if (name != null && name.trim().length() < 1) {
            throw new Exception( "Merci de saisir un nom valide." );
        }
    }

    private void validateEmail(String email) throws Exception {
        if (email != null && email.trim().length() != 0) {
            if (!"([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)".matches(email)) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }
}
