package pl.alburnus.springws.team.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pl.alburnus.springws.team.service.TeamService;
import pl.alburnus.springws.ws.team.Team;
import pl.alburnus.springws.ws.team.TeamRequest;
import pl.alburnus.springws.ws.team.TeamResponse;

@Endpoint
public class TeamEndpoint {

    // namespace from package-info.java in this case TeamRequest, so we know that request or response is from target namespace
    private static final String TARGET_NAMESPACE = "http://alburnus.pl/springws/ws/team";

    @Autowired
    private TeamService teamService;

    // localPart was critical point - when I had TeamDetailsRequest couldn't find mapping
    @PayloadRoot(localPart = "TeamRequest", namespace = TARGET_NAMESPACE)
    @ResponsePayload
    public TeamResponse getDetail(@RequestPayload TeamRequest request) {
        TeamResponse response = new TeamResponse();
        Team team = teamService.getDetail("Nazwa");
        response.setTeam(team);
        return response;
    }
}
