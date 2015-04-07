package economylist.dao;

import economylist.dao.category.CategoryDAO;
import economylist.dao.purchase.PurchaseDAO;
import economylist.dao.recommendation.RecommendationDAO;
import economylist.dao.user.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Den on 12.03.2015.
 */
public class DAOFactory implements IDAOFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/economylist";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection(){

        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAO();
    }

    @Override
    public PurchaseDAO getPurchaseDAO() {
        return new PurchaseDAO();
    }

    @Override
    public RecommendationDAO getRecommendationDAO() {
        return new RecommendationDAO();
    }

    @Override
    public CategoryDAO getCategoryDAO() { return new CategoryDAO(); }
}
