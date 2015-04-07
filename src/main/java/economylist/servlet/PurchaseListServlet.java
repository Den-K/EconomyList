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

@WebServlet(name="PurchaseList", urlPatterns = "/PurchaseList")
public class PurchaseListServlet extends HttpServlet {

    private static Logger LOG = Logger.getLogger(PurchaseListServlet.class);
    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        DAOFactory daoFactory = new DAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        user = userDAO.getUserByEmail(email);

        String purchaseName = request.getParameter("name");
        String purchaseNumber = request.getParameter("number");
        String purchaseDate = request.getParameter("date");
        String purchaseCost = request.getParameter("cost");
        String categoryID = request.getParameter("category");

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
            purchaseDAO.addPurchase(purchase, user.getId(), Integer.parseInt(categoryID));

            request.setAttribute("user", user);
            request.getRequestDispatcher("purchaseList.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", user);
        request.getRequestDispatcher("purchaseList.jsp").forward(request, response);
    }

}
