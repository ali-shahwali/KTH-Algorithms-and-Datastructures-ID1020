#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>

int main(void)
{
    FILE *fp;
    FILE *wfp;
    fp = fopen("Task1example.txt", "r");
    wfp = fopen("Task1dst.txt", "w");

    if(fp == NULL || wfp == NULL) 
      return(-1);

    char ch;
    while(1)
    {
        ch = fgetc(fp);
        if(ch != EOF && (isalpha(ch) != 0 || ch == '\n'))
            fputc(ch,wfp);
        else if(ch != EOF && isalpha(ch) == 0)
            fputc(32,wfp);
        else
            break;
    }
    fclose(fp);
    fclose(wfp);
    return 0;
}