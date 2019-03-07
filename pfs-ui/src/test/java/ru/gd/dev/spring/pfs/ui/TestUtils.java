package ru.gd.dev.spring.pfs.ui;

/**
 * @autor Eremin Artem on 25.02.2019.
 */

public class TestUtils {

    public static String getDriverPath(){
        final StringBuilder path = new StringBuilder();
        path.append("src/main/resources/drivers/geckodriver");
        final String oc = System.getProperty("os.name");
        if(oc.contains("Win")) path.append(".exe");
        return path.toString();
    }
}
