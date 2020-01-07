import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class UnitTest8 {

	@Test
	void test() {
		HashMap<String,Integer> order = new HashMap<String,Integer>()
         {{
             put("apple",10);
             put("orange",5);
             put("grape",2);
         }};
        ArrayList<HashMap<String,Object>> finalResult = new ArrayList<HashMap<String,Object>>();
		InventoryAllocator actualResult = new InventoryAllocator(order,finalResult);
		Assert.assertEquals("[]", actualResult.getBestShipment());		
	}
}
