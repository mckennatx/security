UTEID: lm29956; nk4682;
FIRSTNAME: Lauren; Nick;
LASTNAME: McKenna; Kubala;
CSACCOUNT: mckenna; nkubala;
EMAIL: laurenmckenna@utexas.edu; nkubala@utexas.edu;

[Program 4]
[Description]
This program performs 128 bit AES encryption or decryption given a plaintext file and a key file. 
User can tell the program to either encrypt a file by sending the program the "e" flag, or decrypt a file by sending it the "d" flag. 
When the program encrypts a file, it first computes the expandedKeyArray. It then does the AES encryption algorithm. Because this is 128 bit encryption, 10 rounds of the repeated process occurs:
subBytes, shiftRows, mixColumns, and addRoundKey.
For the decryption process, it does the exact same thing, but in reverse order.

[Completion]
We have fully implemented 128bit AES encryption


[Running Times]
Encryption:
Run Time in seconds = 0.097 seconds
total bytes transferred = 128 bytes
Bandwidth = 1319.5876288659792 bytes/second

Decryption
Run Time in seconds = 0.108 seconds
total bytes transferred = 128 bytes
Bandwidth = 1185.1851851851852 bytes/second

[Test Cases]
We have created 2 test cases for this project. 
1.

line of input file = 12345123451234512345123451234512

12 34 51 23 
45 12 34 51 
23 45 12 34 
51 23 45 12 
stateArray constructed from line of file to encode


10 10 10 10 
10 10 10 10 
10 10 10 10 
10 10 10 10 
key applied

2 24 41 33 
55 2 24 41 
33 55 2 24 
41 33 55 2 
addRoundKey!

-------------------round = 1
77 36 83 c3 
fc 77 36 83 
c3 fc 77 36 
83 c3 fc 77 
SubBytes!

77 36 83 c3 
77 36 83 fc 
77 36 c3 fc 
77 83 c3 fc 
ShiftRows!

77 83 83 82 
77 83 3 c3 
77 f2 c3 c3 
77 47 43 bd 
mixColumns!

db cb db cb 
da ca da ca 
da ca da ca 
da ca da ca 
key applied

ac 48 58 49 
ad 49 d9 9 
ad 38 19 9 
ad 8d 99 77 
addRoundKey!

-------------------round = 2
91 52 6a 3b 
95 3b 35 1 
95 7 d4 1 
95 5d ee f5 
SubBytes!

91 52 6a 3b 
3b 35 1 95 
d4 1 95 7 
f5 95 5d ee 
ShiftRows!

55 6f 1f 3b 
75 ae 91 ed 
1d c1 bd 89 
b6 f3 90 18 
mixColumns!

ad 66 bd 76 
ae 64 be 74 
ae 64 be 74 
c5 f d5 1f 
key applied

f8 9 a2 4d 
db ca 2f 99 
b3 a5 3 fd 
73 fc 45 7 
addRoundKey!

-------------------round = 3
41 1 3a e3 
b9 74 15 ee 
6d 6 7b 54 
8f b0 6e c5 
SubBytes!

41 1 3a e3 
74 15 ee b9 
7b 54 6d 6 
c5 8f b0 6e 
ShiftRows!

a0 e6 80 65 
e1 58 fa ee 
97 36 c5 e4 
5d 47 b6 5d 
mixColumns!

3b 5d e0 96 
3c 58 e6 92 
6e a b4 c0 
fd f2 27 38 
key applied

9b bb 60 f3 
dd 0 1c 7c 
f9 3c 71 24 
a0 b5 91 65 
addRoundKey!

-------------------round = 4
14 ea d0 d 
c1 63 9c 10 
99 eb a3 36 
e0 d5 81 4d 
SubBytes!

14 ea d0 d 
63 9c 10 c1 
a3 36 99 eb 
4d e0 d5 81 
ShiftRows!

63 a6 c7 28 
61 73 95 33 
fd 21 8d 99 
66 54 53 24 
mixColumns!

7c 21 c1 57 
86 de 38 aa 
69 63 d7 17 
6d 9f b8 80 
key applied

