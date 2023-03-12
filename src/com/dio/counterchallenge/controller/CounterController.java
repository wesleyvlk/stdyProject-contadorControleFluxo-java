package com.dio.counterchallenge.controller;

import com.dio.counterchallenge.model.CounterModel;
import com.dio.counterchallenge.model.CounterFunction;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CounterController implements CounterModel {
    public void counterView() {
        try {
            System.out.format("Digite o primeiro parâmetro%n");
            int parameterOne = inputParameterOne();
            System.out.format("Digite o segundo parâmetro%n");
            int parameterTwo = inputParameterTwo();
            counter(parameterOne, parameterTwo);
        } catch (InvalidParametersException e) {
            System.err.format(e.getMessage());
        }
    }

    public int inputParameterOne() {
        return new Scanner(System.in).nextInt();
    }

    public int inputParameterTwo() {
        return new Scanner(System.in).nextInt();
    }

    public void counter(int parameterOne, int parameterTwo) throws InvalidParametersException {
        InvalidParametersException.checkParameters(parameterOne, parameterTwo);

        CounterFunction funcCount = (countOne, countTwo) -> parameterTwo - parameterOne;
        int count = funcCount.applyCount(parameterOne, parameterTwo);

        IntStream.rangeClosed(1, count).forEach(counter -> System.out.format("Imprimindo o número: %d %n", counter));
    }

}