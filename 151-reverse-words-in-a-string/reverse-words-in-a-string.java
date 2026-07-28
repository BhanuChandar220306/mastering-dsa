class Solution {
    public String reverseWords(String s) {
      String[] org=s.trim().split("\\s+");
      int left=0;
      int right=org.length-1;
      while(left<right)
      {
        String temp=org[left];
        org[left]=org[right];
        org[right]=temp;
        left++;
        right--;
      }
      String res=String.join(" ",org);
      return  res;
    }
}