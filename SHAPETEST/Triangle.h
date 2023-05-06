#pragma once
#pragma once
// Triangle.h
#ifndef _TRIANGLE_H
#define _TRIANGLE_H
#include "Shape.h"
#include <iostream>
using namespace std;

class Triangle : public Shape {// rectangle class
public:
    Triangle(double m = 1.0, double h = 1.0, double x = 0.0, double y = 0.0) :
        Shape(x, y), m_base(m), m_height(h) { }
    void out(ostream& sout) const {
        sout << "Triangle = " << m_base << ',' << m_height << ':';
        Shape::out(sout);
    }
    double area() const { return (m_base * m_height)/2; }
protected:
    double m_base, m_height;
};
#endif
