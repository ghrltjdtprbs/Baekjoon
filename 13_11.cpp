#include <iostream>
using namespace std;

template <typename T>
class Point {
public:
    Point(T x = 0, T y = 0) : x_(x), y_(y) {}
    template <typename T>
    friend ostream& operator<<(ostream& out, const Point<T>& pt);
private:
    T x_, y_;
};

// << 연산자 오버로딩도 템플릿으로 작성
template <typename T>
ostream& operator<<(ostream& out, const Point<T>& pt) {
    return out << "(" << pt.x_ << ", " << pt.y_ << ")";
}
template <typename T>
class Array {
public:
    Array(T value) {
        for (int i = 0; i < 5; i++)
            ary_[i] = value;
    }
    void Print() {
        for (int i = 0; i < 5; i++)
            cout << ary_[i] << " ";
        cout << endl;
    }
private:
    T ary_[5];
};
int main() {
    Array<int> ary1(5);
    Array<Point<int>> ary2(Point<int>(1, 2));
    // Point<int>를 원소로 가짐
    ary1.Print();
    ary2.Print();

    return 0;
}

