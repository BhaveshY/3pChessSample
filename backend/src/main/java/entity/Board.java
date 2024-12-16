package entity;

import common.Colour;
import common.InvalidPositionException;
import common.Position;
import utility.BoardAdapter;
import utility.Log;
import utility.PieceFactory;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Class containing the Board logic. To initialize the board with the pieces.
 * To highlight the possible moves, check for legal moves and move pieces.
 * Also, logic to declare winner.
 */
public class Board {

    private static final String TAG = "Board";
    
    /** A map from board positions to the pieces at that position **/
    protected Map<Position, BasePiece> boardMap;
    private Colour turn;
    private boolean gameOver;
    private String winner;
    private Set<Position> highlightPolygons = new HashSet<>();

    /**
     * Board constructor. Places pieces on the board and initializes variables
     * */
    public Board(){
        boardMap = new HashMap<Position,BasePiece>();
        turn = Colour.BLUE;
        gameOver = false;
        winner = null;
        try{
            // Blue, Green, Red
            for(Colour colour: Colour.values()) {
                placeChessPieces(colour);
            }
        } catch(InvalidPositionException e) {
            Log.e(TAG, "InvalidPositionException: "+e.getMessage());
        }
    }

    /**
     * Place all the pieces on the board initially at start positions
     * @param colour for each color place the pieces
     * */
    private void placeChessPieces(Colour colour) throws InvalidPositionException {
        // place ROOK
        Position[] rookStartPositions = new Position[] {Position.get(colour,0,0), Position.get(colour,0,7)};
        boardMap.put(rookStartPositions[0], PieceFactory.createPiece("Rook", colour));
        boardMap.put(rookStartPositions[1], PieceFactory.createPiece("Rook", colour));

        // place KNIGHT
        Position[] knightStartPositions = new Position[] {Position.get(colour,0,1), Position.get(colour,0,6)};
        boardMap.put(knightStartPositions[0], PieceFactory.createPiece("Knight",colour));
        boardMap.put(knightStartPositions[1], PieceFactory.createPiece("Knight",colour));

        // place BISHOP
        Position[] bishopStartPositions = new Position[] {Position.get(colour,0,2), Position.get(colour,0,5)};
        boardMap.put(bishopStartPositions[0], PieceFactory.createPiece("Bishop",colour));
        boardMap.put(bishopStartPositions[1], PieceFactory.createPiece("Bishop",colour));

        // place Queen
        Position queenStartingPosition = Position.get(colour,0,3);
        boardMap.put(queenStartingPosition, PieceFactory.createPiece("Queen",colour));

        // place KING
        Position kingStartingPosition = Position.get(colour,0,4);
        boardMap.put(kingStartingPosition, PieceFactory.createPiece("King",colour));

        // place PAWN
        for(int i = 1; i<7; i++){
            Position ithPawnPosition = Position.get(colour,1,i);
            boardMap.put(ithPawnPosition, PieceFactory.createPiece("Pawn",colour));
        }

    }

     /**
     * To check if the game is over
     * @return boolean
     * */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * To fetch the winner
     * @return String of Winner name
     * */
    public String getWinner() {
        return winner;
    }


    /**
     * Get the current player turn
     * @return Colour
     * */
    public Colour getTurn() {
        return turn;
    }

    /**
     * Get the piece on the selected position
     * @param position The current selected position
     * @return BasePiece
     * */
    private BasePiece getPiece(Position position) {
        return boardMap.get(position);
    }

    /**
     * For the web app to use, board map is converted to string and returned
     * @return map of position and piece converted to strings
     * */
    public Map<String, String> getWebViewBoard() {
        return BoardAdapter.convertModelBoardToViewBoard(this.boardMap);
    }



    /**
     * Tells if the current player has selected his own piece
     * @param position The current position of the piece
     * @return boolean
     * */
    public boolean isCurrentPlayersPiece(Position position) {
        return getPiece(position) != null && getPiece(position).getColour()==turn;
    }


    /**     Check / Check-mate logic helper functions **/


    private Position getKingPosition(Colour colour, Map<Position, BasePiece> boardMap) {
        for(Position position: boardMap.keySet()) {
            BasePiece piece = boardMap.get(position);
            if(piece instanceof King && piece.getColour()==colour) {
                return position;
            }
        }
        return null;
    }
}
