import People.Actor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovieLibrary {
    private List<Movie> movieList;

    public MovieLibrary(JSONArray movieArray) {
        movieList = new ArrayList<>();
        // time to init a movie object and put it in movieList
        for (Object movie : movieArray) {
            JSONObject movieObjectJSON = new JSONObject(movie.toString());
            movieList.add(new Movie(movieObjectJSON));
        }
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public Movie getRandomMovie(){
        Random random = new Random();
        return movieList.get(random.nextInt(movieList.size()));
    }

    public List<Movie> getMoviesByActor(String firstName, String lastName){
        List<Movie> moviesWithGivenActor = new ArrayList<>();
        for (Movie movieFromLibrary: movieList) {
            for(Actor actor: movieFromLibrary.getActors()){
                if (actor.getFirstName().equalsIgnoreCase(firstName) && actor.getLastName().equalsIgnoreCase(lastName)){
                    moviesWithGivenActor.add(movieFromLibrary);
                }
            }
        }
        return moviesWithGivenActor;
    }

    public List<Movie> getMoviesByDateRange(int since, int to){
        List<Movie> moviesFromGivenRange = new ArrayList<>();
        for (Movie movieFromLibrary: movieList) {
            if(since <= movieFromLibrary.getDate() && movieFromLibrary.getDate() <= to){
                moviesFromGivenRange.add(movieFromLibrary);
            }
        }
        return moviesFromGivenRange;
    }
}