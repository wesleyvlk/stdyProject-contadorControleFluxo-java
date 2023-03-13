package com.dio.counterchallenge.controller;

public class InvalidParametersException extends NumberFormatException {
    public InvalidParametersException(String message) {
        super("Erro: " + message);
    }

    public static void checkParameters(int parameterOne, int parameterTwo) throws InvalidParametersException {
        String message = (parameterOne > parameterTwo) ?
                "O valor do parametro 1 nao pode ser maior que o valor do parametro 2." :
                (parameterOne == 0 || parameterTwo == 0) ? "Os parametros nao podem ser iguais a zero." :
                        "O valor do parametro 1 nao pode ser igual ao valor do parametro 2.";

        throw new InvalidParametersException(message);
    }
}
