import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    List<List<String>> res=new ArrayList<List<String>>();
    List<String> path = new ArrayList<String>();
    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return res;
    }
    void backtrack(String s,int index)
    {
        if(index>=s.length())
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();i++)
        {
            if(isPalidrome(s,index,i)){
                String str=s.substring(index,i+1);
                path.add(str);
            }else
            {
                continue;
            }
            backtrack(s,i+1);
            path.remove(path.size()-1);
        }
    }

    private boolean isPalidrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }

}
