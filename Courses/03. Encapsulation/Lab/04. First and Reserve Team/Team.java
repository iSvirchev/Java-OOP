import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        setName(name);
        setFirstTeam(new LinkedList<>());
        setReserveTeam(new LinkedList<>());
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setFirstTeam(List<Person> firstTeam) {
        this.firstTeam = firstTeam;
    }

    private void setReserveTeam(List<Person> reserveTeam) {
        this.reserveTeam = reserveTeam;
    }

    public String getName() {
        return this.name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

    public void addPlayer(Person person){
        if (person.getAge() < 40){
            firstTeam.add(person);
        }else{
            reserveTeam.add(person);
        }
    }

    @Override
    public String toString() {
        return String.format("First team have %d players\nReserve team have %d players", getFirstTeam().size(),getReserveTeam().size());

    }
}
