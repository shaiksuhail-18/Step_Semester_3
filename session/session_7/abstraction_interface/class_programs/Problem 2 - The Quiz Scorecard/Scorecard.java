public class Scorecard {
    private boolean[] results;
    private int recordedCount;

    public Scorecard(int questions) {
        this.results = new boolean[questions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedCount < results.length) {
            results[recordedCount++] = correct;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}
