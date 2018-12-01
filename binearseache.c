/*
Aouther Kalle Jongberg
written 1/12 2018
This is a program there uses binary seach to chek i an element is in an arry.
*/

#include <stdio.h>
#include <stdlib.h>
int binearseache_help(int *arr, int seach_n, int min, int max); // Prototype of the helping funktion

// main binearseache funktion
int binearseache(int *arr, int seach_n,int n){
  // computing input for the heloing funktion.
  int min = 0;
  int max  = n -1;
  // returning if the element where found and in which place.
  // If the element where not in the array -1 is returend.
return (binearseache_help(arr,seach_n, min, max));
}
// this is the helping funktion for the bineary seach.
int binearseache_help(int *arr, int seach_n, int min, int max){
  // cheking if the input is legal.
  if (min < 0) {return -1;}
  // calculationg the midel of the array.
int middel = min+(max-min)/2;
// cheking if the midel element is the whished value.
if(arr[middel] == seach_n){return middel;}
// Cheking that the index is't wrong.
else if(min >= max ){return -1;}
else{
  // cheking if the number is smaler than the midel value.
  if(arr[middel] > seach_n){
    // if it is smaler is the helping funktion called rekusiv on the small half of the array.
    return (binearseache_help(arr, seach_n,min, middel-1));
  }
  else{
    // else is the helping funktion called rekusiv on the upper half of the array.
    return (binearseache_help(arr, seach_n,middel+1, max));
  }
}
}
