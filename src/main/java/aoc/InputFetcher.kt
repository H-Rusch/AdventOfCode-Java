package aoc

import aoc.exception.SessionTokenNotFoundException
import aoc.exception.UnsuccessfulDownloadException
import io.github.cdimascio.dotenv.Dotenv
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.io.path.isRegularFile

private val logger: Logger = LoggerFactory.getLogger("InputFetcher")

private val inputsPath: Path = Paths.get("src/main/resources/inputs/")
private val examplesPath: Path = Paths.get("src/main/resources/examples/")
private val userAgentHeader: String = "https://github.com/H-Rusch/AdventOfCode-Java contact @ https://github.com/H-Rusch/AdventOfCode-Java/issues/new"

fun fetchInput(year: Int, day: Int): String {
    createInputDirectoryIfNotExists(year)

    val filePath = buildInputFilePath(year, day)
    if (!isFilePresent(filePath)) {
        logger.debug("Input file for year $year and day $day not present.")

        val input = makeInputRequest(year, day)
        saveInputToFile(filePath, input)
    }

    return loadInputFromFile(filePath)
}

fun loadExample(year: Int, filename: String): String {
    val filePath = examplesPath.resolve(year.toString()).resolve(filename)

    return Files.readString(filePath)
}

private fun createInputDirectoryIfNotExists(year: Int) {
    val directoryPath: Path = inputsPath.resolve(year.toString())

    if (Files.exists(directoryPath) && Files.isDirectory(directoryPath)) {
        return
    }

    logger.debug("Creating input directory for $year.")
    Files.createDirectory(directoryPath)
}

private fun buildInputFilePath(year: Int, day: Int): Path =
    inputsPath.resolve(year.toString()).resolve(getPaddedFilename(day))

private fun getPaddedFilename(day: Int): String = "day${"%02d".format(day)}.txt"

private fun isFilePresent(filePath: Path): Boolean = filePath.exists() && filePath.isRegularFile()

private fun makeInputRequest(year: Int, day: Int): String {
    val sessionToken = readSessionTokenFromDotenv() ?: throw SessionTokenNotFoundException()

    val response = performRequest(year, day, sessionToken)
    if (response.statusCode() != 200) {
        throw UnsuccessfulDownloadException(response.body())
    }

    return response.body()
}

private fun readSessionTokenFromDotenv(): String? {
    logger.debug("Trying to load session token from .env")
    val dotenv = Dotenv.load()
    return dotenv["session"]
}

private fun performRequest(year: Int, day: Int, sessionToken: String): HttpResponse<String> {
    logger.debug("Performing request to download personal input.")

    val uri = URI.create("https://adventofcode.com/$year/day/$day/input")
    val request = HttpRequest.newBuilder()
        .uri(uri)
        .header("Cookie", "session=$sessionToken")
        .header("User-Agent", userAgentHeader)
        .GET()
        .build()
    val client = HttpClient.newHttpClient()

    return client.send(request, HttpResponse.BodyHandlers.ofString())
}

private fun saveInputToFile(filePath: Path, input: String) {
    logger.debug("Saving input to file.")

    Files.write(filePath, input.trim().toByteArray())
}

private fun loadInputFromFile(filePath: Path): String = Files.readString(filePath)
