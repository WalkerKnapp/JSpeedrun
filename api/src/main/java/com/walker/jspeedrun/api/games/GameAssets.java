package com.walker.jspeedrun.api.games;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

@CompiledJson
public class GameAssets {
    @JsonAttribute
    public GameAsset logo;

    @JsonAttribute(name = "cover-tiny")
    public GameAsset coverTiny;

    @JsonAttribute(name = "cover-small")
    public GameAsset coverSmall;

    @JsonAttribute(name = "cover-medium")
    public GameAsset coverMedium;

    @JsonAttribute(name = "cover-large")
    public GameAsset coverLarge;

    @JsonAttribute
    public GameAsset icon;

    @JsonAttribute(name = "trophy-1st")
    public GameAsset trophy1st;

    @JsonAttribute(name = "trophy-2nd")
    public GameAsset trophy2nd;

    @JsonAttribute(name = "trophy-3rd")
    public GameAsset trophy3rd;

    @JsonAttribute(name = "trophy-4th")
    public GameAsset trophy4th;

    @JsonAttribute
    public GameAsset background;

    @JsonAttribute
    public GameAsset foreground;
}
