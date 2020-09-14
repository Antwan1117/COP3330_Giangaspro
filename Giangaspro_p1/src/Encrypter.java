public class Encrypter {
    public String encrypt (String str) {
        int number = Integer.parseInt(str);

        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;

        // acquire digits
        n1 = number%10;
        number = number/10;

        n2 = number%10;
        number = number/10;

        n3 = number%10;
        number = number/10;

        n4 = number%10;

        // computation
        n1 = encryptionComputation(n1);
        n2 = encryptionComputation(n2);
        n3 = encryptionComputation(n3);
        n4 = encryptionComputation(n4);

        // convert to string
        String str1 = Integer.toString(n1);
        String str2 = Integer.toString(n2);
        String str3 = Integer.toString(n3);
        String str4 = Integer.toString(n4);

        // put back together
        return assembleFinalString(str1,str2,str3,str4);
    }
    public int encryptionComputation (int n) {
        n = (n + 7)%10;
        return n;
    }
    public String assembleFinalString (String str1, String str2, String str3, String str4) {
        return (str2 + str1 + str4 + str3);
    }
}
