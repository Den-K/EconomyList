package economylist.servlet;

import economylist.dao.DAOFactory;
import economylist.dao.purchase.PurchaseDAO;
import economylist.valueobject.Purchase;
import economylist.valueobject.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name="PurchaseList", urlPatterns = "/PurchaseList")
public class PurchaseListServlet extends HttpServlet {

    private static Logger LOG = Logger.getLogger(PurchaseListServlet.class);
    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user = (User)request.getAttribute("user");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory daoFactory = new DAOFactory();
        PurchaseDAO purchaseDAO = daoFactory.getPurchaseDAO();
        List<Purchase> purchaseList = purchaseDAO.getAllByUserID(user.getId());
        request.setAttribute("purchaseList",purchaseList);
        request.setAttribute("user",user);
        request.getRequestDispatcher("purchaseList.jsp").forward(request, response);
    }

}
