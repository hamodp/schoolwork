#author:	Patrick Hamod
#Date:		20 March 2014
#
# program to divide 2 8-bit numbers

.text
main: 
	#la	$t0, vals  # stores the base address to hold the array of held values
	addi	$s0, $0, 255 #value to exit from asking for input
	addi	$t9, $0, 8 #iteration limit
	addi	$t7, $0, 1 #checks the one bit
	addi	$t8, $0, 0 #iteration counter
	add	$t6, $0, $0
			
input:
	#gets fisrt number
	la	$a0, first
	li	$v0,4
	syscall
	li 	$v0, 5
	syscall
	move	$t1, $v0 #get value from user and store it
	bge 	$t1, $s0, error # end prgram if >= 511 is entered or <=0
	blt	$t1, $0, error
	
	#gets the second number from user
	la	$a0, second
	li	$v0,4
	syscall
	li 	$v0, 5
	syscall
	move	$t2, $v0 #get value from user and store it
	bge 	$t2, $s0, error # end prgram if >= 256 is entered or <= 0
	blt	$t2, $0, error
	j	multiprep
	
error:
	la	$a0, outofbounds
	li	$v0,4
	syscall
	li	$v0, 10  # end program
	syscall
	
multiprep:
	add 	$s1, $t1, $0
	sll	$s2, $t2, 8	
	
multiply:
	bge	$t8, $t9, product #check to end loop
	and	$t3, $s1, $t7
	bne	$t3, $t7, multi2
	add	$s1, $s2, $s1
multi2:
	srl	$s1, $s1, 1
	add	$t8, $t8, $t7
	j	multiply
	
product:
	#prints the product
	la	$a0, prod
	li	$v0, 4
	syscall
	add	$a0, $s1, $0
	li	$v0, 1
	syscall
	
divideprep1:
	add	$t8, $0, $0
	add	$s1, $t1,$0 
	sll	$s1, $s1, 1
	j	divideloop
	
divideprep2:
	add	$t8, $0, $0
	add	$s1, $t2,$0
	add	$s2, $t1, $0
	sll	$s2, $s2, 8 
	sll	$s1, $s1, 1

divideloop:
	beq	$s2, $0, divide0
	bge	$t8, $t9, divideresult #check to end loop
	addi	$t8, $t8, 1
	sub	$s1, $s1, $s2
	bge	$s1, $0, dividegreat
	add	$s1, $s1, $s2
	sll	$s1, $s1, 1
	j	divideloop

dividegreat:
	sll	$s1, $s1, 1
	add	$s1, $s1, $t7
	j	divideloop
	
divideresult:
	beq	$t6, $t7, result2 

result1:
	add	$t6, $0, $t7
	la	$a0, quotientab
	li	$v0, 4
	syscall
	andi	$a0, $s1, 15
	li	$v0, 1
	syscall
	
	la	$a0, remainab
	li	$v0, 4
	syscall
	andi	$a0, $s1, 65280
	srl	$a0, $a0, 9
	li	$v0, 1
	syscall
	j	divideprep2

result2:
	add	$t6, $0, $t7
	la	$a0, quotientba
	li	$v0, 4
	syscall
	andi	$a0, $s1, 15
	li	$v0, 1
	syscall
	
	la	$a0, remainba
	li	$v0, 4
	syscall
	andi	$a0, $s1, 65280
	srl	$a0, $a0, 9
	li	$v0, 1
	syscall
	j	exit
	
divide0:
	beq	$t6, $t7, divide02
	la	$a0, quotientab
	li	$v0, 4
	syscall
	la	$a0, divideby0
	li	$v0, 4
	syscall
	add	$t6, $0, $t7
	j	divideprep2
	
divide02:
	la	$a0, quotientba
	li	$v0, 4
	syscall
	la	$a0, divideby0
	li	$v0, 4
	syscall
	

exit:
	li	$v0, 10  # end program
	syscall
	
.data
first: .asciiz "please enter the first integer (a):  "

.data
outofbounds: .asciiz "\nyou must enter an integer >= 0 and <= 511"

.data
second: .asciiz "Please enter the second integer (b):  "

.data
prod: .asciiz "Product:  "

.data
quotientab: .asciiz "\nQuotient (a/b):  "

.data
remainab: .asciiz "\nRemainder (a/b):  "

.data
quotientba: .asciiz "\nQuotient (b/a):  "

.data
remainba: .asciiz "\nRemainder (b/a):  "

.data
divideby0: .asciiz "Divide by 0 not allowed "


