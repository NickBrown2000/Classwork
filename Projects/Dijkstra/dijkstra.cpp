#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <fstream>
#include <iterator>
#include <cstdlib>
#include <algorithm>
#include <climits> 
#include <set>

using namespace std;

#include "graph.h"
#include "queue.h"
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
void Build(char *argv[], Graph<string>& myGraph, Queue<string>& myQ, int& numVert, int dist[], string vertex[]);
void PrintMenu(int& numVert, string vertex[]);
void Dijkstra(string& Start, Graph<string>& myGraph, int& numVert, int dist[], string vertex[], string previous[]);
void removeDuplicates(string arr[], int n);
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
int main(int argc, char *argv[])
{    
    
    //create datatypes
    Graph<string> myGraph(50);
    Queue<string> myQ(100);
    string vertex[50];
    int dist[50];
    string previous[50];
    int numVert = 0;
    
    //call build to build the graph
    Build(argv, myGraph, myQ, numVert, dist, vertex);
    
    //remove duplicates from vertex array
    removeDuplicates(vertex,50);
    
    //print menu
    PrintMenu(numVert, vertex);
    
    //take input from user about starting point
    string Start;
    cin>>Start;
    
    //proform algorithim
    Dijkstra(Start, myGraph, numVert, dist, vertex, previous);

}
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
void Build(char *argv[], Graph<string>& myGraph, Queue<string>& myQ, int& numVert, int dist[], string vertex[]){

  //open map file
  ifstream MapData;
  MapData.open(argv[1]);
  
  //add all tokens in the MapData file to a vector of strings
  string token;
  int numTokens;
  
  while(getline(MapData, token)){
    stringstream ss(token);
    while(getline(ss, token, ';')){
        numTokens++;
        myQ.enqueue(token);
    }
  }
  
  //sort data in the queue into its various branches
  for(int i = 0; i<numTokens; i+=2){
    if(!myQ.isEmpty()){
    
      vertex[i]=myQ.getFront();
      myQ.dequeue();
      
      vertex[i+1]=myQ.getFront();
      myQ.dequeue();
      
      string temp = myQ.getFront();
      myQ.dequeue();
      dist[i]=atoi(temp.c_str());
      
      //cout<<vertex[i]<<" "<<vertex[i+1]<<" "<<dist[i]<<endl;
    }
  }
  
  //create graph using the arrays
  for(int i = 0; i<numTokens; i++){ 
    if(myGraph.IndexIs(vertex[i])<0){
      myGraph.AddVertex(vertex[i]);
      numVert++;
    }
  }
  
  for(int i = 0; i<numTokens; i+=2){
  myGraph.AddEdge(vertex[i],vertex[i+1],dist[i]);
  }
  
}
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
void PrintMenu(int& numVert, string vertex[]){
  //prints menu
  cout<< "A weighted graph has been created for "<<numVert<<" cities:" << endl;
  for(int i = 0; i<numVert; i++){
  cout<<vertex[i]<<endl;
  }
  cout<<endl;
  cout<< "Please input a starting point: ";
}
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

void Dijkstra(string& Start, Graph<string>& myGraph, int& numVert, int dist[], string vertex[], string previous[]){
  
  //Find starting location 
  int x = 0;
  for(int i = 0; i<numVert; i++)
  {
    if(vertex[i]==Start){
      x = i;
    }
  }

  //set the min distance of all points to infinity
  for(int i = 0; i<numVert; i++)
  {
    dist[i] = INT_MAX;
  }

  //set up starting point
  previous[x] = "N/A";
  dist[x] = 0;
  myGraph.MarkVertex(Start);

  //search the graph
  for(int i = 0; i<numVert; i++){
  
      //check current distances of unmarked nodes and update them
      for(int j=0; j<numVert; j++){
        if((!myGraph.IsMarked(vertex[j]))&&(myGraph.WeightIs(vertex[x],vertex[j])>0)&&(dist[x]+myGraph.WeightIs(vertex[x],vertex[j])<dist[j])){
        
          dist[j] = dist[x]+myGraph.WeightIs(vertex[x],vertex[j]);
          previous[j] = vertex[x];
        
        }
      }

      //find the unmarked node with the minimum distance and make it current node then mark it
      int d = INT_MAX;
      for(int j = 0; j<numVert; j++){
        if((!myGraph.IsMarked(vertex[j]))&&(dist[j]<d)){
          x = j;
          d = dist[j];
        }
      }
      
      //mark vertex with smallest dist
      myGraph.MarkVertex(vertex[x]);
 
  }
  
  for(int i = 0; i<numVert; i++){
  
    if(dist[i]==INT_MAX){
      dist[i] = (-1);
      previous[i] = "Not Connected";
    }
  
  }
  
  cout<<"Vertex          Distance          Previous"<<endl;
  cout<<endl;
  for (int i = 1; i<numVert; i++){
  cout<<vertex[i]<<"          "<<dist[i]<<"          "<<previous[i]<<endl;
  }
}
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

void removeDuplicates(string arr[], int n)
{
    // Initialise a set
    // to store the array values
    set<string> s;
  
    // Insert the array elements
    // into the set
    for (int i = 0; i < n; i++) {
  
        // insert into set
        s.insert(arr[i]);
    }
  
    //set<string>::iterator it;
    vector<string> v(s.begin(), s.end());
    
    for(int i = 0; i<v.size();i++){
     arr[i]=v[i];
    }
    
    
    
    
}