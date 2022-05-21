#include <cstdlib>
#include <cstdio>
#include <stdio.h>
#include <iostream>
#include <fstream>
#include "linelist.h"
using namespace std;

//void OpenFile(int argc, char *argv[]);
void PrintMenu();
string input();

int main(int argc, char *argv[])
{
    LineList* doc = new LineList;
    char select;
    
    PrintMenu();
    //Read in File to list
    if(argc != 2)
    {
      cout<<"Invalid: Please Enter Filename"<<endl;
      exit(0);
    }
    else
    {
      cout << "Opening File..." << endl;
      string file = argv[1];
      ifstream infile;
      infile.open(file.c_str());
    
      string line;
      while(1)
      {
        getline(infile, line);
        if(infile.eof())
        {
        break;
        }
        doc -> insertLine(line);
      }
      infile.close();
      
    }
    //take commands
    while(1)
    {
    cout<< doc -> getCurrLineNum() << ")";
    cin>>select;
    
      if(select == 'I')
      {
        cout<<"Enter A New Line:"<<endl;
        doc->insertLine(input());
      }
      else if(select == 'D')
      {
        doc->deleteLine();
      }
      else if(select == 'L')
      {
         doc->printList();
      }
      else if(select == 'P')
      {
        doc->movePrevLine();
      }
      else if(select == 'N')
      {
        doc->moveNextLine();
      }
      else if(select == 'E')
      {
        break;
      }
      else
      {
        cout<<"Invalid Selection, Please Try Again";
      }
    }
    
    //save new document to file
      
      cout << "Saving File..." << endl;
      doc -> goToTop();
      string file = argv[1];
      ofstream outfile;
      outfile.open(file.c_str());
    
      string line;
      while(1)
      {
        line = doc->getCurrLine();
        outfile<< line<<"\n";
        if(doc->getCurrLineNum()>=doc->getLength())
        {
        break;
        }
        doc->moveNextLine();
      }
      outfile.close(); 
}

void PrintMenu()
{
    cout<<"List Of Commands:"
          "\nI: Insert New Line"
          "\nD: Delete Selected Line"
          "\nL: List All Current Lines"
          "\nP: Move To Previous Line"
          "\nN: Move to Next Line"
          "\nE: Exit Program And Save"<<endl;
}

string input()
{
    string input;
    cin >> input;
    return input;
}