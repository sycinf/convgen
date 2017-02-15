package helper;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class RegManager {
	private Hashtable<RegType, Integer> registerTotal;
	private Hashtable<RegType, Set<Integer>> registerAvail;
	
	public RegManager()
	{
		registerTotal = new Hashtable<RegType, Integer>();
		registerAvail = new Hashtable<RegType, Set<Integer>>();
	}
	
	public void initRegType(RegType rt, int numOfReg)
	{
	    
		registerTotal.put(rt, numOfReg);
		Set<Integer> regs = IntStream.rangeClosed(0, numOfReg-1).boxed()
				.collect(Collectors.toSet());		
		registerAvail.put(rt, regs);		
		    
	}
	
	public Set<Integer> requestReg(RegType rt, int numOfReg)
	{		
	    if(registerAvail.containsKey(rt) && registerAvail.get(rt).size() >= numOfReg)
		{		    
		    Set<Integer> originalList = registerAvail.get(rt);
		    Set<Integer> rtList = originalList.stream().limit(numOfReg).collect(Collectors.toSet());
		    registerAvail.get(rt).removeAll(rtList);
		    return rtList;
		}
		else
		    return null;
	}
	
	public boolean returnReg(RegType rt, Set<Integer> rtSet)
	{
	    if(registerAvail.containsKey(rt) && registerAvail.get(rt).size() <= registerTotal.get(rt) - rtSet.size() )
	    {  
	        HashSet<Integer> intersection = new HashSet<Integer>(registerAvail.get(rt));
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
