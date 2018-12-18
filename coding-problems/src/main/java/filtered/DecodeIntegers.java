package filtered;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecodeIntegers {

	public static void main(String[] args) throws Exception {
		String input = "11234";
		InputStream testInput = new ByteArrayInputStream(input.getBytes("UTF-8"));
		System.setIn(testInput);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String encoded = br.readLine();

		List<String> combinations = new DecodeIntegers().solve(encoded);

		// output in the format expected by filtered
		System.out.println(combinations.size());
		Collections.sort(combinations);
		for (String combination : combinations) {
			System.out.println(combination);
		}
	}

	public List<String> solve(String encoded) {
		List<String> combinations = new ArrayList<>();
		if (!(encoded == null || encoded.length() == 0)) {
			permuteCombinations(encoded, "", combinations);
		}
		return combinations;
	}

	private void permuteCombinations(String input, String combination, List<String> combinations) {
		if (input.length() == 0) {
			combinations.add(combination);
			return;
		}

		String firstNum = input.substring(0, 1);
		String decoded = decodeNumber(firstNum);
		String inputWithFirstDigitRemoved = input.substring(1);
		permuteCombinations(inputWithFirstDigitRemoved, combination + decoded, combinations);

		if (input.length() >= 2) {
			String firstTwoNums = input.substring(0, 2);
			int firstTwo = Integer.parseInt(firstTwoNums);
			if (firstTwo > 26) {
				return;
			}
			decoded = decodeNumber(firstTwoNums);
			String inputWithFirstTwoDigitsRemoved = input.substring(2);
			permuteCombinations(inputWithFirstTwoDigitsRemoved, combination + decoded, combinations);
		}
	}

	private String decodeNumber(String number) {
		int num = Integer.parseInt(number);
		num = num + 96;
		char mapped = (char) num;
		return "" + mapped;
	}
}
