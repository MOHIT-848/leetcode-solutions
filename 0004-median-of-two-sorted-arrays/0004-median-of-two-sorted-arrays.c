double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int n= nums1Size+nums2Size;
    int arr[n];
    for (int i=0;i<nums1Size;i++){
        arr[i]=nums1[i];
    }
     for (int i=0;i<nums2Size;i++){
        arr[nums1Size+i]=nums2[i];
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