#include <stdio.h>
#define student 10


int main(void)
{
        int scores[student];
        int sum = 0;
        int i, average;

        for (i = 0; i < student; i++)
        {
                printf("학생들의 성적을 입력하시오: ");
                scanf("%d", &scores[i]);
        }
        for (i = 0; i < student; i++)
                sum += scores[i];

        average = sum / student;
        printf("성적 평균= %d\n", average);

        return 0;
}
