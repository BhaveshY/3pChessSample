package entity;

import common.Colour;
import common.Direction;

import static utility.MovementUtil.step;

/**
 * Queen class extends BasePiece. Move directions for the Queen, the polygons
 * to be highlighted, and its legal moves are checked here
 **/
public class Queen extends BasePiece {

    private static final String TAG = "QUEEN";

    /**
     * Queen constructor
     * @param colour: Colour of the chess piece being initiated
     * */
    public Queen(Colour colour) {
        super(colour);
    }

    /**
     * Method to initialize directions for a chess piece
     **/
    @Override
    protected void setupDirections() {
        this.directions = new Direction[][] {{Direction.FORWARD,Direction.LEFT},{Direction.FORWARD,Direction.RIGHT},
                {Direction.LEFT,Direction.FORWARD},{Direction.RIGHT,Direction.FORWARD},{Direction.BACKWARD,Direction.LEFT},
                {Direction.BACKWARD,Direction.RIGHT},{Direction.LEFT,Direction.BACKWARD},{Direction.RIGHT,Direction.BACKWARD},
                {Direction.FORWARD},{Direction.BACKWARD},{Direction.LEFT},{Direction.RIGHT}};
    }

    /**
     * Returns custom string representation of the class
     * @return String
     * */
    @Override
    public String toString() {
        return this.colour.toString()+"Q";
    }
}
