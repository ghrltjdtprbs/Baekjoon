#pragma once
// Shape.h
#ifndef _SHPAE_H
#define _SHPAE_H
#include <iostream>
using namespace std;

class Shape { // abstract shape class
public:
    Shape(double x = 0.0, double y = 0.0) : m_x(x), m_y(y) { }
    virtual ~Shape() { } // virtual destructor
    virtual void out(ostream& sout) const {
        sout << m_x << ',' << m_y;
    }
    virtual double area() const = 0; // pure virtual function
protected:
    double m_x, m_y; // position
};
#endif
