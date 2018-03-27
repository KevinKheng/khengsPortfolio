# Kevin Kheng 
# Math Quiz 
import random
''' 
I created four different functions 
1st. for welecome function
2nd. for  my choice function 
3rd. for addition function
4th for my multiplication function
'''
def welcome() :
    print("***************************************************")
    print("Welcome to Math Facts - Your Electronic Math Teacher")
    print("****************************************************")
    
def choice() :
    option = int(input("Please choose what kind math questions you want:\n 1.Addition \n 2.Multiplication \n 3.Quit\n"))
    return option

def addition() :
    addition_problems = int(input("How many problems?"))
    digit_option = int(input("[1]-digit,[2]-digit or [3]-digit?"))
    count = 0
    for i in range(addition_problems):
        if digit_option == 1:
            A = random.randint(0,10)
            B = random.randint(0,10)
        elif digit_option == 2:
            A = random.randint(10,99)
            B = random.randit(10,99)
        else:
            A = random.randint(100,999)
            B = random.randint(100,999)
        Answer_addition = A + B
        uInput = int(input("%d + %d ? "% (A,B)))
        if uInput == Answer_addition:
            print("%d + %d = %d Correct" % (A,B,Answer_addition))
            count = count + 1
        else:
            print("%d + %d = %d Incorrect"% (A,B,Answer_addition))
    print("\nYou got %d out of %d"% (count,addition_problems))
    print("That is %.2f percent." % ((count/addition_problems) *100))

def multiplication():
    multiplication_problems = int(input("How many problems?"))
    time_tables = input("Enter the times table to test separated by spaces, A for all:")
    count = 0
    parts = time_tables.split()
    for i in range(multiplication_problems):
        if time_tables == "A":
            A = random.randint(0,12)
        else:
            A = int(random.choice(parts))
        B = random.randint(0,12)
        multiplication_answer = A * B 
        uInput = int(input("%d * %d ? "% (A,B)))
        if uInput == multiplication_answer:
            print("%d * %d = %d Correct" % (A,B,multiplication_answer))
            count = count + 1
        else:
            print("%d * %d = %d Incorrect" % (A,B,multiplication_answer))
    print("\nYou got %d out of %d" % (count,multiplication_problems))
    print("That is %.2f percent." % ((count/multiplication_problems) * 100))
# This is my main module 
welcome()
option = choice()
while option != 3:
    if option == 1:
        addition()
    elif option  == 2:
        multiplication()
    option = choice()
       
print("Thank you for using this program.")        
        
    
    
    
 
    