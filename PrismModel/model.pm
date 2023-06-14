mdp

module M

	state : [0..10] init 0;

//	[inContextOf]state=0 -> 1 : (state'=1);
	[supportedBy]state=0 -> 1 : (state'=2);
	[supportedBy]state=0 -> 1 : (state'=3);
	[supportedBy]state=2 -> 1 : (state'=4);
	[supportedBy]state=3 -> 1 : (state'=5);
//	[inContextOf]state=4 -> 1 : (state'=6);
//	[inContextOf]state=5 -> 1 : (state'=6);
	[supportedBy]state=4 -> 1 : (state'=7);
	[supportedBy]state=4 -> 1 : (state'=8);
	[supportedBy]state=5 -> 1 : (state'=9);
	[Solution]state=7 -> 1 : (state'=7);
	[Solution]state=8 -> 1 : (state'=8);
	[Solution]state=9 -> 1 : (state'=9);
	[Solution]state=10 -> 1 : (state'=10);

endmodule

label "Solution"= state=7 |  state=8 |  state=9 |  state=10  ;
label "G1"= state=0;
label "A1"= state=1;
label "S1"= state=2;
label "S2"= state=3;
label "G2"= state=4;
label "G3"= state=5;
label "C1"= state=6;
label "Sn1"= state=7;
label "Sn2"= state=8;
label "Sn3"= state=9;
label "Sn4"= state=10;

