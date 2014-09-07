SUMMARY = "Par2 Command line"
HOMEPAGE = "http://sourceforge.net/projects/parchive/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
SRC_URI = "http://downloads.sourceforge.net/project/parchive/libpar2/0.2/libpar2-0.2.tar.gz"
SRC_URI[md5sum] = "94c6df4e38efe08056ecde2a04e0be91"
SRC_URI[sha256sum] = "074fbf840f73b1e13e0405fce261078c81c8c0a4859e30a7bba10510f9199908"
S = "${WORKDIR}/${PN}-${PV}"
DEPENDS="libsigc++-2.0"

inherit autotools
