import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Collections.swap;

public class FindMedianSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length>nums2.length)
            {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            int min=Integer.MIN_VALUE;
            int max=Integer.MAX_VALUE;
            int m = nums1.length;
            int n = nums2.length;
            int left = 0;
            int right = m;
            while (left<=right)
            {
                //习近平
                int i=(left+right)/2;
                int j=(m+n+1)/2-i;
                int left1=(i==0)?min:nums1[i-1];
                int right1=(i==m)?max:nums1[i];
                int left2=(j==0)?min:nums2[j-1];
                int right2=(j==n)?max:nums2[j];
                if(left1<=right2&&left2<=right1)
                {
                    if((n+m)%2==1)
                    {
                        return Math.max(left1,left2);
                    }else
                    {
                        return (Math.max(left1,left2)+Math.min(right1,right2))*0.5;
                    }
                }
                if(right1<left2)
                {
                    left++;
                }else
                {
                    right--;
                }
            }
            return 0;
        }
    }
}
