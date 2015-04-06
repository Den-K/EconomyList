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
    public List<Category> getCategoies() {

        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Category> categoryList = new ArrayList<Category>();
        try {
            st = con.prepareStatement("SELECT id, name FROM category WHERE category_id = ?");
            st.setInt(1,0);
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
    public List<Category> getSubCategories(int categoryID) {
        return null;
    }
}
