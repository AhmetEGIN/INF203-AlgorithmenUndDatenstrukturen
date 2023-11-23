import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] nums = {5};

        int target = 5;
//        System.out.println(binarySearch(nums, target, 0, nums.length - 1));
        System.out.println(binarySearch2(nums, target, 0, nums.length -1));
//        System.out.println(binarySearchWithWhileLoop(nums, target));


    }

    public static boolean binarySearch(int[] nums, int target, int left, int right) {
        /*
         * 0 - 12   -> 6
         * 6 - 12   -> 9
         * 9 - 12   -> 10
         * 10 - 12   -> 11
         * 11 - 12
         * */

        if (right > left) {

            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            else if (nums[mid] > target) {
                return binarySearch(nums, target, left, mid);
            } else {
                return binarySearch(nums, target, mid + 1, right);
            }

        }

        return false;


    }

    public static boolean binarySearchWithWhileLoop(int[] nums, int target) {
        int[] tempArray = nums.clone();
        int mid;
        while (true) {
            mid = tempArray.length / 2;
            if (tempArray[mid] == target) return true;
            if (tempArray[mid] > target) {
//                tempArray = tempArray.
                tempArray = Arrays.copyOfRange(tempArray, mid, tempArray.length);
            }else {
                tempArray = Arrays.copyOfRange(tempArray, 0, mid - 1);
            }

        }
//        return false;

    }

    public static int binarySearch2(int[] nums, int target, int left, int right) {
//        Bu metot aranan elemanın kaçıncı index' te olduğunu gösterir.
//        Eğer eleman array içerisinde yoksa -1 döner.
        int index = -1;
        if (right >= left) {

            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                index = mid;
                return index;
            } else if (nums[mid] > target) {
                return binarySearch2(nums, target, left, mid - 1);
            } else {
                return binarySearch2(nums, target, mid + 1, right);
            }

        }

        return index;

    }


}