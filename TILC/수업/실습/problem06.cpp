#include <stdio.h>

int main() {
    int a,b;
    printf("a = ");
    scanf("%d", &a);
    printf("b = ");
    scanf("%d", &b);
    if (a>b) {
        printf(">\n");
    }
    else if (a<b) {
        printf("<\n");
    }
    else {
        printf("==\n");
    }
    return 0;
}