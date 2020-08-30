package vaish.niit.Controller;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sravanthi.niit.DAO.ProductDaoIntf;
import sravanthi.niit.Model.Product;

@Controller
public class UserController {
	@Autowired
	ProductDaoIntf productdao;
	
	@RequestMapping("/loginsuccess")
	public String loginSuccess(HttpSession session,Model m)
	{
		String page=" ";
		boolean loggedIn=false;
		SecurityContext scontext=SecurityContextHolder.getContext();
		Authentication authentication=scontext.getAuthentication();
		String username=authentication.getName();
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				List<Product> productList=productdao.listProducts();
				m.addAttribute("productList",productList);
				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
				
			}
		}
		return page;
	}
	
	@RequestMapping("/perform_logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
}


