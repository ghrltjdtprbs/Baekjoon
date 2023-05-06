// shape-test.cpp
#include <iostream>
#include "Shape.h"
#include "Circle.h"
#include "Rect.h"
#include "client.h"
#include "Triangle.h"
using namespace std;

int main() {
    const int size = 6;
    Shape* shapes[size];

    // build shapes array
    shapes[0] = new Circle();
    shapes[1] = new Circle(2, 10, 20);
    shapes[2] = new Rect();
    shapes[3] = new Rect(3, 4, 30, 40);
    shapes[4] = new Triangle();
    shapes[5] = new Triangle(1,2,10,20);


    // output shapes
    out_shapes(cout, shapes, size);
    // Circle = 1:0,0
    // Circle = 2:10,20
    // Rect = 1,1:0,0
    // Rect = 3,4:30,40

    // output total area
    cout << "total area = "
        << total_area(shapes, size) << endl;
    // total area = 28.7

    for (int i = 0; i < size; i++)
        delete shapes[i];

    return 0;
}
