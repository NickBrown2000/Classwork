////////////////
//Tags
////////////////
#include <cctype>
#include <iostream>
#include <string>
#include <cstdlib>
#include <cmath>
#include "stack.h"
using namespace std;

////////////////
//Primitives
////////////////

void parse(string Line, Stack<char> &Pars, Stack<int> &Num);
int math(Stack<char> &Pars, Stack<int> &Num);
int PrintStack(Stack<int> &Num);

////////////////
//Main Function
////////////////

int main(){

  Stack<char> Params(100);
  Stack<int> Nums(100);
  std::string curr_line;

  while(1){

      getline(cin, curr_line);
      
      parse(curr_line, Params, Nums);
      
      math(Params, Nums);
      
  }
  
  return 1;
}

//////////////////////////////////
//Parses all of the incoming data
//////////////////////////////////

void parse(string Line, Stack<char> &Pars, Stack<int> &Num){

  int CurrInt = 0;
  
  while(Line.length()>=1){
  
  
      if(Line[0] == '_'){
      
          Line[0] = '-';
          CurrInt = atoi(Line.c_str());
          Num.push(CurrInt);
          Line = Line.substr(floor(log10(abs(CurrInt)))+2);
          
      }
      else if(isdigit(Line[0])){

          CurrInt = atoi(Line.c_str());
          Num.push(CurrInt);
          Line = Line.substr(floor(log10(CurrInt))+1);
          
      }
      else if(Line.length()>=1){
          
          Pars.push(Line[0]);
          Line = Line.substr(1); 
      }
      else{
          break;
      }
          
  }

}

/////////////////////////////////////////////////////
//Pops the data in the stacks and completes the math
/////////////////////////////////////////////////////

int math(Stack<char> &Pars, Stack<int> &Num){

  if(Pars.isEmpty()){
    return 0;
  }
  
  if(Num.isEmpty()){
    return 0;
  }
  
  while(!(Pars.isEmpty()||Num.isEmpty()))
  {
    int A;
    int B;
    char Par = Pars.top();
    
    switch (Par){
        
        case 'p':
            //Prints top of stack and does not pop
            cout<<Num.top()<<endl;
            break;
            
        case 'n':
            //Prints top of stack and does pop
            cout<<Num.topAndPop()<<endl;
            break;
            
        case 'f':
            //print all
            PrintStack(Num);
            break;
            
        case 'c':
            //clear both stacks
            Pars.makeEmpty();
            Num.makeEmpty();
            break;
            
        case 'd':
            //duplicate top num
            Num.push(Num.top());
            break;
            
        case 'r':
            //reverses order of top two values
            A = Num.topAndPop();
            B = Num.topAndPop();
            Num.push(A);
            Num.push(B);
            break;
            
        case '+':
            // pop 2, add and push to top
            A = Num.topAndPop();
            B = Num.topAndPop();
            Num.push(A+B);
            break;
            
        case '-':
            // pop 2, sub and push to top
            A = Num.topAndPop();
            B = Num.topAndPop();
            Num.push(B-A);
            break;
            
        case '*':
            // pop 2, mult and push to top
            A = Num.topAndPop();
            B = Num.topAndPop();
            Num.push(A*B);
            break;
            
        case '/':
            // pop 2, div and push to top
            A = Num.topAndPop();
            B = Num.topAndPop();
            Num.push(B/A);
            break;
            
        case '%':
            // pop 2, take remainder and push to top
            A = Num.topAndPop();
            B = Num.topAndPop();
            Num.push(B%A);
            break;
            
        default:
            break;
            
    }
    if(!Pars.isEmpty()){
      Pars.pop();
      return 1;
    }
  }
}


int PrintStack(Stack<int> &Num)
{
    if (Num.isEmpty())
    {
    return 0;
    }
            
    int A = Num.top();
    Num.pop();
            
    PrintStack(Num);
            
    cout << A << " ";
    Num.push(A);
            
    return 1;
}