1f 87 6 7f 
e7 ad ad 99 
94 42 5a 8e 
b cb eb a4 
addRoundKey!

-------------------round = 5
c0 17 6f d2 
94 95 95 ee 
22 2c be 19 
2b 1f e9 49 
SubBytes!

c0 17 6f d2 
95 95 ee 94 
be 19 22 2c 
49 2b 1f e9 
ShiftRows!

c8 b8 ca dd 
61 26 d1 7c 
e9 cd e4 3e 
e2 e3 43 1c 
mixColumns!

c0 e1 20 77 
76 a8 90 3a 
a4 c7 10 7 
36 a9 11 91 
key applied

8 59 ea aa 
17 8e 41 46 
4d a f4 39 
d4 4a 52 8d 
addRoundKey!

-------------------round = 6
30 cb 87 ac 
f0 19 83 5a 
e3 67 bf 12 
48 d6 0 5d 
SubBytes!

30 cb 87 ac 
19 83 5a f0 
bf 12 e3 67 
5d 48 d6 0 
ShiftRows!

a9 49 ce 2f 
85 a8 db fe 
ab b4 61 92 
4c 47 9c 78 
mixColumns!

60 81 a1 d6 
b3 1b 8b b1 
25 e2 f2 f5 
c3 6a 7b ea 
key applied

c9 c8 6f f9 
36 b3 50 4f 
8e 56 93 67 
8f 2d e7 92 
addRoundKey!

-------------------round = 7
dd e8 a8 99 
5 6d 53 84 
19 b1 dc 85 
73 d8 94 4f 
SubBytes!

dd e8 a8 99 
6d 53 84 5 
dc 85 19 b1 
4f 73 d8 94 
ShiftRows!

85 c8 1d 3 
37 a9 48 cf 
c2 3f 6d 42 
53 13 d5 37 
mixColumns!

e8 69 c8 1e 
55 4e c5 74 
a2 40 b2 47 
35 5f 24 ce 
key applied

6d a1 d5 1d 
62 e7 8d bb 
60 7f df 5 
66 4c f1 f9 
addRoundKey!

-------------------round = 8
3c 32 3 a4 
aa 94 5d ea 
d0 d2 9e 6b 
33 29 a1 99 
SubBytes!

3c 32 3 a4 
94 5d ea aa 
9e 6b d0 d2 
99 33 29 a1 
ShiftRows!

d8 db da c5 
2f 6 8e 27 
3f ec 29 49 
67 6 6d d6 
mixColumns!

fa 93 5b 45 
f5 bb 7e a 
29 69 db 9c 
47 18 3c f2 
key applied

22 48 81 80 
da bd f0 2d 
16 85 f2 d5 
20 1e 51 24 
addRoundKey!

-------------------round = 9
93 52 c cd 
57 7a 8c d8 
47 97 89 3 
b7 72 d1 36 
SubBytes!

93 52 c cd 
7a 8c d8 57 
89 3 47 97 
36 b7 72 d1 
ShiftRows!

c 9f 5e 3e 
d1 e3 1c 10 
ba 1a cc c7 
31 c 6f 35 
mixColumns!

86 15 4e b 
2b 90 ee e4 
a0 c9 12 8e 
29 31 d ff 
key applied

8a 8a 10 35 
fa 73 f2 f4 
1a d3 de 49 
18 3d 62 ca 
addRoundKey!

-------------------round = 10
7e 7e ca 96 
2d 8f 89 bf 
a2 66 1d 3b 
ad 27 aa 74 
SubBytes!

7e 7e ca 96 
8f 89 bf 2d 
1d 3b a2 66 
74 ad 27 aa 
ShiftRows!

d9 cc 82 89 
32 a2 4c a8 
b6 7f 6d e3 
2 33 3e c1 
key applied

a7 b2 48 1f 
bd 2b f3 85 
ab 44 cf 85 
76 9e 19 6b 
addRoundKey!

Decryption
line of input file = A7B2481FBD2BF385AB44CF85769E196B

a7 b2 48 1f 
bd 2b f3 85 
ab 44 cf 85 
76 9e 19 6b 
stateArray constructed from line of file to decode

