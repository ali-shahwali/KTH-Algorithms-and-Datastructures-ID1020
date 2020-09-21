#include <stdlib.h>
#include <stdio.h>
/*
README
    To sort all the negative numbers on to the lower half of the array we have 2 variables starting at index
    0 in our array, we call these 'i' and 'j', we iterate 'i' through the array and when we encounter a negative
    number we perform a swap with the elements at 'i' and 'j'. We do this until we have iterated through the array once.
    The for-loop is optimized as to skip any swaps which would swap a negative number with another negative number.
    In the worst case we have to iterate through the entire array and perform a swap every time, this gives us the time
    complexity O(n).
*/
void negativeSort(int arr[], int size)
{
    int j = 0;
    for(int i = 0; i < size; i++)
    {
        if(arr[i] < 0 && arr[j] < 0)
        {
            j++;
            continue;
        }
        if(arr[i] < 0)
        {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j++;
        }
    }
}


int main(void)
{
    int i = 0;
    int arr[] = {-1,2,4,-2,3,-1,5,2,-56,-32};
    int size = sizeof(arr)/sizeof(int);
    printf("Array being sorted: \n");
    while(i < size)
    {
        printf("%d ", arr[i]);
        i++;
    }
    negativeSort(arr, size);
    i = 0;
    printf("\n");
    while(i < size)
    {
        printf("%d ", arr[i]);
        i++;
    }
    
    return 0;
}