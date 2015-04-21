package economylist.dao.recommendation;

import economylist.dao.DAOFactory;
import economylist.valueobject.Recommendation;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Den on 11.03.2015.
 */
public class RecommendationDAO implements IRecommendationDAO {

    private static Logger LOG = Logger.getLogger(RecommendationDAO.class);

    @Override
    //parameters are ID of user and array of his recommendations to be created from getAllByUserID
    public List<Recommendation> getAllRecs(List<Integer> categoryID) {
        Connection con = DAOFactory.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Recommendation> recList = new ArrayList<Recommendation>();

            try {
                for(Integer i : categoryID) {
                    st = con.prepareStatement("SELECT id, text FROM recommendation WHERE category_id = ?");
                    st.setInt(1, i);
                    rs = st.executeQuery();

                    while (rs.next()) {
                        Recommendation recommendation = new Recommendation();
                        recommendation.setId(rs.getInt(1));
                        recommendation.setText(rs.getString(2));
                        recList.add(recommendation);
                    }
                }
            } catch (SQLException e) {
                LOG.error(e.getMessage());

            } finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                    if (rs != null) rs.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }

        return recList;

    }

}
