.data
vals: .space 4000

.text
main: 
	la	$t0, vals  # stores the base address to hold the array of held values
	add	$t2, $0, 9999 #value to exit from asking for input
	add	$s0, $0, $0 #variable for array index
	add	$s1, $0, $0 #variable for running through array
	
input:
	li 	$v0, 5
	syscall
	move	$t1, $v0 #get value from user and store it
	beq 	$t1, $t2, output # end prgram if 9999 is entered
	j	loop

loop: #loop for insertion sort finds if input is smaller than any entry and or inserts at end
	bgt	$s1, $s0, addAtEnd
	beq	$s1, $s0, addAtEnd
	sll	$t3, $s1, 2
	add	$t3, $t0, $t3
	lw	$t4, 0($t3)
	slt	$t4, $t4, $t1
	beq	$t4, $0, insert
	addi	$s1, $s1, 1
	j	loop

addAtEnd: #adds last element if largest number
	sll	$t3, $s0, 2 #shifts index by offset 
	add	$t3, $t0, $t3
	sw	$t1, 0($t3)
	addi	$s0, $s0, 1
	add	$s1, $0, $0
	j	input

insert:#inserts number and pushes back all larger numbers
	#swaps all smaller numbers with larger
	sll	$t3, $s1, 2
	add	$t3, $t0, $t3
	lw	$t4, 0($t3)
	sw	$t1, 0($t3)
	add	$t1, $t4, $0
	add	$t1, $t4, $0
	addi	$s1, $s1, 1
	beq	$s1, $s0, addAtEnd
	j	insert
		
output:#goes through list of numbers and prints them out
	beq	$s1, $s0, maxNum
	sll	$t3, $s1, 2
	add	$t3, $t0, $t3
	lw	$a0, 0($t3)
	li	$v0, 1
	syscall
	la	$a0, next
	li 	$v0, 4
	syscall
	addi	$s1, $s1, 1
	j	output
	
maxNum:#finds maximum number in set
	
	addi	$s0, $s0, -1 #gets last index by subtracting 1 from the size
	#prints out 'max:  '
	la	$a0, max
	li 	$v0, 4
	syscall
	#loads the first number in the set
	sll	$t3, $s0, 2
	add	$t3, $t0, $t3
	lw	$a0, 0($t3)
	li	$v0, 1
	syscall
	
minNum:#finds minimal number of set
	#prints out 'min:  "
	la	$a0, min
	li 	$v0, 4
	syscall
	#loads the first number and 
	lw	$a0, 0($t0)
	li	$v0, 1
	syscall
	
medNum:#finds the median of the set
	
	#prints out 'median: '
	la	$a0, med
	li 	$v0, 4
	syscall
	#finds the middle number choosing the smaller and prints
	srl	$t3, $s0,1
	sll	$t3, $t3, 2
	add	$t3, $t3, $t0
	#loads and prints the median number
	lw	$a0, 0($t3)
	li	$v0, 1
	syscall
	
exit:
	li	$v0, 10  # end program
	syscall
	
.data
next: .asciiz ", "

.data
max: .asciiz "\nmax :  "

.data
min: .asciiz "\nmin:   "

.data
med: .asciiz "\nmedian:   "
