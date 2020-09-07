#include <stdio.h>
#include <stdlib.h>
void recursiveReverse()
{
    char ch;
    if((ch = getchar()) != '\n')
    {
        recursiveReverse();
    }
    putchar(ch);
}

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