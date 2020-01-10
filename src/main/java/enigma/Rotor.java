package enigma;

public class Rotor {

    private int position;
    private int[] cipher = new int[26];
    private int[] bcipher = new int[26];
    private int notch1 = -1;
    private int notch2 = -1;
    
    /**
     * 
     * @return int
     * Function : La fonctionr renvoie la position du rotor.
     */
    public int getPosition() {
        return position;
    }
    
    /**
     * 
     * @param posn
     * Function : Permet d'indiquer la fonction du rotor.
     */
    public void setPosition(int posn) {
        position = posn;
    }
    
    /**
     * 
     * @param str
     * @param notches
     * @return Rotor
     * Function : La fonction permet de créer un nouveau rotor selon la chaîne de caractères rentrer.
     * 			  Le fonction va faire tourner soit deux rotors, soit un seul selon la longueur du notches.
     */
	public static Rotor rotorFactory(String str, String notches){
		char[] s = str.trim().replace(" ", "").toCharArray(); //Permet de remplacer chaque espace par rien
		int[] cipher = new int[26]; //Création d'un tableau d'entier
		for (int i = 0; i< 26; i++){ 
			cipher[i] = toIndex(s[i]); //Appel la fonction toIndex afin de remplir le tableau cipher.
		}
		s = notches.trim().replace(" and ", "").toCharArray(); //Remplace les and dans la chaîne notches par rien
		if (s.length == 2){
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1])); //Si la longueur de s = 2, on créé un rotor permettant de faire tourner 2 rotor 
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}
		
	}
	
	/**
	 * 
	 * @param c
	 * @param notch1
	 * @param notch2
	 * Function : Constructor of Rotor class creating a backcipher with 2 notch
	 */
	Rotor(int[] c, int notch1, int notch2) {
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}
	
	/**
	 * 
	 * @param c
	 * @param notch1
	 * Function : Constructor of Rotor class creating a backcipher with 1 notch
	 */
	Rotor(int[] c, int notch1) {
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}
	
	/**
	 * 
	 * @param p
	 * @return the position of the rotor
	 * Function : 
	 */
    public int convertForward(int p) {
        return ((cipher[((p+position)%26+26)%26]-position)%26+26)%26;
    }

    public int convertBackward(int e) {
        return ((bcipher[((e+position)%26+26)%26]-position)%26+26)%26;
    }
    
    public void advance() {
        position = (position+1) % 26;
    }
    
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }

    protected static char toLetter(int p) {
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) {
        return c - 'A';
    }
    
	private void createBCipher() {
		for(int i =0; i<26; i++)
			bcipher[cipher[i]] = i;
	}



}
