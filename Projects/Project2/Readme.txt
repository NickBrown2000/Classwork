Program: Library Book
Date: 9/29/2020
Author: Nicholas Brown

This program generates a library based on a given semicolon seperated data file using an arraylist of the Library Book class. 

Class Functions:

Main:
This is the main algorithm the code follows. First it asks the user for a data file to use.
Then it generates and sorts a set of records based on the given input file. It then takes in a 
user input to determine whether the user wants to see all records, search for a record or 
exit the program.

getFiles:
Finds all .dat files within the directory and lists them for the user.

makeLibrary:
Reads the data in form the file specified by the user into an arraylist of LibraryBooks.

sort:
Sorts the records by alphabetical order of title.

printMenu:
Prints a list of posible actions the user can choose from.

chooseFunction:
This will run as part of a loop as long as the users input into the menu is not 3 (exit).
Will run accompanying action chosen by the user in the menu.

LibraryBook:
Constructor class for each book object.

get...:
Returns the value of the associated property (i.e. getName retreives book name).

compareTo:
Compares two book titles and returns an int based on the character difference.
If the titles are the same returns zero.

How To Use:
1)Input file name you would like to use (Include .dat in the name, Make sure file is in the same directory)
2)Select which function you would like to use (1=Print all, 2=Search, 3=Exit)
  2-1)
    Type 1 and press enter, the program will print all records.
  2-2)
    Type 2 and press enter, type WHOLE book name and press enter. The program will print out the record if book is found, if not will print "not available".
  2-3)
    Type 3 and press enter, the program will end.
3)You can repetedly run the program until you enter 3 to exit.