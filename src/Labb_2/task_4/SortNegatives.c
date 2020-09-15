#include <stdlib.h>
#include <stdio.h>

void negativeSort(int arr[], int size)
{
    int j = 0;
    int swaps = 0;
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
            swaps++;
        }
    }
    printf("%d", swaps);
}


int main(void)
{
    int arr[] = {3,-2,-1,-2,-3};
    int size = sizeof(arr)/sizeof(int);
    negativeSort(arr, size);
    int i = 0;
    printf("\n");
    while(i < size)
    {
        printf("%d ", arr[i]);
        i++;
    }
    
    return 0;
}