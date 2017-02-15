package assemblyInfra;

import helper.RegType;

public class Register {
	private RegType type;
	private Integer seqNum;
	
	public Register(RegType rt, Integer rn)
	{
		type = rt;
		seqNum = rn;
	}
	
	public RegType getType()
	{
		return type;
	}
	public Integer getSeqNum()
	{
		return seqNum;
	}
	
	
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Register))
			return false;
		return (((Register)o).getType()==type && ((Register)o).getSeqNum().equals(seqNum)); 		
	}
	
	@Override
	public int hashCode()
	{
		return (type.toString()+"num"+seqNum.toString()).hashCode();
	}
	

}
