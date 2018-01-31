# Luhn test

The Luhn test is used by some credit card companies to distinguish valid credit card numbers from what could be a random selection of digits.
Those companies using credit card numbers that can be validated by the Luhn test have numbers that pass the following test:
Reverse the order of the digits in the number.
Take the first, third, ... and every other odd digit in the reversed digits and sum them to form the partial sum s1
Taking the second, fourth ... and every other even digit in the reversed digits:
Multiply each digit by two and sum the digits if the answer is greater than nine to form partial sums for the even digits
Sum the partial sums of the even digits to form s2. 
If s1 + s2 ends in zero then the original number is in the form of a valid credit card number as verified by the Luhn test.

```
> For example, if the trial number is 49927398716:
>
> 1. Reverse the digits:
>    61789372994
>
> 2. The odd digits
>   Sum them
>    6 + 7 + 9 + 7 + 9 + 4 = 42 = s1
>
> 3. The even digits:
>    1,  8,  3,  2,  9
>   a.Multiply each one of them by 2:
>    2, 16,  6,  4, 18
>   b. Sum the digits of each multiplication:
>    2,  (1 + 6),  6,  4,  (1+8) -> 2, 7,  6,  4,  9
>   c. Sum the results of the previous operation:
>    2 + 7 + 6 + 4 + 9 = 28 = s2
>
> 4. Finally compute s1 + s2 = 70
> If the result ends in zero, it means that the digits pass the Luhn test
> In the case of 49927398716 the result is 70 so it passes the Lunh test.


Examples:

000 0000 0000 > true

000 0000 0001 > 100 0000 0000 > false

000 0000 0901 > true
000 0001 0901 > false

000 0000 2040 > true 

000 0000 1090 > true 

