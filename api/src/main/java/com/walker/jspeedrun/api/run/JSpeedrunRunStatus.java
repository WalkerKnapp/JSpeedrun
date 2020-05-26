package com.walker.jspeedrun.api.run;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

import java.time.OffsetDateTime;

@CompiledJson
public class JSpeedrunRunStatus {
    @JsonAttribute
    public String status;

    @JsonAttribute
    public String examiner;

    @JsonAttribute(name = "verify-date")
    public OffsetDateTime verifyDate;
}
