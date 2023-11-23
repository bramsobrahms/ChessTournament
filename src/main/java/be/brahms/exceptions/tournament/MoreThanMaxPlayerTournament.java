package be.brahms.exceptions.tournament;

public class MoreThanMaxPlayerTournament extends TournamentException{

    public MoreThanMaxPlayerTournament(String message) {
        super(message);
    }

    public MoreThanMaxPlayerTournament() {
        super("Vous avez plus de joueur que prévus");
    }
}
