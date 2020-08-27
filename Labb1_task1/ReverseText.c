#include <stdio.h>
char* recursiveReverse(char* str, int len)
{
    if(len >= 0)
    {
        putchar(*str);
        str--;
        len--;
        recursiveReverse(str,len);
    }
    char* text = "\nyou chose recursive";
    return text;
}

void iterativeReverse(char* str, int len)
{
    int i = 0;
    for(i; i < len+1; i++)
    {
        putchar(*str);
        str--;
    }
}

int main(void)
{
    char ch;
    char* str;
    int length = 0;
    printf("enter your characters ");
    while(ch != '\n')
    {
        ch = getchar();
        *str = ch;
        str++;
        length++;
    }
    printf("type 1 for iterative, else recursive ");
    int i;
    scanf("%d", &i);
    if(i == 1)
    {
        iterativeReverse(str, length);
        printf("\nyou chose iterative \n");
    }
    else
       printf(recursiveReverse(str, length));
    
    return 0;
}