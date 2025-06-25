import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencyCounter {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 5, 3, 3, 5, 5, 5}; // 示例数组
        int k=nums.length;
        // 统计数字频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for(Map.Entry<Integer,Integer> m:frequencyMap.entrySet())
        {
            if(pq.size()<k)
            {
                pq.add(new int[]{m.getKey(),m.getValue()});
            }else {
                if(m.getValue()>pq.peek()[1]){
                    pq.poll();
                    pq.add(new int[]{m.getKey(),m.getValue()});
                }
            }
        }
        // 输出结果
        System.out.println("数字\t出现次数");
        System.out.println("----------------");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.printf("%d\t→\t%d次%n", entry.getKey(), entry.getValue());
        }
        int[] result=new int[k];
        for (int i=k-1;i>=0;i--){
            result[i]=pq.poll()[0];
            System.out.println(result[i]);
        }

    }
}