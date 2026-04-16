#include <stdio.h>

int main() {
    int c1, c2, c3;
    printf("a : ");
    scanf("%d", &c1);
    printf("b : ");
    scanf("%d", &c2);
    printf("c : ");
    scanf("%d", &c3);
    
    if (c1 % 2 == 0) {
        printf("짝수 %d ", c1);
    }
    else {
        printf("홀수 %d ", c1);
    }
    if (c2 % 2 == 0) {
        printf("짝수 %d ", c2);
    }
    else {
        printf("홀수 %d ", c2);
    }
    if (c3 % 2 == 0) {
        printf("짝수 %d ", c3);
    }
    else {
        printf("홀수 %d ", c3);
    }   
    printf("\n");
    return 0;

}
