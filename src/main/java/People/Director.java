package People;

import org.json.JSONObject;

public class Director extends Person {
    public Director(String fname, String lname) {
        super();
        firstName = fname;
        lastName = lname;
    }

    public Director(JSONObject director) {
        super(director);
    }
}
