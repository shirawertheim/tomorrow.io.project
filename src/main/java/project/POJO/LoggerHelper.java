package project.POJO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerHelper {
    public static final Logger logger = LoggerFactory.getLogger(LoggerHelper.class);

    private LoggerHelper() {
        throw new IllegalStateException("LoggerHelper class");
    }
}
