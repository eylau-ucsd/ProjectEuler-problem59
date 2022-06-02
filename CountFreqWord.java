import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountFreqWord implements HeuristicStrategy {
    private String freqWord;

    public CountFreqWord(String freqWord) {
        this.freqWord = freqWord;
    }

    @Override
    public int score(String msg) {
        Pattern pattern = Pattern.compile(freqWord);
        Matcher matcher = pattern.matcher(msg);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }
}
