SUMMARY = "Yenc library for Python"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.txt;md5=7073d1d7e78d3b13f448ea0672e2afba"
SRC_URI = "https://pypi.python.org/packages/source/C/CherryPy/CherryPy-${PV}.tar.gz"

SRC_URI[md5sum] = "e2c8455e15c39c9d60e0393c264a4d16"
SRC_URI[sha256sum] = "abd73a449936740e99d3a05eb89b9381dc188ef696904f585463bc28079f1288"

S = "${WORKDIR}/CherryPy-${PV}"

inherit distutils 

RDEPENDS_${PN}_class-native = ""

BBCLASSEXTEND = "native nativesdk"
