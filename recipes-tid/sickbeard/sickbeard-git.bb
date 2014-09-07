# Copyright (C) 2013 Avnet Electronics Marketing

DESCRIPTION = "Sickbeard"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=876108e46a85d097df5da9a4c454c580"

SRC_URI = "git://github.com/midgetspy/Sick-Beard.git;branch=master"
SRCREV = "630fb45df4843069ab2268d4819432e346904901"

inherit autotools pkgconfig
INSTALLDIR = "/usr/lib/sickbeard-git"

S = "${WORKDIR}/git"

do_install() {
        install -d ${D}${INSTALLDIR}
        cp -r * ${D}${INSTALLDIR}/
#       install -d ${D}/etc/init.d
#       install -m 755 ${WORKDIR}/sabnzbd ${D}/etc/init.d/sabnzbd
}
