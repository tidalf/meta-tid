SUMMARY = "Yenc library for Python"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=5858eb949cc6db7a2879a5eb38b3423a"
SRC_URI = "https://bitbucket.org/dual75/yenc/get/0.4.0.tar.bz2"

SRC_URI[md5sum] = "60e1a535b0e0c865c2cc4e7ddf18d9a4"
SRC_URI[sha256sum] = "3e4c70e4ed26ed436e429680d0f0e36eea165a137c40971f338c6c1d7329da45"

S = "${WORKDIR}/dual75-yenc-ee6b73a5b14f"

inherit setuptools

RDEPENDS_${PN}_class-native = ""

BBCLASSEXTEND = "native nativesdk"
