#include <iostream>
using namespace std;

class Point
{
public:
	Point(int x=0, int y=0):x_(x),y_(y) {}
	Point operator++(int NotUsed) {
		Point temp = (*this); x_++; y_++; return temp;
	}
	Point& operator++() { x_++; y_++; return(*this); };
	Point operator--(int);
	Point& operator--();
	Point() { x_ = y_ = 0; }
	int x() { return x_; }
	int y() { return y_; }
	void Print() { cout << "(" << x_ << "," << y_ << ")" << endl; }

private:
	int x_, y_;
};
inline Point& Point::operator--() {
	y_--;
	x_--;
	return *this;
}
inline Point Point::operator--(int) {
	Point temp = *this;
	--*this;
	return temp;
}
int main()
{
	Point pt1(1, 1);
	Point pt2=pt1++;
	Point pt3=(++pt1)++;

	pt1.Print();
	pt2.Print();
	pt3.Print();

	return 0;

}