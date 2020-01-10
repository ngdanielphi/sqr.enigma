package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {
	int[] c = new int[26];
	//Rotor rot = new Rotor();
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void pos_Advance_newPos() {
		for(int i = 0; i < 26; i++) {
			c[i] = i;
		}
		Rotor rot = new Rotor(c, 5);
		
		int init = rot.getPosition();
		int expected = (init+1) % 26;
		rot.advance();
		assertEquals(expected, rot.getPosition());
	}
	
	@Test
	public void pos_CONVERTBACKWARD_newPos() {
		for(int i = 0; i < 26; i++) {
			c[i] = i;
		}
		Rotor rot = new Rotor(c, 5);
		
		int init = rot.getPosition();
		int e = 0;
		int expected = 0;
		rot.convertBackward(e);
		assertEquals(expected, rot.getPosition());
	}
}
