# ---------------------
# Abby Ramos Cortez   |
# Stat 302            |
# Homework 5          |
# 04-10-2023          |
# ---------------------

# =============================== Problem 1 ===============================
age <- c(74, 51, 59, 78, 92, 67, 81, 50, 87, 49)
netWorth <- c(211, 180, 114, 107, 106, 104, 94.5, 79.2, 77.3, 76)

# Scatter Diagram 
# ---------------
plot(age, netWorth, xlab = "Age", ylab = "Net Worth", col = "royalblue3", 
     main = "Age vs Net Worth")

# Pearson's Correlation Coefficient/Testing its Significance
# ----------------------------------------------------------
cor.test(age, netWorth, method = "pearson")

# Pearson's product-moment
# 	correlation
# 
# data:  age and netWorth
# t = -0.17549, df = 8, p-value =
# 0.8651
# alternative hypothesis: true correlation is not equal to 0
# 95 percent confidence interval:
#  -0.6656011  0.5907323
# sample estimates:
#         cor 
# -0.06192723 

# Correlation Coefficient: -0.06192723
# Significance: p-value = 0.8651

# =============================== Problem 2 ===============================
# Daily Cigarette Consumption sorted from low --> high
dailyCigaretteConsumptionRanked <- c(22.5, 22.3, 20.1, 24.4, 19.7, 13.9, 
                                     27.2, 15.1)
rank(dailyCigaretteConsumptionRanked)
# [1] 6 5 4 7 3 1 8 2

dailyCigaretteConsumption <- c(6, 5, 4, 7, 3, 1, 8, 2)
numberOfDeaths <- c(479696, 1760000, 21267, 282072, 43691, 3589, 8515, 120655)
cor.test(dailyCigaretteConsumption, numberOfDeaths, method = "spearman")

# Spearman's rank correlation rho
# 
# data:  dailyCigaretteConsumption and numberOfDeaths
# S = 58, p-value = 0.4618
# alternative hypothesis: true rho is not equal to 0
# sample estimates:
#       rho 
# 0.3095238 

# Spearman Correlation Coefficient: 0.3095238
# Significance: p-value = 0.4618

# =============================== Problem 3 ===============================
IndVar = c(40, 20, 25, 20, 30, 50, 40, 20, 50, 40, 25, 50) # Advertising Costs

DepVar = c(385, 400, 395, 365, 475, 440, 490, 420, 560, 525, 480, 510) # Sales

# ========= (a) =========
# Scatter Diagram with the Least Squares Line
plot(IndVar, DepVar)

abline(lm(DepVar ~ IndVar), col = "red") 

# ========= (b) =========
# Testing Assumptions
# (1) Normality

model = lm(DepVar ~ IndVar)

library(olsrr)
# Next line will perform four normality tests
ols_test_normality(model)

# If you want to extract just results of the Shapiro test 
# Store the results in a temporary variable, and than use it by adding a dollar sign

result = ols_test_normality(model)
result$shapiro

# Shapiro-Wilk normality test
# 
# data:  y
# W = 0.93401, p-value = 0.4245

# (2) Test the presence of autocorrelation
# Ho: There is no autocorrelation, or coefficient of autocorrelation = 0
# H1: There is autocorrelation within the error term
#
# If p-value > 0.05 we cannot reject null hypothesis
# In plain English, there is no autocorrelation
set.seed(123)
library(car)
durbinWatsonTest(lm(DepVar ~ IndVar))

# lag Autocorrelation D-W Statistic p-value
# 1       0.1712395      1.352659   0.268
# Alternative hypothesis: rho != 0

# Assumption 3
# We need to test whether error term has equal variances
# Ho: Homoskedasticity is met, variances are equal
# H1: Heteroskedasticity, variances are not equal
#
# You can select any of following two tests
# For both tests if p-value is non-significant we will consider
# that this assumption is satisfied
#
# Breusch-Pagan test
library(lmtest)
bptest(model)

# studentized Breusch-Pagan test
# 
# data:  model
# BP = 1.5071, df = 1, p-value = 0.2196

# ========= (c) =========
#  Find the equation of the regression line
summary(model)

# Call:
#   lm(formula = DepVar ~ IndVar)
# 
# Residuals:
#   Min      1Q  Median      3Q     Max 
# -87.538 -32.700   8.566  39.118  55.774 
# 
# Coefficients:
#             Estimate Std. Error t value Pr(>|t|)    
# (Intercept)  343.706     44.766   7.678 1.68e-05 ***
# IndVar         3.221      1.240   2.598   0.0266 *  
#   ---
#   Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1
# 
# Residual standard error: 50.23 on 10 degrees of freedom
# Multiple R-squared:  0.403,	Adjusted R-squared:  0.3433 
# F-statistic: 6.751 on 1 and 10 DF,  p-value: 0.02657


# Equation of the Regression Line: Y = 343.706 + 3.221X

# ========= (d) =========
## Predictions (enter desired X below)
Selected.X <- data.frame(IndVar = 35)

predict(model, Selected.X, se.fit=TRUE, interval = "prediction")
# $fit
# fit      lwr      upr
# 1 456.434 339.9318 572.9362
# 
# $se.fit
# [1] 14.53566
# 
# $df
# [1] 10
# 
# $residual.scale
# [1] 50.2257

predict(model, Selected.X, se.fit=TRUE, interval = "confidence")
# $fit
# fit      lwr      upr
# 1 456.434 424.0465 488.8215
# 
# $se.fit
# [1] 14.53566
# 
# $df
# [1] 10
# 
# $residual.scale
# [1] 50.2257




