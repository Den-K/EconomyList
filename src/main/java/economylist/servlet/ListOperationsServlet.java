package economylist.servlet;

import economylist.dao.DAOFactory;
import economylist.dao.purchase.PurchaseDAO;
import economylist.dao.user.UserDAO;
import economylist.valueobject.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ListOperations", urlPatterns = "/ListOperations")
public class ListOperationsServlet extends HttpServlet {

    private String[] selectedOptions;
    private User user;
    private static Logger LOG = Logger.getLogger(ListOperationsServlet.class);
    private String email;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        selectedOptions = req.getParameterValues("selected");
        DAOFactory daoFactory = new DAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        email = req.getParameter("email");
        user = userDAO.getUserByEmail(email);
        req.setAttribute("user", user);
        req.getRequestDispatcher("purchaseList.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String change = req.getParameter("change");
        String delete = req.getParameter("delete");
        DAOFactory daoFactory = new DAOFactory();
        PurchaseDAO purchaseDAO = daoFactory.getPurchaseDAO();

        if(change != null){
            LOG.debug(change + " changing");
            if(selectedOptions != null && selectedOptions.length == 1){
                LOG.debug(change + " changing - " + selectedOptions[0]);
                req.setAttribute("email", email);
                req.setAttribute("selected",selectedOptions[0]);
                req.getRequestDispatcher("changePurchase.jsp").forward(req,resp);
            }
        }

        if(delete != null){
            LOG.debug(delete + " deleting");
            if(selectedOptions != null){
                for(String s : selectedOptions){
                    Integer i = Integer.valueOf(s);
                    purchaseDAO.deletePurchase(i);
                }
            } else{}
        }

        req.setAttribute("user", user);
        req.getRequestDispatcher("purchaseList.jsp").forward(req,resp);
    }
}