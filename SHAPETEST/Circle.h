#pragma once
// Circle.h
#ifndef _CIRCLE_H
#define _CIRCLE_H
#include "Shape.h"
#include <iostream>
using namespace std;

class Circle : public Shape { // circle class
public:
    Circle(double r = 1.0, double x = 0.0, double y = 0.0) :
        Shape(x, y), m_radius(r) { }
    void out(ostream& sout) const {
        sout << "Circle = " << m_radius << ':';
        Shape::out(sout);
    }
    double area() const { return 3.14 * m_radius * m_radius; }
protected:
    double m_radius;
};
#endif
