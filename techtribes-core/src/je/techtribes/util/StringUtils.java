package je.techtribes.util;

/**
 * A collection of utility methods for manipulating strings.
 */
public final class StringUtils {

    public static final int DEFAULT_MAX_CONTENT_LENGTH = 255;

    public static String filterHtml(String s) {
        if (s == null) {
            return null;
        }

        s = s.replaceAll("&lt;", "");
        s = s.replaceAll("&gt;", "");
        s = s.replaceAll("&nbsp;", "");
        s = s.replaceAll("(?s)<!--.*?-->", "");
        return s.replaceAll("(?s)<.*?>", "");
    }

    public static String filterHtmlAndTruncate(String s) {
        return filterHtmlAndTruncate(s, DEFAULT_MAX_CONTENT_LENGTH);
    }

    public static String filterHtmlAndTruncate(String s, int maxLength) {
        String content = filterHtml(s);
        if (content == null) {
            return "";
        } else {
            if (content.length() > maxLength) {
                return content.substring(0, maxLength-3) + "...";
            } else {
                return content;
            }
        }
    }

}