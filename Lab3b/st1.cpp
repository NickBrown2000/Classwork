#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <algorithm>
using namespace std;


void Initialize(vector<int> &x)
{
  cout<<"Input 5 Integers"<<endl;
  for(int i=0;i<5;i++)
  {
    int temp;
    cin>>temp;
    x.push_back(temp);
  }
}


void Print(vector<int> x)
{
  cout<<"Values is vector: ";
  for(int i=0;i<x.size();i++)
  {
    cout<<x[i]<<", ";
  }
  cout<<endl;
}


void Reverse(vector<int> &x)
{
  reverse(x.begin(),x.end());
}

void Compare(string n1, string n2)
{
  if(n1==n2)cout<<"The Strings are the same"<<endl;
  else if(n1<n2)cout<<"String 1 < String 2"<<endl;
  else cout<<"String 1 > String 2"<<endl;
}

int main()
{

stack<string> s1,s2;

s1.push("Hello");
s1.push("World");
s2.push("Goodbye");
s2.push("World");

Compare(s1.top(),s2.top());

s1.pop();
s2.pop();

Compare(s1.top(),s2.top());

vector<int> v;
  
Initialize(v);
Print(v);

Reverse(v);
Print(v);

sort(v.begin(),v.end());
Print(v);

return 0;
}