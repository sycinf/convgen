package assemblyInfra;
/*
 * operand can be a few type:
 * register, constant, external value, and immediate
 * operand can play a few roles:
 * address, raw, offset
 */

public class Operand implements AssemblyPrimitive {
	private Register content;
	private String modifier;
	public Operand(Register r, String m)
	{
		content = r;
		modifier = m;
	}
	
	
	
	
	/*
	 * depending on different opcode, the string might need to be different
	 */
	@Override
	public String getAssemblyString() {
		return "";
	}

}
