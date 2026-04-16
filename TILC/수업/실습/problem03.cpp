#include <stdio.h>

int main() {
    printf("score input: ");
    int score;
    scanf("%d", &score);
    if (score >= 90) {
        printf("A\n");
    }
    else if (score >= 70) {
        printf("B\n");
    }
    else if (score >= 40) {
        printf("C\n");
    }
    else if (score >= 0) {
        printf("D\n");
    }
    return 0;
}