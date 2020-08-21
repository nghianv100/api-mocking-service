package mocking.service.utils;

import java.io.BufferedReader;
import java.util.Scanner;

public class IOUtils {

    private IOUtils() {
    }

    public static String readAsString(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        if (reader != null) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine())
                sb.append(scanner.nextLine());
            scanner.close();
        }
        return sb.toString();
    }
}
