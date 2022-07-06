package mil.nga.gars.app;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Set;

import mil.nga.color.Color;
import mil.nga.gars.GARS;
import mil.nga.gars.grid.GridType;
import mil.nga.gars.grid.style.Grids;
import mil.nga.gars.tile.GARSTileProvider;

/**
 * README example tests
 *
 * @author osbornb
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class ReadmeTest {

    @Before
    public void launchActivity() {
        ActivityScenario.launch(MapsActivity.class);
    }

    /**
     * Test GARS
     */
    @Test
    public void testGARS() {

        Context context = getApplicationContext();

        testTileProvider(context);
        testOptions(GARSTileProvider.create(context));
        testCustomGrids(context);

    }

    /**
     * Test tile provider
     *
     * @param context app context
     */
    private void testTileProvider(Context context) {

        // Context context = ...;
        // GoogleMap map = ...;

        // Tile size determined from display density
        GARSTileProvider tileProvider = GARSTileProvider.create(context);

        // Manually specify tile size
        GARSTileProvider tileProvider2 = GARSTileProvider.create(512, 512);

        // Specified grids
        GARSTileProvider customTileProvider = GARSTileProvider.create(context,
                GridType.THIRTY_MINUTE, GridType.FIFTEEN_MINUTE);

        //map.addTileOverlay(new TileOverlayOptions().tileProvider(tileProvider));

    }

    /**
     * Test tile provider options
     *
     * @param tileProvider tile provider
     */
    private void testOptions(GARSTileProvider tileProvider) {

        int x = 8;
        int y = 12;
        int zoom = 5;

        // Manually get a tile or draw the tile bitmap
        Tile tile = tileProvider.getTile(x, y, zoom);
        Bitmap tileBitmap = tileProvider.drawTile(x, y, zoom);

        double latitude = 63.98862388;
        double longitude = 29.06755082;
        LatLng latLng = new LatLng(latitude, longitude);

        // GARS Coordinates
        GARS gars = tileProvider.getGARS(latLng);
        String coordinate = tileProvider.getCoordinate(latLng);
        String zoomCoordinate = tileProvider.getCoordinate(latLng, zoom);

        String gars30m = tileProvider.getCoordinate(latLng, GridType.THIRTY_MINUTE);
        String gars15m = tileProvider.getCoordinate(latLng, GridType.FIFTEEN_MINUTE);
        String gars5m = tileProvider.getCoordinate(latLng, GridType.FIVE_MINUTE);

    }

    /**
     * Test custom grids
     *
     * @param context app context
     */
    private void testCustomGrids(Context context) {

        Grids grids = Grids.create();

        grids.deletePropagatedStyles();
        grids.disableTypes(GridType.TWENTY_DEGREE, GridType.TEN_DEGREE,
                GridType.FIVE_DEGREE, GridType.ONE_DEGREE);

        grids.setColor(GridType.THIRTY_MINUTE, Color.red());
        grids.setWidth(GridType.THIRTY_MINUTE, 4.0);
        grids.setMinZoom(GridType.THIRTY_MINUTE, 6);

        grids.setLabelMinZoom(GridType.THIRTY_MINUTE, 6);
        grids.setLabelTextSize(GridType.THIRTY_MINUTE, 32.0);

        grids.setColor(GridType.FIFTEEN_MINUTE, Color.blue());
        Set<GridType> lessThan15m = GridType.lessPrecise(GridType.FIFTEEN_MINUTE);
        grids.setWidth(GridType.FIFTEEN_MINUTE, lessThan15m, 4.0);
        grids.setColor(GridType.FIFTEEN_MINUTE, lessThan15m, Color.red());

        grids.setLabelColor(GridType.FIVE_MINUTE, Color.orange());
        grids.setLabelBuffer(GridType.FIVE_MINUTE, 0.1);
        grids.getLabelPaint(GridType.FIVE_MINUTE).setTypeface(Typeface.DEFAULT_BOLD);
        grids.setWidth(GridType.FIVE_MINUTE, lessThan15m, 4.0);
        grids.setColor(GridType.FIVE_MINUTE, lessThan15m, Color.red());
        grids.setColor(GridType.FIVE_MINUTE, GridType.FIFTEEN_MINUTE, Color.blue());

        GARSTileProvider tileProvider = GARSTileProvider.create(context, grids);

    }

}
