############################
# Stat 330: Classwork      #
# Date: 10/20/2022         #
# Name: Abby Ramos Cortez  #
############################


f.norm <- function(x,mu=0,sigma=1){
res <- (1/sqrt(2*pi*sigma^2))*exp(-(x-mu)^2/(2*sigma^2))
return(res)
}

x <- seq(-5,5,length.out=50)
y1 <- f.norm(x)
y1

y2 <- f.norm(x,sigma=1.5)
y2

y3 <- f.norm(x,sigma=2)
y3

plot(x,y1,type='n',xlab='',ylab='',xaxt = 'n', yaxt ='n',
     xlim = c(-5,5),ylim = c(0,0.4))
title('Normal Distributions',cex = 1.4)
lines(x,y1,col='darkorange2',lty='solid',lwd=2)
lines(x,y2,col='cornflowerblue',lty='dotted',lwd=2)
lines(x,y3,col='yellowgreen',lty='dashed',lwd=2)
axis(1,at=c(-5,0,5),cex.axis=1.5)
axis(2,at=c(0.0,0.2,0.4),cex.axis=1.5)
mtext('x',side=1,cex=1,line=2.5)
mtext('f(x)',side=2,cex=1,line=2.5)
legend(x='topleft',legend=c('sd = 1.0','sd = 1.5','sd = 2.0'),
       lty = c('solid','dotted','dashed'),col = c('darkorange2','cornflowerblue','yellowgreen'),lwd = 2)



