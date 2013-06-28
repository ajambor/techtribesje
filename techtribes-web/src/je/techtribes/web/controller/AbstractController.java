package je.techtribes.web.controller;

import je.techtribes.component.contentsource.ContentSourceComponent;
import je.techtribes.domain.ContentSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;

public class AbstractController {

    protected ContentSourceComponent contentSourceComponent;

    @Autowired
    public void setContentSourceComponent(ContentSourceComponent contentSourceComponent) {
        this.contentSourceComponent = contentSourceComponent;
    }

    protected void addCommonAttributes(ModelMap model) {
        model.addAttribute("peopleAndTribes", contentSourceComponent.getPeopleAndTribes());

        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            model.addAttribute("user", lookupContentSourceBySignedInTwitterId());
        }
    }

    protected void setPageTitle(ModelMap model, String title) {
        if (title != null && !title.isEmpty()) {
            model.addAttribute("pageTitle", "- " + title);
        }
    }

    protected void setPageTitle(ModelMap model, String title1, String title2) {
        setPageTitle(model, title1 + " - " + title2);
    }

    protected void setPageTitle(ModelMap model, String title1, String title2, String title3) {
        setPageTitle(model, title1 + " - " + title2 + " - " + title3);
    }

    protected ContentSource lookupContentSourceBySignedInTwitterId() {
        String twitterId = SecurityContextHolder.getContext().getAuthentication().getName();
        return contentSourceComponent.findByTwitterId(twitterId);
    }

}
