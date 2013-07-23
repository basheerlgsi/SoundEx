package ex.soundex;

import static org.junit.Assert.*;

import org.junit.Test;

public class SoundExTest {

	@Test 
	public void testOneLetterWord() throws Exception {
		assertEquals("A000", SoundEx.encode("A"));
	}
	
	@Test 
	public void testtwoLetterWord() throws Exception {
		assertEquals("A000", SoundEx.encode("AA"));
	}
	
	@Test 
	public void testthreeLetterWord() throws Exception {
		assertEquals("A000", SoundEx.encode("AAA"));
	}
	//Retain the first letter of the name and drop all other occurrences of a, e, i, o, u, y, h, w
	@Test
	public void testVowelDropAEIWord() throws Exception {
		assertEquals("A000", SoundEx.encode("Aaei"));
	}
	//Retain the first letter of the name and drop all other occurrences of a, e, i, o, u, y, h, w
	@Test
	public void testVowelDropOUYWord() throws Exception {
		assertEquals("A000", SoundEx.encode("Aouy"));
	}
	//Retain the first letter of the name and drop all other occurrences of a, e, i, o, u, y, h, w
	@Test
	public void testVowelDropWHWord() throws Exception {
		assertEquals("A000", SoundEx.encode("AWH"));
	}
	
	@Test //char b,  f, p, v ==>1
	public void testLetterbWord() throws Exception {
		assertEquals("A100", SoundEx.encode("Ab"));
	}
	@Test //char b,  f, p, v==>1
	public void testLetterfWord() throws Exception {
		assertEquals("A100", SoundEx.encode("Af"));
	}
	@Test //char b,  f, p, v==>1
	public void testLetterpWord() throws Exception {
		assertEquals("A100", SoundEx.encode("Ap"));
	}
	@Test //char b,  f, p, v==>1
	public void testLetterAvWord() throws Exception {
		assertEquals("A100", SoundEx.encode("Av"));
	}
	
	@Test //c, g, j, k, q, s, x, z => 2
	public void testLetterAcgjWord() throws Exception {
		assertEquals("A200", SoundEx.encode("Acgj"));
	}
	
	@Test //c, g, j, k, q, s, x, z => 2
	public void testLetterAkqsWord() throws Exception {
		assertEquals("A200", SoundEx.encode("Akqs"));
	}
	
	@Test //c, g, j, k, q, s, x, z => 2
	public void testLetterAZXWord() throws Exception {
		assertEquals("A200", SoundEx.encode("AZX"));
	}
	
	@Test //•d, t => 3
	public void testLetterAdtWord() throws Exception {
		assertEquals("A300", SoundEx.encode("Adt"));
	}
	
	@Test //•d, t => 3 and ignore vowel
	public void testLetterAdetWord() throws Exception {
		assertEquals("A330", SoundEx.encode("Adet"));
	}
	
	@Test //•l => 4
	public void testLetterAlWord() throws Exception {
		assertEquals("A400", SoundEx.encode("Al"));
	}
	
	@Test //•l => 4 and ignore vowel
	public void testLetterAluWord() throws Exception {
		assertEquals("A400", SoundEx.encode("Alu"));
	}
	
	@Test //•m, n => 5 
	public void testLetterAmnWord() throws Exception {
		assertEquals("A500", SoundEx.encode("Amn"));
	}
	@Test //•m, n => 5 and ignore vowel
	public void testLetterAmenWord() throws Exception {
		assertEquals("A550", SoundEx.encode("Amen"));
	}
	
	@Test //•r => 6
	public void testLetterArWord() throws Exception {
		assertEquals("A600", SoundEx.encode("Ar"));
	}
	@Test //•r => 6 and ignore vowel
	public void testLetterAreWord() throws Exception {
		assertEquals("A600", SoundEx.encode("Ar"));
	}
	
	@Test //•d, t => 3 and  two numbers same with h encoded as single number
	public void testtwoLetterAdhtWord() throws Exception {
		assertEquals("A300", SoundEx.encode("Adht"));
	}
	
	@Test //threeletter with h encoded 
	public void testthreeLetterAdamhntWord() throws Exception {
		assertEquals("A353", SoundEx.encode("Adamhnt"));
		
	}
	
	@Test //threeletter with a encoded 
	public void testthreeLetterAdamantWord() throws Exception {
		assertEquals("A355", SoundEx.encode("Adamant"));
		
	}
	
	@Test //If you have more than 3 letters, just retain the first 3 numbers
	public void testMorethanthreeLetterWord() throws Exception {
		assertEquals("T152", SoundEx.encode("TapanKumar"));
		
	}
	
	@Test //Acceptance case 1 Robert
	public void testRobertWord() throws Exception {
		assertEquals("R163", SoundEx.encode("Robert"));
		
	}
	
	@Test //Acceptance case 1 Rupert
	public void testRupertWord() throws Exception {
		assertEquals("R163", SoundEx.encode("Rupert"));
		
	}
	
	@Test //Acceptance case 1 Rubin
	public void testRubinWord() throws Exception {
		assertEquals("R150", SoundEx.encode("Rubin"));
		
	}
	@Test //Acceptance case 2 Ashcraft
	public void testAshcraftWord() throws Exception {
		assertEquals("A261", SoundEx.encode("Ashcraft"));
		
	}
	@Test //Acceptance case 2 Ashcroft
	public void testAshcroftWord() throws Exception {
		assertEquals("A261", SoundEx.encode("Ashcroft"));
		
	}
	@Test //Acceptance case 3 Tymczak
	public void testTymczakWord() throws Exception {
		assertEquals("T522", SoundEx.encode("Tymczak"));
	}
	@Test //Acceptance case 4 Pfister
	public void testPfisterWord() throws Exception {
		assertEquals("P236", SoundEx.encode("Pfister"));
	}
	
	@Test
	public void testAmanWord() throws Exception {
		assertEquals("A550", SoundEx.encode("Aman"));
	}
	
	@Test //rule no 2 applying to first letter with h encoded
	public void testAhAWord() throws Exception {
		assertEquals("A000", SoundEx.encode("AhA"));
	}
	
	@Test //Mississippi
	public void MISSISSIPPI() throws Exception {
		assertEquals("M221", SoundEx.encode("MISSISSIPPI"));
	}
}
