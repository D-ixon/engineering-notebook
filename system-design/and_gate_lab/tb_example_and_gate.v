`timescale 1ns/1ps

module tb_example_and_gate;

    reg input_1;
    reg input_2;
    wire and_result;

    // Instantiate the circuit under test
    example_and_gate uut (
        .input_1(input_1),
        .input_2(input_2),
        .and_result(and_result)
    );

    initial begin
        $dumpfile("and_gate.vcd");
        $dumpvars(0, tb_example_and_gate);

        $monitor("time=%0t input_1=%b input_2=%b output=%b",
                 $time, input_1, input_2, and_result);

        input_1 = 0; input_2 = 0;
        #10;

        input_1 = 0; input_2 = 1;
        #10;

        input_1 = 1; input_2 = 0;
        #10;

        input_1 = 1; input_2 = 1;
        #10;

        $finish;
    end

endmodule