module not_gate (
    input_A 
    output_B
)

    input input_A;
    output output_B

    wire iam_not;
    assign iam_not = ! input_A;

    output_B = iam_not;

endmodule