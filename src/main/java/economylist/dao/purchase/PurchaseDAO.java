package economylist.dao.purchase;

import economylist.dao.DAOFactory;
import economylist.valueobject.Purchase;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO implements IPurchaseDAO{

    private static Logger LOG = Logger.getLogger(PurchaseDAO.class);

    @Override
    public List<Purchase> getAllByUserID(int ID) {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Purchase> purchaseList = new ArrayList<Purchase>();
        try {
            st = con.prepareStatement("SELECT id, name, date, number, cost FROM purchase WHERE id_user = ?");
            st.setInt(1,ID);
            rs = st.executeQuery();

            while(rs.next()){
                Purchase purchase = new Purchase();
                purchase.setId(rs.getInt(1));
                purchase.setName(rs.getString(2));
                purchase.setDate(rs.getDate(3));
                purchase.setNumber(rs.getInt(4));
                purchase.setCost(rs.getFloat(5));
                purchaseList.add(purchase);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if(st != null) st.close();
                if(con != null) con.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return purchaseList;
    }

    @Override
    public void addPurchase(Purchase purchase) {

    }

    @Override
    public boolean deletePurchase(int ID) {
        return true;
    }

    @Override
    public boolean updatePurchase(int ID) {
        return true;
    }
}
