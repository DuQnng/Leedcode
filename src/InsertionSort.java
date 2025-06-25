public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        // 外层循环：遍历所有未排序的元素（从第二个元素开始）
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // 当前需要插入的元素
            int j = i - 1;    // 已排序部分的最后一个元素索引
            
            // 内层循环：将 key 插入到已排序部分的正确位置
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // 将比 key 大的元素后移
                j--;
            }
            arr[j + 1] = key; // 插入 key 到正确位置
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        insertionSort(arr);
        System.out.println("排序后数组: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}