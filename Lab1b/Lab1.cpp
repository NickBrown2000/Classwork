#include <iostream>
using namespace std;
double convert(double value);    // function prototype

int main (){
    cout<<"Enter A Celcius Value: ";
    cout<<"\n Degrees Fahrenheit:"<<convert(cin);         
    return 0;
}
double convert(double tmp){
  return (1.8*tmp)+32;
}