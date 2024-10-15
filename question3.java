import java.util.*;

class College {
    String name;
    String location;
    int fees;
    int ranking;
    
    public College(String name, String location, int fees, int ranking) {
        this.name = name;
        this.location = location;
        this.fees = fees;
        this.ranking = ranking;
    }
}

public class CollegeRankingSystem {

    public static List<String> rankColleges(List<College> colleges, String preferredLocation, int maxFees, int rankingWeight, int feesWeight) {
        List<String> result = new ArrayList<>();

        // Step 1: Filter the colleges by preferred location and fees
        List<College> filteredColleges = new ArrayList<>();
        for (College college : colleges) {
            if (college.location.equals(preferredLocation) && college.fees <= maxFees) {
                filteredColleges.add(college);
            }
        }

        // Step 2: Calculate score for each college
        Map<College, Double> collegeScores = new HashMap<>();
        for (College college : filteredColleges) {
            double score = (college.ranking * rankingWeight) + ((double)college.fees / maxFees) * feesWeight;
            collegeScores.put(college, score);
        }

        // Step 3: Sort colleges by score in non-decreasing order
        filteredColleges.sort((c1, c2) -> {
            double score1 = collegeScores.get(c1);
            double score2 = collegeScores.get(c2);
            return Double.compare(score1, score2);
        });

        // Step 4: Output the sorted list of colleges
        for (College college : filteredColleges) {
            double score = collegeScores.get(college);
            result.add(String.format("Name: %s, Location: %s, Fees: %d, Ranking: %d, Score: %.2f",
                    college.name, college.location, college.fees, college.ranking, score));
        }

        return result;
    }

    public static void main(String[] args) {
        // Example input
        List<College> colleges = Arrays.asList(
                new College("College A", "New York", 20000, 1),
                new College("College B", "California", 15000, 2),
                new College("College C", "New York", 25000, 3),
                new College("College D", "New York", 10000, 4)
        );

        String preferredLocation = "New York";
        int maxFees = 20000;
        int rankingWeight = 2;
        int feesWeight = 1;

        // Get the ranked colleges based on the user's preferences
        List<String> rankedColleges = rankColleges(colleges, preferredLocation, maxFees, rankingWeight, feesWeight);

        // Print the ranked colleges
        for (String collegeInfo : rankedColleges) {
            System.out.println(collegeInfo);
        }
    }
}
