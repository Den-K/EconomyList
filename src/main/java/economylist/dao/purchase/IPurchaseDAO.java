package economylist.dao.purchase;

import economylist.valueobject.Purchase;

import java.util.List;

/**
 * Created by Den on 11.03.2015.
 */
public interface IPurchaseDAO {

    List<Purchase> getAllByUserID(int ID);
    void addPurchase(Purchase purchase);
    boolean deletePurchase(int ID);
    boolean updatePurchase(int ID);
}
