public class Decrypter {
    public String decrypt (String str) {
        int y = Integer.parseInt(str);

        int m1 = 0;
        int m2 = 0;
        int m3 = 0;
        int m4 = 0;

        //acquire digits
        m1 = y%10;
        y = y/10;

        m2 = y%10;
        y = y/10;

        m3 = y%10;
        y = y/10;

        m4 = y%10;

        //perform computations
        m1 = decryptionComputation(m1);
        m2 = decryptionComputation(m2);
        m3 = decryptionComputation(m3);
        m4 = decryptionComputation(m4);

        // convert to string
        String str1 = Integer.toString(m1);
        String str2 = Integer.toString(m2);
        String str3 = Integer.toString(m3);
        String str4 = Integer.toString(m4);

        // put back together
        return assembleFinalString(str1,str2,str3,str4);
    }
    public int decryptionComputation (int m) {
        if (m < 7) {
            return (m+3);
        }
        else {return ((m-10)+3);}
    }
    public String assembleFinalString (String str1, String str2, String str3, String str4) {
        return (str2 + str1 + str4 + str3);
    }
}
