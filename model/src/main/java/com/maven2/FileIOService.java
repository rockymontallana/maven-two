package com.maven2;
import java.util.*;
import java.io.*;
public class FileIOService {

    public List<String> readFile(String fileName) throws IOException{
        List<String> fileContent = new ArrayList<String>();
        String filePath = "C:/Users/Rocky/Desktop/mavenExercise/exercise-two/data/" + fileName;
        Scanner fileInput = new Scanner(new File(filePath));
		
		fileContent.clear();
        while (fileInput.hasNextLine()) {
			fileContent.add(fileInput.nextLine());
        }
        fileInput.close();
        
        for (int i = 0; i < fileContent.size(); i++) {
			if (fileContent.get(i).trim().isEmpty()) {
				fileContent.remove(i);
			}
		}
		
		return fileContent;
    }
	
	public void writeFile(String newFileContent) throws IOException{
		FileWriter writer  = new FileWriter("C:/Users/Rocky/Desktop/mavenExercise/exercise-two/data/newFile.txt");
		
		writer.write(newFileContent);
		writer.close();
		readFile("newFile.txt");	
	}
	
	public Map<String, String> createMap() throws IOException{
		Map<String, String> currentMapContent = new HashMap<String, String>();
		List<String> currentFileContent = new ArrayList<String>();
		
		currentFileContent = readFile("newFile.txt");
		
		for (int i = 0; i < currentFileContent.size(); i++) {
			String[] listLine = currentFileContent.get(i).split("\t");
			
			for (int j = 0; j < listLine.length; j++) {
				String[] keyValue = listLine[j].split(":", 2);
				
				if (keyValue.length >= 2) {
					currentMapContent.put(keyValue[0], keyValue[1]);
				}
			}
		}
		
		return currentMapContent;
	}
}