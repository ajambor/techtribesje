package je.techtribes.web.tagext;

import je.techtribes.util.FriendlyDateFormatter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Date;

public class DateTag extends SimpleTagSupport {

    private Date date;
    private boolean showTime = true;

    @Override
    public void doTag() throws JspException, IOException {
        FriendlyDateFormatter formatter = new FriendlyDateFormatter();
        if (showTime) {
            getJspContext().getOut().write(formatter.formatAsDateWithTime(date));
        } else {
            getJspContext().getOut().write(formatter.formatAsDateWithoutTime(date));
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setShowTime(boolean showTime) {
        this.showTime = showTime;
    }

}
