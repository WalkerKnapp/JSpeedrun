package com.walker.jspeedrun.api;

import com.dslplatform.json.*;
import com.walker.jspeedrun.api.games.JSpeedrunGame;

public class JSpeedrunData {

    // Suppress unchecked cast from reader.context to ThreadLocal<String>, as this is checked for.
    @SuppressWarnings("unchecked")
    public static class Converter implements Configuration {
        private static JsonReader.ReadObject<JSpeedrunGame> GAME_READER;
        private static JsonWriter.WriteObject<JSpeedrunGame> GAME_WRITER;

        public static void forceConfigure(DslJson dslJson) {
            if(GAME_READER == null) {
                GAME_READER = dslJson.tryFindReader(JSpeedrunGame.class);
                GAME_WRITER = dslJson.tryFindWriter(JSpeedrunGame.class);
            }
        }

        @Override
        public void configure(DslJson dslJson) {
            GAME_READER = dslJson.tryFindReader(JSpeedrunGame.class);
            GAME_WRITER = dslJson.tryFindWriter(JSpeedrunGame.class);
        }

        public static final JsonReader.ReadObject<JSpeedrunData> JSON_READER = reader -> {
            if(!(reader.context instanceof ThreadLocal)) {
                throw new IllegalStateException("JSpeedrunData converters must be used with a DslJson<ThreadLocal<String>> object, specifying the presumed type");
            }

            Class<?> expectedType = ((ThreadLocal<Class<?>>) reader.context).get();

            if(expectedType.isArray()) {
                expectedType = expectedType.getComponentType();
            }

            if (JSpeedrunGame.class.equals(expectedType)) {
                return GAME_READER.read(reader);
            } else {
                throw new IllegalStateException("Unexpected type specified as presumed: " + (expectedType == null ? "null" : expectedType.getCanonicalName()));
            }
        };

        public static final JsonWriter.WriteObject<JSpeedrunData> JSON_WRITER = (writer, value) -> {
            if(value instanceof JSpeedrunGame) {
                GAME_WRITER.write(writer, (JSpeedrunGame) value);
            }
        };
    }
}
