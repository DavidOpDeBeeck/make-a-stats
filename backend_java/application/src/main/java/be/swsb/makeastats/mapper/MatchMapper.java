package be.swsb.makeastats.mapper;

import be.swsb.makeastats.model.Match;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public Match map(String playerName, String matchId, String json) {
        String statsJson = ((JSONArray) JsonPath.read(json, "$..stats[?(@.name == '" + playerName + "')]")).toJSONString();
        int kills = (int) ((JSONArray) JsonPath.read(statsJson, "$..kills")).get(0);
        return new Match(matchId, kills);
    }
}
