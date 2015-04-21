package economylist.dao.recommendation;

import economylist.valueobject.Recommendation;

import java.util.List;
/**
 * Created by Den on 11.03.2015.
 */
public interface IRecommendationDAO {

    List<Recommendation> getAllRecs(int userID, int[] recArray);


}
