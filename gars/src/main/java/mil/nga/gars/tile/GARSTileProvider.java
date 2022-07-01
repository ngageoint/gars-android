package mil.nga.gars.tile;

import android.content.Context;
import android.graphics.Bitmap;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;

import java.util.Collection;

import mil.nga.gars.GARS;
import mil.nga.gars.grid.GridType;
import mil.nga.gars.grid.style.Grid;
import mil.nga.gars.grid.style.Grids;

/**
 * GARS Tile Provider
 *
 * @author osbornb
 */
public class GARSTileProvider implements TileProvider {

    /**
     * Tile width
     */
    private int tileWidth;

    /**
     * Tile height
     */
    private int tileHeight;

    /**
     * Grids
     */
    private Grids grids;

    /**
     * Create a tile provider with all grids
     *
     * @param context app context
     * @return tile provider
     */
    public static GARSTileProvider create(Context context) {
        return new GARSTileProvider(context);
    }

    /**
     * Create a tile provider with grid types
     *
     * @param context app context
     * @param types   grids types to enable
     * @return tile provider
     */
    public static GARSTileProvider create(Context context, GridType... types) {
        return new GARSTileProvider(context, types);
    }

    /**
     * Create a tile provider with grid types
     *
     * @param context app context
     * @param types   grids types to enable
     * @return tile provider
     */
    public static GARSTileProvider create(Context context, Collection<GridType> types) {
        return new GARSTileProvider(context, types);
    }

    /**
     * Create a tile provider with grids
     *
     * @param context app context
     * @param grids   grids
     * @return tile provider
     */
    public static GARSTileProvider create(Context context, Grids grids) {
        return new GARSTileProvider(context, grids);
    }

    /**
     * Create a tile provider with all grids
     *
     * @param tileLength tile width and height
     * @return tile provider
     */
    public static GARSTileProvider create(int tileLength) {
        return new GARSTileProvider(tileLength);
    }

    /**
     * Create a tile provider with grid types
     *
     * @param tileLength tile width and height
     * @param types      grids types to enable
     * @return tile provider
     */
    public static GARSTileProvider create(int tileLength, GridType... types) {
        return new GARSTileProvider(tileLength, types);
    }

    /**
     * Create a tile provider with grid types
     *
     * @param tileLength tile width and height
     * @param types      grids types to enable
     * @return tile provider
     */
    public static GARSTileProvider create(int tileLength, Collection<GridType> types) {
        return new GARSTileProvider(tileLength, types);
    }

    /**
     * Create a tile provider with grids
     *
     * @param tileLength tile width and height
     * @param grids      grids
     * @return tile provider
     */
    public static GARSTileProvider create(int tileLength, Grids grids) {
        return new GARSTileProvider(tileLength, grids);
    }

    /**
     * Create a tile provider with all grids
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     * @return tile provider
     */
    public static GARSTileProvider create(int tileWidth, int tileHeight) {
        return new GARSTileProvider(tileWidth, tileHeight);
    }

    /**
     * Create a tile provider with grid types
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     * @param types      grids types to enable
     * @return tile provider
     */
    public static GARSTileProvider create(int tileWidth, int tileHeight, GridType... types) {
        return new GARSTileProvider(tileWidth, tileHeight, types);
    }

    /**
     * Create a tile provider with grid types
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     * @param types      grids types to enable
     * @return tile provider
     */
    public static GARSTileProvider create(int tileWidth, int tileHeight, Collection<GridType> types) {
        return new GARSTileProvider(tileWidth, tileHeight, types);
    }

    /**
     * Create a tile provider with grids
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     * @param grids      grids
     * @return tile provider
     */
    public static GARSTileProvider create(int tileWidth, int tileHeight, Grids grids) {
        return new GARSTileProvider(tileWidth, tileHeight, grids);
    }

    /**
     * Constructor
     *
     * @param context app context
     */
    public GARSTileProvider(Context context) {
        this(TileUtils.tileLength(context));
    }

    /**
     * Constructor
     *
     * @param context app context
     * @param types   grids types to enable
     */
    public GARSTileProvider(Context context, GridType... types) {
        this(TileUtils.tileLength(context), types);
    }

    /**
     * Constructor
     *
     * @param context app context
     * @param types   grids types to enable
     */
    public GARSTileProvider(Context context, Collection<GridType> types) {
        this(TileUtils.tileLength(context), types);
    }

