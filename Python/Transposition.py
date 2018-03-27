
import random

text =input("Enter the text to encrypt: ")

count = len(text)
numbers = list(range(count))
key = numbers
random.shuffle(key)

encrypted = " "
for pos in key :
    encrypted = encrypted + text[pos]
print(key)
print("Encypted :%s" % encrypted)

decrypted = " "
for i in range(count):
    location = key.index(i)
    decrypted = decrypted + encrypted[location]

print("Decrypted : %s " % decrypted) 