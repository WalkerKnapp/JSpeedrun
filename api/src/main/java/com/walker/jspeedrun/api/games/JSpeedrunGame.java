package com.walker.jspeedrun.api.games;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.walker.jspeedrun.api.JSpeedrunData;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CompiledJson
public class JSpeedrunGame extends JSpeedrunData {
    @JsonAttribute
    public String id;

    @JsonAttribute
    public Map<String, String> names;

    @JsonAttribute
    public String abbreviation;

    @JsonAttribute
    public String weblink;

    @JsonAttribute
    public int released;

    @JsonAttribute
    public Date releaseDate;

    @JsonAttribute
    public JSpeedrunGameRuleset ruleset;

    @JsonAttribute
    public boolean romhack;

    @JsonAttribute(name = "gametypes")
    public List<String> gameTypes;

    @JsonAttribute
    public List<String> platforms;

    @JsonAttribute
    public List<String> regions;

    @JsonAttribute
    public List<String> genres;

    @JsonAttribute
    public List<String> engines;

    @JsonAttribute
    public List<String> developers;

    @JsonAttribute
    public List<String> publishers;

    @JsonAttribute
    public Map<String, String> moderators;

    @JsonAttribute
    public OffsetDateTime created;

    @JsonAttribute
    public JSpeedrunGameAssets assets;

    @JsonAttribute
    public List<JSpeedrunGameLink> links;
}
