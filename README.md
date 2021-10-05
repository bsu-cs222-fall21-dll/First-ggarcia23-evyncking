# FirstProject-Gerardo-Evyn

FirstProject
Created by Evyn King and Gerardo Garcia

v0.2.1

Allows user to search wikipedia up to the 30 most 
recent changes on an article of their choosing.

We got some of our ideas of formatting and how to parse through the JSON data from 
First-waroberts-mthagelnour such as splitting the classes into separate
packages to help clean the code up, and to make it easier to navigate through. 
They also gave us an idea on how to parse through the JSON data.

# Entry Points
* To run through the console run the java Main class in the controller package


* To run the GUI go in the gradle tab, under application select run for the GUI

#Known Errors
* When GUI exits with error code 2 the console will repeat the message of an article not being found twice
* In the GUI when there is a missing input it will exit with error code 1, but the console will
give the message detailing that there is a missing input alongside the article not being found, but exit wih error code 1
  * Running through the console also shares this problem as well as repeating a missing input twice, and a missing article