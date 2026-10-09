import java.util.Random;

public class RockPaperScissorsGame {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computerMoves = {"Scissors", "Paper", "Rock", "Paper", "Rock"};
        
        int wins = 0;
        int losses = 0;
        int draws = 0;
        
        for (int i = 0; i < 5; i++) {
            String playerMove = playerMoves[i];
            String computerMove = computerMoves[i]; // Simulated for demo purposes
            
            String result = playRound(playerMove, computerMove);
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.println("Round " + (i + 1) + " \u2014 Player: " + playerMove + ", Computer: " + computerMove + " | " + result);
        }
        
        double winPercentage = ((double) wins / 5) * 100;
        System.out.println("Final Summary (after 5 rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }
}
