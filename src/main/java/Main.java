import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        MovieLibrary movieLibrary = setUpLibrary("src/main/moviesInput.json");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1. Podaj dwie daty aby wyświetlić nazwy filmów wydanych pomiędzy tymi datami\n" +
                    "2. Wyświetl wszystkie informacje o losowym filmie\n" +
                    "3. Podaj imię i nazwisko aktora aby wyświetlić nazwy filmów w jakich zagrał\n" +
                    "other: Terminate");
            switch(scanner.nextLine()){
                case "1":
                    selectFromRange(movieLibrary, scanner);
                    break;
                case "2":
                    selectRandom(movieLibrary);
                    break;
                case "3":
                    selectByActor(movieLibrary, scanner);
                    break;
                default:
                    return;
            }
        }
    }

    private static void selectByActor(MovieLibrary movieLibrary, Scanner scanner) {
        // Getting with given actor
        System.out.println("Provide the actor's first name");
        String fName = scanner.nextLine();
        System.out.println("Provide the actor's last name");
        String lName = scanner.nextLine();
        System.out.println(movieLibrary.getMoviesByActor(fName, lName));
    }

    private static void selectRandom(MovieLibrary movieLibrary) {
        // Getting a random one
        System.out.println(movieLibrary.getRandomMovie());
    }

    private static void selectFromRange(MovieLibrary movieLibrary, Scanner scanner) {
        // Getting with given range
        System.out.println("Provide the minimum year of release: ");
        int since = scanner.nextInt();
        System.out.println("Provide the maximum year of release: ");
        int to = scanner.nextInt();
        System.out.println(movieLibrary.getMoviesByDateRange(since, to));
    }

    private static MovieLibrary setUpLibrary(String path) throws IOException {
        File file = new File(path);
        String json = Files.readString(Path.of(file.toString()));
        JSONObject movieList = new JSONObject(json);
        JSONArray movieArray = new JSONArray(movieList.getJSONArray("movieList"));
        return new MovieLibrary(movieArray);
    }
}

