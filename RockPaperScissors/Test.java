import java.util.Scanner;
import static java.lang.System.*;
public class Lab10d
{
    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        out.println("Rock-Paper-Scissors");
        char response = 'y';

        while(response != 'n')
        {
            out.print("\nRo-sham-bo! - pick your weapon[rock, paper, scissors]::");
            String yours = keyboard.nextLine();

            RockPaperScissors game = new RockPaperScissors(yours);
            out.println(game);

            out.print("\nDo you want to play again (y/n)? ");
            response = keyboard.nextLine().charAt(0);
        }
    }
}
