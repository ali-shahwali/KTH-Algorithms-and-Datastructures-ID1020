#include <stdio.h>
#include <stdlib.h>
/*
we create a char 'ch' that takes input from the getchar function, as long as ch != a newline we call upon the function again
and effectively create a new instance of the method, as soon as we hit newline we go through each instance of the method and
putchar is used to display the the given characters on stdout, because we created a new instance through recursion we will
therefor get the sequence of characters in reverse order when jumping back in every instance
*/
void recursiveReverse()
{
    char ch;
    if((ch = getchar()) != '\n')
    {
        recursiveReverse();
    }
    putchar(ch);
}
/*
uses malloc to provide allocate space for 50 characters, uses getchar and stores the given input in to a char array 'str'
we track the length of the array with the variable 'len' and in the first while loop we repeat this process and move
'str's adress foward until a newline is fed in. then we enter the next while loop and use putchar to place each char in 'str' 
onto stdout and move the address backward until 'len' is 0.
*/
void iterativeReverse()
{
    char* str = (char*)malloc(50*sizeof(char));
    int len = 0;
    char ch = 0;
    while(ch != '\n')
    {
        ch = getchar();
        *str = ch;
        str++;
        len++;
    }
    while(len >= 0)
    {
        putchar(*str);
        str--;
        len--;
    }
    printf("\n");
}

int main(void)
{
    printf("Enter your text to be reversed iteratively \n");
    iterativeReverse();
    printf("Enter your text to be reversed recursively \n");
    recursiveReverse();
    return 0;
}