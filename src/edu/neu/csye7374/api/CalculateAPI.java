package edu.neu.csye7374.api;

public interface CalculateAPI {
	public enum OPERATION {
		ADD,SUB,MULT,DIV
	}
	double operation(OPERATION op, double a, double b);
}
