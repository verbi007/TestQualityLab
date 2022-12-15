package dataProvider;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("mail.url");
    String URL_SEND_TO = readConfig().getString("mail.url_send_to");
    String LOGIN = readConfig().getString("auth.login");
    String PASSWORD = readConfig().getString("auth.password");
}
