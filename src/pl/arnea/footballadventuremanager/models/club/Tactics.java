package pl.arnea.footballadventuremanager.models.club;

import pl.arnea.footballadventuremanager.models.person.PlayerPosition;

import java.util.ArrayList;
import java.util.List;

public class Tactics {


    List<PlayerPosition> tactics = new ArrayList();

    public Tactics(List<PlayerPosition> tactics) {
        this.tactics = tactics;
    }

    public List<PlayerPosition> getTactics() {
        return tactics;
    }

    public void setTactics(List<PlayerPosition> tactics) {
        this.tactics = tactics;
    }


}
