package application.utils;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomDeserializer extends StdDeserializer<Map<String, String>> {
    private ObjectMapper mapper = new ObjectMapper();

    protected CustomDeserializer(Class<?> vc) {
        super(vc);
    }

    protected CustomDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected CustomDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Map<String, String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String jsonInput = jsonParser.getText();
        com.fasterxml.jackson.core.type.TypeReference<HashMap<String, String>> typeRef
                = new com.fasterxml.jackson.core.type.TypeReference<>() {
        };
        Map<String, String> map = mapper.readValue(jsonInput, typeRef);
        return map;
    }
}
