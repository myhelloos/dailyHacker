#include <stdio.h>

int main(void) {
    char a[2][2][3] = {{{1,6,3},{5,4,15}},{{3,5,33},{23,12,7}}};
    int i;
    for (i = 0; i < 12; i++) {
        printf("%d ", *(*(*a) + i));
    }
    return 0;
}
