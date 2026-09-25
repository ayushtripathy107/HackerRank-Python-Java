class Solution {
    public int maximumPopulation(int[][] logs) {
        // Array to track population changes from year 1950 to 2050
        int[] yearChanges = new int[101];
        
        // Record the birth and death events
        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];
            
            yearChanges[birth - 1950]++; // Population increases at birth year
            yearChanges[death - 1950]--; // Population decreases at death year
        }
        
        int maxPopulation = 0;
        int currentPopulation = 0;
        int earliestYear = 1950;
        
        // Sweep through the years to find the maximum population
        for (int i = 0; i < 101; i++) {
            currentPopulation += yearChanges[i];
            
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                earliestYear = 1950 + i;
            }
        }
        
        return earliestYear;
    }
}
