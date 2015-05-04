#include <stdio.h>

void swap(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

int main() {
	int a = 0;
	int b = 1;
	swap(&a, &b);
	printf("%d,%d", a, b);
	return 0;
}
