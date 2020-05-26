package com.walker.jspeedrun.api.run;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

import java.util.List;

@CompiledJson
public class JSpeedrunVideos {
    @CompiledJson
    public static class VideoLink {
        @JsonAttribute
        public String uri;
    }

    @JsonAttribute
    public String text;

    @JsonAttribute
    public List<VideoLink> links;
}
