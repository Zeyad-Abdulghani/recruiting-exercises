import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class UnitTest2 {

	@Test
	void test() {
		HashMap<String,Integer> order = new HashMap<String,Integer>()
         {{
             put("apple",1);
         }};
         ArrayList<HashMap<String,Object>> finalResult = new ArrayList<HashMap<String,Object>>()
		{{
			add(new HashMap<String,Object>()
			{{
				put("name","owd");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",0);
				}}
						);
			}});
		}};
		InventoryAllocator actualResult = new InventoryAllocator(order,finalResult);
		Assert.assertEquals("[]", actualResult.getBestShipment());		
	}
}
