package be.brahms.exceptions.tournament;

public class NotFoundTournamentException extends TournamentException{

    public NotFoundTournamentException(String message) {
        super(message);
    }

    public NotFoundTournamentException() {
        super("Le tournois que vous cherchez n'existe pas ");
    }

}
