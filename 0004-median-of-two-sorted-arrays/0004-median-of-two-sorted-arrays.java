class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int n= nums1.length+nums2.length;
    int arr[]=new int[n];
    for (int i=0;i<nums1.length;i++){
        arr[i]=nums1[i];
    }
     for (int i=0;i<nums2.length;i++){
        arr[nums1.length+i]=nums2[i];
    }
    int temp= arr[0];
    for (int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(arr[i]>arr[j]){
                temp= arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }

        }
    }
    int  mid= n/2;
    if(n%2==0){
        return ((double)arr[mid-1]+(double)arr[mid])/2.0f;
    }
    else{
         return (double)arr[mid];
    }


    }
}