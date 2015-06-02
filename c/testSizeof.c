#include <stdio.h>

void fun(int b[100]) {
  printf("%d,%d\n", sizeof(b), sizeof(b[100]));
}

int main() {
  int a[100];
  printf("%d,%d\n", sizeof(a), sizeof(a[100]));
  printf("%d,%d\n", sizeof(&a), sizeof(&a[0]));

  int *p = NULL;
  printf("%d,%d\n", sizeof(p), sizeof(*p));

  int b[100];
  fun(b);
  return 0;
}
