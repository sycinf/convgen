package helper;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegManagerTest {

    RegManager subject;
    final int REGNUM = 32;
    
    @Before
    public void setUp() throws Exception {
        
        subject = new RegManager();
        subject.initRegType(RegType.ASIMDQ, REGNUM);
    }

    @After
    public void tearDown() throws Exception {
    }
    

    @Test
    public void testRequestReg() {
        Set<Integer> firstBatch = subject.requestReg(RegType.ASIMDQ, REGNUM/2);
        Set<Integer> secondBatch = subject.requestReg(RegType.ASIMDQ, REGNUM-REGNUM/2);
        
        assertTrue(firstBatch!=null && secondBatch!=null && firstBatch.size()==REGNUM/2 && secondBatch.size() == REGNUM-REGNUM/2);
        
        
    }
    
    @Test
    public void testReturnReg() {
        Set<Integer> firstBatch = subject.requestReg(RegType.ASIMDQ, REGNUM/2);
        Set<Integer> secondBatch = subject.requestReg(RegType.ASIMDQ, REGNUM);
        
        assertTrue(firstBatch!=null && secondBatch==null);
        subject.returnReg(RegType.ASIMDQ, firstBatch);
        secondBatch = subject.requestReg(RegType.ASIMDQ, REGNUM);
        assertTrue(secondBatch!=null);
        
        
        
    }

}
