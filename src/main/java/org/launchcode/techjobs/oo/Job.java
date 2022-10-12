package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.


    public Job() {
        id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positiontype, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positiontype;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String jobless = "OOPS";
        if (name == null || name == "" && employer == null || employer.getValue() == "" && location == null || location.getValue() ==""
                && positionType == null || positionType.getValue() ==""  && coreCompetency == null || coreCompetency.getValue() == "") {
            return jobless;
        }
        if (name == null || name == "") {
            name = "Data not available";
        }
        if (employer == null || employer.getValue() == "") {
            employer.setValue("Data not available");
        }
        if(location == null || location.getValue() ==""){
            location.setValue("Data not available");
        }
        if (positionType == null || positionType.getValue() ==""){
            positionType.setValue("Data not available");
        }
        if(coreCompetency == null || coreCompetency.getValue() == ""){
            coreCompetency.setValue("Data not available");
        }

        return "\n" +
                "ID: " + id + "\nName: " + name + "\nEmployer: " + employer.getValue() + "\nLocation: " + location.getValue() +"\nPosition Type: " + positionType.getValue() +"\nCore Competency: " + coreCompetency.getValue() +"\n";

    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

}
