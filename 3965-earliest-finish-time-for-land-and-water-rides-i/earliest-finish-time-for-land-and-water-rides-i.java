class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
         int minLandEnd = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            minLandEnd = Math.min(minLandEnd, landStartTime[i] + landDuration[i]);
        }
        
        int landToWaterMinFinish = Integer.MAX_VALUE;
        for (int j = 0; j < waterStartTime.length; j++) {
            // Water ride can only start after the land ride finishes AND after it opens
            int waterStart = Math.max(minLandEnd, waterStartTime[j]);
            landToWaterMinFinish = Math.min(landToWaterMinFinish, waterStart + waterDuration[j]);
        }

        // --- SCENARIO 2: Water Ride first, then Land Ride ---
        int minWaterEnd = Integer.MAX_VALUE;
        for (int j = 0; j < waterStartTime.length; j++) {
            minWaterEnd = Math.min(minWaterEnd, waterStartTime[j] + waterDuration[j]);
        }
        
        int waterToLandMinFinish = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            // Land ride can only start after the water ride finishes AND after it opens
            int landStart = Math.max(minWaterEnd, landStartTime[i]);
            waterToLandMinFinish = Math.min(waterToLandMinFinish, landStart + landDuration[i]);
        }

        // Return the best overall path configuration
        return Math.min(landToWaterMinFinish, waterToLandMinFinish);
    }
}