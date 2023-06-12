import java.util.Random;
import java.util.Scanner;

public class DiceBoardGame {
    private static int target;
    private static int[] scores;
    private static boolean[] completedPlayers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int num = sc.nextInt();

        System.out.print("Enter the target score: ");
        target = sc.nextInt();

        scores = new int[num];
        completedPlayers = new boolean[num];

        playGame();
        sc.close();
        System.out.println(" Game Over! ");
    }

    public static void playGame() {
        Random random = new Random();
        int currentP = 0;

        while (true) {
            int roll = random.nextInt(6) + 1; // Simulate dice roll
            scores[currentP] += roll;
            System.out.println("Player " + (currentP + 1) + " rolled a " + roll + ". Score: " + scores[currentP]);

            if (scores[currentP] >= target) {
                System.out.println("Player " + (currentP + 1) + " wins!");
                break;
            }

            currentP = (currentP + 1) % scores.length;

            if (isGameComplete()) {
                System.out.println("All players completed . No winner.");
                break;
            }
        }
    }

    public static boolean isGameComplete() {
        for (int i = 0; i < scores.length; i++) {
            if (!completedPlayers[i] && scores[i] < target)
                return false;
            completedPlayers[i] = true;
        }
        return true;
    }
}