package edu.neu.csye7374.fileUtilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Save   {

	private String data;
	

	public Save(String csv) {
		this.data = csv;
	}
	
	public void save() throws IOException {
		
		FileOutputStream f = new FileOutputStream(new File(data));
		ObjectOutputStream o = new ObjectOutputStream(f);

		// Write objects to file
		//o.writeObject(p1);

		o.close();
		f.close();
	}

	public String processData() {

		String sb = "";
		return sb.toString();
	}


	public void saveCSV() {

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(data);
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
