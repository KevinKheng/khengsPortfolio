#Kevin Kheng 
# Rock,paper, Scissor 

#Declare my variables and constants and also generate random choice
#for the computer.
import random
humanwins = 0
compwins = 0
playerchoice = 0





print("****************************************************")
print("Welcome to Kevin Kheng Rock , Paper, Scissors game!")
print("****************************************************")



#I use the if ,elif, and else statement to compare the choices
#I used a while loop so that the player and computer is less than 4 to continue the game.
#I also used another while loop to be user friendly to the player in case they input the wrong number.
while humanwins < 4 and compwins < 4:
    compchoice = random.randint(0,2)
    playerchoice = int(input("Enter 0 for Rock ,1 for Paper,2 for Scissor:"))
    while playerchoice not in range (0,3):
       playerchoice = int(input("You enter the wrong  number or character.Please enter the correct input.Enter 0 for Rock,1 for Paper,2 for Scissor:"))
    if compchoice == 0 and playerchoice == 1:
        print("Paper covered the computer rock.You won that round!")
        humanwins = humanwins +1
    elif compchoice == 1 and playerchoice == 2:
        print("Scissors cut computer paper.You won that round!")
        humanwins = humanwins + 1 
    elif compchoice == 2 and playerchoice == 0:
        print("Rock bust computer scissor.You won that round!")
        humanwins = humanwins + 1 
    elif compchoice == 1 and playerchoice == 0:
        print("Paper covered your rock.Computer won that round!")
        compwins = compwins + 1
    elif compchoice == 2 and playerchoice == 1:
        print("Scissor cut your paper.Computer won that round!")
        compwins = compwins + 1
    elif compchoice == 0 and playerchoice == 2:
        print("Rock bust your your scissor.Computer won that round!")
        compwins=compwins + 1
    else:
        compchoice == playerchoice
        print("It was a tie")
    print ("Human wins : %d   Computer Wins : %d" %(humanwins,compwins))
#I use the if and else statement to declare the winner of the game which is out
#of 4.
if compwins == 4 :
    print("*******************************")
    print("Computer won that game out of 4.")
    print("*******************************")
else:
    humanwins == 4
    print("***************************")
    print("You won that game out of 4.")
    print("***************************")


        

            


