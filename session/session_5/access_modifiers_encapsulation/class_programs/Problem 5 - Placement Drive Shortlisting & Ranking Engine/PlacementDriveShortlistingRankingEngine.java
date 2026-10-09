import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;
    double compositeScore;
    
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.compositeScore = cgpa * 10 + codingScore;
    }
    
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}

public class PlacementDriveShortlistingRankingEngine {
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }
    
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }
    
    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] eligibleTemp = new Candidate[candidates.length];
        int count = 0;
        
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                eligibleTemp[count++] = c;
            }
        }
        
        Candidate[] eligible = Arrays.copyOf(eligibleTemp, count);
        Arrays.sort(eligible);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < eligible.length; i++) {
            sb.append((i + 1)).append(". ").append(eligible[i].name).append(" (").append(eligible[i].compositeScore).append(")");
            if (i < eligible.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
