package economylist.servlet;

import economylist.valueobject.User;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="PurchaseList", urlPatterns = "/PurchaseList")
public class PurchaseListServlet extends HttpServlet {

    private static Logger LOG = Logger.getLogger(PurchaseListServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("purchaseList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("purchaseList.jsp").forward(request, response);
    }

}
