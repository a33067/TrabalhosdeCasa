/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.elements;

import java.io.PrintStream;
import pt.isel.mpd14.tohtml.HtmlElement;

/**
 *
 * @author Koracione
 */
public class HtmlThematicBreak extends HtmlElement{

    @Override
    protected void doBefore(PrintStream out) {
       out.println("<hr>");
    }

    @Override
    protected void doAfter(PrintStream out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
