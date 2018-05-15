package m_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import m_package.Admin;


@WebServlet("/Test")
public class Test_bean extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String login;
    private String pwd;
    
    public void init() throws ServletException{
    	this.login = "admin";
    	this.pwd   = "1234";
    }
    
    public Test_bean() {
    	super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	treatment(request, response);  
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	treatment(request, response);    	
    }

    
    protected void treatment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/** Récupération formulaire */
    	
        String nom = request.getParameter("nom");
        
        request.setAttribute("nom", nom);
        System.out.print(nom);
        if(!"admin".equals(nom)){
        	System.out.print("-ici-");
        	this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        } else {
        	System.out.print("-là-");
        	this.getServletContext().getRequestDispatcher("/WEB-INF/page2.jsp").forward(request, response);
        }
        
        	
    	
    	/**
        Admin admin = new Admin();
        admin.setAddr("admin@admin.com");
        admin.setMdp("azerty");
        
        request.setAttribute("admin", admin);
        
       	String addr = request.getParameter("addr");
       	String mdp = request.getParameter("mdp");
       	
       	HttpSession session = request.getSession();
       	
       	session.setAttribute("addr", addr);
       	session.setAttribute("mdp", mdp);
       	
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
        */
    	/*
    	String loginA = request.getParameter("loginA");
    	String pwdA = request.getParameter("pwdA");

    	
    	RequestDispatcher dispatcher = null;
    	
    	if(this.login.equalsIgnoreCase(loginA) && this.pwd.equalsIgnoreCase(pwdA)){
    		dispatcher = request.getRequestDispatcher("pannel_admin.jsp");
    	} else {
    		dispatcher = request.getRequestDispatcher("WEB-INF/accueil.jsp");
    	}
    	
    	dispatcher.forward(request, response);
    	*/
    	/**
    	Admin admin = new Admin(loginA,pwdA);
    	HttpSession sessionAdmin = request.getSession();
    	sessionAdmin.setAttribute("admin", admin);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
    	dispatcher.forward(request, response);
    	*/
    	//this.getServletContext().getRequestDispatcher("/WEB-INF/pannel_admin.jsp").forward(request, response);

    
    }	
    
    
    


}