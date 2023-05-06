#pragma once
// Rect.h
#ifndef _RECT_H
#define _RECT_H
#include "Shape.h"
#include <iostream>
using namespace std;

class Rect : public Shape {// rectangle class
public:
    Rect(double w = 1.0, double h = 1.0, double x = 0.0, double y = 0.0) :
        Shape(x, y), m_width(w), m_height(h) { }
    void out(ostream& sout) const {
        sout << "Rect = " << m_width << ',' << m_height << ':';
        Shape::out(sout);
    }
    double area() const { return m_width * m_height; }
protected:
    double m_width, m_height;
};
#endif
