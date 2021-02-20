package tech.becoming.clickandcollect.app.core;

import tech.becoming.clickandcollect.app.core.auth.UsersStorage;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static tech.becoming.clickandcollect.app.core.auth.UsersStorage.IN_MEMORY;

@Component
@ConfigurationProperties("app.security")
public class SecurityProperties {

    private UsersStorage storage = IN_MEMORY;

    public UsersStorage getStorage() {
        return storage;
    }

    public void setStorage(UsersStorage storage) {
        this.storage = storage;
    }
}
