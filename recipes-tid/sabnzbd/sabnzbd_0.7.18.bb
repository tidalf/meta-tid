DESCRIPTION = "Sabnzbd"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = "file://GPL2.txt;md5=892f569a555ba9c07a568a7c0c4fa63a"

DEPENDS = "python python-CherryPy"
RDEPENDS_${PN} = "\
	python-core python-shell python-compression python-crypt python-ctypes python-sqlite3 \
	python-cheetah python-pyopenssl python-multiprocessing \
        python-unixadmin \ 
        python-misc python-subprocess python-html python-email python-yenc python-CherryPy \
	"
# RRECOMMENDS_${PN} = "unrar"
SRC_URI = "${SOURCEFORGE_MIRROR}/sabnzbdplus/sabnzbdplus/${PV}/SABnzbd-${PV}-src.tar.gz \
	   file://sabnzbd.service"

SRC_URI[md5sum] = "64d8b675da010dbd444c932bbb3112b6"
SRC_URI[sha256sum] = "aa05697d901b3e334e92f274b2e8788973059840be656a1545e8f2a4b070b014"

S = "${WORKDIR}/SABnzbd-${PV}"

INSTALLDIR = "/usr/lib/${PN}"

PACKAGES = "${PN}-doc ${PN}-src ${PN}"

FILES_${PN}-src = "${INSTALLDIR}/*/*.py ${INSTALLDIR}/*/*/*.py"
FILES_${PN}-doc = "${INSTALLDIR}/*.txt ${INSTALLDIR}/licenses ${INSTALLDIR}/interfaces/*/licenses"
FILES_${PN} = "${INSTALLDIR} /etc/init.d/sabnzbd"

inherit update-rc.d systemd
INITSCRIPT_NAME = "sabnzbd"
INITSCRIPT_PARAMS = "defaults"

do_compile() {
	python -m compileall .
}

do_install() {
	install -d ${D}${INSTALLDIR}
	cp -r . ${D}${INSTALLDIR}/
#	install -d ${D}/etc/init.d
#	install -m 755 ${WORKDIR}/sabnzbd ${D}/etc/init.d/sabnzbd
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/${PN}.service ${D}${systemd_unitdir}/system

}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "${PN}.service"
