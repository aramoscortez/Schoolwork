# ---------------------
# Abby Ramos Cortez   |
# Stat 302            |
# Homework 3          |
# 03-01-2023          |
# ---------------------

# =============================== Problem 1 ===============================
men <- c(96.9,97.4,97.5,97.8,97.8,97.9,98.0,98.6,98.8)
women <- c(97.8,98.0,98.2,98.2,98.2,98.6,98.8,99.2,99.4)

# Check Conditions
# ----------------
# (1) Normality 
shapiro.test(men) # p-value = 0.7935
shapiro.test(women) # p-value = 0.3848
# Since both p-values are greater than the significance level, we fail to reject
# the null hypothesis and assume normality. 

# (2) Equal Variances
var.test(men, women) # p-value = 0.8669
# Since the p-value is greater than the significance level, we fail to reject
# the null hypothesis. The random samples have equal variances, so we will 
# conduct the pooled t-test. 

# Pooled t-test
# -------------
t.test(men,women,alternative = "two.sided",var.equal = TRUE, paired = FALSE)

# Results:
# t = -2.3724, df = 16, p-value = 0.03055

# Interpretation:
# Since the p-value is less than the significance level, we would reject the 
# null hypothesis.

# =============================== Problem 2 ===============================
normalair <- c(4.67,4.21,2.18,3.91,4.09,5.24,2.94,4.71,4.04,5.79,3.80,4.38)
enrichedair <- c(5.04,4.52,6.18,7.01,4.36,1.81,6.22,5.70)

# Check Conditions
# ----------------
# (1) Normality
shapiro.test(normalair) # p-value = 0.8118
shapiro.test(enrichedair) # p-value = 0.3529
# Since both p-values are greater than the significance level, we fail to reject
# the null hypothesis and assume normality. 

# (2) Equal Variances
var.test(normalair,enrichedair) # p-value = 0.1194
# Since the p-value is greater than the significance level, we fail to reject
# the null hypothesis. The random samples have equal variances, so we will 
# conduct the pooled t-test. 

# Pooled t-test
# -------------
t.test(normalair,enrichedair,alternative = "greater",var.equal = TRUE,
       paired = FALSE)

# Results:
# t = -1.6484, df = 18, p-value = 0.9417

# Interpretation
# Since the p-value is greater than the significance level, we would fail to 
# reject the null hypothesis.

# =============================== Problem 3 ===============================
nonitrogen <- c(0.32,0.53,0.28,0.37,0.47,0.43,0.36,0.42,0.38,0.43)
nitrogen <- c(0.26,0.43,0.47,0.49,0.52,0.75,0.79,0.86,0.62,0.46)

# Pooled t-test
t.test(nonitrogen,nitrogen,alternative = "two.sided",var.equal = TRUE,
       paired = FALSE)

# 95 percent confidence interval:
#  -0.29915788 -0.03284212

# =============================== Problem 4 ===============================
companytr <- c(0.50,0.587,0.90,1.17,1.14,1.25,0.75,1.22,0.74,0.80)
vendortr <- c(0.79,0.71,0.82,0.82,0.73,0.77,0.72,0.79,0.72,0.91)

diffcv <- companytr - vendortr

# Check Conditions
# ----------------
# Normality 
shapiro.test(diffcv) # p-value = 0.3077
# Since both p-values are greater than the significance level, we fail to reject
# the null hypothesis and assume normality. We will conduct the t-test

t.test(companytr,vendortr,alternative = "two.sided",paired = TRUE)

# Results:
# t = 1.4891, df = 9, p-value = 0.1706
# Since the p-value is greater than the significance level, we would fail to 
# reject the null hypothesis.