d9 cc 82 89 
32 a2 4c a8 
b6 7f 6d e3 
2 33 3e c1 
key applied

7e 7e ca 96 
8f 89 bf 2d 
1d 3b a2 66 
74 ad 27 aa 
invAddRoundKey!

-------------------round = 9
7e 7e ca 96 
2d 8f 89 bf 
a2 66 1d 3b 
ad 27 aa 74 
invShiftRows!

8a 8a 10 35 
fa 73 f2 f4 
1a d3 de 49 
18 3d 62 ca 
invSubBytes!

86 15 4e b 
2b 90 ee e4 
a0 c9 12 8e 
29 31 d ff 
key applied

c 9f 5e 3e 
d1 e3 1c 10 
ba 1a cc c7 
31 c 6f 35 
invAddRoundKey!

93 52 c cd 
7a 8c d8 57 
89 3 47 97 
36 b7 72 d1 
invMixColumns!

-------------------round = 8
93 52 c cd 
57 7a 8c d8 
47 97 89 3 
b7 72 d1 36 
invShiftRows!

22 48 81 80 
da bd f0 2d 
16 85 f2 d5 
20 1e 51 24 
invSubBytes!

fa 93 5b 45 
f5 bb 7e a 
29 69 db 9c 
47 18 3c f2 
key applied

d8 db da c5 
2f 6 8e 27 
3f ec 29 49 
67 6 6d d6 
invAddRoundKey!

3c 32 3 a4 
94 5d ea aa 
9e 6b d0 d2 
99 33 29 a1 
invMixColumns!

-------------------round = 7
3c 32 3 a4 
aa 94 5d ea 
d0 d2 9e 6b 
33 29 a1 99 
invShiftRows!

6d a1 d5 1d 
62 e7 8d bb 
60 7f df 5 
66 4c f1 f9 
invSubBytes!

e8 69 c8 1e 
55 4e c5 74 
a2 40 b2 47 
35 5f 24 ce 
key applied

85 c8 1d 3 
37 a9 48 cf 
c2 3f 6d 42 
53 13 d5 37 
invAddRoundKey!

dd e8 a8 99 
6d 53 84 5 
dc 85 19 b1 
4f 73 d8 94 
invMixColumns!

-------------------round = 6
dd e8 a8 99 
5 6d 53 84 
19 b1 dc 85 
73 d8 94 4f 
invShiftRows!

c9 c8 6f f9 
36 b3 50 4f 
8e 56 93 67 
8f 2d e7 92 
invSubBytes!

60 81 a1 d6 
b3 1b 8b b1 
25 e2 f2 f5 
c3 6a 7b ea 
key applied

a9 49 ce 2f 
85 a8 db fe 
ab b4 61 92 
4c 47 9c 78 
invAddRoundKey!

30 cb 87 ac 
19 83 5a f0 
bf 12 e3 67 
5d 48 d6 0 
invMixColumns!

-------------------round = 5
30 cb 87 ac 
f0 19 83 5a 
e3 67 bf 12 
48 d6 0 5d 
invShiftRows!

8 59 ea aa 
17 8e 41 46 
4d a f4 39 
d4 4a 52 8d 
invSubBytes!

c0 e1 20 77 
76 a8 90 3a 
a4 c7 10 7 
36 a9 11 91 
key applied

c8 b8 ca dd 
61 26 d1 7c 
e9 cd e4 3e 
e2 e3 43 1c 
invAddRoundKey!

c0 17 6f d2 
95 95 ee 94 
be 19 22 2c 
49 2b 1f e9 
invMixColumns!

-------------------round = 4
c0 17 6f d2 
94 95 95 ee 
22 2c be 19 
2b 1f e9 49 
invShiftRows!

1f 87 6 7f 
e7 ad ad 99 
94 42 5a 8e 
b cb eb a4 
invSubBytes!

7c 21 c1 57 
86 de 38 aa 
69 63 d7 17 
6d 9f b8 80 
key applied

63 a6 c7 28 
61 73 95 33 
fd 21 8d 99 
66 54 53 24 
invAddRoundKey!

