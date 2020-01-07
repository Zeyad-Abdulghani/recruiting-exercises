import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class UnitTest6 {

	@Test
	void test() {
		HashMap<String,Integer> order = new HashMap<String,Integer>()
         {{
             put("apple",10);
             put("orange",5);
             put("grape",2);
         }};
         ArrayList<HashMap<String,Object>> finalResult = new ArrayList<HashMap<String,Object>>()
		{{
			add(new HashMap<String,Object>()
			{{
				put("name","owd");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",5);
					put("grape",2);
					put("orange",3);
				}}
				
						);
			}});
			
			add(new HashMap<String,Object>()
			{{
				put("name","dm");
				put("inventory", new HashMap<String,Integer>()
				{{
					put("apple",5);
					put("grape",1);
					put("orange",6);
				}}	
						);
			}});
			
		}};
		InventoryAllocator actualResult = new InventoryAllocator(order,finalResult);
		Assert.assertEquals("[{owd={orange=3, apple=5, grape=2}}, {dm={orange=2, apple=5}}]", actualResult.getBestShipment());		
	}
}
