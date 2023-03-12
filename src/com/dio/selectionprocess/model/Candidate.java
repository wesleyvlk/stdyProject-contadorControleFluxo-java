package com.dio.selectionprocess.model;

public class Candidate {
    private final String name;
    private final Double intendedSalary;

    public Candidate(String name, Double intendedSalary) {
        this.name = name;
        this.intendedSalary = intendedSalary;
    }

    public String getName() {
        return name;
    }

    public Double getIntendedSalary() {
        return intendedSalary;
    }

    @Override
    public String toString() {
        return "Candidate{" + "name='" + name + '\'' + ", intendedSalary=" + intendedSalary + '}';
    }
}
