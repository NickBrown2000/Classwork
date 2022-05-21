Readme for Bingo.java
By: Nicholas Brown
Date: September 15 2020

How It Works:
This program functions based on a simple algorithm. First it will read a file and use it to fill up an array
of integers using FillCard(). Then using that array it uses nested for loops in PrintCard() to print out a
bingo card. After printing out the bingo card the program will run through the PlayGame() function until a
win condition is returned by CheckWin(). PlayGame() finds a random integer between 1 and 75 that has not
been previously used in the same game and searches the array for it using nested for loops. If the randomly
selected integer is found, then it will replace its value with a 0. When the sum of any Row, Column or
Diagonal is 0, the win condition is met and CheckWin() will break the do while loop. After the loop is
broken, the program will print the final card, the type of win, and the numbers drawn.

To Edit Your Card:
The editing of the card if very easy. Just open the bingo.in file as if it were a .txt file and input your desired
numbers. Note: Make sure to enter them in ROW MAJOR order.

To Play The Game:
Play the game by first editing your bingo.in file to select your card numbers. After this type javac Bingo.java into
your command bar and hit enter. After compiling type java Bingo to run the program.