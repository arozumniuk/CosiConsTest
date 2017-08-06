package main.java;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Config {

    private static EnvironmentType currentEnvironmentType = EnvironmentType.DD;
    private static String currentBrowser = "chrome";


    /**
     * Returns environment URL for <sitename></sitename> by specified environment name
     *
     * @return String with environment URL
     */
    public static String getStartUrl(EnvironmentType environmentName) {

        Map<EnvironmentType, String> environmentUrl = new HashMap<EnvironmentType, String>();
        environmentUrl.put(EnvironmentType.DD, Paths.get("src/main/resources/application/index.html").toUri().toString());
        return environmentUrl.get(environmentName);
    }

    public static EnvironmentType getCurrentEnvironmentType() {
        return (Objects.equals(System.getProperty("environmentName"), null)) ? currentEnvironmentType : EnvironmentType.valueOf(System.getProperty("environmentName"));
    }


    public static String getStartUrl() {
        return getStartUrl(getCurrentEnvironmentType());
    }


    /**
     * Selects one of available LogLevels.
     */
    public static int getLogLevel() {
        return Logger.LOG_LEVEL_INFO;
    }

    /**
     * Use this function to specify ImplicitlyWait for WebDriver
     *
     * @return int seconds
     */
    public static int getDefaultImplicitlyWait() {
        return 2;
    }

    public static String getBrowserName() {
        return currentBrowser;
    }


}
