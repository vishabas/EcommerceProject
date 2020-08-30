package vaish.niit.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController { 
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	
	@RequestMapping(value="/home")
	public String home(){
		return "Home";
	}

	@RequestMapping(value="/register")
	public String register(){
		return "Register";


}
}
