package be.brahms.services;

public interface EmailServ {

    void sendingEmail(String to, String subject, String text);

}
