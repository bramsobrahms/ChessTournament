package be.brahms.exceptions.player;

public abstract class PlayerException extends RuntimeException{

    public PlayerException(String message) {
        super(message);
    }
}
