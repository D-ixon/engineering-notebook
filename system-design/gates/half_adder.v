module half_adder (
    input wire a,
    input wire b,
    output wire sum,
    output wire carry
);

    // Sum is the XOR of the two inputs
    assign sum = a ^ b;
    
    // Carry is the AND of the two inputs
    assign carry = a & b;

endmodule