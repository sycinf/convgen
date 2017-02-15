package assemblyInfra;

import java.util.ArrayList;
import java.util.List;

public class Loop implements AssemblyPrimitive{
	// either one of these can be 
	private String lower;
	private String upper;
	private String stride;
	private List<Instruction> statements;
	
	public Loop()
	{
		statements = new ArrayList<Instruction>();
	}
	
	private String getHead()
	{
		return "";
	}
	private String getTail()
	{
		return "";
	}
	
	
	@Override
	public String getAssemblyString() {
		String rtStr=getHead();
		for(Instruction inst: statements)
		{
			rtStr+= inst.getAssemblyString();
		}
		rtStr+=getTail();
		return rtStr;
	}

}
