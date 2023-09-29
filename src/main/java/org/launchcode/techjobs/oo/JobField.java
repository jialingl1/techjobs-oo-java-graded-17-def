package org.launchcode.techjobs.oo;

import java.util.Objects;

//declare each of the common fields.
public abstract class JobField {
    int id; //all fields have default/protected access. Seems abstract classes can't have private fields?
    static int nextId = 1;
    String value;

    //Code the constructors.
    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //Add in the custom methods.

    @Override
    public String toString() { return value;}

    @Override //made this one abstract to force child classes write their own code
    public abstract boolean equals(Object o);

    @Override
    public int hashCode() { return Objects.hash(getId()); }

    //Use Generate to create the appropriate getters and setters.

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
