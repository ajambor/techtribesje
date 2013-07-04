package je.techtribes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController extends AbstractController {

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
        addCommonAttributes(model);
        setPageTitle(model, "Sign up");

		return "signup";
	}

}
