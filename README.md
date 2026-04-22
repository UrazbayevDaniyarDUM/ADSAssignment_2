Assignment 2 – Banking System

Student: Urazbayev Daniyar
Group: IT-2503

Project Overview

This project is a simple banking system simulation.
The main goal is to demonstrate how different data structures work in practice and how they can be used in real-life situations.

Data Structures Used
LinkedList – to store bank accounts
Stack – to store transaction history
Queue – to manage requests (bill payments and account creation)
Array – to store fixed number of accounts
Functionality
Bank Accounts (LinkedList)

The program stores all accounts in a LinkedList.
Each account has:

accountNumber
username
balance

User can:

add account
view all accounts
search account
Deposit and Withdraw

User can:

deposit money
withdraw money

The balance is updated inside the LinkedList.

Transaction History (Stack)

All operations are saved in a Stack:

deposit
withdraw
bill payment

User can:

see last transaction
undo last transaction

Stack is used because it works as LIFO (last in, first out).

Bill Payment (Queue)

Bill payments are stored in a Queue.

User can:

add bill
process bill

Queue is used because it works as FIFO (first in, first out).

Account Requests (Queue)

New account requests are stored in a Queue.

Admin:

processes requests
adds approved accounts to LinkedList
Array (Physical Structure)

The program also uses an array with 3 predefined accounts.
This shows how data is stored in fixed memory.

Menu System

The program has three parts:

Bank Menu

create request
deposit
withdraw

ATM Menu

check balance
withdraw

Admin Menu

process account requests
view bill queue
