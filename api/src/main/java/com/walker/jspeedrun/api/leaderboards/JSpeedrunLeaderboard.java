package com.walker.jspeedrun.api.leaderboards;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.walker.jspeedrun.api.JSpeedrunData;
import com.walker.jspeedrun.api.run.JSpeedrunRun;
import com.walker.jspeedrun.api.structs.JSpeedrunLink;
import com.walker.jspeedrun.api.games.JSpeedrunGameRuleset;

import java.util.List;
import java.util.Map;

@CompiledJson
public class JSpeedrunLeaderboard extends JSpeedrunData {
    @CompiledJson
    public static class LeaderboardPlace {
        @JsonAttribute
        public int place;

        @JsonAttribute
        public JSpeedrunRun run;
    }

    @JsonAttribute
    public String weblink;

    @JsonAttribute
    public String game;

    @JsonAttribute
    public String category;

    @JsonAttribute
    public String level;

    @JsonAttribute
    public String platform;

    @JsonAttribute
    public String region;

    @JsonAttribute
    public String emulators;

    @JsonAttribute
    public JSpeedrunGameRuleset.RunTimes timing;

    @JsonAttribute
    public Map<String, String> values;

    @JsonAttribute
    public List<LeaderboardPlace> runs;

    @JsonAttribute
    public List<JSpeedrunLink> links;
}
