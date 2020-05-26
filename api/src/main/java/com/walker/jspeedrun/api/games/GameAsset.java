package com.walker.jspeedrun.api.games;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

@CompiledJson
public class GameAsset {
    @JsonAttribute
    public String uri;

    @JsonAttribute
    public int width;

    @JsonAttribute
    public int height;
}
