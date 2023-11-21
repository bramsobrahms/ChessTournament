package be.brahms.exceptions.player;

public class NotFoundPlayerException extends PlayerException{

    public NotFoundPlayerException() {
        super("Cet ID n'existe pas");
    }

    public NotFoundPlayerException(String message) {
        super(message);
    }

}
