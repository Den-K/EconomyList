package economylist.dao.purchase;

import economylist.dao.DAOFactory;
import economylist.valueobject.Purchase;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO implements IPurchaseDAO{

    private static Logger LOG = Logger.getLogger(PurchaseDAO.class);

    @Override
    public List<Purchase> getAllByUserID(int userID) {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Purchase> purchaseList = new ArrayList<Purchase>();
        try {
            st = con.prepareStatement("SELECT id, name, date, number, cost FROM purchase WHERE id_user = ?");
            st.setInt(1,userID);
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
            LOG.error(e.getMessage());

        } finally {
            try {
                if(st != null) st.close();
                if(con != null) con.close();
                if(rs != null) rs.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage());
            }
        }
        return purchaseList;
    }

    @Override
    public void addPurchase(Purchase purchase, int userID, int categoryID) {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement("INSERT INTO purchase (name, date, number, cost, id_user, category_id) VALUES(?,?,?,?,?,?)");
            st.setString(1, purchase.getName());
            st.setDate(2, new Date(purchase.getDate().getTime()));
            st.setInt(3, purchase.getNumber());
            st.setFloat(4, purchase.getCost());
            st.setFloat(5, userID);
            st.setInt(6,categoryID);
            st.executeUpdate();

        } catch (SQLException e) {
            LOG.error(e.getMessage());

        } finally {
            try {
                if(st != null) st.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage());
            }
        }
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
