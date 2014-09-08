DESCRIPTION = "Arduino IDE HFP for Udoo"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = "file://revisions.txt;md5=20319c61d8a41b964f195fa6a4ee1f4f"

DEPENDS = "oracle-jse-ejre-arm"

SRC_URI = "http://udoo.org/download/files/arduino-1.5.4-hfp-for_UDOO.tar.gz"

SRC_URI[md5sum] = "5cbee0a847097a7685965156c6b2e127"
SRC_URI[sha256sum] = "403ba7fedc80a5637cc6a6c08e80e1dc475b15b61ba4b3ff069087dbd37cb4af"

S = "${WORKDIR}/${PN}-${PV}"

INSTALLDIR = "/usr/lib/${PN}"

do_compile() { 
        rm lib/librxtxSerial64.so 2>/dev/null || true
}
do_install() {
	install -d ${D}${INSTALLDIR}
	cp -r . ${D}${INSTALLDIR}/
}
do_package_qa() {
        echo "bahnon"
}
