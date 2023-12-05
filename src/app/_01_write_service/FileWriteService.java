package app._01_write_service;

import app.utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriteService {
    public static void writeToFile(String fileName, String content) {
        // Створення об'єкта Path для визначення шляху до файлу
        Path filePath = Paths.get(Constants.BASE_PATH_IN_AND_OUT, fileName + ".txt");
        try {
            // Створення всіх необхідних каталогів, якщо їх немає
            Files.createDirectories(filePath.getParent());
            // Запис вмісту у файл
            Files.write(filePath, content.getBytes());
            System.out.println("File created and saved successfully.");
        } catch (IOException e) {
            System.err.println("Error creating or writing file: " + e.getMessage());
        }
    }
}
