package dao;

import dao.purchase.PurchaseDAO;
import dao.recommendation.RecommendationDAO;
import dao.user.UserDAO;

/**
 * Created by Den on 12.03.2015.
 */
public interface IDAOFactory {

    UserDAO getUserDAO();
    PurchaseDAO getPurchaseDAO();
    RecommendationDAO getRecommendationDAO();

}
