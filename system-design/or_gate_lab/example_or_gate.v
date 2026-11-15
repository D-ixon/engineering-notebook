module example_or_gate (
    input_A,
    input_B,
    out,
);

    input input_A;
    input input_B;
    output out;

    wire or_ramp;

    assign or_ramp = input_A || input_B;
    assign out = or_ramp;

endmodule