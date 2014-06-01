package pl.arnea.footballadventuremanager.models.club;

public class ClubFacilities {
    Stadium stadium;
    Office office;
    TrainingBase trainingBase;
    PhysioBase physioBase;

    public ClubFacilities(Stadium stadium, Office office,
                          TrainingBase trainingBase, PhysioBase physioBase) {

        this.stadium = stadium;
        this.office = office;
        this.trainingBase = trainingBase;
        this.physioBase = physioBase;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public TrainingBase getTrainingBase() {
        return trainingBase;
    }

    public void setTrainingBase(TrainingBase trainingBase) {
        this.trainingBase = trainingBase;
    }

    public PhysioBase getPhysioBase() {
        return physioBase;
    }

    public void setPhysioBase(PhysioBase physioBase) {
        this.physioBase = physioBase;
    }


}
