package economylist.servlet;

import economylist.dao.DAOFactory;
import economylist.dao.purchase.PurchaseDAO;
import economylist.dao.user.UserDAO;
import economylist.valueobject.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ListOperations", urlPatterns = "/ListOperations")
public class ListOperationsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] selectedOptions = req.getParameterValues("selected");
        DAOFactory daoFactory = new DAOFactory();
        PurchaseDAO purchaseDAO = daoFactory.getPurchaseDAO();
        String email = req.getParameter("email");
        UserDAO userDAO = daoFactory.getUserDAO();
        User user = userDAO.getUserByEmail(email);
        req.setAttribute("user", user);

        if(selectedOptions != null){
            for(String s : selectedOptions){
                Integer i = Integer.valueOf(s);
                purchaseDAO.deletePurchase(i);
            }
        } else{}

        req.getRequestDispatcher("purchaseList.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}