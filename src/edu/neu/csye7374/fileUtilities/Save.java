package edu.neu.csye7374.fileUtilities;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Save implements FileUtility {

	private String csv;

	public Save(String csv) {
		this.csv = csv;
	}

	public String processData() {

		String sb = "";
		return sb.toString();
	}

	@Override
	public void execute() {

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(csv);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

			StringBuilder sb = new StringBuilder();
			sb.append("ID");
			sb.append(',');
			sb.append("First Name");
			sb.append(',');
			sb.append("Last Name");
			sb.append(',');
			sb.append("Total Bill");
			sb.append(',');
			sb.append("Detail");

			sb.append('\n');
			sb.append("");
			sb.append(',');
			sb.append("");
			sb.append(',');
			sb.append("");
			sb.append(',');
			sb.append("");
			sb.append(',');

			String data = processData();
			sb.append(data);
			sb.append('\n');
			bufferWriter.write(sb.toString());

			bufferWriter.newLine();

			bufferWriter.flush();
			bufferWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
