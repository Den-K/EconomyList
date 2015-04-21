package economylist.servlet;

import economylist.dao.DAOFactory;
import economylist.dao.purchase.PurchaseDAO;
import economylist.dao.user.UserDAO;
import economylist.valueobject.Purchase;
import economylist.valueobject.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Den on 22.04.2015.
 */
@WebServlet(name="ChangePurchase", urlPatterns = "/ChangePurchase")
public class ChangePurchaseServlet extends HttpServlet {

    private User user;
    private static Logger LOG = Logger.getLogger(ChangePurchaseServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOFactory daoFactory = new DAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        String email = req.getParameter("email");
        String id = req.getParameter("id");

        String purchaseName = req.getParameter("name");
        String purchaseNumber = req.getParameter("number");
        String purchaseDate = req.getParameter("date");
        String purchaseCost = req.getParameter("cost");

        if(!(purchaseName.equals("") || purchaseNumber.equals("")
                || purchaseDate.equals("") || purchaseCost.equals(""))) {

            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(purchaseDate);
            } catch (ParseException e) {
                LOG.error(e.getMessage());
            }

            Purchase purchase = new Purchase();
            purchase.setName(purchaseName);
            purchase.setNumber(Integer.valueOf(purchaseNumber));
            purchase.setDate(date);
            purchase.setCost(Float.valueOf(purchaseCost));

            PurchaseDAO purchaseDAO = daoFactory.getPurchaseDAO();
            purchaseDAO.updatePurchase(purchase, Integer.valueOf(id));

            user = userDAO.getUserByEmail(email);
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("purchaseList.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", user);
        req.getRequestDispatcher("purchaseList.jsp").forward(req,resp);
    }
}
