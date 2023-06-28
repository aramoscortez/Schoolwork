# ---------------------
# Abby Ramos Cortez   |
# Stat 302            |
# Homework 2          |
# 2-13-2023           |
# ---------------------

# =============================== Problem 1 ===============================
n1 <- 440
x1 <- 23
conflevel <- 0.90
binom.confint(x1,n1,conflevel)
# wilson 23 440 0.05227273 0.03739514 0.07262278

# =============================== Problem 2 ===============================
# (a)
n2 <- 209
x2 <- 23
p2 <- 0.07

test2 <- n2*(1-p2)
test2
# [1] 194.37

prop.test(x2,n2,p=p2, alternative = "greater",conf.level = 0.95)
# 1-sample proportions test with continuity correction
# 
# data:  x2 out of n2, null probability p2
# X-squared = 4.5522, df = 1, p-value = 0.01644
# alternative hypothesis: true p is greater than 0.07
# 95 percent confidence interval:
#   0.07727412 1.00000000
# sample estimates:
#   p 
# 0.1100478 


# (b)
prop.test(x2,n2,p=p2, alternative = "greater",conf.level = 0.99)
# 1-sample proportions test with continuity correction
# 
# data:  x2 out of n2, null probability p2
# X-squared = 4.5522, df = 1, p-value = 0.01644
# alternative hypothesis: true p is greater than 0.07
# 99 percent confidence interval:
#   0.06733072 1.00000000
# sample estimates:
#   p 
# 0.1100478 


# =============================== Problem 3 ===============================
zalphahalf <- 1.96
marginoferror <- 0.01
p3 <- 0.5
samplesize <- ((zalphahalf/marginoferror)^2)*p3*(1-p3) # Found the formula
# on the internet. Wanted to double check. 
samplesize
# [1] 9604


# =============================== Problem 4 ===============================
n4 <- 104490000
x4 <- 54263471
p4 <- 0.5

# We need to check if the conditions are met: n(1-p) > 10
test4 <- n4*(1-p4)
test4
# [1] 52245000
# The conditions are met since n(1-p) = 52245000 --> 52245000 > 10. Thus, we may
# apply the normal model to p-hat.


prop.test(x4,n4,p=p4, alternative = "greater",conf.level = 0.95)
# p-value < 2.2e-16





