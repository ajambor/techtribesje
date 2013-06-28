package je.techtribes.web.tagext;

import je.techtribes.domain.ContentSource;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class GotoPersonOrTribeTag extends SimpleTagSupport {

    private ContentSource contentSource;

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext)getJspContext();
        JspWriter out = pageContext.getOut();

        if (contentSource != null) {
            out.write(contentSource.isTribe() ?
                    "/tribes/" + contentSource.getShortName():
                    "/people/" + contentSource.getShortName());
        }
    }

    public void setContentSource(ContentSource contentSource) {
        this.contentSource = contentSource;
    }

}
