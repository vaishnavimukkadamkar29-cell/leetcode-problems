class Solution {
    public int minimumEffort(int[][] tasks) {
         Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int initialEnergy = 0;
        int currentEnergy = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            // Step 2: If we don't have enough to start the task, "top up"
            if (currentEnergy < minimum) {
                int needed = minimum - currentEnergy;
                initialEnergy += needed;
                currentEnergy += needed;
            }

            // Step 3: Spend the actual energy required for the task
            currentEnergy -= actual;
        }

        return initialEnergy;
    }
}