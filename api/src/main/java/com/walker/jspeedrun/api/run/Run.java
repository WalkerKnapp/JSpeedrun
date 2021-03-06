package com.walker.jspeedrun.api.run;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.walker.jspeedrun.api.structs.Link;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@CompiledJson
public class Run {
    @CompiledJson
    public static class Player {
        @JsonAttribute
        public String rel;

        @JsonAttribute
        public String id;

        @JsonAttribute
        public String name;

        @JsonAttribute
        public String uri;
    }

    @CompiledJson
    public static class RunTimes {
        @JsonAttribute
        public String primary;

        @JsonAttribute(name = "primary_t")
        public double primaryTime;

        @JsonAttribute
        public String realtime;

        @JsonAttribute(name = "realtime_t")
        public double realtimeTime;

        @JsonAttribute(name = "realtime_noloads")
        public String realtimeNoLoads;

        @JsonAttribute(name = "realtime_noloads_t")
        public double realtimeNoLoadsTime;

        @JsonAttribute
        public String ingame;

        @JsonAttribute(name = "ingame_t")
        public double ingameTime;
    }

    @CompiledJson
    public static class RunSystem {
        @JsonAttribute
        public String platform;

        @JsonAttribute
        public boolean emulated;

        @JsonAttribute
        public String region;
    }

    @CompiledJson
    public static class RunSplits {
        @JsonAttribute
        public String rel;

        @JsonAttribute
        public String uri;
    }

    @JsonAttribute
    public String id;

    @JsonAttribute
    public String level;

    @JsonAttribute
    public String category;

    @JsonAttribute
    public Videos videos;

    @JsonAttribute
    public String comment;

    @JsonAttribute
    public RunStatus status;

    @JsonAttribute
    public List<Player> players;

    @JsonAttribute
    public LocalDate date;

    @JsonAttribute
    public OffsetDateTime submitted;

    @JsonAttribute
    public RunTimes times;

    @JsonAttribute
    public RunSystem system;

    @JsonAttribute
    public RunSplits splits;

    @JsonAttribute(name = "values")
    public Map<String, String> variableValues;

    @JsonAttribute
    public List<Link> links;
}
