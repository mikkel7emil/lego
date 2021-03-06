/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegoException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ML
 */
abstract class Command {
    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "order", new Order() );
        commands.put( "myorders", new MyOrders() );
        commands.put( "orderbom", new OrderBoM() );
        commands.put( "home", new Home() );
        commands.put( "ship", new Ship() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
        
    }

    
    
    abstract String execute( HttpServletRequest request, HttpServletResponse response ) throws LegoException;
}
