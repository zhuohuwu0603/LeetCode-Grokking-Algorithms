public class Solution2 {

    /**
     * 典型的使用三路快排可以解决的问题
     * <p>
     * 在这个过程中 设置 j 和 r 这两个辅助变量
     * 使得 [0,j) 中所有的元素等于 0 ，遍历过程中 i j 互换，然后 j 加 1 ， i 加 1
     * [j,i) 中所有的元素等于 1 , 遍历过程中， i 加 1 就可以了
     * [r,lenght-1] 中所有的元素等于 2 ，遍历过程中 r 先减1，交换 i 和 r ，注意，此时 i 不加
     * 不用 for 循环，因为不是从头遍历到为，这里采用的是指针碰撞，直到 i 和 r 撞到一起为止
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length;
        while (i < r) {
            if (nums[i] == 0) {
                swap(nums, i++, l++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, --r);
            }
        }
    }

    // 特别要注意边界条件的判断

    public void sortColors1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        // 定义
        // [0,left) 都等于 0
        // [left,index) 都等于 1
        // [right,len) 都等于 2
        int left = 0;

        // 初始值 right 在边界外，所以交换完 right 之后，right 的情况我们是已经知道的
        int right = len;
        int index = 0;
        while (index < right) {
            if (nums[index] == 0) {
                // 交换
                swap(nums, left, index);
                left++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                assert nums[index] == 2;
                right--;
                swap(nums, index, right);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
