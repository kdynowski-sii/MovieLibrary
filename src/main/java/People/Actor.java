package People;

import org.json.JSONObject;

public class Actor extends Person {
    public Actor(String fname, String lname) {
        firstName = fname;
        lastName = lname;
    }

    public Actor(JSONObject pActorJSON) {
        super(pActorJSON);
    }
}
