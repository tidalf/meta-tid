DESCRIPTION = "Fvb tool"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=a1923fe8f8ff37c33665716af0ec84f1"
# DEPENDS = "curl libevent intltool"

inherit autotools 
# systemd

SRC_URI = "http://s-tech.elsat.net.pl/fbv/fbv-1.0b.tar.gz" 
SRC_URI[md5sum] = "3e466375b930ec22be44f1041e77b55d"
SRC_URI[sha256sum] = "9b55b9dafd5eb01562060d860e267e309a1876e8ba5ce4d3303484b94129ab3c"

#EXTRA_OECONF = "--enable-lightweight"

do_configure() {
#        ./autogen.sh --noconfigure
        oe_runconf
}

#do_install_append() {
#       	install -d ${D}/etc/transmission-daemon
#	install -m 0644 ${WORKDIR}/settings.json ${D}/etc/transmission-daemon
#        install -d ${D}${systemd_unitdir}/system
#        install -m 0644 ${WORKDIR}/transmission-daemon.service ${D}${systemd_unitdir}/system
#
#}

#SYSTEMD_PACKAGES = "${PN}"
#SYSTEMD_SERVICE_${PN} = "transmission-daemon.service"
