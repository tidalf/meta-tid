SUMMARY = "Par2 Command line"
HOMEPAGE = "http://sourceforge.net/projects/parchive/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
SRC_URI = "http://downloads.sourceforge.net/project/parchive/par2cmdline/0.4/par2cmdline-0.4.tar.gz"
#           file://par2cmdline-0.4-gcc4.patch;patch=0"

SRC_URI[md5sum] = "1551b63e57e3c232254dc62073b723a9"
SRC_URI[sha256sum] = "9e32b7dbcf7bca8249f98824757d4868714156fe2276516504cd26f736e9f677"

# DEPENDS = "libpar2 gtkmm" 
DEPENDS = "libpar2" 

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools
