package economylist.servlet;

import economylist.dao.DAOFactory;
import economylist.dao.user.IUserDAO;
import economylist.valueobject.User;
import economylist.verification.InputVerification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Den on 14.03.2015.
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = "/SignUp")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("repeat");

        if(name.equals("") || surname.equals("") || email.equals("") || password.equals("") || passwordRepeat.equals("")) {
            request.setAttribute("verif", "Please, fill empty fields!");
            request.getRequestDispatcher("registration.jsp").forward(request, response);

        } else if(!InputVerification.validateEmail(email)) {
            request.setAttribute("verif", "Incorrect email!");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else{
            User user = new User(name, surname, email, password);
            DAOFactory daoFactory = new DAOFactory();
            IUserDAO userDAO = daoFactory.getUserDAO();
            userDAO.addUser(user);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request,response);
    }
}
