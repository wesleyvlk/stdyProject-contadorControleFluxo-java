package com.dio.selectionprocess.view;

import com.dio.selectionprocess.controller.SelectionController;
import java.util.Arrays;
import java.util.Objects;

public class SelectionView {
    private SelectionController getController() {
        return new SelectionController();
    }

    public void processSelection() {
        System.out.format("Case 1. Metodos analyzeCandidate e valueInterestsRandom, para 3 condicoes:%n");
        getController().checkCandidate(getController().generateRandomSalary());
        getController().checkCandidate(getController().generateRandomSalary());
        getController().checkCandidate(getController().generateRandomSalary());

        System.out.format("%nCase 2. ArrayList de candidates e metodo selectCandidates:%n");
        String[] selectedCandidates = getController().selectCandidates(getController().candidatesList);

        System.out.format("%nCase 3. Metodo listSelectedCandidates com array selectedCandidates:%n");
        getController().showSelectedCandidates(selectedCandidates);

        System.out.format("%nCase 4. metodo callSelectedCandidate com array selectedCandidates:%n");
        Arrays.stream(selectedCandidates)
                .filter(Objects::nonNull)
                .forEach(candidateSelected ->
                        System.out.format(getController().callCandidateSelected(candidateSelected)));
    }

}
