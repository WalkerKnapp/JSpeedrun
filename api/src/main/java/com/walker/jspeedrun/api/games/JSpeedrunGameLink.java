package com.walker.jspeedrun.api.games;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

@CompiledJson
public class JSpeedrunGameLink {
    @JsonAttribute
    public String rel;

    @JsonAttribute
    public String uri;
}
