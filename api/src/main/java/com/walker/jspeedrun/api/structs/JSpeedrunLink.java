package com.walker.jspeedrun.api.structs;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

@CompiledJson
public class JSpeedrunLink {
    @JsonAttribute
    public String rel;

    @JsonAttribute
    public String uri;
}
