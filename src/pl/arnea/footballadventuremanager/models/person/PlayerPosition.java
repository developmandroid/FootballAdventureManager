package pl.arnea.footballadventuremanager.models.person;

/**
 * Created by Arnea on 10.05.14.
 */
public class PlayerPosition {
    String playerPosition;
    String playerPositionSide;
    String position;

    public PlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;

    }

    public PlayerPosition(String playerPosition, String playerPositionSide) {
        this.playerPosition = playerPosition;
        this.playerPositionSide = playerPositionSide;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getPlayerPositionSide() {
        return playerPositionSide;
    }

    public void setPlayerPositionSide(String playerPositionSide) {
        this.playerPositionSide = playerPositionSide;
    }

    public String toString() {

        if (getPlayerPositionSide() == null) {
            position = getPlayerPosition();

        } else
            position = getPlayerPosition() + getPlayerPositionSide();
        return position;
    }

}
