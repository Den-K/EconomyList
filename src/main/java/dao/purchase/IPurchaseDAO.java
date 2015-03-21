package dao.purchase;

import valueobject.Purchase;

import java.util.List;

/**
 * Created by Den on 11.03.2015.
 */
public interface IPurchaseDAO {

    List<Purchase> getAll();
    void addPurchase(Purchase purchase);
    boolean deletePurchase(int id);
    boolean updatePurchase(int id);
}
