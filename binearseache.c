#include <stdio.h>
#include <stdlib.h>
int binearseache(int *arr, int seach_n, int min, int max);
int main(void){
  int* arr = malloc(sizeof(int)*5);
  for (size_t i = 0; i < 5; i++) {
    arr[i] = i;
  }

int seach_n = 6;
int min = -1;
int max = 5;
printf("%d\n", binearseache(arr,seach_n,min,max));
}


int binearseache(int *arr, int seach_n, int min, int max){
  if (min < 0) {return -1;}
  if(max > (sizeof(*arr)/sizeof(arr[0]))){
    return -1;
  }
int middel = min+(max-min)/2;
if(arr[middel] == seach_n){return middel;}
else if(min >= max ){return -1;}
else{
  if(arr[middel] > seach_n){
    return (binearseache(arr, seach_n,min, middel-1));
  }
  else{
    return (binearseache(arr, seach_n,middel+1, max));
  }
}
}
