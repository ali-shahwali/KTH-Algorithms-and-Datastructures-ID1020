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
    while((ch = fgetc(fp)) != EOF)
    {
        if((isalpha(ch) != 0 || ch == '\n'))
            fputc(ch,wfp);
        else
            fputc(32,wfp);
    }

    fclose(fp);
    fclose(wfp);
    return 0;
}