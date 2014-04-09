package itmo.cs.testing.lab2.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Logger;

public class Parser {

	private static final Logger log = Logger.getLogger(Parser.class.getName());

	private static final String DELIMITER = "	";

	public static Collection<ResultUnit> parse(String resource) {
		Collection<ResultUnit> result = new ArrayList<>();
		InputStream input = Parser.class.getResourceAsStream(resource);
		if (input == null) {
			log.warning(String.format("Resource %s not found", resource));
			throw new IllegalArgumentException();
		}
		try (Scanner scan = new Scanner(input)) {
			while (scan.hasNext()) {
				result.add(getResultUnit(scan.nextLine()));
			}
		}
		return result;
	}

	private static ResultUnit getResultUnit(String line) {
		ResultUnit res = new ResultUnit();
		String[] s = line.split(DELIMITER);
		try {
			res.setX(Double.parseDouble(s[0]));
			res.setY(Double.parseDouble(s[1]));
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			log.warning("Parse exception couse:\n "
					+ e.getStackTrace().toString());
		}
		return res;
	}
}
