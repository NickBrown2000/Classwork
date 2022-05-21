#include "Sort.h"
#include <vector>
#include <queue>
#include <iostream>
#include <cstdlib>
#include <math.h> 
using namespace std;

int maxElemLength(const vector<int>& v);
int GetDigit(int number, int k);
vector<queue<int> > ItemsToQueues(const vector<int>& L, int k);
vector<queue<int> > QueuesToArray(const vector<queue<int> >& QA, int numVals);
void RadixSort(vector<int>& L, int numDigits);
void PrintVector(const vector<int>& L);

int main(int argc, char *argv[])
{
vector<int> L;
vector<queue<int> > QA(10);
RadixSort(L, maxElemLength(L));

}

int maxElemLength(const vector<int>& v){
//for loop looking for max
int max;
for(int i = 0; i<v.size(); i++){
  if(max<v[i]){
    max = v[i];
  }
}
return (int) (log10(max) + 1);
//return length of max
}

int GetDigit(int number, int k){
//return number at k
return (number%10^(k+1))/10^k;
}



vector<queue<int> > ItemsToQueues(const vector<int>& L, int k)
{
  vector <queue <int> > temp(10);
  for(int i = 0; i < L.size(); i++)
  {
    temp[getDigit(L[i],k)].push(L[i]);
  }
  return temp;
}


vector<queue<int> > QueuesToArray(const vector<queue<int> >& QA, int numVals)
{
  vector <int> sortedArray;
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

void RadixSort(vector<int>& L, int numDigits){
for (int k = 0; k<numDigits; K++){
    QA = itemsToQueue(v,k);
    v = queuesToArray(QA, v.size());
  }
}



void PrintVector(const vector<int>& L){


}

