package pl.alburnus.springws.team.service;

import org.springframework.stereotype.Service;
import pl.alburnus.springws.ws.team.Team;

@Service
public class TeamServiceImpl implements TeamService {
    public Team getDetail(String name) {
        Team team = new Team();
        team.setName("THE BEST");
        return team;
    }
}
