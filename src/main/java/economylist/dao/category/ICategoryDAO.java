package economylist.dao.category;

import economylist.valueobject.Category;

import java.util.List;


public interface ICategoryDAO {

    List<Category> getCategoies();
    List<Category> getSubCategories(int categoryID);
}
