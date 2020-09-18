## Task 1
Simple insertion sort algorithm, we start at array index 1 and continuously 
compare with the element to the left until we reach index 0, then we increment
to index 2 and repeat until we reach the final element.
We do this with a nested for-loop giving us the worst case time complexity O(n²).
We print the array after each inner loop using Arrays.toString()
## Task 2
To count the number of swaps we simply create a variable named "swaps" and
increment during each iteration of the inner for-loop.
## Task 3
An inversion is every pair of elements which in the context of the array is out-of-order
For example the array containing [3,2,4,1] has inversions (3-2) (3-1) (2-4) and (4-1).
To find every inversion we use a similar algorithm as insertion sort, we start at index 0
and using a nested for-loop we check for every inversion by iterating through the array.
We concatenate each inversion to a string and return said string. In the worst case 
we also have O(n²) time complexity.
## Task 4
To sort all the negative numbers on to the lower half of the array we have 2 variables starting at index
0 in our array, we call these 'i' and 'j', we iterate 'i' through the array and when we encounter a negative
number we perform a swap with the elements at 'i' and 'j'. We do this until we have iterated through the array once.
The for-loop is optimized as to skip any swaps which would swap a negative number with another negative number.
In the worst case we have to iterate through the entire array and perform a swap every time, this gives us the time
complexity O(n).
## Task 5