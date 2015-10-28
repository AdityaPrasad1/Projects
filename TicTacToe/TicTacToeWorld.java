import java.awt.Color;
import info.gridworld.grid.Grid;
import info.gridworld.world.World;
import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;

public class TicTacToeWorld extends World<Piece>
{
    private String whosTurn;
    private boolean gameOver;

    public TicTacToeWorld()
    {
        super(new BoundedGrid<Piece>(3,3));
        whosTurn="X";
        gameOver=false;
        setMessage("Welcome to TIC TAC TOE!  - -  Click a spot - "+whosTurn+" turn.");
    }

    //this method is called when a mouse click occurs
    //this method will draw Xs and Os at the location clicked
    public boolean locationClicked(Location loc)
    {
        Grid<Piece> grid = getGrid();
        if(grid==null)
            return false;

        //if the game is over, clear the board and get ready to play a new game
        if(gameOver==true)
        {
            resetWorld();
            gameOver = false;
            setMessage("Click a spot - " + whosTurn + "'s turn.\nClick the step button to check for a winner!");
            return true;
        }

        //this section will draw an X or an O
        Piece piece = grid.get(loc);
        if(whosTurn.equals("X")&&piece==null)
        {
            add(loc,new Piece("X",Color.BLACK, Color.RED));
            whosTurn="O";
        }
        else if(whosTurn.equals("O")&&piece==null)
        {
            add(loc,new Piece("O",Color.YELLOW, Color.BLUE));
            whosTurn="X";

        }
        setMessage("Click a spot - " + whosTurn + "'s turn.\nClick the step button to check for a winner!");

        step();

        return true;
    }

    //this method will be called each time the step button is pressed
    public void step()
    {
        Grid<Piece> grid = getGrid();
        if(grid == null)
            return;

        String winner = getWinner();
        if(! winner.equals("no winner"))
        {
            setMessage("And the winner is . . . . "+winner+".\nClick anywhere on the board to play another game!");
            gameOver = true;
        }
    }
    //this method will determine if someone has won the game
    public String getWinner()
    {
        Grid<Piece> grid = getGrid();
        if(grid==null)
            return "no winner";

        String winner="";
        for (int r = 0; r<grid.getNumRows(); r++)
        {
            Piece row0 = grid.get(new Location(r,0));
            Piece row1 = grid.get(new Location(r,1));
            Piece row2 = grid.get(new Location(r,2));

            if(row0==null||row1==null||row2==null) continue;

            if(row0.getName().equals(row1.getName())&&row0.getName().equals(row2.getName()))
            {
                winner=row0.getName()+" wins horizontally!";
                break;
            }
        }

        //check for vertical winner
        for (int c = 0; c<grid.getNumCols(); c++)
        {
            Piece col0 = grid.get(new Location(0,c));
            Piece col1 = grid.get(new Location(1,c));
            Piece col2 = grid.get(new Location(2,c));

            if(col0==null||col1==null||col2==null) continue;

            if(col0.getName().equals(col1.getName())&&col0.getName().equals(col2.getName()))
            {
                winner=col0.getName()+" wins vertically!";
                break;
            }
        }

        //check for diagonal winner
        {
            Piece diag0 = grid.get(new Location(0,0));
            Piece diag1 = grid.get(new Location(1,1));
            Piece diag2 = grid.get(new Location(2,2));

            if(diag0!=null&&diag1!=null&&diag2!=null)

                if(diag0.getName().equals(diag1.getName())&&diag0.getName().equals(diag2.getName()))
                {
                    winner=diag0.getName()+" wins diagonally!";
            }

        }

        {
            Piece diag00 = grid.get(new Location(0,2));
            Piece diag01 = grid.get(new Location(1,1));
            Piece diag02 = grid.get(new Location(2,0));

            if(diag00!=null&&diag01!=null&&diag02!=null)

                if(diag00.getName().equals(diag01.getName())&&diag00.getName().equals(diag02.getName()))
                {
                    winner=diag00.getName()+" wins diagonally!";
            }

        }

        if(isWorldFull() && winner.length()==0){
            winner =  "cat's game - no winner!\n\n";
        }
        else if(!isWorldFull() && winner.length()==0){
            winner="no winner";
        }
        return winner;
    }

    //this method will determine if the board if full of Xs and Os
    public boolean isWorldFull()
    {
        if(getGrid().getOccupiedLocations().size() == 9)
        {
            return true;
        }
        return false;
    }

    //this method will clear the board of all Xs and Os
    public void resetWorld()
    {
        Grid<Piece> grid = getGrid();
        for(Location l: grid.getOccupiedLocations())
        {
            grid.remove(l);
        }
    }
}
