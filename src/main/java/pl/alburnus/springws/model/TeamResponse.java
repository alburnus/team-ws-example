package pl.alburnus.springws.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "team"
})
// Only on root element!
@XmlRootElement(name = "TeamResponse", namespace = "http://alburnus.pl/springws/ws/team")
public class TeamResponse {

    @XmlElement(name = "Team", required = true)
    protected Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
