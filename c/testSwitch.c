#include <stdio.h>

int main(void)
{
  const int i = 10;
  int j;
  switch(j)
  {
    case i:
      printf("j == i");
      break;
    // case NULL:
    //   printf("j == NULL");
    //   break;
    case 'A':
      printf("j == A(char)");
      break;
    // case "A":
    //   printf("j == A(String)");
    //   break;
    // case 2+8:
    //   printf("j == 2+8");
    //   break;
    // case 0.2:
    //   printf("j == 0.2");
    //   break;
    // case 0.2+0.8:
    //   printf("i == 0.2+0.8");
    //   break;
    case -1:
      printf("j == -1");
      break;
    // case -0.2:
    //   printf("j == -0.2");
    //   break;
    // case 10:
    //   printf("j == 10");
    //   break;
    default:
      break;
  }
}
