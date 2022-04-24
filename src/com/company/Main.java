package com.company;

import com.company.logic.Check.CheckStrings;
import com.company.logic.Read;
import com.company.logic.Write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<MyFile> fileList = new ArrayList<>();

        Read readFile = new Read();
        Write writeFile = new Write();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");

        String path = scanner.next();               // вводим путь с консоли

        path = CheckStrings.checkPath(path);        // проверка ввода пути

        readFile.setEnteredPath(path);              // уставанвливаем полю введенный путь
        fileList = readFile.loadFile(fileList);     // считываем из файла данные в arrayList

        writeFile.setFileList(fileList);            // Передаем список документов для записи
        writeFile.writeData();                      // Записываем документы

    }
}
