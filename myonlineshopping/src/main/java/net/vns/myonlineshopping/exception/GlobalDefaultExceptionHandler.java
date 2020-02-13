package net.vns.myonlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle", "The page is not constructed");
		mv.addObject("errorDescription", "The page you are looking for is not available!");
		mv.addObject("title", "404 Error page");
		return mv;
	}
	
	

		
		@ExceptionHandler(ProductNotFoundException.class)
		
		public ModelAndView handlerProductNotFoundException() {
			ModelAndView mv=new ModelAndView("error");
			mv.addObject("errorTitle", "product not available");
			mv.addObject("errorDescription", "The product you are looking for is not available!");
			mv.addObject("title", "product Unavailable");
			return mv;
		}
		
@ExceptionHandler(Exception.class)
		
		public ModelAndView handlerException(Exception ex) {
			ModelAndView mv=new ModelAndView("error");
			mv.addObject("errorTitle", "Contact admin!");
			/*only debudg purpuse*/
			StringWriter sw=new StringWriter();
			PrintWriter pw=new PrintWriter(sw);
			ex.printStackTrace(pw);
			mv.addObject("errorDescription", sw.toString());
			mv.addObject("title", "error");
			return mv;
		}
}
