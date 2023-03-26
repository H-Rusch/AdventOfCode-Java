package util.days;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputFetcher {

    private final static Path INPUT_PATH = Paths.get("src/main/resources/inputs/");

    public static String fetchInput(int year, int day) throws UnsuccessfulDownloadException, IOException, InterruptedException {
        createDirectoryIfNotExists(year);

        if (!testDayExists(year, day)) {
            String input = makeRequest(year, day);
            saveToFile(year, day, input);
            return input;
        }

        return loadInputFromFile(year, day);
    }

    private static String loadInputFromFile(int year, int day) throws IOException {
        Path file = INPUT_PATH.resolve(year + "/" + getFilename(day));

        return Files.readString(file);
    }

    private static void createDirectoryIfNotExists(int year) {
        Path folder = INPUT_PATH.resolve(String.valueOf(year));
        if (!Files.exists(folder)) {
            try {
                Files.createDirectory(folder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static Path getFilePath(int year, int day) {
        return INPUT_PATH.resolve(year + "/" + getFilename(day));
    }

    private static String getFilename(int day) {
        return String.format("day%02d.txt", day);
    }

    private static boolean testDayExists(int year, int day) {
        Path file = getFilePath(year, day);

        return Files.isRegularFile(file);
    }

    private static String makeRequest(int year, int day) throws IOException, InterruptedException, UnsuccessfulDownloadException {
        System.out.println("Downloading input");

        // read session from .env
        Dotenv dotenv = Dotenv.load();
        String sessionId = dotenv.get("session");

        URI uri = URI.create("https://adventofcode.com/" + year + "/day/" + day + "/input");

        // make http request
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Cookie", "session=" + sessionId)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // handle response
        if (response.statusCode() != 200) {
            throw new UnsuccessfulDownloadException(response.body());
        }

        System.out.println("Input downloaded successfully.");

        return response.body();
    }

    private static void saveToFile(int year, int day, String input) {
        Path file = getFilePath(year, day);

        try {
            Files.writeString(file, input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws UnsuccessfulDownloadException, IOException, InterruptedException {
        fetchInput(2015, 1);
    }
}
