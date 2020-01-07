/**
 * Determines the best way an order can be shipped given inventory across a set of warehouses
 *
 * @Zeyad Abdulghani
 * @January-06-2020
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class InventoryAllocator
{
    //inventory is represented as a list of warehouses
    //where every warehouse has two keys which are
    //"name" and "inventory", the warehouse inventory is
    //(item,amount) pairs, same as the order
    //ArrayList was chosen to preserve order so cheaper 
    //inventories are visited first
    private ArrayList<HashMap<String,Object>> inventory;

    public InventoryAllocator(ArrayList<HashMap<String,Object>> inventory)
    {
        this.inventory = new ArrayList<HashMap<String,Object>>(inventory);
    }
      
    public ArrayList<HashMap<String,Object>> getInventory()
    {
        return new ArrayList<HashMap<String,Object>>(this.inventory);
    }
    
    public void setInventory(ArrayList<HashMap<String,Object>> inventory)
    {
        this.inventory = new ArrayList<HashMap<String,Object>>(inventory);
    }
    
    public String getBestShipment(HashMap<String,Integer> order){
    	//handle the empty order case
    	if(order.size() == 0) {
        	return new ArrayList<>().toString();
        }
    	//create temporary order to avoid altering class member
    	HashMap<String,Integer> currentOrder = new HashMap<String,Integer>(order);
        ArrayList<HashMap<String,HashMap<String,Integer>>> bestShipment = new ArrayList<HashMap<String,HashMap<String,Integer>>>();
        for(HashMap<String,Object> warehouse : this.inventory){
            String warehouseName = (String)warehouse.get("name");
            HashMap<String,HashMap<String,Integer>> warehouseResult = new HashMap<String,HashMap<String,Integer>>();
            HashMap<String,Integer> warehouseInventory = (HashMap<String,Integer>) warehouse.get("inventory");
            HashMap<String,Integer> takenInventory = new HashMap<String,Integer>();
            //Set to store common items between current warehouse and order
            Set<String> commonItems = new HashSet<String>(warehouseInventory.keySet()); 
            //get the intersection of the two key sets
            commonItems.retainAll(currentOrder.keySet());
            for(String item : commonItems){
                int warehouseAmount = warehouseInventory.get(item);
                int orderAmount = currentOrder.get(item);
                if(warehouseAmount <= 0 || orderAmount <= 0) continue;
                int takenAmount = (warehouseAmount < orderAmount) ? warehouseAmount : orderAmount;
                takenInventory.put(item,takenAmount);
                currentOrder.put(item,orderAmount - takenAmount);
                //remove met order items as you go
                if(orderAmount - takenAmount <= 0){
                	currentOrder.remove(item);
                }
            }
            warehouseResult.put(warehouseName,takenInventory);
            bestShipment.add(warehouseResult);
            //check if order is met after visiting every warehouse
            //to remove unnecessary overhead when order is already met
            if(currentOrder.size() == 0) {
            	return bestShipment.toString();
            }
        }
        
        return (new  ArrayList<HashMap<String,HashMap<String,Integer>>>()).toString();
       
    }   
}
