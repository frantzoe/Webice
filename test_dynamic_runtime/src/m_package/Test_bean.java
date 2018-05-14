package m_package;

import java.io.IOException;
import java.io.PrintWriter;

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
    
    public Test_bean() {
    	super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /** JAVA BEAN
         * Admin admin = new Admin();
         * admin.setAddr("admin@admin.com");
         * admin.setMdp("azerty");
         * 
         * request.setAttribute("admin", admin);
        */
       	String addr = request.getParameter("addr");
       	String mdp = request.getParameter("mdp");
       	
       	HttpSession session = request.getSession();
       	
       	session.setAttribute("addr", addr);
       	session.setAttribute("mdp", mdp);
       	
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }
    
    
    


}