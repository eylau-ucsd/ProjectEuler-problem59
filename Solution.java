import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static final String CIPHER_TEXT_FILE = "p059_cipher.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(CIPHER_TEXT_FILE));
        StringBuilder sb = new StringBuilder();
        reader.useDelimiter(",");
        while (reader.hasNext()) {
            char result = (char) reader.nextInt();
            sb.append(result);
        }
        String cipherText = sb.toString();
        List<PlainText> ptCandidates = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                for (char k = 'a'; k <= 'z'; k++) {
                    String key = (new StringBuilder()).append(i).append(j).append(k).toString();
                    PlainText ptCandidate = decrypt(cipherText, key);
                    ptCandidates.add(ptCandidate);
                }
            }
        }
        Collections.sort(ptCandidates, Collections.reverseOrder());
        String answer = ptCandidates.get(0).toString();
        System.out.println(answer);
        System.out.println();
        System.out.println(String.format("Sum of ASCII values: %d", sumOfAscii(answer)));
    }

    public static PlainText decrypt(String cipherText, String key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char cipherChar = cipherText.charAt(i);
            char keyChar = key.charAt(i % key.length());
            char plainChar = (char) (cipherChar ^ keyChar);
            sb.append(plainChar);
        }
        return new PlainText(sb.toString());
    }

    public static int sumOfAscii(String s) {
        int acc = 0;
        for (int i = 0; i < s.length(); i++) {
            acc += s.charAt(i);
        }
        return acc;
    }
}
