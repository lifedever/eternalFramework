package io.github.eternalpro.web.converter;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

public class MappingJacksonJsonpHttpMessageConverter
        extends MappingJackson2HttpMessageConverter {

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        JsonGenerator jsonGenerator = this.getObjectMapper().getJsonFactory().createJsonGenerator(outputMessage.getBody(), encoding);

        try {
            String jsonPadding = "callback";

            // If the callback doesn't provide, use the default callback
            if (object instanceof JSONPObject) {
                String jsonCallback = ((JSONPObject) object).getFunction();
                if (jsonCallback != null) {
                    jsonPadding = jsonCallback;
                }
            }

            jsonGenerator.writeRaw(jsonPadding);
            jsonGenerator.writeRaw('(');
            this.getObjectMapper().writeValue(jsonGenerator, object);
            jsonGenerator.writeRaw(");");
            jsonGenerator.flush();
        } catch (JsonProcessingException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }
}
