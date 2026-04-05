#include <stdio.h>

int main() {
    int month;
    printf("month input: ");
    scanf("%d", &month);
    if (month == 1 || month == 2 || month == 12) {
        printf("겨울\n");
 }
    else if (month == 3 || month == 4 || month == 5) {
        printf("봄\n");
    }
    else if (month == 6 || month == 7 || month == 8) {
        printf("여름\n");
    }
    else if (month == 9 || month == 10 || month == 11) {
        printf("가을\n");
    }
    return 0;
}

// Switch구문몰랏어요
