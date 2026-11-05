`timescale 1ns / 1ps

module tb_half_adder;

    // Inputs
    reg a;
    reg b;

    // Outputs
    wire sum;
    wire carry;

    // Instantiate the Unit Under Test (UUT)
    half_adder uut (
        .a(a), 
        .b(b), 
        .sum(sum), 
        .carry(carry)
    );

    // Stimulus block
    initial begin
        // Apply test vectors with 10ns delays
        a = 0; b = 0;
        #10;
        
        a = 0; b = 1;
        #10;
        
        a = 1; b = 0;
        #10;
        
        a = 1; b = 1;
        #10;
        
        // End the simulation
        $finish;
    end

    // Monitor changes in signals
    initial begin
        $dumpfile("half_adder.vcd");
        $dumpvars(0, tb_half_adder);
        $monitor("Time = %0t ns | a = %b, b = %b | sum = %b, carry = %b", 
                 $time, a, b, sum, carry);
    end

endmodule