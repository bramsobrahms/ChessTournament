package be.brahms.services;

public interface EmailServ {

    void sendingEmail(String subject, String text,String... to);

}
