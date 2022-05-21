#include "Sort.h"
#include <vector>
#include <queue>
#include <iostream>
#include <cstdlib>
#include <math.h> 
using namespace std;

int maxElemLength(const vector<string>& v);
int GetDigit(char n, int k);
vector<queue<string> > ItemsToQueues(const vector<string>& L, int k);
vector<queue<string> > QueuesToArray(const vector<queue<string> >& QA, int numVals);
void RadixSort(vector<string>& L, int numDigits);
void PrintVector(const vector<string>& L);

int main(int argc, char *argv[])
{
vector<string> L;
vector<queue<string> > QA(10);
RadixSort(L, maxElemLength(L));

}

int maxElemLength(const vector<string>& v){
//for loop looking for max
string max;
for(int i = 0; i<v.size(); i++){
  if(max<v[i]){
    max = v[i];
  }
}
return max.length();
//return length of max
}

int GetDigit(string n, int k){
//return number at k
return n.substring(k,1);
}



vector<queue<string> > ItemsToQueues(const vector<string>& L, int k)
{
  vector <queue <string> > temp(10);
  for(int i = 0; i < L.size(); i++)
  {
    temp[getDigit(L[i],k)].push(L[i]);
  }
  return temp;
}


vector<queue<string> > QueuesToArray(const vector<queue<string> >& QA, int numVals)
{
  vector <string> sortedArray;
  for(int i = 0; i < numVals; i++)
  {
    while(!QA[i].empty())
    {
        int tempNum = QA[i].front();
        sortedArray.push_back(tempNum);
        QA[i].pop();
    }
  }
  return sortedArray;
}

void RadixSort(vector<string>& L, int numDigits){
for (int k = 0; k<numDigits; K++){
    QA = itemsToQueue(v,k);
    v = queuesToArray(QA, v.size());
  }
}



void PrintVector(const vector<int>& L){


}

