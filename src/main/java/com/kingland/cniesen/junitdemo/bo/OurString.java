package com.kingland.cniesen.junitdemo.bo;

import java.util.Objects;

public class OurString {
    String value ;

    public OurString(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OurString ourString = (OurString) o;
        return Objects.equals(value, ourString.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "OurString{" +
                "value='" + value + '\'' +
                '}';
    }
}
