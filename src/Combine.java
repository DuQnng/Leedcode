import java.util.ArrayList;
import java.util.List;

public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return res;

    }

    private void backtracking(int n, int k, int startIndex) {
        if(path.size()==k)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<=n;i++)
        {
            path.add(i);
            backtracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}
