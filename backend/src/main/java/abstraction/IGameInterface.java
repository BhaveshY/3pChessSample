package abstraction;
import common.Colour;
import common.GameState;

import java.util.Map;

public interface IGameInterface {

    /**
     * Get the current board map being used by backend for current game session
     * @return Board map
     * */
    Map<String, String> getBoard();


    /**
     * @return returns which colour turn it is currently
     * */
    Colour getTurn();
}
