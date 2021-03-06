package economylist.dao.purchase;

import economylist.valueobject.Purchase;

import java.util.List;
import java.sql.Date;

public interface IPurchaseDAO {

    List<Purchase> getAllByUserID(int userID);
    Purchase getPurchaseByID(int ID);
    void addPurchase(Purchase purchase, int userID, int categoryID);
    boolean deletePurchase(int ID);
    boolean updatePurchase(Purchase purchase, int ID);
    double getSumByMonth(Date d, int ID);
}
