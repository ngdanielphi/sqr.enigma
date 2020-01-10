package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {
	int[] r = new int[26];
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	@Test
	public void pos_CONVERTFORWARD_newPos() {
		for(int i = 0; i < 26; i++) {
			r[i] = i;
		}
		Reflector refl = new Reflector(r);
		
		int init = refl.getPosition();
		int e = 25;
		int expected = 25;
		refl.convertForward(e);
		assertEquals(expected, refl.getPosition());
	}

}
