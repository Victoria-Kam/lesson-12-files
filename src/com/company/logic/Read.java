package com.company.logic;

import com.company.MyFile;
import com.company.logic.Check.CheckStrings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/*
 * В классе Read реализованы методы:
 * loadFile() - чтение из файла, который находится в папке resources
 * setEnteredPath() - устанавливает полю enteredPath введенный с консоли путь
 * getEnteredPath() - возвращает путь, который был введен с консоли
 * */

public final class Read {

    private final String SOURCE_PATH = "src/resources/file.txt";
    BufferedReader bufferedReader;

    public String enteredPath;

    public Read() {
    }


    public ArrayList<MyFile> loadFile(ArrayList<MyFile> fileList) throws IOException {  // Чтение из файла, который находится в папке resources

        String line;

        try {
            FileReader reader = new FileReader(this.enteredPath);
            bufferedReader = new BufferedReader(reader, 100);

            while ((line = bufferedReader.readLine()) != null) {

                fileList.add(new MyFile(line, CheckStrings.checkLine(line)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }

        return fileList;
    }


    public void setEnteredPath(String enteredPath) {

        this.enteredPath = enteredPath;
    }

    public String getEnteredPath() {
        return this.enteredPath;
    }
}
