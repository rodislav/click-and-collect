package fr.ul.miage.clickandcollect.core.auth;

public interface PasswordChecker {

    boolean areEqual(String source, String target);

}
