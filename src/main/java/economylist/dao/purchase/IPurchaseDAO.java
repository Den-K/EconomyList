package economylist.dao.purchase;

import economylist.valueobject.Purchase;

import java.util.List;

public interface IPurchaseDAO {

    List<Purchase> getAllByUserID(int userID);
    void addPurchase(Purchase purchase, int userID, int categoryID);
    boolean deletePurchase(int ID);
    boolean updatePurchase(Purchase purchase, int ID);
}
