#include <stdio.h>

extern int foo2;

int main(int argc, char *args[]) {
    foo2 = 5;
    foo2_func(50);
    return 0;
}
