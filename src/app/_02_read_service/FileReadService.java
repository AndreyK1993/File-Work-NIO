package app._02_read_service;

import app.utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadService {
    public static String readFromFile(String fileName) {
        // Створення об'єкта Path для визначення шляху до файлу
        Path filePath = Paths.get(Constants.BASE_PATH_IN_AND_OUT, fileName + ".txt");

        // Перевірка на існування та тип файлу перед читанням
        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            System.out.println("File does not exist or is not a regular file.");
            return "";
        }

        try {
            // Читання вмісту файлу та повернення його як рядка
            return Files.readString(filePath);
        } catch (IOException e) {
            // Обробка помилок, пов'язаних із читанням файлу
            System.err.println("Error reading file: " + e.getMessage());
            return "";
        }
    }
}