14 ea d0 d 
63 9c 10 c1 
a3 36 99 eb 
4d e0 d5 81 
invMixColumns!

-------------------round = 3
14 ea d0 d 
c1 63 9c 10 
99 eb a3 36 
e0 d5 81 4d 
invShiftRows!

9b bb 60 f3 
dd 0 1c 7c 
f9 3c 71 24 
a0 b5 91 65 
invSubBytes!

3b 5d e0 96 
3c 58 e6 92 
6e a b4 c0 
fd f2 27 38 
key applied

a0 e6 80 65 
e1 58 fa ee 
97 36 c5 e4 
5d 47 b6 5d 
invAddRoundKey!

41 1 3a e3 
74 15 ee b9 
7b 54 6d 6 
c5 8f b0 6e 
invMixColumns!

-------------------round = 2
41 1 3a e3 
b9 74 15 ee 
6d 6 7b 54 
8f b0 6e c5 
invShiftRows!

f8 9 a2 4d 
db ca 2f 99 
b3 a5 3 fd 
73 fc 45 7 
invSubBytes!

ad 66 bd 76 
ae 64 be 74 
ae 64 be 74 
c5 f d5 1f 
key applied

55 6f 1f 3b 
75 ae 91 ed 
1d c1 bd 89 
b6 f3 90 18 
invAddRoundKey!

91 52 6a 3b 
3b 35 1 95 
d4 1 95 7 
f5 95 5d ee 
invMixColumns!

-------------------round = 1
91 52 6a 3b 
95 3b 35 1 
95 7 d4 1 
95 5d ee f5 
invShiftRows!

ac 48 58 49 
ad 49 d9 9 
ad 38 19 9 
ad 8d 99 77 
invSubBytes!

db cb db cb 
da ca da ca 
da ca da ca 
da ca da ca 
key applied

77 83 83 82 
77 83 3 c3 
77 f2 c3 c3 
77 47 43 bd 
invAddRoundKey!

77 36 83 c3 
77 36 83 fc 
77 36 c3 fc 
77 83 c3 fc 
invMixColumns!

-------------------round = 0
77 36 83 c3 
fc 77 36 83 
c3 fc 77 36 
83 c3 fc 77 
invShiftRows!

2 24 41 33 
55 2 24 41 
33 55 2 24 
41 33 55 2 
invSubBytes!

10 10 10 10 
10 10 10 10 
10 10 10 10 
10 10 10 10 
key applied

12 34 51 23 
45 12 34 51 
23 45 12 34 
51 23 45 12 
invAddRoundKey!

TEST CASE 2
line of input file = 90921909219092190921909219092121

90 92 19 9 
21 90 92 19 
9 21 90 92 
19 9 21 21 
stateArray constructed from line of file to encode


90 81 29 8 
12 90 81 29 
8 12 90 81 
29 8 12 12 
key applied

0 13 30 1 
33 0 13 30 
1 33 0 13 
30 1 33 33 
addRoundKey!

-------------------round = 1
63 7d 4 7c 
c3 63 7d 4 
7c c3 63 7d 
4 7c c3 c3 
SubBytes!

63 7d 4 7c 
63 7d 4 c3 
63 7d 7c c3 
c3 4 7c c3 
ShiftRows!

c3 4 4 a6 
c3 4 f4 7c 
98 f6 7c 7c 
38 8f 8c 19 
mixColumns!

34 b5 9c 94 
1e 8e f 26 
c1 d3 43 c2 
19 11 3 11 
key applied

f7 b1 98 32 
dd 8a fb 5a 
59 25 3f be 
21 9e 8f 8 
addRoundKey!

-------------------round = 2
68 c8 46 23 
c1 7e f be 
cb 3f 75 ae 
fd b 73 30 
SubBytes!

68 c8 46 23 
7e f be c1 
75 ae cb 3f 
30 fd b 73 
ShiftRows!

17 c9 95 52 
3b c2 6c 88 
ac 9c 68 9 
d3 3 a9 7d 
mixColumns!

c1 74 e8 7c 
3b b5 ba 9c 
43 90 d3 11 
3b 2a 29 38 
key applied

