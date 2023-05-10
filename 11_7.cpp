#include<iostream>
using namespace std;

class Base
{
public :
	Base() { cout << "Base::Base()" << endl; }
	Base(int n) { cout << "Base::Base(" << n << ")" << endl; }
};

class Derived :public Base
{
public :
	Derived() { cout << "D::D()" << endl; }
	Derived(int n):Base(n)
	{
		Base btemp(-n);
		b_ = btemp;
		cout << "Derived::Derived(" << n << ")" << endl;
	}
private:
	Base b_;
};
int main()
{
	Derived d(3);
	return 0;
}