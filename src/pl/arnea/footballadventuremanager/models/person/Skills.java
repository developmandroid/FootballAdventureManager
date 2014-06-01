package pl.arnea.footballadventuremanager.models.person;

public class Skills {
    // defensive skills
    int tackling;
    int heading;
    int marking;

    // offensive skills
    int crossing;
    int passing;
    int creativity;
    int technique;
    int finishing;

    // fitness and other
    int strenght;
    int jumping;

    // goalkeepers
    int goalkeeping;

    public Skills() {

    }

    public Skills(int tackling, int heading, int marking, int crossing,
                  int passing, int creativity, int technique, int finishing,
                  int strenght, int jumping, int goalkeeping) {

        this.tackling = tackling;
        this.heading = heading;
        this.marking = marking;
        this.crossing = crossing;
        this.passing = passing;
        this.creativity = creativity;
        this.technique = technique;
        this.finishing = finishing;
        this.strenght = strenght;
        this.jumping = jumping;
        this.goalkeeping = goalkeeping;
    }

    public int getTackling() {
        return tackling;
    }

    public void setTackling(int tackling) {
        this.tackling = tackling;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getMarking() {
        return marking;
    }

    public void setMarking(int marking) {
        this.marking = marking;
    }

    public int getCrossing() {
        return crossing;
    }

    public void setCrossing(int crossing) {
        this.crossing = crossing;
    }

    public int getPassing() {
        return passing;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public int getCreativity() {
        return creativity;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    public int getTechnique() {
        return technique;
    }

    public void setTechnique(int technique) {
        this.technique = technique;
    }

    public int getFinishing() {
        return finishing;
    }

    public void setFinishing(int finishing) {
        this.finishing = finishing;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getJumping() {
        return jumping;
    }

    public void setJumping(int jumping) {
        this.jumping = jumping;
    }

    public int getGoalkeeping() {
        return goalkeeping;
    }

    public void setGoalkeeping(int goalkeeping) {
        this.goalkeeping = goalkeeping;
    }


}
