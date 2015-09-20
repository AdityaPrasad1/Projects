import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
    private String personChoice;
    private String compChoice;

    public RockPaperScissors(String person)
    {
        setPlayers(person);
    }

    public void setPlayers(String person)
    {
        personChoice = person;
        int weapon = (int)(Math.random()*3);

        if(weapon == 0)
        {
            compChoice = "rock";
        }
        else if (weapon == 1)
        {
            compChoice = "paper";
        }
        else if (weapon == 2)
        {
            compChoice = "scissors";
        }
    }


    public String determineWinner()
    {
        String winner="";

        if(personChoice.equals("rock") && compChoice.equals("paper"))
        {
            winner = "Computer";
        }
        else if(personChoice.equals("paper") && compChoice.equals("scissors"))
        {
            winner = "Computer";
        }
        else if(personChoice.equals("scissors") && compChoice.equals("rock"))
        {
            winner = "Computer";
        }
        else if(personChoice.equals("paper") && compChoice.equals("rock"))
        {
            winner = "Person";
        }
        else if(personChoice.equals("scissors") && compChoice.equals("rock"))
        {
            winner = "Person";
        }
        else if(personChoice.equals("rock") && compChoice.equals("scissors"))
        {
            winner = "Person";
        }
        else if(personChoice.equals(compChoice))
        {
            winner = "Draw";
        }

        return winner;
    }


    public String toString()
    {
        String output="";

        output += "Player had " + personChoice + "\n";
        output += "Computer had " + compChoice + "\n";
        output += "Winner was " + determineWinner() + "\n\n";

        return output;
    }
}
