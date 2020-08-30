package vaish.niit.DAO;

import java.util.List;

import vaish.niit.Model.Category;

public interface CategoryDAO {
	
	public boolean addCategory(Category category);
    public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listcategories();

}



