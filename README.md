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

// TODO

```

#### Tile Provider Options ####

```java

// TODO

```

#### Custom Grids ####

```java

// TODO

```

### Installation ###

Pull from the [Maven Central Repository](http://search.maven.org/#artifactdetails|mil.nga.gars|gars-android|1.0.0|aar) (AAR, POM, Source, Javadoc)

    api 'mil.nga.gars:gars-android:1.0.0'

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

    api 'mil.nga.gars:gars-android:1.0.0'

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
