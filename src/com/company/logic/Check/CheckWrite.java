package com.company.logic.Check;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * В классе CheckWrite реализованы методы:
 * createADirectory() - создает папку, куда будут сохраняться файл-отчеты
 * createFileForNotValidData() - создает файл для записи невалидных данных
 * createFileForValidData() - создает файл для записи валидных данных
 * */

public final class CheckWrite {

    private final String PROJECT_PATH = "src/";
    private final String DIRECTORY_NAME = "report";
    private String filePath;

    public void createADirectory() {
        File directory = new File(PROJECT_PATH + "/" + DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdir();
        }
        filePath = PROJECT_PATH + "/" + DIRECTORY_NAME;

    }

    public String createFileForNotValidData() throws IOException {

        Path notValid = Paths.get(filePath + "/" + "notValidData.txt");

        File notValidData = new File(notValid.toString());
        if (!notValidData.exists()) {
            Files.createFile(notValid);
        }
        return filePath + "/" + "notValidData.txt";
    }


    public String createFileForValidData() throws IOException {

        Path valid = Paths.get(filePath + "/" + "validData.txt");

        File validData = new File(valid.toString());
        if (!validData.exists()) {
            Files.createFile(valid);
        }
        return filePath + "/" + "validData.txt";
    }
}
