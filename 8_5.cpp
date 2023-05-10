#include <iostream>
using namespace std;
class Array {
public:
	Array(int count) :count_(count) {

		ary_ = new int[count_];
		for (int i = 0; i < count_; i++)
			ary_[i] = i;
	}
	void Print() {
		for (int i = 0; i < count_; i++)
			cout << ary_[i] << " ";
		cout << endl;
	}


	Array& Set(int x, int y) {
		ary_[x] = y;
		return *this;}

private:
	int* ary_;
	int count_;

};
int main() {
	Array ary1(5);
	Array ary2(7);
	Array ary3(ary1);

	ary2.Set(0, 11).Set(1, 12).Set(2, 13);

	ary1.Print();
	ary2.Print();
	ary3.Print();

	return 0;
	

}