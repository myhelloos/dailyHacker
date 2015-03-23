#include "foo.h"

int main(int argc, char *argv[]) {
    int result;
    int r = 5;

#ifdef AREA
    result = PI * r * r;
#else
    result = PI * r * 2;
#endif
}
