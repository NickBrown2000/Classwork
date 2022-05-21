#include <cstdlib>
#include <cstdio>
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>
#include <locale>
//#include <algorithm>
#include <sstream>
#include <vector>
using namespace std;

#include "HashTable.h"
#include "BinarySearchTree.h"

void Build(HashTable& dict);
void Check(int argc, char *argv[], HashTable& dict);
void PrintMenu(string Word);
void Select(string Word, HashTable& dict, int linenum, fstream& err, fstream& output);
void Suggest(string Word, HashTable& dict);

int main(int argc, char *argv[])
{

    if(argc == 1){
    cout<<"Invalid: Enter a file name in the command line"<<endl;
    exit(0);
    }

    //create all datatypes needed
    HashTable dict(500);

    //Build Dict
    Build(dict);

    //Go through file and check it
    Check(argc, argv, dict);
    
    exit(1);
    
}

void Build(HashTable &dict){
  //open dictionary file and hash it
  ifstream dictfile;
  dictfile.open("dict.txt");
  string word;
  
   while(!dictfile.eof()){
   getline(dictfile,word);
   dict.insert(word);
   }
}

void Check(int argc, char *argv[], HashTable& dict){

    //Read in file from args
    ifstream userfile;
    userfile.open(argv[1]);
  
    fstream output;
    output.open ("dict.txt");
    
    fstream err;
    err.open ("notfound.txt");
  
    int linenum = 0;
    string line;
    
    while(!userfile.eof()){
        getline(userfile, line);
        linenum++;
        vector <string> word;

            //Read in next word from line and remove from line
            stringstream check1(line);
            string temp;
            while(getline(check1, temp, ' '))
            {
            word.push_back(temp);

            }

        //convert word to lowercase
        //transform(word.begin(), word.end(), word.begin(), ::tolower);
            
        //hash word and look for hash if not found print menu else continue
        for(int i = 0; i < word.size(); i++){

                 if(!dict.find(word[i]))
                 {

                 //print menu
                 PrintMenu(word[i]);

                 //based on user input preform action
                 Select(word[i], dict, linenum, err, output);

                 }
        }
    }
}

void PrintMenu(string Word){
  //prints menu
  cout<< Word << " Not Found In Dictionary" << endl;
  cout<<endl;
  cout<<"A) Add to Dictionary"<<endl;
  cout<<"I) Ignore and Skip"<<endl;
  cout<<"G) Go to next"<<endl;
  cout<<"S) Search for suggested spelling"<<endl;
  cout<<"Q) Quit"<<endl;
  cout<<"\nSelection: ";
}

void Select(string Word, HashTable& dict, int linenum, fstream& err, fstream& output){

  //take in char from keyboard for selection
  char select;
  cin>> select;
  
  switch(select)
  {
      //Add to dict
      case 'A':
          dict.insert(Word);
          output <<Word<<" ";
          break;
      //Ignore and Skip
      case 'I':
          // adds to hashtable but not permanant dict 
          //file so it will be ignored while checking
          //the rest of the file
          dict.insert(Word);
          break;
      //Go to next word
      case 'G':
          err <<" "<<Word<<" Line:"<<linenum<<endl;
          break;
      //Search for suggestion
      case 'S':
          Suggest(Word, dict);
          err <<" "<<Word<<" Line:"<<linenum<<endl;
          break;
      //Quit
      case 'Q':
          exit(1);
          break;
  }
  output.close();
  err.close();
}

void Suggest(string Word, HashTable& dict){

	string word = Word;
	string wordN = "";

	for (int i = 0;  i < word.length()-1;  i++)
	{
		wordN += word.substr(0, i);
		wordN += word[i+1];
		wordN += word[i];
		wordN += word.substr(i+2);
		cout << wordN << endl;
		wordN = "";  //reset it back to original word


		if (dict.find(wordN))
  		{
  			cout << "Suggested Spelling is " << wordN << endl;
  		} 

	}


}




