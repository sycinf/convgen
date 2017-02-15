package helper;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import assemblyInfra.Register;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

public class RegManager {
	private Hashtable<RegType, Integer> registerTotal;
	private Hashtable<RegType, Set<Register>> registerAvail;
	
	public RegManager()
	{
		registerTotal = new Hashtable<RegType, Integer>();
		registerAvail = new Hashtable<RegType, Set<Register>>();
	}
	
	public void initRegType(RegType rt, int numOfReg)
	{
	    if(registerTotal.containsKey(rt) || registerAvail.containsKey(rt))
	    	return;
		registerTotal.put(rt, numOfReg);
		Set<Integer> regsNums = IntStream.rangeClosed(0, numOfReg-1).boxed()
				.collect(Collectors.toSet());
		registerAvail.put(rt, new HashSet<Register>());
		for(Integer i: regsNums)
		{
			registerAvail.get(rt).add(new Register(rt, i));			
		}
				
		    
	}
	
	
	public Set<Register> requestReg(RegType rt, int numOfReg)
	{		
	    if(registerAvail.containsKey(rt) && registerAvail.get(rt).size() >= numOfReg)
		{		    
		    Set<Register> originalList = registerAvail.get(rt);
		    Set<Register> rtList = originalList.stream().limit(numOfReg).collect(Collectors.toSet());
		    registerAvail.get(rt).removeAll(rtList);
		    return rtList;
		}
		else
		    return null;
	}
	
	public boolean returnReg(RegType rt, Set<Register> rtSet)
	{
	    if(registerAvail.containsKey(rt) && registerAvail.get(rt).size() <= registerTotal.get(rt) - rtSet.size() )
	    {  
	        HashSet<Register> intersection = new HashSet<Register>(registerAvail.get(rt));
	        intersection.retainAll(rtSet);
	        if(intersection.size()==0)
	        {
	            registerAvail.get(rt).addAll(rtSet);
	            return true;
	        }	        
	    }
	    return false;
	}
	
	public int getRegAvailNum(RegType rt)
	{
	    if(!registerAvail.containsKey(rt))
	        return 0;
	    else
	        return registerAvail.get(rt).size();
	}
	
}
