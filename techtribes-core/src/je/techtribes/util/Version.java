package je.techtribes.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Version {

    private static final String BUILD_VERSION_KEY = "build.number";
    private static final String BUILD_TIMESTAMP_KEY = "build.timestamp";

    private static String version;
    private static Date buildTimestamp;

    private static final Log log = LogFactory.getLog(Version.class);

    static {
        try {
            Properties buildProperties = new Properties();
            InputStream in = Version.class.getClassLoader().getResourceAsStream("build.properties");
            DateFormat format = new SimpleDateFormat("dd MMM yyyy HH:mm");
            if (in != null) {
                buildProperties.load(in);
                version = buildProperties.getProperty(BUILD_VERSION_KEY);
                buildTimestamp = format.parse(buildProperties.getProperty(BUILD_TIMESTAMP_KEY));
                in.close();
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static String getBuildNumber() {
        return version;
    }

    public static Date getBuildTimestamp() {
        return buildTimestamp;
    }

}
