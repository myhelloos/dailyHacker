class A
{
   public:
      int a;
};

struct B : A { };

struct C
{
      int c;
};

class D : C { };

int main()
{
   B b;
   D d;
   b.a = 1;
   d.c = 2;
}
