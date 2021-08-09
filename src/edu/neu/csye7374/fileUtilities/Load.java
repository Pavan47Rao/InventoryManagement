package edu.neu.csye7374.fileUtilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Load implements FileUtility{

	private String csv;
	private String data;
	

	public Load(String csv) {
		this.csv = csv;
	}

	@Override
	public void execute() {
		List<String> strings = new ArrayList<String>();
		Scanner inLine = null;
		try {
			inLine = new Scanner(new BufferedReader(new FileReader(csv)));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		while (inLine.hasNextLine()) {
			strings.add(inLine.nextLine());
		}
		inLine.close();
	}
}
	