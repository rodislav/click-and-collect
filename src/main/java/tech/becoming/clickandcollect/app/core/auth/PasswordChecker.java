package tech.becoming.clickandcollect.app.core.auth;

public interface PasswordChecker {

    boolean areEqual(String source, String target);

}
