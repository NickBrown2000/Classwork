#include <queue>
#include "BinaryHeap.h"
#include <string>
#include <iostream>
using namespace std;


int main(){

    priority_queue<string> PQ(50);
    
    PQ.push("josh");
    PQ.push("billy");
    PQ.push("hailey");
    PQ.push("abby");
    PQ.push("eli");
    PQ.push("isabella");
    PQ.push("charlie");
    PQ.push("daniel");
    PQ.push("forrest");
    PQ.push("george");

    
    while(!PQ.empty())
    {
    cout<<PQ.pop()<<" ";
    }
}