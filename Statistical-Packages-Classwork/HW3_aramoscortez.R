##################################
#STAT 330 - Homework 3           #
#Name: Abby Ramos Cortez         #  
#Date: 10/1/2022                 #                                
##################################

#================================= Problem 1 =================================
fibonacci.num <- function(n=20){
  n <- n-3
  res <- NULL
  first.num <- 0
  second.num <- 1
  count <- 2
  if(n<=0){
    print("Enter in a positive integer")
  }else if(n==1){
    res <- c(res,first.num)
  }else{
    res <- c(res,first.num)
    res <- c(res,second.num)
    while(count<n){
      next.num <- first.num + second.num
      res <- c(res, next.num)
      first.num <- second.num
      second.num <- next.num
      count <- count + 1
    }
  }
return(res)}

fibonacci.num(10)
#[1] 0 1 1 2 3 5 8
fibonacci.num()
#[1]   0   1   1   2   3   5   8  13  21  34  55  89 144 233 377 610 987



#================================= Problem 2 =================================
vec1 <- c(20,5,9,2)
vec2 <- c(100,2,5,8,9,22,20)

med <- function(x){
  s <- sort(x)
  n <- length(x)
  if(n%%2 == 0){
    (s[n/2] + s[(n/2)+1])/2
  }else{
    s[(n/2)+0.5]
  }
}

#Verifying 
median(vec1)
#[1] 7
med(vec1)
#[1] 7

median(vec2)
#[1] 9
med(vec2)
#[1] 9





#=============================================================================
res <- NULL
res[1] <- 0
res[2] <- 1
i <- 1
n <- 10
while(i<n){
  res[i+2] <- res[i] + res[i+1]
  i <- i+1
}
res