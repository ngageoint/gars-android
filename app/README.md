# GARS App

[APK](https://github.com/ngageoint/gars-android/releases/latest/download/gars.apk)

The GARS App provides a Global Area Reference System map using the [gars-android](https://github.com/ngageoint/gars-android) library.

TODO

### Build ###

Build this repository using Android Studio and/or Gradle. Run the "assembleRelease" task on the app Gradle script.

#### Map Key ####

When building this project locally, a Google API key is required to see map tiles:
 * Maps SDK for Android: [Get API Key](https://developers.google.com/maps/documentation/android-sdk/signup)

On the [Google Cloud Platform Console](https://cloud.google.com/console/google/maps-apis/overview), configure "Maps SDK for Android" credentials (replacing the example fingerprints).

| Package name           | SHA-1 certificate fingerprint                               |
| ---------------------- | ----------------------------------------------------------- |
| mil.nga.gars.app       | 12:34:56:78:90:AB:CD:EF:12:34:56:78:90:AB:CD:EF:AA:BB:CC:DD |

In your `gradle.properties`, add your API Key (replacing the example keys)

```
RELEASE_MAPS_GARS_API_KEY=AIzaSyBdVl-cTICSwYKrZ95SuvNw7dbMuDt1KG0
DEBUG_MAPS_API_KEY=AIzaSyBdVl-cTICSwYKrZ95SuvNw7dbMuDt1KG0
```
