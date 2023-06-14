#-------------------#
# Abby Ramos Cortez #
# Stat 302          #
# Homework 1        #
# 1-29-2023         #
#-------------------#

# =============================== Problem 1 ====================================
# (a)
exactlyfour <- dbinom(4,8,0.35)
exactlyfour
# [1] 0.1875097

# (b)
atmost6 <- pbinom(6,8,0.35)
atmost6
# [1] 0.9964292

# (c)
atleast4 <- 1-pbinom(3,8,0.35)
atleast4
# [1] 0.2936006

# =============================== Problem 2 ====================================
ages <- c(19,19,19,16,21,14,23,17,19,20,18,24,20,13,16,17,19,18,19,17,21,24,18,23,
          19,21,22,20,20,20,24,17,20,22,19,22,21,18,20,22,16,15,21,23,21,18,18,20,
          15,25)

# (a)
ages.hist <- hist(ages,col='tomato',xlab = 'Ages')
# Yes, the data follows a bell-shaped, normal distribution.

# (b)
agesmean <- mean(ages)
agesmean
# [1] 19.46

agessd <- sd(ages)
agessd
# [1] 2.704569

percent13oryounger <- pnorm(13,agesmean,agessd)
percent13oryounger
# [1] 0.00845749

# (c)
# The age at the 79th percentile in the sample:
ageat79thp <- quantile(ages,probs = 0.79)
ageat79thp
#   79% 
# 21.71

# The Exact Result:
ageat79thpr <- qnorm(0.79, agesmean, agessd)
ageat79thpr
# [1] 21.64102

# =============================== Problem 3 ====================================
gremean <- 650
gresd <- 30

# (a)
# --------------------
below750 <- pnorm(750,gremean,gresd)
below750
# [1] 0.9995709

# --------------------
morethan700 <- 1 - pnorm(700,gremean,gresd)
morethan700
# [1] 0.04779035

# (b)
gre25 <- qnorm(0.25,gremean,gresd)
gre25
# [1] 629.7653

# --------------------
gre90 <- qnorm(0.90,gremean,gresd)
gre90
# [1] 688.4465

# (c)
set.seed(900919761)
sample1000 <- rnorm(1000,gremean,gresd)

# --------------------
samplehist <- hist(sample1000,col='royalblue1')

# --------------------
samplemean <- mean(sample1000)
samplemean
# [1] 649.7883

# --------------------
samplesd <- sd(sample1000)
samplesd
# [1] 28.94842

# --------------------
samplevar <- var(sample1000)
samplevar
# [1] 838.0111

# --------------------
sample25 <- qnorm(0.25,samplemean,samplesd)
sample25
# [1] 630.2629

sample90 <- qnorm(0.90,samplemean,samplesd)
sample90
# [1] 686.8872

# The true percentiles in part B and the sample percentiles are not too
# far from each other. 

# --------------------
sampleiqr <- IQR(sample1000)
sampleiqr
# [1] 39.7554