d6 bd 7d 2e 
0 77 d6 14 
ef c bb 18 
e8 29 80 45 
addRoundKey!

-------------------round = 3
f6 7a ff 31 
63 f5 f6 fa 
df fe ea ad 
9b a5 cd 6e 
SubBytes!

f6 7a ff 31 
f5 f6 fa 63 
ea ad df fe 
6e 9b a5 cd 
ShiftRows!

77 c3 8a f4 
4c fa cf 23 
7e 7b 54 f9 
c2 f8 6e 4f 
mixColumns!

1b 6f 87 fb 
b9 c b6 2a 
44 d4 7 16 
2b 1 28 10 
key applied

6c ac d f 
f5 f6 79 9 
3a af 53 ef 
e9 f9 46 5f 
addRoundKey!

-------------------round = 4
50 91 d7 76 
e6 42 b6 1 
80 79 ed df 
1e 99 5a cf 
SubBytes!

50 91 d7 76 
42 b6 1 e6 
ed df 80 79 
cf 1e 99 5a 
ShiftRows!

44 39 af fe 
37 82 d7 70 
99 a0 7d 8c 
da fd ca b1 
mixColumns!

f6 99 1e e5 
fe f2 44 6e 
8e 5a 5d 4b 
24 25 d 1d 
key applied

b2 a0 b1 1b 
c9 70 93 1e 
17 fa 20 c7 
fe d8 c7 ac 
addRoundKey!

-------------------round = 5
37 e0 c8 af 
dd 51 dc 72 
f0 2d b7 c6 
bb 61 c6 91 
SubBytes!

37 e0 c8 af 
51 dc 72 dd 
b7 c6 f0 2d 
91 bb 61 c6 
ShiftRows!

bb d9 8c d2 
c6 a9 46 bf 
bb 7d e2 79 
86 4c 3 8d 
mixColumns!

79 e0 fe 1b 
4d bf fb 95 
2a 70 2d 66 
fd d8 d5 c8 
key applied

c2 39 72 c9 
8b 16 bd 2a 
91 d cf 1f 
7b 94 d6 45 
addRoundKey!

-------------------round = 6
25 12 40 dd 
3d 47 7a e5 
81 d7 8a c0 
21 22 f6 6e 
SubBytes!

25 12 40 dd 
47 7a e5 3d 
8a c0 81 d7 
6e 21 22 f6 
ShiftRows!

67 4b 17 c7 
40 9c 2b 33 
df 90 da 54 
7e ce e0 61 
mixColumns!

73 93 6d 76 
7e c1 3a af 
c2 b2 9f f9 
52 8a 5f 97 
key applied

14 d8 7a b1 
3e 5d 11 9c 
1d 22 45 ad 
2c 44 bf f6 
addRoundKey!

-------------------round = 7
fa 61 da c8 
b2 4c 82 de 
a4 93 6e 95 
71 1b 8 42 
SubBytes!

fa 61 da c8 
4c 82 de b2 
6e 95 a4 93 
42 71 1b 8 
ShiftRows!

17 bb 69 dd 
92 ab 91 11 
ac 41 7a 5f 
b3 56 39 72 
mixColumns!

4a d9 b4 c2 
e7 26 1c b3 
4a f8 67 9e 
6a e0 bf 28 
key applied

5d 62 dd 1f 
75 8d 8d a2 
e6 b9 1d c1 
d9 b6 86 5a 
addRoundKey!

-------------------round = 8
4c aa c1 c0 
9d 5d 5d 3a 
8e 56 a4 78 
35 4e 44 be 
SubBytes!

4c aa c1 c0 
5d 5d 3a 9d 
a4 78 8e 56 
be 35 4e 44 
ShiftRows!

65 e5 17 35 
bf ad 72 5f 
9b 58 2e 3d 
4a aa 70 18 
mixColumns!

a7 7e ca 8 
ec ca d6 65 
7e 86 e1 7f 
4f af 10 38 
key applied

c2 9b dd 3d 
53 67 a4 3a 
e5 de cf 42 
5 5 60 20 
addRoundKey!

