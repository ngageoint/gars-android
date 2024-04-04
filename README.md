# GARS Android

### Global Area Reference System Android Lib ####

The GARS Library was developed at the [National Geospatial-Intelligence Agency (NGA)](http://www.nga.mil/) in collaboration with [BIT Systems](https://www.caci.com/bit-systems/). The government has "unlimited rights" and is releasing this software to increase the impact of government investments by providing developers with the opportunity to take things in new directions. The software use, modification, and distribution rights are stipulated within the [MIT license](http://choosealicense.com/licenses/mit/).

### Pull Requests ###
If you'd like to contribute to this project, please make a pull request. We'll review the pull request and discuss the changes. All pull request contributions to this project will be released under the MIT license.

Software source code previously released under an open source license and then modified by NGA staff is considered a "joint work" (see 17 USC § 101); it is partially copyrighted, partially public domain, and as a whole is protected by the copyrights of the non-government authors and must be released according to the terms of the original open source license.

### About ###

[GARS Android](http://ngageoint.github.io/gars-android/) is an Android library providing Global Area Reference System functionality, a standardized geospatial reference system for areas.  [GARS App](https://github.com/ngageoint/gars-android/tree/master/app) is a map implementation utilizing this library.

### Usage ###

View the latest [Javadoc](http://ngageoint.github.io/gars-android/docs/api/)

#### Tile Provider ####

```java

// Context context = ...;
// GoogleMap map = ...;

// Tile size determined from display density
GARSTileProvider tileProvider = GARSTileProvider.create(context);

// Manually specify tile size
GARSTileProvider tileProvider2 = GARSTileProvider.create(512, 512);

// Specified grids
GARSTileProvider customTileProvider = GARSTileProvider.create(context,
        GridType.THIRTY_MINUTE, GridType.FIFTEEN_MINUTE);

map.addTileOverlay(new TileOverlayOptions().tileProvider(tileProvider));

```

#### Tile Provider Options ####

```java

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

```

#### Custom Grids ####

```java

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

```

### Installation ###

Pull from the [Maven Central Repository](http://search.maven.org/#artifactdetails|mil.nga.gars|gars-android|1.2.3|aar) (AAR, POM, Source, Javadoc)

    api 'mil.nga.gars:gars-android:1.2.3'

### Build ###

[![Build Artifacts](https://github.com/ngageoint/gars-android/workflows/Build%20Artifacts/badge.svg)](https://github.com/ngageoint/gars-android/actions/workflows/build-artifacts.yml)
[![Test](https://github.com/ngageoint/gars-android/workflows/Test/badge.svg)](https://github.com/ngageoint/gars-android/actions/workflows/test.yml)

Build this repository using Android Studio and/or Gradle.

#### Project Setup ####

Include as repositories in your project build.gradle:

    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }

##### Normal Build #####

Include the dependency in your module build.gradle with desired version number:

    api 'mil.nga.gars:gars-android:1.2.3'

As part of the build process, run the "publishToMavenLocal" task on the gars-android Gradle script to update the Maven local repository.

##### Local Build #####

Replace the normal build dependency in your module build.gradle with:

    api project(':gars')

Include in your settings.gradle:

    include ':gars'

From your project directory, link the cloned SDK directory:

    ln -s ../gars-android/gars gars

### Remote Dependencies ###

* [GARS Java](https://github.com/ngageoint/gars-java) (The MIT License (MIT)) - GARS Library

### GARS App ###

[APK](https://github.com/ngageoint/gars-android/releases/latest/download/gars.apk)

The [GARS App](https://github.com/ngageoint/gars-android/tree/master/app) provides a Global Area Reference System map using this library.
