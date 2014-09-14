# Copyright (C) 2013 Avnet Electronics Marketing

DESCRIPTION = "Sickbeard"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=876108e46a85d097df5da9a4c454c580"

RDEPENDS_${PN} = "\
	python-core python-shell python-compression python-crypt python-ctypes python-sqlite3 \
	python-cheetah python-pyopenssl python-multiprocessing \
        python-unixadmin \ 
        python-misc python-subprocess python-html python-email python-yenc python-CherryPy \
	"
SRC_URI = "git://github.com/midgetspy/Sick-Beard.git;branch=master \
           file://sickbeard.service"
SRCREV = "630fb45df4843069ab2268d4819432e346904901"

inherit autotools pkgconfig systemd
INSTALLDIR = "/usr/lib/sickbeard-git"

S = "${WORKDIR}/git"

do_install() {
        install -d ${D}${INSTALLDIR}
        cp -r * ${D}${INSTALLDIR}/
#       install -d ${D}/etc/init.d
#       install -m 755 ${WORKDIR}/sabnzbd ${D}/etc/init.d/sabnzbd
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/sickbeard.service ${D}${systemd_unitdir}/system
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "sickbeard.service"


