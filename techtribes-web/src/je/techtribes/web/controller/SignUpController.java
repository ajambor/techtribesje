package je.techtribes.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignUpController extends AbstractController {

    private static Log log = LogFactory.getLog(SignUpController.class);

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showHomePage(ModelMap model, HttpServletRequest request) {
        addCommonAttributes(model);
        setPageTitle(model, "Sign up");

		return "signup";
	}

}
