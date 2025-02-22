// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class CaesarCipher {

    Character[] alphabet;
    DynamicArray<Character> cipher;

    // Need an offset to keep track of different index mappings
    private int offset;

    CaesarCipher(int offset){
        this.offset = offset;
        this.alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = Character.valueOf((char) ('a' + i));
        }
       cipher = new DynamicArray<Character>(offset, alphabet);
       this.offset = offset;
    }

    public char get(int i){
        if (i-offset < 0){
            return cipher.get((i - offset) + alphabet.length);
        } 
        return cipher.get(i - offset);
    }

    public int findIndex(char val){
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] == val){
                return i;
            }
        }
        return -1;
    }

    public static boolean isLowerCaseCharacter(char c) {
        return c >= 'a' && c <= 'z';
    }

    public char encode(int i){
        int adj = i - offset;
        char newChar;
        if(adj >= 0){
            newChar = cipher.get(adj);
        } else{
            newChar = cipher.get(alphabet.length + adj);
        }
        System.out.println("    " + adj + ": " + newChar);
        return newChar;
    }

    /** Encode a message using the cipher
     * @param T message to encode
     * @return encoded message */  
    public String encode(String message){
        char[] original = message.toCharArray();
        char[] encoded = new char[original.length];
        for(int i = 0; i < original.length; i++){
            Character current = original[i];
            if(isLowerCaseCharacter(current)){
                encoded[i] = encode(findIndex(current));
            } else {
                encoded[i] = current;
            }
        }
        return new String(encoded); 
     }
    
     public char decode(char val){
        int i = findIndex(val);
        System.out.println(val + " " + i);

        int adj = i + offset;
        if (adj >= alphabet.length){
            adj -= alphabet.length;
        }
        return(alphabet[adj]);
    }

    /** Decode a message using the cipher 
     * @param String message to decode
     * @param int key to use in decoding
     * @return decoded message
    */
    public String decode(String message){
        char[] original = message.toCharArray();
        char[] decoded = new char[original.length];
        for(int i = 0; i < original.length; i++){
            if(isLowerCaseCharacter(original[i])){
                decoded[i] = decode(original[i]);
            } else{
                decoded[i] = original[i];
            }
        }
        return new String(decoded);
    }

    public static void main(String[] args) {
        CaesarCipher myCipher = new CaesarCipher(3);
        //System.out.println(myCipher.encode("cressida"));
        System.out.println(myCipher.decode("zobppfax"));
        // Challenge: keep upper case
    }   
}
