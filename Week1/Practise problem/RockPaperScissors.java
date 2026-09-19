import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors  {

    // Method to determine the result of a round
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int N = 5;

        // Arrays for storing round information
        String[] playerMoves = new String[N];
        String[] computerMoves = new String[N];
        String[] results = new String[N];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] moves = {"Rock", "Paper", "Scissors"};

        System.out.println("===== ROCK PAPER SCISSORS GAME =====");

        // Play N rounds
        for (int i = 0; i < N; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter your move (Rock/Paper/Scissors): ");

            String playerMove = sc.nextLine();

            // Validate input
            while (!playerMove.equalsIgnoreCase("Rock") &&
                   !playerMove.equalsIgnoreCase("Paper") &&
                   !playerMove.equalsIgnoreCase("Scissors")) {

                System.out.print("Invalid move! Enter Rock, Paper or Scissors: ");
                playerMove = sc.nextLine();
            }

            // Convert first letter to uppercase format
            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            // Generate computer move randomly
            String computerMove = moves[random.nextInt(3)];

            // Determine result
            String result = playRound(playerMove, computerMove);

            // Store data in arrays
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            // Display round result
            System.out.println("Player Move   : " + playerMove);
            System.out.println("Computer Move : " + computerMove);
            System.out.println("Result        : " + result);

            // Update statistics
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        // Calculate win percentage
        double winPercentage = (wins * 100.0) / N;

        // Final summary
        System.out.println("\n\n========== FINAL SUMMARY ==========");

        System.out.printf("%-8s %-15s %-18s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < N; i++) {
            System.out.printf("%-8d %-15s %-18s %-15s%n",
                    (i + 1),
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("----------------------------------------------------------");

        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.2f%%%n", winPercentage);

        sc.close();
    }
}