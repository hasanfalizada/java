package test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IOExample {
	public static void main(String[] args) throws IOException {
		////////////////////////////////////////////////////////////////////
		try {
			// read all bytes
			byte[] bytes = Files.readAllBytes(Paths.get("C:\\Temp\\input.txt"));

			// convert bytes to string
			String content = new String(bytes);

			// print contents
			System.out.println(content);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////

		try {
			// read all lines
			List<String> lines = Files.readAllLines(Paths.get("C:\\Temp\\input.txt"), StandardCharsets.UTF_8);

			// print all lines
			for (String line : lines) {
				System.out.println(line);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////

		try {
			// initialize lines stream
			Stream<String> stream = Files.lines(Paths.get("C:\\Temp\\input.txt"), StandardCharsets.UTF_8);

			// apply filters and print all lines
			stream.map(String::trim).filter(l -> !l.isEmpty()).forEach(System.out::println);

			// close the stream
			stream.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////

		try {
			// data to write
			String contents = "Hey, there!\nWhat's up?";

			// write to file
			Files.write(Paths.get("C:\\Temp\\output.txt"), contents.getBytes());

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////

		try {
			// data to write
			String contents = "Weldone!";

			// append to file
			Files.write(Paths.get("C:\\Temp\\output.txt"), contents.getBytes(), StandardOpenOption.APPEND);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////

		try {
			// data to write
			List<String> contents = Arrays.asList("Hey, there", "How are you doing?");

			// write to file
			Files.write(Paths.get("C:\\Temp\\output.txt"), contents, StandardCharsets.UTF_8, StandardOpenOption.CREATE);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////

		// writes all files of the current directory
		Files.list(Paths.get(".")).forEach(System.out::println);

	}
}
