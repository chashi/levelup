package filtered;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecodeIntegersTest {

	private DecodeIntegers decodeIntegers;

	@BeforeEach
	void setup() {
		decodeIntegers = new DecodeIntegers();
	}

	@Test
	void nulll() {
		List<String> combinations = decodeIntegers.solve(null);
		assertEquals(0, combinations.size());
	}

	@Test
	void empty() {
		List<String> combinations = decodeIntegers.solve("");
		assertEquals(0, combinations.size());
	}

	@Test
	void one1() {
		List<String> combinations = decodeIntegers.solve("1");
		assertEquals(1, combinations.size());
		assertEquals("a", combinations.get(0));
	}

	@Test
	void one2() {
		List<String> combinations = decodeIntegers.solve("2");
		assertEquals(1, combinations.size());
		assertEquals("b", combinations.get(0));
	}

	@Test
	void one3() {
		List<String> combinations = decodeIntegers.solve("9");
		assertEquals(1, combinations.size());
		assertEquals("i", combinations.get(0));
	}

	@Test
	void two1() {
		List<String> combinations = decodeIntegers.solve("11");
		assertEquals(2, combinations.size());
		assertEquals("aa", combinations.get(0));
		assertEquals("k", combinations.get(1));
	}

	@Test
	void two2() {
		List<String> combinations = decodeIntegers.solve("26");
		assertEquals(2, combinations.size());
		assertEquals("bf", combinations.get(0));
		assertEquals("z", combinations.get(1));
	}

	@Test
	void two3() {
		List<String> combinations = decodeIntegers.solve("27");
		assertEquals(1, combinations.size());
		assertEquals("bg", combinations.get(0));
	}

	@Test
	void three() {
		List<String> combinations = decodeIntegers.solve("987");
		assertEquals(1, combinations.size());
		assertEquals("ihg", combinations.get(0));
	}

	@Test
	void original() {
		List<String> combinations = decodeIntegers.solve("1123");
		assertEquals(5, combinations.size());
		assertEquals("aabc", combinations.get(0));
		assertEquals("aaw", combinations.get(1));
		assertEquals("alc", combinations.get(2));
		assertEquals("kbc", combinations.get(3));
		assertEquals("kw", combinations.get(4));
	}

}
