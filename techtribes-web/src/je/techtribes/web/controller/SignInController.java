package je.techtribes.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignInController extends AbstractController {

    private static Log log = LogFactory.getLog(SignInController.class);

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String showHomePage(ModelMap model, HttpServletRequest request) {
        Connection<?> connection = ProviderSignInUtils.getConnection(new ServletWebRequest(request));
        if (connection != null) {
            log.error(connection);
        }

        addCommonAttributes(model);
        setPageTitle(model, "Sign in");

		return "signin";
	}

}
