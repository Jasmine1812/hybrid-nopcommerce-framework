package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"file:environmentConfig/${env}.properties"})
public interface Environment extends Config {
    @Key("App.Url")
    String appUrl();

    @Key("App.Username")
    String appUsername();

    @Key("App.Password")
    String appPassword();

    String dbUrl();

}