-------------------round = 9
25 14 c1 27 
ed 85 49 80 
d9 1d 8a 2c 
6b 6b d0 b7 
SubBytes!

25 14 c1 27 
85 49 80 ed 
8a 2c d9 1d 
b7 6b 6b d0 
ShiftRows!

e3 b4 b0 af 
6 99 c1 11 
6d b8 55 9b 
15 8f d7 22 
mixColumns!

f1 8f 45 4d 
3e f4 22 47 
79 ff 1e 61 
7f d0 c0 f8 
key applied

12 3b f5 e2 
38 6d e3 56 
14 47 4b fa 
6a 5f 17 da 
addRoundKey!

-------------------round = 10
c9 e2 e6 98 
7 3c 11 b1 
fa a0 b3 2d 
2 cf f0 57 
SubBytes!

c9 e2 e6 98 
3c 11 b1 7 
b3 2d fa a0 
57 2 cf f0 
ShiftRows!

67 e8 ad e0 
d1 25 7 40 
38 c7 d9 b8 
9c 4c 8c 74 
key applied

ae a 4b 78 
ed 34 b6 47 
8b ea 23 18 
cb 4e 43 84 
addRoundKey!

DECRYPT
line of input file = AE0A4B78ED34B6478BEA2318CB4E4384

ae a 4b 78 
ed 34 b6 47 
8b ea 23 18 
cb 4e 43 84 
stateArray constructed from line of file to decode

67 e8 ad e0 
d1 25 7 40 
38 c7 d9 b8 
9c 4c 8c 74 
key applied

c9 e2 e6 98 
3c 11 b1 7 
b3 2d fa a0 
57 2 cf f0 
invAddRoundKey!

-------------------round = 9
c9 e2 e6 98 
7 3c 11 b1 
fa a0 b3 2d 
2 cf f0 57 
invShiftRows!

12 3b f5 e2 
38 6d e3 56 
14 47 4b fa 
6a 5f 17 da 
invSubBytes!

f1 8f 45 4d 
3e f4 22 47 
79 ff 1e 61 
7f d0 c0 f8 
key applied

e3 b4 b0 af 
6 99 c1 11 
6d b8 55 9b 
15 8f d7 22 
invAddRoundKey!

25 14 c1 27 
85 49 80 ed 
8a 2c d9 1d 
b7 6b 6b d0 
invMixColumns!

-------------------round = 8
25 14 c1 27 
ed 85 49 80 
d9 1d 8a 2c 
6b 6b d0 b7 
invShiftRows!

c2 9b dd 3d 
53 67 a4 3a 
e5 de cf 42 
5 5 60 20 
invSubBytes!

a7 7e ca 8 
ec ca d6 65 
7e 86 e1 7f 
4f af 10 38 
key applied

65 e5 17 35 
bf ad 72 5f 
9b 58 2e 3d 
4a aa 70 18 
invAddRoundKey!

4c aa c1 c0 
5d 5d 3a 9d 
a4 78 8e 56 
be 35 4e 44 
invMixColumns!

-------------------round = 7
4c aa c1 c0 
9d 5d 5d 3a 
8e 56 a4 78 
35 4e 44 be 
invShiftRows!

5d 62 dd 1f 
75 8d 8d a2 
e6 b9 1d c1 
d9 b6 86 5a 
invSubBytes!

4a d9 b4 c2 
e7 26 1c b3 
4a f8 67 9e 
6a e0 bf 28 
key applied

17 bb 69 dd 
92 ab 91 11 
ac 41 7a 5f 
b3 56 39 72 
invAddRoundKey!

fa 61 da c8 
4c 82 de b2 
6e 95 a4 93 
42 71 1b 8 
invMixColumns!

-------------------round = 6
fa 61 da c8 
b2 4c 82 de 
a4 93 6e 95 
71 1b 8 42 
invShiftRows!

14 d8 7a b1 
3e 5d 11 9c 
1d 22 45 ad 
2c 44 bf f6 
invSubBytes!

73 93 6d 76 
7e c1 3a af 
c2 b2 9f f9 
52 8a 5f 97 
key applied

