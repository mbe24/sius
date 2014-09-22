sius [![Build Status](https://travis-ci.org/mbe24/sius.svg?branch=master)](https://travis-ci.org/mbe24/sius) [![Coverage Status](https://img.shields.io/coveralls/mbe24/sius.svg)](https://coveralls.io/r/mbe24/sius) [![Version Info](http://img.shields.io/badge/version-v0.2.0-blue.svg)](https://github.com/mbe24/sius) [![License Info](http://img.shields.io/badge/license-Apache%20License%20v2.0-orange.svg)](https://raw.githubusercontent.com/mbe24/jcurry/master/LICENSE)
====

S.I. Unit System
----------------

### Overview ###

Sius is a library for SI unit conversion. It is statically typed to prevent computations with uncompatible units
at compile time.

### Documentation ###

The classes documentation is available here http://mbe24.github.io/sius/.

### Continuous integration ###

Sius' build configuration uses two CI services: travis-ci and drone, since travis does not allow downloading build artifacts
and drone does not support gradle for java.

Please visit https://drone.io/github.com/mbe24/sius/files for current jars.

### Usage ###

Download the jars manually or add sius to your maven dependencies

    <dependency>
        <groupId>org.beyene</groupId>
        <artifactId>sius</artifactId>
        <version>0.2.0</version>
    </dependency>
