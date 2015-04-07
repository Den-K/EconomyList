package economylist.dao;

import economylist.dao.category.CategoryDAO;
import economylist.dao.purchase.PurchaseDAO;
import economylist.dao.recommendation.RecommendationDAO;
import economylist.dao.user.UserDAO;

/**
 * Created by Den on 12.03.2015.
 */
public interface IDAOFactory {

    UserDAO getUserDAO();
    PurchaseDAO getPurchaseDAO();
    RecommendationDAO getRecommendationDAO();
    CategoryDAO getCategoryDAO();

}
