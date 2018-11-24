package pl.alburnus.springws.team.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.alburnus.springws.team.service.TeamService;
import pl.alburnus.springws.ws.model.Team;
import pl.alburnus.springws.ws.wrapper.TeamDetailRequest;
import pl.alburnus.springws.ws.wrapper.TeamDetailResponse;

@Endpoint
public class TeamEndpoint {

    // namespace from package-info.java in this case TeamDetailRequest, so we know that request or response is from target namespace
    private static final String TARGET_NAMESPACE = "http://pl/alburnus/springws/ws/wrapper";

    @Autowired
    private TeamService teamService;

    // localPart was critical point - when I had TeamDetailsRequest couldn't find mapping
    @PayloadRoot(localPart = "TeamDetailRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload
    TeamDetailResponse getDetail(@RequestPayload TeamDetailRequest request) {
        TeamDetailResponse response = new TeamDetailResponse();
        Team team = teamService.getDetail("Nazwa");
        response.setTeamDetail(team);
        return response;
    }
}
