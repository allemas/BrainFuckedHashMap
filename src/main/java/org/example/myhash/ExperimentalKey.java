package org.example.myhash;

public class ExperimentalKey {
    String internalValue;

    public ExperimentalKey(String k) {
        internalValue = k;
    }

    @Override
    public String toString() {
        return internalValue;
    }

    @Override
    public boolean equals(Object obj) {
        return internalValue.equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return (int) internalValue.charAt(0);
    }
}
