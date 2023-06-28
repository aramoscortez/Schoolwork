############################
# Stat 330: Homework 6     #
# Date: 11/17/2022         #
# Name: Abby Ramos Cortez  #
############################


#================================= Problem 1 ===============================
# (a)
set.seed(123)
rand.uni <- runif(500,10,20)

# (b)
rand.norm <- rnorm(500,mean=-5,sd=1.5)

# (c)
rand.exp <- rexp(500,3)

par(mfrow=c(3,1),bg='lightyellow')
hist(rand.uni,col='tan1',xlab='Random Number',main='Histogram of Uniform Distribution')
hist(rand.norm,col='yellowgreen',xlab='Random Number',main='Histogram of Normal Distribution')
hist(rand.exp,col='royalblue',xlab='Random Number',main='Histogram of Exponential Distribution')

#================================= Problem 2 ===============================
# (a)
nomorethan3 <- ppois(3,7)
nomorethan3
#[1] 0.08176542

# (b)
atleast2 <- 1-ppois(1,7)
atleast2
#[1] 0.9927049

# (c)
exactly5 <- dpois(5,7)
exactly5
#[1] 0.1277167

#================================= Problem 3 ===============================
# (a)
set.seed(123)
par(mfrow=c(3,1),bg='lightyellow')

rand.gamma <- rgamma(1000,36,2)
hist.a <- hist(rand.gamma,col='cornflowerblue',xlab='Random Number',main='Histogram of the Gamma Distribution')

# (b)
y <- seq(5,32,length.out=50)
truegamma <- dgamma(y,36,2)
plot(x=y,y=truegamma,type='l',col='orangered2',xlab='y',ylab='f(y)',
     main='Plot of the True Gamma PDF')

hist.b <- hist(rand.gamma,col='cornflowerblue',xlab='Random Number',main='Histogram of Gamma Distribution',
               freq=FALSE,breaks=100)
lines(x=y, y=truegamma,col='orangered2')

# The plot of the true gamma PDF approximately matches the histogram of the Gamma 
# Distribution in (3a).

# (c)
mean.rand <- mean(rand.gamma)
mean.rand
#[1] 17.84978

var.rand <- var(rand.gamma)
var.rand
#[1] 8.582408

# Formula for true mean of the Gamma Distribution: Shape/Rate
true.mean.rand <- 36/2
true.mean.rand
#[1] 18

# Formula for true mean of the Gamma Distribution: Shape/(Rate^2)
true.var.rand <- 36/(2^2)
true.var.rand
#[1] 9

# The sample mean and the sample variance closely correspond to their respective
# true values. 

# (d)
lifetime.y <- qgamma(0.70,36,2)
lifetime.y
#[1] 19.44443
# The lifetime which is at the 70th percentile is approximately 20.

# (e)
lifetime.y1 <- 1-pgamma(19,36,2)
lifetime.y1
#[1] 0.3509736

# (f)
lifetime.y2 <- pgamma(24,36,2)-pgamma(15,36,2)
lifetime.y2
#[1] 0.8116776

# (g)
par(mfrow=c(1,1),bg='lightyellow')

y <- seq(5,32,length.out=50)
fy <- dgamma(y,36,2)
y0 <- seq(15, 25, length.out=100)
fy0 <- dgamma(y0,36,2)
plot(y, fy, type="l", xaxt="n", ylab="f(y)", 
     main="Gamma Distribution")
polygon( c(15,y0,25), c(0,fy0,0), col="slateblue2" )
axis(1, at=c(10,15,20,25,30))


