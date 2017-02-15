package assemblyInfra;
import java.util.ArrayList;
import java.util.List;
public class Instruction implements AssemblyPrimitive{
	private List<Operand> operands;
	private OpCode op;
	
	public Instruction(OpCode op_)
	{
		operands = new ArrayList<Operand>();
		op = op_;
	}
	
	public void addOperand(Operand nextOp)
	{
		operands.add(nextOp);
	}
	

	@Override
	public String getAssemblyString() {
		String myAssem = op.toString();
		for(Operand opr : operands)
			myAssem+=(" "+opr.getAssemblyString());
		return myAssem+"\t\n";
	}
	 	
}
