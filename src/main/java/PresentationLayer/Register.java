package PresentationLayer;

import FunctionLayer.Entities.User;
import FunctionLayer.Facades.LogicFacade;
import FunctionLayer.LegoException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Register is to...

 @author kasper
 */
public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LegoException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( email, password1 );
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {
            throw new LegoException( "the two passwords did not match" );
        }
    }

}
