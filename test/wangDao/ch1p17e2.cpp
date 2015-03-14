#include <iostream>
#include <string.h>

using namespace std;

int main() {
	char a[] = "abcd";
	char *p = a;
	int b = strlen(a);
	*a = p[b];
	++p;
	cout<<p<<endl;
	cout<<a<<endl;
	return 0;
}
