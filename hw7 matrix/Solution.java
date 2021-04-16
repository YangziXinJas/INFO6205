public class Solution{

    // 1. https://leetcode.com/problems/rotate-image/
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private void transpose(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    private void reflect(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - j - 1];
                matrix[i][matrix[0].length - j - 1] = temp;
            }
        }
    }

    // 2. https://leetcode.com/problems/reverse-words-in-a-string/
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.trim().split("\\s+");
        System.out.println(strs.length);
    
        for (int i = strs.length-1; i >= 0; i--)
        {
            String str = strs[i];
            sb.append(str);
            if (i != 0) sb.append(" ");  
        }
        return sb.toString();  
    }

    // 3. https://leetcode.com/problems/set-matrix-zeroes/
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        int row = matrix.length;
        int column = matrix[0].length;
       
        for (int c = 0; c < column; c++){
            if (matrix[0][c] == 0)
                firstRow = true;
        }
       
        for (int r = 0; r < row; r++){
            for (int c = 0; c < column; c++){
                if (matrix[r][c] == 0)
                    matrix[0][c] = 0;
            }
        }
       
        for (int r = 1; r < row; r++){
            boolean rowZero = false;
           
            for (int c = 0; c < column; c++){
                if (matrix[r][c] == 0)
                    rowZero = true;
            }
           
            for (int c = 0; c < column; c++){
                if (rowZero || matrix[0][c] == 0)
                    matrix[r][c] = 0;
            }
        }
       
        for (int c = 0; c < column; c++){
            if (firstRow)
                matrix[0][c] = 0;
        }
    }

    // 4. https://leetcode.com/problems/valid-anagram/
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
       
        int[] alphabet = new int[26];
       
        for(int i = 0; i < s.length(); i++){
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
       
        for(int c: alphabet){
            if(c != 0){
                return false;
            }
        }
        return true;
    }

    // 5. https://leetcode.com/problems/longest-common-prefix/
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
       
        int min = Integer.MAX_VALUE;
        for(String s: strs){
            min = Math.min(s.length(), min);
        }
       
        int left = 1;
        int right = min;
       
        while(left <= right){
            int mid = (left + right) / 2;
            if(isCommon(strs, mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
       
        return strs[0].substring(0, (left + right) / 2);
    }
   
    private boolean isCommon(String[] strs, int length){
        String s = strs[0].substring(0, length);
        for(int i = 1; i < strs.length; i++){
            if(!strs[i].startsWith(s)){
                return false;
            }
        }
        return true;
    }
}