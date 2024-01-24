package springreact.demo.gson_examples;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExampleGSON {
    public static void main(String[] args) {
        Gson gson = new Gson();

        String json = gson.toJson(ExampleData.THRILLER);
        System.out.println(json);

        String ss = "{\"id\":0,\"title\":\"Thriller\",\"yearReleased\":1982,\"artist\":{\"id\":0,\"name\":\"Michael Jackson\",\"yearBorn\":1958,\"isDeceased\":false},\"songs\":[]}";
        Album thriller = gson.fromJson(ss, Album.class);
        System.out.println();
        System.out.println("Album: " + thriller.title);
        System.out.println("Artist: " + thriller.artist.name);
    }
}
