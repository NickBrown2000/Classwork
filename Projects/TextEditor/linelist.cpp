#include "linelist.h"

LineList::LineList()
{
	LineNode *line = new LineNode;
	LineNode *line2 = new LineNode;

	line -> info = topMessage;
	currLine = line;
	currLineNum = 0;
	length = 0;
	line2 -> info = bottomMessage;
	currLine -> back = NULL;
	currLine -> next = line2;
	line2 -> back = line;
	line2 -> next = NULL;
}

void LineList::goToTop() 
{
  // Post : Advances currLine to line 1
  while(1)
  {
    movePrevLine();
    currLineNum --;
    if(currLineNum == 0)
    {
    movePrevLine();
    break;
    }
  }
}

void LineList::goToBottom() 
{
	// Post : Advances currLine to last line
  while(1)
  {
    moveNextLine();
    currLineNum++;
    if(currLineNum == length+1)
    {
    break;
    }
  }
}

void LineList::insertLine(string newLine)
{
    
    if((length == 0)||(currLineNum != length+1))
    {
	  // post : newLine has been inserted after the current line
    length++;
    currLineNum++;
    
    LineNode* temp = new LineNode;
    temp->info = newLine;
 
    temp->next = currLine->next;
    currLine->next = temp;
    temp->back = currLine;
    temp->next->back = temp;
    
    currLine = currLine->next;
    }
    else
    {
    cout<<"Cannot Add A Line There"<<endl;
    }
    goToTop();
}

void LineList::deleteLine()
{
	// post : deletes the current line leaving currentLine
	// pointing to line following
 if(currLine == NULL || currLineNum == 0 || currLineNum == length+1)
 {
 cout<<"Cannot delete line"<<endl;
 }
 else if(currLine->next == NULL)
 {
 movePrevLine();
 currLine->next = NULL;
 length--;
 }
 else
 {
 moveNextLine();
 currLine->back=currLine->back->back;
 currLine->back->next=currLine->back->next->next;
 length--;
 }
 
}

void LineList::printList() 
{
    goToTop();
    for(int i=0;i<=getLength()+1;i++)
    {
    cout<<getCurrLineNum()<<") "<<getCurrLine()<<"\n";
    moveNextLine();
    }
}

string LineList::getCurrLine() const
{
return currLine->info;
}

void LineList::moveNextLine()
{
	// Post : Advances currLine (unless already at last line)
  if(currLine->next != NULL)
  {
  currLine = currLine->next;
  currLineNum++;
  }
}

void LineList::movePrevLine()
{
  // Post : Advances currLine (unless already at last line)
  if(currLine->back != NULL)
  {
  currLine = currLine->back;
  currLineNum--;
  }
}

int LineList::getCurrLineNum() const
{
  return currLineNum;
}

int LineList::getLength() const
{
  return length;
}