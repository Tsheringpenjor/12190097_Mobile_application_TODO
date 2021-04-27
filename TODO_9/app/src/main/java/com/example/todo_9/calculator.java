package com.example.todo_9;

public class calculator {
    public enum operator {ADD,SUB,MUL,DIV}

    public double add(double operator1, double operator2){
        return operator1 + operator2;
    }

    public double sub(double operator1, double operator2){
        return operator1 - operator2;
    }

    public double mul(double operator1, double operator2){
        return operator1 * operator2;
    }

    public double div(double operator1, double operator2){
        return operator1 / operator2;
    }
}
