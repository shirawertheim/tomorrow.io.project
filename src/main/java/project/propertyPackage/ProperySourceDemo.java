package project.propertyPackage;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("application.properties")
public class ProperySourceDemo implements InitializingBean {

    @Autowired
    Environment env;

    @Override
    public void afterPropertiesSet() throws Exception {
        setDatabaseConfig();
    }

    private void setDatabaseConfig() {
        DataSourceConfig config = new DataSourceConfig();
        config.setDriver(env.getProperty("jdbc.driver"));
        config.setUrl(env.getProperty("jdbc.url"));
        config.setUsername(env.getProperty("jdbc.username"));
        config.setPassword(env.getProperty("jdbc.password"));
        System.out.println(config.toString());
    }
}