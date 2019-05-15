CS3339 Datapath Project - Michael Corbett, Olisa Wallace, Colton Eastland, Marco Romano

This project was created for the purpose of education on the basics of a MIPS datapath on the standard instruction types (ALU, Load Word, Store Word, and Branch type instructions). For each instruction type listed there are options to both passively observe an animation describing the wires and controls signals of a single processor for a single instruction, as well as taking on a more active part in the process by offering the user the ability to click on the nodes of each wire and connect them to their appropriate counterpart depending on the instruction.

-------------------------------------------------------------------------------
Contents:

-About
-Running Datapath Viewer
-Features

-------------------------------------------------------------------------------
=About=
The datapath is a series of functioning units that are used by the Central Processing Unit to enact basic instructions.

==Components==
These functioning units, called "components", are connected via a series of wires throughout the datapath that receive and deliver electrical signals to and from other components. The information each wire produces is 0 or 1, depending on whether it has a high or low electrical signal, and those eletrical signals depend on what instruction was given. The componenets each have ports in specific places for specific purposes and will perform different tasks based on the combination of 0 and 1 signals they recieve.

The components used in the project are: The Program Counter (PC), Instruction Memory, Register File, ALU and Adders, Data Memory, the Sign Extender, Bit-Shifter, and MUXes.

Memory can be generally defined here as a piece of hardware of integrated circuits that store data for immediate use. There are different types of memory for different uses.

A register is simply an alotted location in memory of a fixed size that can be directly interacted with by a programmer. The Program Counter is a register that stores the address in memory of the current instruction being executed, and usually increments sequentially to move onto the next instruction.

Instruction memory accepts the address in the PC and decodes instruction at that location. Then it passes on the correct data to the Register File and sometimes Sign-Extender.

The Register File stores 32 registers, and accepts and/or passes on new data/data addresses to the ALU.

The ALU (Arithmetic and Logic Unit) performs arithmetic upon the data inside the address inputs and outputs the result. The Adders are simple ALUs whose only purpose is to accept two pieces or data and output their sum.

The Sign Extender accepts a 16-bit (16 digit long) binary string instruction and outputs the same value except as a 32 bit string by adding either 1s or 0s, depending on the parity of the value.

Data Memory acts as a storage and retrieval area for data without the use of registers. It can be both read from and stored to.

The Bit-Shifter or Shift Unit performs an "Arithmetic Shift", which means it accepts a 32-bit binary string, moves all the digits twice to the left, and then the farthest-right bits are replaced with 0s. This effectively multiplies the entire string by 4 in base 2. The farthest left bits "fall off" and are no longer important. The bit-shifter will then output this result into an adder, which then outputs the sum of the current PC, which will feed back into the PC to alter the current instruction stream, depending on if the current instruction demands it.

MUXes are a type of gate that allow or deny passage of a wire's signal to a component depending on the MUXes own signal, which is received from a control unit. 

==Instructions==
Instructions are types of commands that can be issued at an architectural level to enact operations upon data, depending on the type of instruction and data input alongside it. Here, the only instruction types issued are ALU, Store, Load, and Branch.

ALU instructions operate upon the data in two registers in the register file, and then output the result of the operation into a third specified register. ALU instructions actually encompass any basic math instruction (add, sub, div, mul, etc.), but are referred to as ALU-type due to their main execution being the mathematical operation on the input data. E.g. [add $t3, $r1, $r2 will add the contents of registers $r1 and $r2 and store the result in register $t3]

Store instructions accept a register and then store its data at a specified address in data memory. The location in data memory may be directly stored to, or offsetting it from an existing data memory address. E.g. [sw $t0, 16($s0) will store the contents of $t0 into the location 4 bits away from the address stored in $s0]

Load instructions are similar to store instructions, but they instead take the location in memory specified, and store the data found there in a register. E.g. [lw $t0, 0($t3) will take the data at the address in $t3 and copy it into $t0]

Branch instructions alter the program counter to pick up and place the current state of the processor at a different set of instructions, rather than the normal, sequential series. The branch only occurs if certain conditions are met, although there are unconditional branches, called "Jumps". E.g. [beq $s0, $t0 LOOP will move the next set of instructions executed to the location LOOP.]


-------------------------------------------------------------------------------
=Running Datapath Viewer=

Running Datapath Viewer is simple. Simply run the accompanying .jar file in this project.

-------------------------------------------------------------------------------
=Features=

Each feature of the program is selectable from the menu bar at the top of the window, some with multiple options after clicking them.

-User
  --Allows a user-specific name to be entered
  --Will save specific progress in the other featured options to specific usernames

-Animation
  --Gives a choice between ALU, Store, Load, and Branch type instructions.
  --the program will depict an animation sequence to show how data travels throughout the components and wires of the processor according to the selected instruction type.

-Drag n Drop
  --The program presents the user with a series of blank nodes about the screen, and a compartment containing a variety of processor components.
  --The components are capable of drag and drop functionality, and will snap to their appropriate position when dropped over it, and returns to its original position when dropped in an incorrect node.

-Data Path
  --Given a choice between ALU, Store, Load, and Branch type instructions.
  --The user is presented with the basic MIPS processor components and an enumeration of green nodes at several places.
  --Each node lies at the positions of the components ports or at divergent wire positions for MUXs.
  --The user may click a node to activate it, and then click its corresponding node to reveal the datapath between the two, depending on if its the correct datapath according to the chosen instruction type.

-Control Unit
  --Given a choice between ALU, Store, Load, and Branch type instructions.
  --The program depicts the MIPS datapath and displays the control unit and its signal wires
  --The control unit will present, in order, each signal it has to offer to the user with a choice between '0' and '1'. If incorrect, nothing happens, if correct, the next control signal choice appears.