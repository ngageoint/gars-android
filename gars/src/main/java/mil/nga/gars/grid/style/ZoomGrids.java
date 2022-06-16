package mil.nga.gars.grid.style;

import java.util.Iterator;

/**
 * Zoom Grids for Android specific styling
 */
public class ZoomGrids extends mil.nga.gars.grid.ZoomGrids {

    /**
     * Constructor
     *
     * @param zoom zoom level
     */
    public ZoomGrids(int zoom) {
        super(zoom);
    }

    /**
     * Get a grid iterable
     *
     * @return grid iterable
     */
    public Iterable<Grid> grids() {

        return new Iterable<Grid>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public Iterator<Grid> iterator() {
                return gridIterator();
            }

        };
    }

    /**
     * Get a grid iterator
     *
     * @return grid iterator
     */
    private Iterator<Grid> gridIterator() {

        Iterator<mil.nga.gars.grid.Grid> grids = iterator();

        return new Iterator<Grid>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                return grids.hasNext();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public Grid next() {
                return (Grid) grids.next();
            }

        };
    }

}
