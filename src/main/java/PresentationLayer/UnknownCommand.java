/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegoException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ML
 */
public class UnknownCommand extends Command {
    
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LegoException {
        String msg = "Unknown command. Contact IT";
        throw new LegoException( msg );
    }
    
    
}
