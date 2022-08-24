package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    public int id;
    private static int nextId = 1;
    public String value;

    public JobField() {
        this.id = nextId;
        nextId ++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //Getters and setters

    public int getId(){ return id;}

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value;}

    public abstract String toString();

    public abstract boolean equals(Object o);

    public int hashCode() { return Objects.hash(id);}
}
