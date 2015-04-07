package economylist.dao.category;

import economylist.valueobject.Category;

import java.util.List;


public interface ICategoryDAO {

    List<Category> getCategories();
    Category getCategoryByPurchase(int purchaseID);
    List<Category> getSubCategories(int categoryID);
}
