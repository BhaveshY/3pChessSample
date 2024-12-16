package entity;

import common.Colour;
import common.Direction;

import static utility.MovementUtil.step;

/**
 * Pawn class extends BasePiece. Move directions for the Pawn, the polygons
 * to be highlighted, and its legal moves are checked here
 **/
public class Pawn extends BasePiece {

    private static final String TAG = "PAWN";

    /**
     * Pawn constructor
     * @param colour: Colour of the chess piece being initiated
     * */
    public Pawn(Colour colour) {
        super(colour);
    }

    /**
     * Method to initialize directions for a chess piece
     **/
    @Override
    public void setupDirections() {
        this.directions = new Direction[][] {{Direction.FORWARD},{Direction.FORWARD,Direction.FORWARD},
                {Direction.FORWARD,Direction.LEFT},{Direction.LEFT,Direction.FORWARD},{Direction.FORWARD,Direction.RIGHT},
                {Direction.RIGHT,Direction.FORWARD}};
    }


    /**
     * Returns custom string representation of the class
     * @return String
     * */
    @Override
    public String toString() {
        return this.colour.toString()+"P";
    }
}
