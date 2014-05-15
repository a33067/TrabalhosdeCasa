/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml.layouts;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import pt.isel.mpd14.iters.Queryable;
import pt.isel.mpd14.probe.Binder;
import pt.isel.mpd14.tohtml.AbstractHtmlLayout;

/**
 *
 * @author Koracione
 * @param <T>
 */
public class TableHtmlLayout<T> implements Queryable<T>  {

    
    protected String buildHeadContent(Object o) {
        String res = "       <title>";
        res += o.getClass();
        res += "</title>\n";
        res = "      <tr>\n";
        return res;
    }

    
    protected String buildBodyContent(Object o, List<T> li) {
        String res = "      <tr>\n";
       
        try {
            res+=buildBodyContentAux(o,li);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        res += "       </tr>\n";
        return res;
    }
    protected String buildBodyContentAux(Object o,Predicate<T> li) throws IllegalArgumentException, IllegalAccessException {
        String res=""; 
        while (li.hasNext()){
        Map<String, Object> values = Binder.getFieldsValues(o);
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String k = entry.getKey();
                Object v  = entry.getValue();
                res += "          <td>";
                res += k + ": " + v;
                res += "</td>\n";
                
            }
    }
            return res;
    }

    final Iterable<T> src;
   
     public Queryable<T> filter(Predicate<T> p) {
        return new IterableQueryable<>(new Iterable<T>() {

            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    
                    private final Iterator<T> srcIter = src.iterator();
                    private T nextElem = null;
                    private boolean valueReady = false;

                    @Override
                    public boolean hasNext() {
                        if (valueReady) {
                            return true;
                        }
                        
                        while (srcIter.hasNext()) {
                            T elem = srcIter.next();
                            
                            if (p.test(elem)) {
                                nextElem = elem;
                                valueReady = true;
                                return true;
                            }
                        }
                        
                        return false;
                    }

                    @Override
                    public T next() {
                        if (!valueReady && !hasNext())
                            throw new NoSuchElementException();
                        else {
                            valueReady = false;
                            return nextElem;
                        }
                    }
                    
                };
            }
            
        });
    }

    @Override
    public <R> Queryable<R> map(Function<T, R> mapper) {
        return new IterableQueryable<>(new Iterable<R>() {

            @Override
            public Iterator<R> iterator() {
                return new Iterator<R>(){

                    private final Iterator<T> srcIter = src.iterator();
                    
                    @Override
                    public boolean hasNext() {
                        return srcIter.hasNext();
                    }

                    @Override
                    public R next() {
                        return mapper.apply(srcIter.next());
                    }
                    
                };
            }
            
        });
    }

    @Override
    public Queryable<T> skip(int n) {
        return new IterableQueryable<>(new Iterable<T>() {

            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {

                    private final Iterator<T> srcIter = src.iterator();
                    private int skips = n;
                    
                    @Override
                    public boolean hasNext() {
                        while (skips > 0 && srcIter.hasNext()) {
                            srcIter.next();
                            skips--;
                        }
                        
                        return srcIter.hasNext();
                    }

                    @Override
                    public T next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        
                        return srcIter.next();
                    }
                    
                };
            }
            
        });
    }

    @Override
    public Iterator<T> iterator() {
        return src.iterator();
    }
   
}