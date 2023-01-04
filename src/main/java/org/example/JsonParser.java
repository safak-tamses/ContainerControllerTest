package org.example;

import org.apache.commons.text.StringEscapeUtils;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public String parse(List<String> data){
        List<String> dataEntity = new ArrayList<>();
        String jsonhead = "{\"devices\":[ \n";
        String jsontail = "]}";
        String json = jsonhead;

        for (int j = 0; j < data.size(); j++) {
            if (j == data.size() - 1) {
                json = json + data.get(j);
            } else {
                json = json + data.get(j) + ",\n";
            }
        }
        json = json + jsontail;
        String unescapedJsonString = StringEscapeUtils.unescapeJava(json);
        return unescapedJsonString;
    }
}
