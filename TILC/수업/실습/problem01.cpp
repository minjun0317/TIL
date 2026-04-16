#include <stdio.h>

int main() {
    int c, c1, c2;
    printf("a : ");
    scanf("%d", &c);
    printf("b : ");
    scanf("%d", &c1);
    printf("c : ");
    scanf("%d", &c2);

    if (c % 2 == 0) {
        printf("%d ", c);
    }
    if (c1 % 2 == 0) {
        printf("%d ", c1);
    }
    if (c2 % 2 == 0) {
        printf("%d ", c2);
    }
    printf("\n");
    
    return 0;
}