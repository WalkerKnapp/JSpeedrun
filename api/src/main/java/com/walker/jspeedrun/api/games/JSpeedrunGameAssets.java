package com.walker.jspeedrun.api.games;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

@CompiledJson
public class JSpeedrunGameAssets {
    @JsonAttribute
    public JSpeedrunGameAsset logo;

    @JsonAttribute(name = "cover-tiny")
    public JSpeedrunGameAsset coverTiny;

    @JsonAttribute(name = "cover-small")
    public JSpeedrunGameAsset coverSmall;

    @JsonAttribute(name = "cover-medium")
    public JSpeedrunGameAsset coverMedium;

    @JsonAttribute(name = "cover-large")
    public JSpeedrunGameAsset coverLarge;

    @JsonAttribute
    public JSpeedrunGameAsset icon;

    @JsonAttribute(name = "trophy-1st")
    public JSpeedrunGameAsset trophy1st;

    @JsonAttribute(name = "trophy-2nd")
    public JSpeedrunGameAsset trophy2nd;

    @JsonAttribute(name = "trophy-3rd")
    public JSpeedrunGameAsset trophy3rd;

    @JsonAttribute(name = "trophy-4th")
    public JSpeedrunGameAsset trophy4th;

    @JsonAttribute
    public JSpeedrunGameAsset background;

    @JsonAttribute
    public JSpeedrunGameAsset foreground;
}
