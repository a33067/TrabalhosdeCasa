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
public  class HtmlUnkownElement extends HtmlElement {
    	final String elem;
	
	public HtmlUnkownElement(String elem) {
		this.elem = elem;
	}

	@Override
	protected void doBefore(PrintStream out) {
		out.print("<"+elem+">");
	}

	@Override
	protected void doAfter(PrintStream out) {
		out.println("</"+elem+">");
	}

}
