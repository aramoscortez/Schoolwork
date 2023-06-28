##################################
#STAT 330 - Homework 4           #
#Name: Abby Ramos Cortez         #  
#Date: 10/13/2022                #                                
##################################

#================================= Problem 1 =================================
setwd("C:/Users/abbyr/OneDrive/Documents/Stat 330/Homework")
tennis.dfr <- read.table("tennisplayers2012.txt")
tennis.dfr

#V1         V2  V3 V4   V5  V6 V7  V8
#1      Bjorn       Borg 141 17  608 127 11  64
#2        Rod      Laver 140 29  486 121 11  63
#3       Pete    Sampras 203 38  762 222 14  64
#4        Ken   Rosewall 173 34  517 165  8  52
#5      Jimmy    Connors 233 49 1155 271  8 109
#6       Ivan      Lendl 222 49 1068 242  8  94
#7       John   Newcombe 152 43  444 171  7  35
#8       John    McEnroe 167 38  881 198  7  77
#9      Andre     Agassi 224 53  870 274  8  60
#10     Boris     Becker 163 40  713 214  6  49
#11      Mats   Wilander 144 37  571 222  7  33
#12    Stefan     Edberg 178 47  806 270  6  41
#13    Arthur       Ashe 138 41  613 213  3  33
#14       Jim    Courier 118 38  506 237  4  23
#15 Guillermo      Vilas 137 45  940 286  4  62
#16   Yevgeny Kafelnikov  99 36  609 306  2  26
#17       Roy    Emerson 209 46  392 138 12  15
#18       Tom      Okker  88 39  520 217  0  31
#19      Ilie    Nastase  97 43  730 296  2  58
#20    Thomas     Muster  77 38  626 271  1  44
#21      Stan      Smith 112 48  641 262  2  39
#22   Michael      Chang 120 56  662 312  1  34
#23    Manuel    Orantes  66 26  616 251  1  32
#24     Vitas Gerulaitis  86 37  494 208  1  27
#25     Roger    Federer 247 37  866 194 17  76
#26    Rafael      Nadal 157 22  583 122 11  50
#27   Lleyton     Hewitt 140 52  564 213  2  28
#28      Andy    Roddick 131 45  612 213  1  32
#29     Novak   Djokovic 134 27  454 122  5  31


colnames(tennis.dfr)<-c("first.name","last.name","major.match.wins","major.match.losses","overall.match.wins","overall.match.losses","major.titles","overall.titles")
tennis.dfr

# first.name  last.name major.match.wins major.match.losses overall.match.wins
# 1       Bjorn       Borg              141                 17                608
# 2         Rod      Laver              140                 29                486
# 3        Pete    Sampras              203                 38                762
# 4         Ken   Rosewall              173                 34                517
# 5       Jimmy    Connors              233                 49               1155
# 6        Ivan      Lendl              222                 49               1068
# 7        John   Newcombe              152                 43                444
# 8        John    McEnroe              167                 38                881
# 9       Andre     Agassi              224                 53                870
# 10      Boris     Becker              163                 40                713
# 11       Mats   Wilander              144                 37                571
# 12     Stefan     Edberg              178                 47                806
# 13     Arthur       Ashe              138                 41                613
# 14        Jim    Courier              118                 38                506
# 15  Guillermo      Vilas              137                 45                940
# 16    Yevgeny Kafelnikov               99                 36                609
# 17        Roy    Emerson              209                 46                392
# 18        Tom      Okker               88                 39                520
# 19       Ilie    Nastase               97                 43                730
# 20     Thomas     Muster               77                 38                626
# 21       Stan      Smith              112                 48                641
# 22    Michael      Chang              120                 56                662
# 23     Manuel    Orantes               66                 26                616
# 24      Vitas Gerulaitis               86                 37                494
# 25      Roger    Federer              247                 37                866
# 26     Rafael      Nadal              157                 22                583
# 27    Lleyton     Hewitt              140                 52                564
# 28       Andy    Roddick              131                 45                612
# 29      Novak   Djokovic              134                 27                454
# overall.match.losses major.titles overall.titles
# 1                   127           11             64
# 2                   121           11             63
# 3                   222           14             64
# 4                   165            8             52
# 5                   271            8            109
# 6                   242            8             94
# 7                   171            7             35
# 8                   198            7             77
# 9                   274            8             60
# 10                  214            6             49
# 11                  222            7             33
# 12                  270            6             41
# 13                  213            3             33
# 14                  237            4             23
# 15                  286            4             62
# 16                  306            2             26
# 17                  138           12             15
# 18                  217            0             31
# 19                  296            2             58
# 20                  271            1             44
# 21                  262            2             39
# 22                  312            1             34
# 23                  251            1             32
# 24                  208            1             27
# 25                  194           17             76
# 26                  122           11             50
# 27                  213            2             28
# 28                  213            1             32
# 29                  122            5             31

#================================= Problem 2 =================================
greatest.dfr <- tennis.dfr[tennis.dfr$major.titles >= 6,c(1,2)]
greatest.dfr

# first.name last.name
# 1       Bjorn      Borg
# 2         Rod     Laver
# 3        Pete   Sampras
# 4         Ken  Rosewall
# 5       Jimmy   Connors
# 6        Ivan     Lendl
# 7        John  Newcombe
# 8        John   McEnroe
# 9       Andre    Agassi
# 10      Boris    Becker
# 11       Mats  Wilander
# 12     Stefan    Edberg
# 17        Roy   Emerson
# 25      Roger   Federer
# 26     Rafael     Nadal


#================================= Problem 3 =================================
write.table(greatest.dfr,file = "greatest_dfr.txt",sep = " ", col.names = TRUE, quote = FALSE)
read.table("greatest_dfr.txt")

# first.name last.name
# 1       Bjorn      Borg
# 2         Rod     Laver
# 3        Pete   Sampras
# 4         Ken  Rosewall
# 5       Jimmy   Connors
# 6        Ivan     Lendl
# 7        John  Newcombe
# 8        John   McEnroe
# 9       Andre    Agassi
# 10      Boris    Becker
# 11       Mats  Wilander
# 12     Stefan    Edberg
# 17        Roy   Emerson
# 25      Roger   Federer
# 26     Rafael     Nadal









