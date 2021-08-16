package edu.neu.csye7374.adapter;

import edu.neu.csye7374.api.CalculateAPI;

public class Calculator implements CalculateAPI{

	@Override
	public double operation(OPERATION op, double a, double b) {
		double result =0;
		// TODO Auto-generated method stub
		switch(op) {
		case ADD:
			result = a+b;
			break;
		case MULT:
			result = a*b;
			break;
		case DIV:
			result = a/b;
			break;
		case SUB:
			result = a-b;
			break;
		default:
			break;
		
		}
		return result;
	}
}
