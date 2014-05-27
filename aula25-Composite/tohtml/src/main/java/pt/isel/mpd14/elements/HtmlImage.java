/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.elements;

import java.awt.Image;
import java.io.PrintStream;
import pt.isel.mpd14.tohtml.HtmlElement;

/**
 *
 * @author Koracione
 */
public class HtmlImage extends HtmlElement {
    
    Image img;
    public HtmlImage(Image img){
        this.img=img;
    }
    @Override
    protected void doBefore(PrintStream out) {
        out.println("<img>");
    }

    @Override
    protected void doAfter(PrintStream out) {
        out.println("</img>");
    }
    
}
