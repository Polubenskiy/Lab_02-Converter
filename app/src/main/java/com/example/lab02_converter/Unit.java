package com.example.lab02_converter;

public class Unit
{
    //Polubenskiy_Danya_393 Lab_02 - Converter
    float coeff;
    String name;

    Unit(String name, float coeff)
    {
        this.name = name;
        this.coeff = coeff;
    }

    public String toString()
    {
        return name;
    }
}


