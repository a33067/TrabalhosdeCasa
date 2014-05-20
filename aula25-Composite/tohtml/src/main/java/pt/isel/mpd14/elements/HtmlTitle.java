/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.elements;

import pt.isel.mpd14.tohtml.HtmlElement;
import java.io.PrintStream;

/**
 *
 * @author Koracione
 */
public class HtmlTitle extends HtmlElement{

	final String text;
	
	public HtmlTitle(String text) {
		this.text = text;
	}

	@Override
	protected void doBefore(PrintStream out) {
		out.print("<title>" + text);
	}

	@Override
	protected void doAfter(PrintStream out) {
		out.println("</title>");
	}
}
