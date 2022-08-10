package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class JsonController {
    private Gson gson;

    public JsonController() {
        this.gson = new Gson();
    }

    //ArrayList a Json
    public String objectsToJson(ArrayList<Object> objects) {
        return gson.toJson(objects);
    }

    public String objects2ToJson(ArrayList<Object> objects2) {
        return gson.toJson(objects2);
    }

    public String charsToJson(ArrayList<Character> chars) {
        return gson.toJson(chars);
    }

    //Json a ArrayList
    public ArrayList<Object> jsonToObjects(String jsonText) {
        ArrayList<Object> objects = gson.fromJson(jsonText, new TypeToken<ArrayList<Object>>() {
        }.getType());
        return objects;
    }

    public ArrayList<Object> jsonToObjects2(String jsonText) {
        ArrayList<Object> objects2 = gson.fromJson(jsonText, new TypeToken<ArrayList<Object>>() {
        }.getType());
        return objects2;
    }

    public ArrayList<Character> jsonToChars(String jsonText) {
        ArrayList<Character> chars = gson.fromJson(jsonText, new TypeToken<ArrayList<Object>>() {
        }.getType());
        return chars;
    }


    //Json a un solo object
    public Object jsonToObject(String jsonText) {
        Object object = gson.<Object>fromJson(jsonText, Object.class);
        return object;
    }

    //Un solo Object a Json
    public String objectToJson(Object object) {
        return gson.toJson(object);
    }

}