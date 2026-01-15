package exceptionHandling;

import java.util.*;
import java.io.*;


public class ReadFileLines {

    public static List<String> readFileLines(String filename){

        List<String> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null){
                lines.add(line);
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found: " + e.getMessage());
        } catch(IOException e){
            System.out.println("Error reading files: " + e.getMessage());
        }
        return lines;
    }

    public static void main(String[] args) {
        List<String> lines = readFileLines("test.txt");
        System.out.println("File contents: " + lines);
    }
}
