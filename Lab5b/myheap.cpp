#include "BinaryHeap.h"
#include <string>
#include <iostream>
using namespace std;

int main(){

    BinaryHeap<char> PQ(50);
    
    PQ.insert('A');
    PQ.insert('B');
    PQ.insert('C');
    PQ.insert('D');
    PQ.insert('E');
    PQ.insert('F');
    PQ.insert('G');
    PQ.insert('H');
    PQ.insert('I');
    PQ.insert('J');
    
    PQ.deleteMin();
    
    PQ.printLtSubtree();
    cout<<"\nThe Height Is "<<PQ.Height()<<endl;
    cout<<"The Max Is "<<PQ.findMax()<<endl;
}