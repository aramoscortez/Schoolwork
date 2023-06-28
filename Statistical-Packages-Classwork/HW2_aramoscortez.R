##################################
#STAT 330 - Homework 2           #
#Name: Abby Ramos Cortez         #  
#Date: 09/14/2022                #                                
##################################

#================================= Problem 1 =================================
A <- c(3,5,-3,4,-2,9,0,8)
Amat <- matrix(A,nrow=4,ncol=2)
Amat
#     [,1] [,2]
#[1,]    3   -2
#[2,]    5    9
#[3,]   -3    0
#[4,]    4    8


B <- c(2,4,0,1,10,20,30,40)
Bmat <- matrix(B,nrow=4,ncol=2)
Bmat
#     [,1] [,2]
#[1,]    2   10
#[2,]    4   20
#[3,]    0   30
#[4,]    1   40


for(col in 1:ncol(Amat)){
  for(col in 1:ncol(Bmat)){
    summ = Amat[ ,1]+Bmat[ ,2]
  }
}

summ
#[1] 13 25 27 44

#================================= Problem 2 =================================
n <-1
res <- NULL
while (n>=1 & sqrt(n)<=3){
  res <- c(res,n)
  n <- n+1
}
res
#[1] 1 2 3 4 5 6 7 8 9
#================================= Problem 3 =================================
Y <- c(12,10,7,5.8,9.3)
Y
#[1] 12.0 10.0  7.0  5.8  9.3

mean_Y <- 8.5
sd_Y <- 0.75

#(a)
z <- NULL
for(i in 1:length(Y)){
  z = (Y-mean_Y)/sd_Y
}
z
#[1]  4.666667  2.000000 -2.000000 -3.600000  1.066667

#(b)
vec <- NULL
for(j in z){
  if (j>=-3 & j<=3){
    vec <-c(vec,"Non-outlier")}
  else{
    vec <- c(vec,"Outlier")}}
vec
#[1] "Outlier"     "Non-outlier" "Non-outlier" "Outlier"     "Non-outlier"

#(c)
Data <- data.frame(Y,z,vec)
Data
#     Y         z         vec
#1 12.0  4.666667     Outlier
#2 10.0  2.000000 Non-outlier
#3  7.0 -2.000000 Non-outlier
#4  5.8 -3.600000     Outlier
#5  9.3  1.066667 Non-outlier

#(d)
colnames(Data) <- c("Y","Z-score","Classification")
Data
#     Y   Z-score Classification
#1 12.0  4.666667        Outlier
#2 10.0  2.000000    Non-outlier
#3  7.0 -2.000000    Non-outlier
#4  5.8 -3.600000        Outlier
#5  9.3  1.066667    Non-outlier
#================================= Problem 4 =================================
a <- 10
b <- -7
c <- 5


if(a>b & b>c){
  x <- c(c,b,a)
}else if(c>b & b>a){
  x <- c(a,b,c)
}else if(a>c & b>a){
  x <- c(c,a,b)
}else if(b>c & c>a){
  x <- c(a,c,b)
}else if(c>a & a>b){
  x <- c(b,a,c)
}else{
  x <- c(b,c,a)
}
x
#[1] -7  5 10
