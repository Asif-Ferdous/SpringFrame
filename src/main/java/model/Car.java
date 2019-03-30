package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("name")
    private String name;

    public Car(){}

    public Car(String manufacturer, String name) {
        this.manufacturer = manufacturer;
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }
}
