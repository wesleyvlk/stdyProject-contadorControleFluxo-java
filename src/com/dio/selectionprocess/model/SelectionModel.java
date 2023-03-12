package com.dio.selectionprocess.model;

import java.util.List;

public interface SelectionModel {
    static final double BASE_SALARY = 2000d;
    static final int CALLS_ALLOWED = 3;

    Candidate createCandidate(String name, double intendedSalary);

    String[] selectCandidates(List<Candidate> candidatesList);

    void showSelectedCandidates(String... selectedCandidates);

    String callCandidateSelected(String candidateSelected);
}
