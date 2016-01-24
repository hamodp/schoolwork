#author:	Patrick Hamod
#Date:		20 March 2014
#
# program to find GCD and LCM of 2 16-bit numbers

.text
main: 
	#la	$t0, vals  # stores the base address to hold the array of held values
	addi	$s0, $0, 65536 #value to exit from asking for input

input:
	#gets fisrt number
	la	$a0, first
	li	$v0,4
	syscall
	li 	$v0, 5
	syscall
	move	$t1, $v0 #get value from user and store it
	bge 	$t1, $s0, error # end prgram if >= 65536 is entered or <=
	blt	$t1, $0, error
	
	#gets the second number from user
	la	$a0, second
	li	$v0,4
	syscall
	li 	$v0, 5
	syscall
	move	$t2, $v0 #get value from user and store it
	bge 	$t2, $s0, error # end prgram if >= 65536 is entered or <=
	blt	$t2, $0, error
	j	max
	
error:
	la	$a0, outofbounds
	li	$v0,4
	syscall
	li	$v0, 10  # end program
	syscall
	
max:
	ble	$t2, $t1, GCDPrep #puts larger number in $t1 or swaps
	add	$t3, $t1, $0
	add	$t1, $t2, $0
	add	$t2, $t3, $0
	
GCDPrep:
	#prepares loop variables
	addi	$t3, $0, 1
	add	$s1, $t1, $0
	add	$s2, $t2, $0
	#checks if smaller variable is 0 if it is GCD =1
	bge	$s2, $t3, GCDLoop
	add	$s2, $t3, $0
GCDLoop:
	#finds the GCD
	div	$s1, $s2
	mfhi	$t3
	beq	$t3, $0, GCD
	add	$s1, $s2, $0
	mflo	$s2
	j	GCDLoop
GCD:
	#prints the GCD
	la	$a0, gcd
	li	$v0, 4
	syscall
	add	$a0, $s2, $0
	li	$v0, 1
	syscall
	
LCM:
	#divide the larger number by GCD
	div	$t1, $s2
	mflo	$s1
	#multiply the quotient by the smaller number to get the LCM
	mult	$s1, $t2
	mflo	$s1
	
	#print LCM 
	la	$a0, lcm
	li	$v0, 4
	syscall
	add	$a0, $s1, $0
	li	$v0, 1
	syscall
	
exit:
	li	$v0, 10  # end program
	syscall
	
.data
first: .asciiz "please enter the first integer:  "

.data
outofbounds: .asciiz "\nyou must enter an integer >= 0 and <= 65535"

.data
second: .asciiz "Please enter the second integer:  "

.data
gcd: .asciiz "GCD:  "

.data
lcm: .asciiz "\nLCM:  "
