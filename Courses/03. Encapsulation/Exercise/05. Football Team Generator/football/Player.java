package football;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public Player() {
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateStats(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateStats(endurance, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateStats(endurance, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateStats(endurance, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateStats(endurance, "Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return this.name;
    }

    public double overallSkillLevel(){
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) /5.0;
    }

    private void validateStats(int value, String type) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(type + " should be between 0 and 100.");
        }
    }
}
