DESCRIPTION = "NZBGET can grab nzb from newsgroups"
LICENSE = "GPLv2 & MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=a1923fe8f8ff37c33665716af0ec84f1"
# DEPENDS = "curl libevent intltool"

inherit autotools systemd

SRC_URI = "http://sourceforge.net/projects/nzbget/files/${PN}-${PV}-r1103.tar.gz \
           file://cpp.patch \
           file://nzbget.service \
           file://nzbget.conf"

SRC_URI[md5sum] = "62802a4ea93ddf4e01531c8ca9fb95cc"
SRC_URI[sha256sum] = "a347aadc8c33ca052dbf561285f89d13fa7681d3e328af88acf1890458e56645"

do_qa_configure() {
 echo kapoue
}
do_package_qa() {
 echo kapoue
}

#do_configure() {
#        ./autogen.sh --noconfigure
#        oe_runconf
#}

do_install_append() {
        install -d ${D}/usr/share/nzbget/webui
	install -m 755 ${WORKDIR}/nzbget.conf ${D}/usr/share/nzbget/webui
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/nzbget.service ${D}${systemd_unitdir}/system
}


SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "${PN}.service"
