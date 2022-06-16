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

    // TODO

}
