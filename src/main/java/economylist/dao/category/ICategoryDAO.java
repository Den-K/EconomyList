package economylist.dao.category;

import economylist.valueobject.Category;

import java.util.List;


public interface ICategoryDAO {

    List<Category> getCategories();
    List<Category> getSubCategories(int categoryID);
}
