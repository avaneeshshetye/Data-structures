package com.Avaneesh;
import java.util.Iterator;
import java.util.NoSuchElementException;

private class PositionIterator
        implements Iterator<Position <E> >{
    private Position <E> cursor = first( ); // next to report
    private Position <E> recent = null; // last reported
    public boolean hasNext( ) { return (cursor != null); }
    /** Returns the next position in the iterator. */
    public Position <E> next( ) throws NoSuchElementException {
        if (cursor == null) throw new
                NoSuchElementException("nothing left");
        recent = cursor;
        cursor = after(cursor);
        return recent;}
    /** Removes element returned by call to next. */
    public void remove( ) throws IllegalStateException {
        if (recent == null) throw new
                IllegalStateException("nothing to remove");
        LinkedPositionalList.this.remove(recent);
        recent = null; // don’t allow remove until next is called
    }}

private class PositionIterable implements
        Iterable<Position<E>> {
    public Iterator<Position <E> > ( ) {
        return new PositionIterator( );
    }
}
    /** Returns iterable instance. */
    public Iterable<Position<E>> positions( ) {
        return new PositionIterable( );
    }

