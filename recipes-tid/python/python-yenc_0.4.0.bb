SUMMARY = "Yenc library for Python"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=5858eb949cc6db7a2879a5eb38b3423a"
SRC_URI = "http://ematome.com/yenc-0.4.0.tar.gz" 
SRC_URI[md5sum] = "f0545036e3b0562457575113da73e5c8"
SRC_URI[sha256sum] = "fc35d17a993471ac61ad2822c55a84d3145647212248884bd673d46c42c49a7d"

S = "${WORKDIR}/yenc-${PV}"

inherit setuptools

RDEPENDS_${PN}_class-native = ""

BBCLASSEXTEND = "native nativesdk"
