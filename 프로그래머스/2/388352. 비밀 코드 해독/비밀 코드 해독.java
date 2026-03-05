class Solution {
    
    int cnt = 0;
    int[] arr = new int[5];
    
    public int solution(int n, int[][] q, int[] ans) {
        recursive(0, 1, n, q, ans);
        return cnt;
    }
    
    private void recursive(int depth, int p, int n, int[][] q, int[] ans) {
        if(depth == 5) {
            if(isPossible(q, ans))
                cnt++;
            return;
        }
        for (int i = p; i <= n; i++) {
            arr[depth] = i;
            recursive(depth + 1, i + 1, n, q, ans);
        }
    }
    
    private boolean isPossible(int[][] q, int[] ans) {
        for(int i = 0; i < ans.length; i++) {
            int cnt = 0;
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(arr[j] == q[i][k]) {
                        cnt++;
                        continue;
                    }
                }
            }
            if(ans[i] != cnt)
                return false;
        }
        return true;
    }
}