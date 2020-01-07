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
	//order is represented as (item,amount) pairs
    private HashMap<String,Integer> order;
    
    //inventory is represented as a list of warehouses
    //where every warehouse has two keys which are
    //"name" and "inventory", the warehouse inventory is
    //(item,amount) pairs, same as the order
    //ArrayList was chosen to preserve order so cheaper 
    //inventories are visited first
    private ArrayList<HashMap<String,Object>> inventory;

    public InventoryAllocator(HashMap<String,Integer> order, ArrayList<HashMap<String,Object>> inventory)
    {
        this.order = new HashMap<String,Integer>(order);
        this.inventory = new ArrayList<HashMap<String,Object>>(inventory);
    }
     
    public HashMap<String,Integer> getOrder()
    {
        return new HashMap<String,Integer>(this.order); 
    }
    
    public void setOrder(HashMap<String,Integer> order)
    {
        this.order = new HashMap<String,Integer>(order);
    }
    
    public ArrayList<HashMap<String,Object>> getInventory()
    {
        return new ArrayList<HashMap<String,Object>>(this.inventory);
    }
    
    public void setInventory(ArrayList<HashMap<String,Object>> inventory)
    {
        this.inventory = new ArrayList<HashMap<String,Object>>(inventory);
    }
    
    public String getBestShipment(){
    	//handle the empty order case
    	if(this.order.size() == 0) {
        	return new ArrayList<>().toString();
        }
    	//create temporary order to avoid altering class member
    	HashMap<String,Integer> tempOrder = new HashMap<String,Integer>(this.order);
        ArrayList<HashMap<String,HashMap<String,Integer>>> bestShipment = new ArrayList<HashMap<String,HashMap<String,Integer>>>();
        for(HashMap<String,Object> warehouse : this.inventory){
            String warehouseName = (String)warehouse.get("name");
            HashMap<String,HashMap<String,Integer>> warehouseResult = new HashMap<String,HashMap<String,Integer>>();
            HashMap<String,Integer> warehouseInventory = (HashMap<String,Integer>) warehouse.get("inventory");
            HashMap<String,Integer> takenInventory = new HashMap<String,Integer>();
            //Set to store common items between current warehouse and order
            Set<String> commonItems = new HashSet<String>(warehouseInventory.keySet()); 
            //get the intersection of the two key sets
            commonItems.retainAll(tempOrder.keySet());
            for(String item : commonItems){
                int warehouseAmount = warehouseInventory.get(item);
                int orderAmount = tempOrder.get(item);
                if(warehouseAmount <= 0 || orderAmount <= 0) continue;
                int takenAmount = (warehouseAmount < orderAmount) ? warehouseAmount : orderAmount;
                takenInventory.put(item,takenAmount);
                tempOrder.put(item,orderAmount - takenAmount);
                //remove met order items as you go
                if(orderAmount - takenAmount <= 0){
                	tempOrder.remove(item);
                    continue;
                }
            }
            warehouseResult.put(warehouseName,takenInventory);
            bestShipment.add(warehouseResult);
            //check if order is met after visiting every warehouse
            //to remove unnecessary overhead when order is already met
            if(tempOrder.size() == 0) {
            	return bestShipment.toString();
            }
        }
        
        return (new  ArrayList<HashMap<String,HashMap<String,Integer>>>()).toString();
       
    }   
}
