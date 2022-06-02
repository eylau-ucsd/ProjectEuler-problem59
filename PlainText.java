
public class PlainText implements Comparable<PlainText> {
    private final String plainTextString;
    private HeuristicStrategy heuristic;

    public PlainText(String s, HeuristicStrategy heuristic) {
        this.plainTextString = s;
        this.heuristic = heuristic;
    }

    public PlainText(String s) {
        this(s, new CountFreqWord("the"));
    }

    public void setHeuristic(HeuristicStrategy heuristic) {
        this.heuristic = heuristic;
    }

    public int getScore() {
        return heuristic.score(plainTextString);
    }

    public String toString() {
        return plainTextString;
    }

    public int compareTo(PlainText pt) {
        return getScore() - pt.getScore();
    }
}
