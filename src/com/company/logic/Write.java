package com.company.logic;

import com.company.MyFile;
import com.company.logic.Check.CheckWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * * В классе Write реализованы методы:
 * setFileList() - присваивает fileList данные, которые были переданы в этот метод
 * createFiles() - вызывает методы из класса CheckWrite для создания файлов, если их не существует, и возвращает путь к этим файлам
 * writeData() - записывает данные из fileList в файлы
 * writeValidData() - записывает валидные данные в файл validData.txt
 * writeNotValidData() - записывает валидные данные в файл notValidData.txt
 * findTheReason() - возвращает строку, которая указывает причину невалидности данных
 */

public final class Write {

    private FileWriter fileWriterValid;
    private FileWriter fileWriterNotValid;

    private ArrayList<MyFile> fileList;
    private CheckWrite checkWrite;

    private String notValidPath;
    private String validPath;

    public Write() {
        fileList = new ArrayList<>();
        checkWrite = new CheckWrite();
        this.createFiles();
    }

    public void setFileList(ArrayList<MyFile> fileList) {
        this.fileList = fileList;
    }

    public void createFiles() {

        try {
            checkWrite.createADirectory();
            notValidPath = checkWrite.createFileForNotValidData();
            validPath = checkWrite.createFileForValidData();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void writeData() {

        try {
            this.writeValidData();
            this.writeNotValidData();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private void writeValidData() throws IOException {

        File fileWrite = new File(validPath);
        fileWriterValid = new FileWriter(fileWrite);

        try (BufferedWriter writer = new BufferedWriter(fileWriterValid)) {
            for (MyFile file : fileList) {
                if (file.isValid()) {
                    writer.write(file.getNumber() + "\n");
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void writeNotValidData() throws IOException {

        File fileWrite = new File(notValidPath);
        fileWriterNotValid = new FileWriter(fileWrite);

        try (BufferedWriter writer = new BufferedWriter(fileWriterNotValid)) {
            for (MyFile file : fileList) {
                if (!file.isValid()) {
                    writer.write(file.getNumber() + " " + this.findTheReason(file));
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String findTheReason(MyFile file) {
        if (file.getNumber().length() > 15) {
            return "\tБольше положенной длины\n";
        }
        return "\tЕсть иные символы\n";
    }

}
