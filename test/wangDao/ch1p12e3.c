#include<stdio.h>

int main(void){
	char a[] = {"programming"}, b[] = {"language"};
	char *p1, *p2;
	int i;
	p1 =a, p2 = b;
	for (i = 0; i < 7; i++){
		if (*(p1+i) == *(p2+i)) {
			printf("%c", *(p1+i));
		}
	}
}
