# ====================
# Abby Ramos Cortez  |
# Stat 302           |
# Homework 4         |
# 3-27-23            |
# ====================

# ============================ Problem 1 =================================
nonsmokers <- c(0.97,0.72,1.00,0.81,0.62,1.32,1.24,0.99,0.90,0.74,0.88,0.94,1.16,
                0.86,0.85,0.58,0.57,0.64,0.98,1.09,0.92,0.78,1.24,1.18)
smokers <- c(0.48,0.71,0.98,0.68,1.18,1.36,0.78,0.64)
# Two Independent Populations 
# Significance level = 0.05

# --------- (A) ---------
# Test Normality 
shapiro.test(nonsmokers) # p-value = 0.6209
shapiro.test(smokers) # p-value = 0.5211
# both p-values > significance level -- fail to reject H0 --> assume normality

# Test Equal Variances 
var.test(nonsmokers,smokers)
# p-value = 0.2223 -- fail to reject H0 --> conduct pooled t-test

# Conducting Pooled t-test
t.test(nonsmokers,smokers,alternative = "two.sided",var.equal = TRUE,
       paired = FALSE)
# t = 0.66896, df = 30, p-value = 0.5086

# --------- (B) ---------
wilcox.test(nonsmokers,smokers,paired = FALSE,exact = FALSE)
# W = 114, p-value = 0.4461

# ============================ Problem 2 =================================
scoreBefore <- c(85,96,70,76,81,68,77,40)
scoreAfter <- c(88,98,89,86,92,99,88,99)
# Paired Data 

# Testing the population of diff for normality
diffAB <- scoreAfter - scoreBefore
shapiro.test(diffAB) # p-value = 0.03593
# p-value > significance level(0.01) --> fail to reject H0(H0: pop is normal)
# --> assume normality --> conduct t-test

# conducting t-test 
t.test(scoreBefore,scoreAfter,alternative = "two.sided",paired = TRUE)
# t = -2.735, df = 7, p-value = 0.02913

# ============================ Problem 3 =================================
zeroWeeds <- c(166.7,172.2,165.0,176.9,186.4)
threeWeeds <- c(78.6,176.4,153.1,156.0,146.3)

# Test Normality 
shapiro.test(zeroWeeds) # p-value = 0.6225
shapiro.test(threeWeeds) # p-value = 0.1137

# Test Equal Variances
var.test(zeroWeeds,threeWeeds)
# p-value = 0.01511 > significance level (0.005) -- fail to reject H0 
# --> conduct pooled t-test

# Pooled t-test
t.test(zeroWeeds,threeWeeds,alternative = "less",var.equal = TRUE,
       paired = FALSE,conf.level = 0.995)
# t = 1.8354, df = 8, p-value = 0.1038

