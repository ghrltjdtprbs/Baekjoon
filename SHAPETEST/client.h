#pragma once
// client.h
#ifndef _CLIENT_H
#define _CLIENT_H
#include <iostream>

// funtion prototypes in client.cpp

// output shapes
void out_shapes(ostream& sout, Shape* shapes[], int size);

// return total area
double total_area(Shape* shapes[], int size);

#endif //_CLIENT_H
