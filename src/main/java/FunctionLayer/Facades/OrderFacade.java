/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Facades;

import DataAccessLayer.OrderMapper;
import FunctionLayer.Entities.BoM;
import FunctionLayer.Entities.OrderObject;
import FunctionLayer.Entities.User;
import FunctionLayer.LegoException;
import java.util.List;

/**
 *
 * @author Mellem
 */
public class OrderFacade {
    
    public static OrderObject createOrder(int length, int width, int height, User user) throws LegoException{
        OrderObject order = new OrderObject(length,width,height,user.getEmail());
        
        order = OrderMapper.createOrder(order);
        
        return order;
    }
    
    public static void shipOrder(int id) throws LegoException{
        if (!OrderMapper.isShipped(id)) OrderMapper.shipOrder(id);
    }
    
    /**
     *
     * @param order
     * @return
     * @throws FunctionLayer.LegoException
     */
    public static BoM[] viewBoM(OrderObject order) throws LegoException{
        return order.getBoM();
    }
    
    
    public static List<OrderObject> viewOrders(User user) throws LegoException{
        return OrderMapper.getOrders(user);
    }
    
    public static OrderObject viewOrder(int id) throws LegoException{
        return OrderMapper.getOrder(id);
    }

    public static List<OrderObject> viewOrders() throws LegoException{
        return OrderMapper.getOrders();
    }
}
