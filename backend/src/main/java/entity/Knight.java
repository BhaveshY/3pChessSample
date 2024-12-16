package entity;

import common.Colour;
import common.Direction;

import static utility.MovementUtil.step;

/**
 * Knight class extends BasePiece. Move directions for the Knight, the polygons
 * to be highlighted, and its legal moves are checked here
 **/
public class Knight extends BasePiece {

    private static final String TAG = "KNIGHT";

    /**
     * Knight constructor
     * @param colour: Colour of the chess piece being initiated
     * */
    public Knight(Colour colour) {
        super(colour);
    }

    /**
     * Method to initialize directions for a chess piece
     **/
    @Override
    protected void setupDirections() {
        this.directions = new Direction[][] {{Direction.FORWARD,Direction.FORWARD,Direction.LEFT},
                {Direction.FORWARD,Direction.FORWARD,Direction.RIGHT},{Direction.FORWARD,Direction.LEFT,Direction.LEFT},
                {Direction.FORWARD,Direction.RIGHT,Direction.RIGHT},{Direction.BACKWARD,Direction.BACKWARD,Direction.LEFT},
                {Direction.BACKWARD,Direction.BACKWARD,Direction.RIGHT},{Direction.BACKWARD,Direction.LEFT,Direction.LEFT},
                {Direction.BACKWARD,Direction.RIGHT,Direction.RIGHT},{Direction.LEFT,Direction.LEFT,Direction.FORWARD},
                {Direction.LEFT,Direction.LEFT,Direction.BACKWARD},{Direction.LEFT,Direction.FORWARD,Direction.FORWARD},
                {Direction.LEFT,Direction.BACKWARD,Direction.BACKWARD},{Direction.RIGHT,Direction.RIGHT,Direction.FORWARD},
                {Direction.RIGHT,Direction.RIGHT,Direction.BACKWARD},{Direction.RIGHT,Direction.FORWARD,Direction.FORWARD},
                {Direction.RIGHT,Direction.BACKWARD,Direction.BACKWARD}};
    }

    /**
     * Returns custom string representation of the class
     * @return String
     * */
    @Override
    public String toString() {
        return this.colour.toString()+"N";
    }
}
