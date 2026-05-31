class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        
        // Use a long variable to prevent integer overflow during accumulation
        long currentMass = mass;
        
        for (int asteroid : asteroids) {
            // If the current asteroid is too heavy, the planet is destroyed
            if (asteroid > currentMass) {
                return false;
            }
            // Absorb the asteroid's mass
            currentMass += asteroid;
        }
        
        return true;
        
    }
}