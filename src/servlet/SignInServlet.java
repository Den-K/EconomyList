package servlet;

import dao.DAOFactory;
import dao.user.IUserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Den on 02.03.2015.
 */

@WebServlet(name="SignIn", urlPatterns = "/SignIn")
public class SignInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email.equals("") || password.equals("")){
            request.setAttribute("verification", "Please, fill empty fields!");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if(!validateEmail(email)) {
            request.setAttribute("verification", "Incorrect email!");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {

            DAOFactory daoFactory = new DAOFactory();
            IUserDAO userDAO = daoFactory.getUserDAO();

                //check email in DB, means that user exists
                if(userDAO.verifyUserByEmail(email)) {
                    //check accordance between email and password
                    request.getRequestDispatcher("purchaseList.jsp").forward(request, response);

                } else {
                    request.setAttribute("verification", "Email not found!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private boolean validateEmail(String email){
        Pattern p = Pattern.compile(".+[@].+\\.(com|ua|ru|net)");
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
