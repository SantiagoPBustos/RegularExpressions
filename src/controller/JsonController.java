package controller;

import com.google.gson.Gson;

public class JsonController {
    private Gson gson;

    public JsonController() {
        this.gson = new Gson();
    }

    public Object jsonToObject(String jsonText) {
        Object object = gson.<Object>fromJson(jsonText, Object.class);
        return object;
    }

    public String objectToJson(Object object) {
        return gson.toJson(object);
    }

}
