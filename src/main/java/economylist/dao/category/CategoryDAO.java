package economylist.dao.category;

import economylist.dao.DAOFactory;
import economylist.valueobject.Category;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {

    private static Logger LOG = Logger.getLogger(CategoryDAO.class);

    @Override
    public List<Category> getCategories() {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Category> categoryList = new ArrayList<Category>();
        try {
            st = con.prepareStatement("SELECT id, name FROM category WHERE category_id <> 0");
            //st.setInt(1,0);
            rs = st.executeQuery();

            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                categoryList.add(category);
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
        return categoryList;
    }

    @Override
    public Category getCategoryByPurchase(int purchaseID) {
        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        Category category = null;
        try {
            st = con.prepareStatement("SELECT category.id, category.name FROM category,purchase " +
                    "WHERE category.id = purchase.category_id AND purchase.id = ?");
            st.setInt(1,purchaseID);
            rs = st.executeQuery();

            while(rs.next()){
                category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
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
        return category;
    }


    @Override
    public List<Category> getSubCategories(int categoryID) {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Category> categoryList = new ArrayList<Category>();
        try {
            st = con.prepareStatement("SELECT id, name FROM category WHERE category_id = ?");
            st.setInt(1,categoryID);
            rs = st.executeQuery();

            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                categoryList.add(category);
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
        return categoryList;
    }
}
