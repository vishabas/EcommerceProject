package vaish.niit.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/category")
	public String showCategory(Model m)
	{
		Category category=new Category();
		List<Category> listcategories=categoryDAO.listcategories();
		m.addAttribute(category);
		m.addAttribute("categoryList", listcategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/insertCategory",method=RequestMethod.POST)
	public String saveCategoryDetail(@RequestParam("catName")String categoryName,@RequestParam("catDesc") String categoryDesc,Model m)
	{
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDAO.addCategory(category);
		
	
		List<Category> listcategories=categoryDAO.listcategories();
		m.addAttribute("categoryList", listcategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deletecategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		List<Category> listcategorys=categoryDAO.listcategories();
		m.addAttribute("categoryList", listcategorys);
		
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editcategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		m.addAttribute("category",category);
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	 public String updateCategory(Model m,@RequestParam("catId")int categoryID,@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc)
	 {
		 Category category=categoryDAO.getCategory(categoryID);
		 category.setCategoryName(categoryName);
		 category.setCategoryDesc(categoryDesc);
		 categoryDAO.updateCategory(category);
		 List<Category> listcategories=categoryDAO.listcategories();
		 m.addAttribute("categoryList",listcategories);
		 return "Category";
	 }
	
	

}

}
