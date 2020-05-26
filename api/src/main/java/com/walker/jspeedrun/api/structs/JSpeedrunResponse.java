package com.walker.jspeedrun.api.structs;

import com.dslplatform.json.*;

import java.util.ArrayList;
import java.util.List;

@CompiledJson
public class JSpeedrunResponse<T> {

    public static class DataConverter {
        public static final JsonReader.ReadObject<List<JSpeedrunData>> JSON_READER = reader -> {
            Class<?> expectedType = ((ThreadLocal<Class<?>>) reader.context).get();

            if(expectedType.isArray()) {
                // The data is a list of JSpeedrunData objects
                return reader.readCollection(JSpeedrunData.Converter.JSON_READER);
            } else {
                // The data is a single JSpeedrunData object
                ArrayList<JSpeedrunData> list = new ArrayList<>();
                list.add(JSpeedrunData.Converter.JSON_READER.read(reader));
                return list;
            }
        };
        public static final JsonWriter.WriteObject<List<JSpeedrunData>> JSON_WRITER = (writer, value) -> {
            if (value == null || value.isEmpty()) {
                writer.writeNull();
            } else {
                if(value.size() == 1) {
                    // The data is a single JSpeedrunData object
                    JSpeedrunData.Converter.JSON_WRITER.write(writer, value.get(0));
                } else {
                    // The data is a list of JSpeedrunData objects
                    writer.serialize(value, JSpeedrunData.Converter.JSON_WRITER);
                }
            }
        };
    }

    @JsonAttribute(converter = DataConverter.class)
    public List<JSpeedrunData> data;

    @JsonAttribute
    public int status;

    @JsonAttribute
    public String message;

    // TODO: This is a mess
    public List<T> getData() {
        return (List<T>) this.data;
    }

}
