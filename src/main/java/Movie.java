import People.Actor;
import People.Director;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private int releaseYear;
    private Director director;
    private String genre;
    private List<Actor> actors;

    public Movie(JSONObject movieObjectJSON) {
        // Here are methods to get certain property from movie object
        this.title = movieObjectJSON.get("title").toString();
        this.releaseYear = Integer.parseInt(movieObjectJSON.get("releaseYear").toString());
        this.director = new Director(new JSONObject(movieObjectJSON.get("director").toString())); // TODO create a constructor
        JSONArray actorsJSON = new JSONArray(movieObjectJSON.get("actors").toString());
        actors = new ArrayList<Actor>();
        for (Object actorJSON : actorsJSON) {
            JSONObject pActorJSON = new JSONObject(actorJSON.toString());
            actors.add(new Actor(pActorJSON)); // TODO create a constructor

        }
        this.genre = movieObjectJSON.get("genre").toString();
    }

    @Override
    public String toString() {
//                  * title: The Shawshank Redemption
//                  * director: Frank Darabont
//                  * genre: drama
//                  * date: 1994
//                  * actors: Tim Robbins, Morgan Freeman, Bob Gunton
        String temp = "title: " + title + "\n" +
                "director: " + director.toString() +
                "\ngenre: " + genre +
                "\ndate: " + releaseYear +
                "\nactors: ";
        for(Actor actor: actors){
            temp += actor.toString();
        }
        return temp;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public int getDate() {
        return releaseYear;
    }
}
