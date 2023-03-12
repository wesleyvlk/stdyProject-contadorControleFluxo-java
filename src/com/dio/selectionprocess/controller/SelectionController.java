package com.dio.selectionprocess.controller;

import com.dio.selectionprocess.model.Candidate;
import com.dio.selectionprocess.model.SelectionModel;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SelectionController implements SelectionModel {
    private static final double BASE_SALARY;
    private static final int CALLS_ALLOWED;

    static {
        BASE_SALARY = 2000d;
        CALLS_ALLOWED = 3;
    }

    public final List<Candidate> candidatesList;
    private final Random random;

    public SelectionController() {
        candidatesList = new ArrayList<>();
        String[] namesCandidates = new String[]{"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};
        Arrays.stream(namesCandidates).map(candidateName -> createCandidate(candidateName, generateRandomSalary())).forEach(candidatesList::add);

        random = new Random();
    }

    public void checkCandidate(double intendedSalary) {
        if (BASE_SALARY > intendedSalary) {
            System.out.format("LIGAR PARA O CANDIDATO %n");
        } else if (BASE_SALARY == intendedSalary) {
            System.out.format("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA %n");
        } else {
            System.out.format("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS %n");
        }
    }

    public double generateRandomSalary() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public Candidate createCandidate(String name, double intendedSalary) {
        return new Candidate(name, intendedSalary);
    }

    public String[] selectCandidates(List<Candidate> candidatesList) {
        int jobsOpen = 5;
        String[] selectCandidates = new String[jobsOpen];
        int totalSelected = 0;
        int nextCandidate;

        for (nextCandidate = 0; nextCandidate < candidatesList.size(); nextCandidate++) {
            Candidate candidate = candidatesList.get(nextCandidate);
            double intendedSalary = candidate.getIntendedSalary();
            String candidateName = candidate.getName();
            String message = String.format("O candidato %s está pedindo: R$ %.2f %n", candidateName, intendedSalary);

            if (intendedSalary > BASE_SALARY)
                message += String.format("QUE PENA!! O candidato %s NÃO foi selecionado %n", candidateName);
            else {
                message += String.format("LEGAL!! O candidato %s foi selecionado %n", candidateName);
                selectCandidates[totalSelected] = candidateName;
                totalSelected++;
            }

            System.out.format(message);

            if (totalSelected == jobsOpen) {
                break;
            }
        }

        System.out.format("Total de selecionados: %d %nTotal de consultados: %d %n", totalSelected, nextCandidate);
        return selectCandidates;
    }

    public void showSelectedCandidates(String... selectedCandidates) {
        Arrays.stream(selectedCandidates).filter(Objects::nonNull).forEach(System.out::println);
    }

    public String callCandidateSelected(String candidateSelected) {
        boolean callAnswered = random.nextInt(CALLS_ALLOWED) == 1;
        int callsMade = 1;
        boolean wasAttended;

        do {
            wasAttended = callAnswered;
            callsMade++;
        } while (!wasAttended && callsMade <= CALLS_ALLOWED);

        String message;
        if (wasAttended) {
            message = String.format("CONTATO REALIZADO COM SUCESSO, CONSEGUIMOS CONTATO COM %s NA %dª TENTATIVA%n", candidateSelected, callsMade - 1);
        } else {
            message = String.format("NÃO CONSEGUIMOS CONTATO COM %s, NÚMERO MÁXIMO DE TENTATIVAS %d REALIZADA%n", candidateSelected, CALLS_ALLOWED);
        }

        return message;
    }
}
