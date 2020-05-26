package com.walker.jspeedrun.api.structs;

import com.dslplatform.json.*;
import com.walker.jspeedrun.api.games.Game;
import com.walker.jspeedrun.api.leaderboards.Leaderboard;

public class JSpeedrunData {

    // Suppress unchecked cast from reader.context to ThreadLocal<String>, as this is checked for.
    @SuppressWarnings("unchecked")
    public static class Converter implements Configuration {
        private static JsonReader.ReadObject<Game> GAME_READER;
        private static JsonWriter.WriteObject<Game> GAME_WRITER;

        private static JsonReader.ReadObject<Leaderboard> LEADERBOARD_READER;
        private static JsonWriter.WriteObject<Leaderboard> LEADERBOARD_WRITER;

        public static void forceConfigure(DslJson dslJson) {
            if(GAME_READER == null) {
                GAME_READER = dslJson.tryFindReader(Game.class);
                GAME_WRITER = dslJson.tryFindWriter(Game.class);

                LEADERBOARD_READER = dslJson.tryFindReader(Leaderboard.class);
                LEADERBOARD_WRITER = dslJson.tryFindWriter(Leaderboard.class);
            }
        }

        @Override
        public void configure(DslJson dslJson) {
            forceConfigure(dslJson);
        }

        public static final JsonReader.ReadObject<JSpeedrunData> JSON_READER = reader -> {
            if(!(reader.context instanceof ThreadLocal)) {
                throw new IllegalStateException("JSpeedrunData converters must be used with a DslJson<ThreadLocal<String>> object, specifying the presumed type");
            }

            Class<?> expectedType = ((ThreadLocal<Class<?>>) reader.context).get();

            if(expectedType.isArray()) {
                expectedType = expectedType.getComponentType();
            }

            if (Game.class.equals(expectedType)) {
                return GAME_READER.read(reader);
            } else if (Leaderboard.class.equals(expectedType)) {
                return LEADERBOARD_READER.read(reader);
            } else {
                throw new IllegalStateException("Unexpected type specified as presumed: " + (expectedType == null ? "null" : expectedType.getCanonicalName()));
            }
        };

        public static final JsonWriter.WriteObject<JSpeedrunData> JSON_WRITER = (writer, value) -> {
            if(value instanceof Game) {
                GAME_WRITER.write(writer, (Game) value);
            } else if(value instanceof Leaderboard) {
                LEADERBOARD_WRITER.write(writer, (Leaderboard) value);
            }
        };
    }
}
