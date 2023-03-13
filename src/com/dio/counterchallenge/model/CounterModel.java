package com.dio.counterchallenge.model;

import com.dio.counterchallenge.controller.InvalidParametersException;

public interface CounterModel {
    void counterView();

    int inputParameterOne();

    int inputParameterTwo();

    void counter(int parameterOne, int parameterTwo) throws InvalidParametersException;
}
