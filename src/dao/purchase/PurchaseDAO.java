package dao.purchase;

import valueobject.Purchase;

import java.util.List;

/**
 * Created by Den on 11.03.2015.
 */
public class PurchaseDAO implements IPurchaseDAO{

    @Override
    public List<Purchase> getAll() {
        return null;
    }

    @Override
    public void addPurchase(Purchase purchase) {

    }

    @Override
    public boolean deletePurchase(int id) {
        return true;
    }

    @Override
    public boolean updatePurchase(int id) {
        return true;
    }
}
