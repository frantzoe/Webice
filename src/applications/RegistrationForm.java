package applications;

import models.Candidate;
import services.Candidates;
import utilities.JParse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class RegistrationForm {

    private static final String USER_FNAME = "surname";
    private static final String USER_LNAME = "forename";
    private static final String USER_GENDER = "gender";
    private static final String USER_BIRTH = "birthday";
    private static final String USER_EMAIL = "email";
    private static final String USER_PHONE = "telephone";
    private static final String USER_ADDR = "street";
    private static final String USER_CITY = "city";
    private static final String USER_ZIP = "zip";
    private static final String USER_MOTIV = "motivation";

    public Candidate register(String path, HttpServletRequest request) {

        String surname = request.getParameter(USER_LNAME).trim();
        String forename = request.getParameter(USER_FNAME).trim();
        String email = request.getParameter(USER_EMAIL).trim();
        String gender = request.getParameter(USER_GENDER).trim();
        String birthday = request.getParameter(USER_BIRTH).trim();
        String telephone = request.getParameter(USER_PHONE).trim();

        /*
        String address = request.getParameter(USER_ADDR);
        String city = request.getParameter(USER_CITY);
        String zip = request.getParameter(USER_ZIP);
        String motivation = request.getParameter(USER_MOTIV);
        */

        Candidate candidate = new Candidate();

        candidate.setSurname(surname);
        candidate.setForename(forename);
        candidate.setGender(gender);
        candidate.setBirthday(birthday);
        candidate.setTelephone(telephone);
        candidate.setEmail(email);

        System.out.println(request.getServletContext().getRealPath(path));

        try {
            //**
            File file = new File(request.getServletContext().getRealPath(path));
            //**
            Candidates candidates = JParse.unmarshal(Candidates.class, file);

            System.out.println(candidates);

            candidates.addCandidate(candidate);
            //**
            JParse.marshal(candidates, file);
            System.out.println(candidate);
            System.out.println("Success!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(candidate);

        return candidate;
    }
}
