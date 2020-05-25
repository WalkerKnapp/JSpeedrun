package com.walker.jspeedrun.api.games;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.dslplatform.json.JsonValue;

import java.util.List;

@CompiledJson
public class JSpeedrunGameRuleset {
    public enum RunTimes {
        REALTIME("realtime"),
        REALTIME_NOLOADS("realtime_noloads"),
        INGAME("ingame");

        @JsonValue
        public final String name;

        RunTimes(String name) {
            this.name = name;
        }
    }

    @JsonAttribute(name = "show-milliseconds")
    public boolean showMilliseconds;

    @JsonAttribute(name = "require-verification")
    public boolean requireVerification;

    @JsonAttribute(name = "require-video")
    public boolean requireVideo;

    @JsonAttribute(name = "run-times")
    public List<RunTimes> runTimes;

    @JsonAttribute(name = "default-time")
    public RunTimes defaultTime;

    @JsonAttribute(name = "emulators-allowed")
    public boolean emulatorsAllowed;
}