67 4b 17 c7 
40 9c 2b 33 
df 90 da 54 
7e ce e0 61 
invAddRoundKey!

25 12 40 dd 
47 7a e5 3d 
8a c0 81 d7 
6e 21 22 f6 
invMixColumns!

-------------------round = 5
25 12 40 dd 
3d 47 7a e5 
81 d7 8a c0 
21 22 f6 6e 
invShiftRows!

c2 39 72 c9 
8b 16 bd 2a 
91 d cf 1f 
7b 94 d6 45 
invSubBytes!

79 e0 fe 1b 
4d bf fb 95 
2a 70 2d 66 
fd d8 d5 c8 
key applied

bb d9 8c d2 
c6 a9 46 bf 
bb 7d e2 79 
86 4c 3 8d 
invAddRoundKey!

37 e0 c8 af 
51 dc 72 dd 
b7 c6 f0 2d 
91 bb 61 c6 
invMixColumns!

-------------------round = 4
37 e0 c8 af 
dd 51 dc 72 
f0 2d b7 c6 
bb 61 c6 91 
invShiftRows!

b2 a0 b1 1b 
c9 70 93 1e 
17 fa 20 c7 
fe d8 c7 ac 
invSubBytes!

f6 99 1e e5 
fe f2 44 6e 
8e 5a 5d 4b 
24 25 d 1d 
key applied

44 39 af fe 
37 82 d7 70 
99 a0 7d 8c 
da fd ca b1 
invAddRoundKey!

50 91 d7 76 
42 b6 1 e6 
ed df 80 79 
cf 1e 99 5a 
invMixColumns!

-------------------round = 3
50 91 d7 76 
e6 42 b6 1 
80 79 ed df 
1e 99 5a cf 
invShiftRows!

6c ac d f 
f5 f6 79 9 
3a af 53 ef 
e9 f9 46 5f 
invSubBytes!

1b 6f 87 fb 
b9 c b6 2a 
44 d4 7 16 
2b 1 28 10 
key applied

77 c3 8a f4 
4c fa cf 23 
7e 7b 54 f9 
c2 f8 6e 4f 
invAddRoundKey!

f6 7a ff 31 
f5 f6 fa 63 
ea ad df fe 
6e 9b a5 cd 
invMixColumns!

-------------------round = 2
f6 7a ff 31 
63 f5 f6 fa 
df fe ea ad 
9b a5 cd 6e 
invShiftRows!

d6 bd 7d 2e 
0 77 d6 14 
ef c bb 18 
e8 29 80 45 
invSubBytes!

c1 74 e8 7c 
3b b5 ba 9c 
43 90 d3 11 
3b 2a 29 38 
key applied

17 c9 95 52 
3b c2 6c 88 
ac 9c 68 9 
d3 3 a9 7d 
invAddRoundKey!

68 c8 46 23 
7e f be c1 
75 ae cb 3f 
30 fd b 73 
invMixColumns!

-------------------round = 1
68 c8 46 23 
c1 7e f be 
cb 3f 75 ae 
fd b 73 30 
invShiftRows!

f7 b1 98 32 
dd 8a fb 5a 
59 25 3f be 
21 9e 8f 8 
invSubBytes!

34 b5 9c 94 
1e 8e f 26 
c1 d3 43 c2 
19 11 3 11 
key applied

c3 4 4 a6 
c3 4 f4 7c 
98 f6 7c 7c 
38 8f 8c 19 
invAddRoundKey!

63 7d 4 7c 
63 7d 4 c3 
63 7d 7c c3 
c3 4 7c c3 
invMixColumns!

-------------------round = 0
63 7d 4 7c 
c3 63 7d 4 
7c c3 63 7d 
4 7c c3 c3 
invShiftRows!

0 13 30 1 
33 0 13 30 
1 33 0 13 
30 1 33 33 
invSubBytes!

90 81 29 8 
12 90 81 29 
8 12 90 81 
29 8 12 12 
key applied

90 92 19 9 
21 90 92 19 
9 21 90 92 
19 9 21 21 
invAddRoundKey!