package mil.nga.gars.grid.style;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Collection;
import java.util.List;

import mil.nga.gars.color.Color;
import mil.nga.gars.features.Bounds;
import mil.nga.gars.features.Line;
import mil.nga.gars.grid.GridType;
import mil.nga.gars.grid.Label;
import mil.nga.gars.tile.GARSTile;
import mil.nga.gars.tile.TileDraw;

/**
 * Grids with Android specific styling
 */
public class Grids extends mil.nga.gars.grid.Grids {

    /**
     * Create with all grid types enabled
     *
     * @return grids
     */
    public static Grids create() {
        return new Grids();
    }

    /**
     * Create with grids to enable
     *
     * @param types grid types to enable
     * @return grids
     */
    public static Grids create(GridType... types) {
        return new Grids(types);
    }

    /**
     * Create with grids to enable
     *
     * @param types grid types to enable
     * @return grids
     */
    public static Grids create(Collection<GridType> types) {
        return new Grids(types);
    }

    /**
     * Constructor, all grid types enabled
     */
    public Grids() {

    }

    /**
     * Constructor
     *
     * @param types grid types to enable
     */
    public Grids(GridType... types) {
        super(types);
    }

    /**
     * Constructor
     *
     * @param types grid types to enable
     */
    public Grids(Collection<GridType> types) {
        super(types);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Grid newGrid(GridType type) {
        return new Grid(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ZoomGrids newZoomGrids(int zoom) {
        return new ZoomGrids(zoom);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Grid getGrid(GridType type) {
        return (Grid) super.getGrid(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZoomGrids getGrids(int zoom) {
        return (ZoomGrids) super.getGrids(zoom);
    }

    /**
     * Draw a tile with the dimensions and XYZ coordinate
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     * @param x          x coordinate
     * @param y          y coordinate
     * @param zoom       zoom level
     * @return bitmap tile
     */
    public Bitmap drawTile(int tileWidth, int tileHeight, int x, int y, int zoom) {
        Bitmap bitmap = null;
        ZoomGrids zoomGrids = getGrids(zoom);
        if (zoomGrids.hasGrids()) {
            bitmap = drawTile(GARSTile.create(tileWidth, tileHeight, x, y, zoom), zoomGrids);
        }
        return bitmap;
    }

    /**
     * Draw a tile with the dimensions and bounds
     *
     * @param tileWidth  tile width
     * @param tileHeight tile height
     * @param bounds     bounds
     * @return bitmap tile
     */
    public Bitmap drawTile(int tileWidth, int tileHeight, Bounds bounds) {
        return drawTile(GARSTile.create(tileWidth, tileHeight, bounds));
    }

    /**
     * Draw the tile
     *
     * @param garsTile tile
     * @return bitmap tile
     */
    public Bitmap drawTile(GARSTile garsTile) {
        Bitmap bitmap = null;
        ZoomGrids zoomGrids = getGrids(garsTile.getZoom());
        if (zoomGrids.hasGrids()) {
            bitmap = drawTile(garsTile, zoomGrids);
        }
        return bitmap;
    }

    /**
     * Draw the tile
     *
     * @param garsTile  GARS tile
     * @param zoomGrids zoom grids
     * @return bitmap tile
     */
    private Bitmap drawTile(GARSTile garsTile, ZoomGrids zoomGrids) {

        Bitmap bitmap = Bitmap.createBitmap(garsTile.getWidth(), garsTile.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        for (Grid grid : zoomGrids.grids()) {

            Paint labelPaint = grid.getLabelPaint();

            List<Line> lines = grid.getLines(garsTile);
            if (lines != null) {
                TileDraw.drawLines(lines, garsTile, grid, canvas);
            }

            List<Label> labels = grid.getLabels(garsTile);
            if (labels != null) {
                TileDraw.drawLabels(labels, grid.getLabelBuffer(), garsTile, canvas, labelPaint);
            }

        }

        return bitmap;
    }

    /**
     * Get the grid line paint for the grid type
     *
     * @param type grid type
     * @return grid line paint
     */
    public Paint getLinePaint(GridType type) {
        return getGrid(type).getLinePaint();
    }

    /**
     * Set the grid line paint for the grid type
     *
     * @param type      grid type
     * @param linePaint grid line paint
     */
    public void setLinePaint(GridType type, Paint linePaint) {
        getGrid(type).setLinePaint(linePaint);
    }

    /**
     * Get the grid type precision line paint for the grid type
     *
     * @param type          grid type
     * @param precisionType precision grid type
     * @return grid line paint
     */
    public Paint getLinePaint(GridType type, GridType precisionType) {
        return getGrid(type).getLinePaint(precisionType);
    }

    /**
     * Set the grid type precision line paint for the grid type
     *
     * @param type          grid type
     * @param precisionType precision grid type
     * @param linePaint     grid line paint
     */
    public void setLinePaint(GridType type, GridType precisionType, Paint linePaint) {
        getGrid(type).setLinePaint(precisionType, linePaint);
    }

    /**
     * Get the grid label paint for the grid type
     *
     * @param type grid type
     * @return grid label paint
     */
    public Paint getLabelPaint(GridType type) {
        return getGrid(type).getLabelPaint();
    }

    /**
     * Set the grid label paint for the grid type
     *
     * @param type       grid type
     * @param labelPaint grid label paint
     */
    public void setLabelPaint(GridType type, Paint labelPaint) {
        getGrid(type).setLabelPaint(labelPaint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLabelColor(GridType type, Color color) {
        super.setLabelColor(type, color);
        getGrid(type).resetLabelPaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLabelTextSize(GridType type, double textSize) {
        super.setLabelTextSize(type, textSize);
        getGrid(type).resetLabelPaint();
    }

}
