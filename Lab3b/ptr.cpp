#include <iostream>
#include <string.h>
#include <cctype>
#include <cstring>

using namespace std;

struct RecType
{
  int age;
  float weight;
  char gender;
};

int main()
{
  int num = 5;
  int* intPtr = NULL;
  intPtr = &num;
  *intPtr *= 10;
  cout<<*intPtr<<endl;
  
  RecType* recPtr = new RecType;
  recPtr->age = 25;
  recPtr->weight = 190;
  recPtr->gender = 'M';
  recPtr->age += 5;
  cout<<"Age:"<<recPtr->age<<"  Gender:"<<recPtr->gender<<"  Weight:"<<recPtr->weight<<endl;
  delete recPtr;
  recPtr = NULL;
  
  char* strPtr = new char[50];
  strcpy(strPtr,"Operating Systems");
  cout<<strPtr<<endl;
  
  int lowerCase = 0;
  for (int i = 0; i<strlen(strPtr);i++)
  {
    if(islower(*(strPtr+i))){
      lowerCase++;
    }
  }
  cout<<"There are "<<lowerCase<<" lowercase characters"<<endl;
  
  strPtr=strPtr+10;
  cout<<"New String: "<<strPtr<<endl;
  
  strPtr=strPtr-10;
  
  delete strPtr;
  strPtr = NULL;
  
  return 0;
  
}