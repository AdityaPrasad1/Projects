import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.world.World;
import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;

public class Snake
{
    private Actor head;
    private Actor tail;
    private int foodEaten;
    private boolean didEat;
    private boolean isDead;

    public Snake()
    {
        head = new Section();
        head.setDirection(0);
        tail = head;
        foodEaten = 0;
        isDead = false;
    }

    public void putSelfInGrid(Grid<Actor> grid, Location loc)
    {
        head.putSelfInGrid(grid, loc);
    }

    public void move()
    {
        Grid<Actor> gr = head.getGrid();
        //make sure snake is not dead and that the grid is not null
        if(!isDead() && gr != null)
        {
            //make  new Section for this Snake
            Section newhead = new Section();

            int dir = head.getDirection();
            Location loc = head.getLocation();
            Location next = loc.getAdjacentLocation(dir);

            Actor neighbor = gr.get(next);

            if(gr.isValid(next))
            {
                if(neighbor == null)
                {
                    newhead.putSelfInGrid(gr, next);
                    newhead.setDirection(dir);
                    head = newhead;
                    removeTail();
                    didEat = false;
                }
                else if(neighbor instanceof Food)
                {
                    neighbor.removeSelfFromGrid();
                    newhead.putSelfInGrid(gr, next);
                    head = newhead;
                    newhead.setDirection(dir);
                    foodEaten++;
                    didEat = true;
                }
                else if(neighbor instanceof Section)
                {
                    isDead = true;
                    return;
                }
            }
            else
            {
                isDead = true;
                return;
            }
        }


    }

    public void removeTail()
    {
        //if the snake is moving normally
        //the tail gets removed as a new section is added to the front
        Grid<Actor> gr = tail.getGrid();
        Location tailLoc = tail.getLocation();
        int tailDir = tail.getDirection();
        Location front = tailLoc.getAdjacentLocation(tailDir);
        Section newTail = (Section)gr.get(front);
        tail.removeSelfFromGrid();
        tail = newTail;
    }

    public void setDirection(String dir)
    {
        if(dir.equals("UP"))
        {
            head.setDirection(0);
        }
        else if(dir.equals("RIGHT"))
        {
            head.setDirection(90);
        }
        else if(dir.equals("DOWN"))
        {
            head.setDirection(180);
        }
        else if(dir.equals("LEFT"))
        {
            head.setDirection(270);
        }
    }

    public int getFoodEaten()
    {
        return foodEaten;
    }

    public void setFoodEaten(int amount)
    {
        foodEaten = amount;
    }

    public boolean isDead()
    {
        return isDead;
    }
}
