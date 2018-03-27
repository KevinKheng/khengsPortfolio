#Kevin Kheng 
# Presidential Primary Simulator 

import random
#I initialize two variables for  the sum of Clinton delegates and Sander Delegates
#I did this before the for loop so that these variables are recognizable for the arithmetic part
#of the problem. I needed to have the sum in order to determine who won the 
#presidential election.They are added on to my for loop.
 
Clinton_delegates_sum_total = 0
Sanders_delegates_sum_total = 0
'''
I use the for statement with 6 different variables :total votes,Clinton votes,
Sander votes, Clinton delegates , Sander delegates ,and total delegates.
I use the random function on the total votes then random generate Clinton votes
from range 1 through my variable total_votes.I did this  so that Clinton votes
does not exceed the total votes which will not make sense if Clinton votes 
exceed the total votes.Second I use Sander votes and subtract it from Clinton
votes for the remainder.Third,I did the same thing on the delegates for as votes
algorithm.In the deleagate part I had to take the votes of the candidate and divide it
by the total votes then divide it by the total delegates that I randomly generate.
I round the delegates so that I can get more of an accurate information on the 
delegates.Fourth, I added the sum of the delegates and used the variables that I 
intialize before the for loop in order to tracked the number of delegates each state.
'''
for i in range (50):
    total_votes = random.randint(10000,100000)
    Clinton_votes = random.randint(1,total_votes)
    Sander_votes = total_votes - Clinton_votes
    total_delegates = random.randint(1,100)
    Clinton_delegates = round((Clinton_votes /total_votes) * total_delegates)
    Sander_delegates = round(total_delegates - Clinton_delegates)
    Clinton_delegates_sum_total = Clinton_delegates_sum_total +  Clinton_delegates
    Sanders_delegates_sum_total= Sanders_delegates_sum_total + Sander_delegates 
    print("State #%d" %(i + 1))#Added 1 so I can increment the state by 1 instead of having a state # 0
    print("---------")
    print("Candidate     Votes       Delegates  ")
    print (" Clinton %10d%10d" % (Clinton_votes,Clinton_delegates))
    print (" Sanders %10d%10d" % (Sander_votes,Sander_delegates))
    print()
print("Total Delegates")
print("----------------")
print(" Clinton %10d" % (Clinton_delegates_sum_total))
print(" Sanders % 10d" %(Sanders_delegates_sum_total))
# I use the if and else statement to delcare the winner by the candidate delgates
# Who ever have the greatest sum of delegates win.
if Clinton_delegates_sum_total > Sanders_delegates_sum_total :
    print("\nClinton has defeated Sanders.")
else:
    print("\nSanders has defeated Clinton.")
    
  

    

