import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;

public class SnakeWorld extends ActorWorld
{
    private int foodDelay;
    private Snake snake;

    public SnakeWorld(int width, int height)
    {
        super(new BoundedGrid<Actor>(width, height));
        Grid<Actor> grid = getGrid();
        snake = new Snake();
        snake.putSelfInGrid(grid, new Location(4,7));
        foodDelay = (int)(Math.random()*grid.getNumRows() * 3);
        setMessage("The Snake Game - Candle As Many Cakes As You Can!");
    }

    public void step()
    {
        if(snake.isDead())
        {
            setMessage("Your candles are extinguished!  They lit "+ snake.getFoodEaten() + " cakes!");
        }
        else
        {
            Grid<Actor> grid = getGrid();
            if(grid == null)
            {
                return;
            }
            setMessage("The Snake Game!!! - " + snake.getFoodEaten() + " cakes lit so far!");

            if(isFoodAllGone())
            {
                addFood();
            }
        }
        snake.move();
    }

    public boolean isFoodAllGone()
    {
        //check the grid to see if any Food remains
        ArrayList<Location> all = getGrid().getOccupiedLocations();
        for(Location item : all)
        {
            if(getGrid().get(item) instanceof Food)
            {
                return false;
            }
        }

        return true;
    }

    public void addFood()
    {
        int r = (int)(Math.random() * getGrid().getNumRows());
        int c = (int)(Math.random() * getGrid().getNumCols());
        Location newfood = new Location(r,c);
        Grid<Actor> gr = getGrid();

        while(gr.get(newfood) != null)
        {
            r = (int)(Math.random() * getGrid().getNumRows());
            c = (int)(Math.random() * getGrid().getNumCols());
            newfood = new Location(r,c);
        }
        Food jimmy = new Food();
        jimmy.putSelfInGrid(gr, newfood);
    }

    public boolean keyPressed(String description, Location loc)
    {
        snake.setDirection(description);
        return true;
    }
}
