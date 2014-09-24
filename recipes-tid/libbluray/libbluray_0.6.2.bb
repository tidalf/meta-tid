DESCRIPTION = "Library to access Blu-Ray disks"
SECTION = "libs/multimedia"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=435ed639f84d4585d93824e7da3d85da"
DEPENDS = "libxml2"

PR = "r0"

SRC_URI = "git://git.videolan.org/${PN}.git;protocol=git;tag=6bea5848c573c12134019fd32d0b68afce05c8be"

S = "${WORKDIR}/git"


inherit autotools lib_package pkgconfig


