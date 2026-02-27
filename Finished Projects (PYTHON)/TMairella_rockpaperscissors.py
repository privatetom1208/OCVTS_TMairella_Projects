# Thomas Mairella
# Rock Paper Scissors Game
# 3/8/26

import random

print("Welcome to Rock Paper Scissors!")
options = ["R", "P", "S"]

while True:
    try:
        choice = input("Enter your choice: R, P, or S (Rock, Paper, or Scissors)").upper()
        if choice not in options:
            raise ValueError("Invalid choice")
    except ValueError:
        print("Please enter a valid choice: R, P, or S.")
        continue

    botchoice = random.choice(options)

    if choice == botchoice:
        print("It's a tie! The bot also chose", botchoice)
    elif (choice == "R" and botchoice == "S") or (choice == "P" and botchoice == "R") or (choice == "S" and botchoice == "P"):
        print("You win! The bot chose", botchoice)
    else:
        print("You lose! The bot chose", botchoice)
    play_again = input("Do you want to play again? (Y/N)").upper()
    if play_again != "Y":
        print("Thanks for playing!")
        break