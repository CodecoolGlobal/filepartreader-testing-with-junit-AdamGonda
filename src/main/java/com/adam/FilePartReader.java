package com.adam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class FilePartReader {

    private String filePath;

    //It has one constructor : it sets the class' instance variables to some invalid default value
    // INCONSISTENT -> WHY DON'T GIV THEM A DEFAULT VALUE AT DECLARATION (MENTORS SAD IT IS BETTER THAT WAY)
    public FilePartReader() {
        filePath = "Default";
    }

    public void setup (String filePath){
        this.filePath = filePath;
    }

    public String read() throws IOException {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(filePath)));
        return data;
    }

    public String readLines (int fromLine, int toLine) throws FileNotFoundException {
        if(fromLine > toLine || fromLine < 1) throw new IllegalArgumentException();

        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        List<String> lines = new ArrayList<>();

        while (sc.hasNextLine()) { lines.add(sc.nextLine()); }


        List<String> resultLines = new ArrayList<>();
        for (int i = fromLine - 1; i < toLine - 1; i++) {
            resultLines.add(lines.get(i));
        }
        return String.join(" ", resultLines);
    }
}
