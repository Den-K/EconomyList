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
// Commented code here references to recommendations
        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Purchase> purchaseList = new ArrayList<Purchase>();

        //Array for IDs of harmful categories represented in the list
         /*int [] recArray = new int [5];
        for (int j=0;j<recArray.length; i++) recArray[j]=0;
         */

         //int n = 0;

        try {
            st = con.prepareStatement("SELECT id, name, date, number, cost FROM purchase WHERE id_user = ?");
            //st = con.prepareStatement("SELECT id, name, date, number, cost, category_id FROM purchase WHERE id_user = ?");
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

                //Compare every purchase's category with harmful ones. If matches, add its ID to array.

                /* if (rs.getInt(6) == 6 || rs.getInt(6) == 7)
                {
                recArray[n] = rs.getInt(6);
                    n++;
                }
                */
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

    public Purchase getPurchaseByID(int ID) {
        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        Purchase purchase = new Purchase();

        try {
            st = con.prepareStatement("SELECT id, name, date, number, cost FROM purchase WHERE id = ?");
            st.setInt(1, ID);
            rs = st.executeQuery();

            while(rs.next()){

                purchase.setId(rs.getInt(1));
                purchase.setName(rs.getString(2));
                purchase.setDate(rs.getDate(3));
                purchase.setNumber(rs.getInt(4));
                purchase.setCost(rs.getFloat(5));
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
        return purchase;
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

    //added implementation
    @Override
    public boolean deletePurchase(int ID) {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("DELETE FROM purchase WHERE id = ?");
            st.setInt(1,ID);
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
        return true;
    }

    // added implementation, updated IPurchaseDAO
    @Override
    public boolean updatePurchase(Purchase purchase, int ID) {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("UPDATE purchase SET name = ?, date = ?, number = ?, cost = ? WHERE id = ?");
            st.setString(1, purchase.getName());
            st.setDate(2, new Date(purchase.getDate().getTime()));
            st.setInt(3, purchase.getNumber());
            st.setFloat(4, purchase.getCost());
            st.setInt(5,ID);
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

        return true;
    }

    public double getSumByMonth(Date d, int ID) {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        //List<Purchase> purchaseList = new ArrayList<Purchase>();

        int year = d.getYear();
        int month = d.getMonth();

        double total = 0;

        try {
            //st = con.prepareStatement("SELECT id, name, date, number, cost FROM purchase WHERE id_user = ? AND date like '%" + year + "-0" + month +"%'");
            st = con.prepareStatement("SELECT sum(cost) AS total FROM purchase WHERE id_user = ? AND date like '%" + year + "-0" + month +"%'");
            st.setInt(1,ID);
            rs = st.executeQuery();

            total = rs.getFloat(1);



            /*while(rs.next()){
                Purchase purchase = new Purchase();
                purchase.setId(rs.getInt(1));
                purchase.setName(rs.getString(2));
                purchase.setDate(rs.getDate(3));
                purchase.setNumber(rs.getInt(4));
                purchase.setCost(rs.getFloat(5));
                purchaseList.add(purchase);

            }*/

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
        return total;
    }
}
