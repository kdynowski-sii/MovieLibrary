package People;

import org.json.JSONObject;

abstract class Person {
    protected String firstName, lastName;

    public Person(JSONObject person) {
        this.firstName = person.get("firstName").toString();
        this.lastName = person.get("lastName").toString();
    }

    public Person() {

    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", ";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
