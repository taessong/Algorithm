import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        ArrayList<int[]> arr = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int extIdx = map.get(ext);
        int sortIdx = map.get(sort_by);
        
        for(int i = 0; i < data.length; i++) {
            if(data[i][extIdx] < val_ext) arr.add(data[i]);
        }
        
        arr.sort(Comparator.comparing(x -> x[sortIdx]));
        
        return arr.toArray(int[][]::new);
    }
}