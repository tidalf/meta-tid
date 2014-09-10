DESCRIPTION = "Transmission is a cross-platform BitTorrent client that is: easy, lean, native and powerful"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=a1923fe8f8ff37c33665716af0ec84f1"
DEPENDS = "curl libevent intltool"

inherit autotools systemd

SRC_URI = "http://download.transmissionbt.com/files/transmission-2.84.tar.xz \
           file://transmission-daemon.service \
           file://settings.json"

SRC_URI[md5sum] = "411aec1c418c14f6765710d89743ae42"
SRC_URI[sha256sum] = "a9fc1936b4ee414acc732ada04e84339d6755cd0d097bcbd11ba2cfc540db9eb"

EXTRA_OECONF = "--enable-lightweight"

do_configure() {
        ./autogen.sh --noconfigure
        oe_runconf
}

do_install_append() {
       	install -d ${D}/etc/transmission-daemon
	install -m 0644 ${WORKDIR}/settings.json ${D}/etc/transmission-daemon
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/transmission-daemon.service ${D}${systemd_unitdir}/system

}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "transmission-daemon.service"
