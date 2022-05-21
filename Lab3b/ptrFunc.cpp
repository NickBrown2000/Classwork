#include <iostream>

using namespace std;

bool ptrValue(double *p1, double *p2){
    if(*p1==*p2)
        return true;
    else
        return false;
}

bool ptrAddress(double *p1,double *p2){
    if(p1==p2) //If the address in pointers are same
        return true;
    else
        return false;
}

int main()
{
    double n1=5, n2=6; 
    double *p1=&n1;
    double *p2=&n2;
    
    cout<<ptrValue(p1,p2)<<endl;
    cout<<ptrAddress(p1,p2)<<endl;
    
    p1 = p2;
    
    cout<<ptrValue(p1,p2)<<endl;
    cout<<ptrAddress(p1,p2)<<endl;
    
    return 0;
}