class Solution {
    public double angleClock(int hour, int minutes) {
        // 1. Calculate positions in degrees relative to 12 o'clock
        double minuteAngle = minutes * 6.0;
        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;
        
        // 2. Find absolute difference
        double diff = Math.abs(hourAngle - minuteAngle);
        
        // 3. Return the smaller angle
        return Math.min(diff, 360.0 - diff);
    }
}
