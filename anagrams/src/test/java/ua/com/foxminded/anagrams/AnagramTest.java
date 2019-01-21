package ua.com.foxminded.anagrams;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnagramTest {
private Anagram anagram = new Anagram();
	
	@Test
	public void shouldReverseWhen1NonLetterCharacterInTheWord() {
		String actual = anagram.reverse("a1bcd efg!h");
		String expected = "d1cba hgf!e";		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void shouldReverseWhen2NonLetterCharactersInTheWord() {
		String actual = anagram.reverse("a1bc8d efg!h4");
		String expected = "d1cb8a hgf!e4";		
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReverseWhenMultiNonLetterCharactersInTheWord() {
		String actual = anagram.reverse("\\asd()f889    zyx**\\t\\tjkh\\nlop54ty\\");
		String expected = "\\fds()a889    ytp**\\o\\lnhk\\jttx54yz\\";
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReverseWhenContainsCrlf() {
		String actual = anagram.reverse("fds()a889\r\np");
		String expected = "pas()d889\r\nf";
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReverseWhenContainsTabulation() {
		String actual = anagram.reverse("abc\tde");
		String expected = "edc\tba";
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReturnWarningWhenInputIsBlank() {
		String actual = anagram.reverse("");
		String expected = "Строка не должна быть пустой";
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReturnWarningWhenInputIsNull() {
		String actual = anagram.reverse(null);
		String expected = "Строка не должна быть пустой";
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReturnFiveSymbolsWhenInputTextContainsFiveSymbols() {
		Map<Integer, Character> actual = anagram.getNonLetters("1asd()f*!");
		Map<Integer, Character> expected = Map.of(0, '1', 4, '(', 5, ')', 7, '*', 8, '!');
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReturnEmptyMapWhenInputTextContainsNoSymbols() {
		Map<Integer, Character> actual = anagram.getNonLetters("erkshanbgf");
		Map<Integer, Character> expected = new TreeMap();
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReturnAb1cdWhenInputTextContainsAb1cd9() {
		String actual = anagram.removeNonLetters("ab1cd9");
		String expected = "abcd";
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReturnEmptyWhenInputTextContainsOnlyNonLetters() {
		String actual = anagram.removeNonLetters("!2+09%4");
		String expected = "";
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReturnA4bcd9WhenInputTextIsAbcd() {
		TreeMap<Integer, Character> nonLetters =  new TreeMap();
		nonLetters.put(1, '4');
		nonLetters.put(5, '9');
		String actual = anagram.retrieveWord(nonLetters, "abcd");
		String expected = "a4bcd9";
		assertThat(actual, is(expected));
	}

	@Test
	public void shouldReturnTheSameWhenNonLettersIsEmpty() {
		TreeMap<Integer, Character> nonLetters =  new TreeMap();
		String actual = anagram.retrieveWord(nonLetters, "abcd");
		String expected = "abcd";
		assertThat(actual, is(expected));
	}




}
