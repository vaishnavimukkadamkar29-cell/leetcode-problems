        import java.util.*;
class Solution {
    public int minJumps(int[] nums) {

 int n = nums.length;

        // prime -> list of indices divisible by prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Build map
        for (int i = 0; i < n; i++) {

            Set<Integer> factors = getPrimeFactors(nums[i]);

            for (int f : factors) {
                map.computeIfAbsent(f, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int jumps = 0;

        // avoid processing same prime multiple times
        Set<Integer> used = new HashSet<>();

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {

                int i = q.poll();

                if (i == n - 1) return jumps;

                // left
                if (i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                // right
                if (i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                // teleport only if nums[i] is PRIME
                if (isPrime(nums[i])) {

                    int p = nums[i];

                    if (!used.contains(p)) {

                        List<Integer> list = map.get(p);

                        if (list != null) {

                            for (int idx : list) {

                                if (!vis[idx]) {
                                    vis[idx] = true;
                                    q.offer(idx);
                                }
                            }
                        }

                        used.add(p);
                    }
                }
            }

            jumps++;
        }

        return -1;
    }

    // check prime
    private boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) return false;
        }

        return true;
    }

    // unique prime factors
    private Set<Integer> getPrimeFactors(int num) {

        Set<Integer> set = new HashSet<>();

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {

                set.add(i);

                while (num % i == 0) {
                    num /= i;
                }
            }
        }

        if (num > 1) {
            set.add(num);
        }

        return set;
    }
}
        