class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> num=new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
           if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++; 
            }
        }
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                num.add(arr[index]);
            }
        }
        return num;
    }
    public  void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}