    /**
     * Constructor
     *
     * @param context app context
     * @param grids   grids
     */
    public GARSTileProvider(Context context, Grids grids) {
        this(TileUtils.tileLength(context), grids);
    }

    /**
     * Constructor
     *
     * @param tileLength tile width and height
     */
    public GARSTileProvider(int tileLength) {
        this(tileLength, tileLength);
    }

    /**
     * Constructor
     *
     * @param tileLength tile width and height
     * @param types      grids types to enable
     */
    public GARSTileProvider(int tileLength, GridType... types) {
        this(tileLength, tileLength, types);
    }

    /**
     * Constructor
     *
     * @param tileLength tile width and height
     * @param types      grids types to enable
     */
    public GARSTileProvider(int tileLength, Collection<GridType> types) {
        this(tileLength, tileLength, types);
    }

    /**
     * Constructor
     *
     * @param tileLength tile width and height
     * @param grids      grids
     */
    public GARSTileProvider(int tileLength, Grids grids) {
        this(tileLength, tileLength, grids);
    }

    /**
     * Constructor
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     */
    public GARSTileProvider(int tileWidth, int tileHeight) {
        this(tileWidth, tileHeight, Grids.create());
    }

    /**
     * Constructor
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     * @param types      grids types to enable
     */
    public GARSTileProvider(int tileWidth, int tileHeight, GridType... types) {
        this(tileWidth, tileHeight, Grids.create(types));
    }

    /**
     * Constructor
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     * @param types      grids types to enable
     */
    public GARSTileProvider(int tileWidth, int tileHeight, Collection<GridType> types) {
        this(tileWidth, tileHeight, Grids.create(types));
    }

    /**
     * Constructor
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     * @param grids      grids
     */
    public GARSTileProvider(int tileWidth, int tileHeight, Grids grids) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.grids = grids;
    }

    /**
     * Get the tile width
     *
     * @return tile width
     */
    public int getTileWidth() {
        return tileWidth;
    }

    /**
     * Set the tile width
     *
     * @param tileWidth tile width
     */
    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    /**
     * Get the tile height
     *
     * @return tile height
     */
    public int getTileHeight() {
        return tileHeight;
    }

    /**
     * Set the tile height
     *
     * @param tileHeight tile height
     */
    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    /**
     * Get the grids
     *
     * @return grids
     */
    public Grids getGrids() {
        return grids;
    }

    /**
     * Set the grids
     *
     * @param grids grids
     */
    public void setGrids(Grids grids) {
        this.grids = grids;
    }

    /**
     * Get the grid
     *
     * @param type grid type
     * @return grid
     */
    public Grid getGrid(GridType type) {
        return grids.getGrid(type);
    }

    /**
     * Get the Global Area Reference System coordinate for the location in five
     * minute precision
     *
     * @param latLng location
     * @return GARS coordinate
     */
    public String getCoordinate(LatLng latLng) {
        return getGARS(latLng).coordinate();
    }

    /**
     * Get the Global Area Reference System coordinate for the location in the
     * zoom level precision
     *
     * @param latLng location
     * @param zoom   zoom level precision
     * @return GARS coordinate
     */
    public String getCoordinate(LatLng latLng, int zoom) {
        return getCoordinate(latLng, getPrecision(zoom));
    }

    /**
     * Get the Global Area Reference System coordinate for the location in the
     * grid type precision
     *
     * @param latLng location
     * @param type   grid type precision
     * @return GARS coordinate
     */
    public String getCoordinate(LatLng latLng, GridType type) {
        return getGARS(latLng).coordinate(type);
    }

    /**
     * Get the Global Area Reference System for the location
     *
     * @param latLng location
     * @return GARS
     */
    public GARS getGARS(LatLng latLng) {
        return GARS.from(TileUtils.toPoint(latLng));
    }

    /**
     * Get the grid precision for the zoom level
     *
     * @param zoom zoom level
     * @return grid type precision
     */
    public GridType getPrecision(int zoom) {
        return grids.getPrecision(zoom);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tile getTile(int x, int y, int zoom) {
        return TileUtils.toTile(drawTile(x, y, zoom));
    }

    /**
     * Draw the tile
     *
     * @param x    x coordinate
     * @param y    y coordinate
     * @param zoom zoom level
     * @return bitmap
     */
    public Bitmap drawTile(int x, int y, int zoom) {
        return grids.drawTile(tileWidth, tileHeight, x, y, zoom);
    }

}
