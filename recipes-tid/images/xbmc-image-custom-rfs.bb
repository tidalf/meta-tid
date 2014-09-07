DESCRIPTION = "XBMC image RFS customization"
 
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "xbmc"

PR = "r0"

SRC_URI = " \
 file://NetworkManager.conf \
 file://profile \
 file://config \
 file://advancedsettings.xml \
 file://guisettings.xml \
 file://get_dvb_firmware \
 file://wd \
"

SRC_URI_append_utilite = "file://boot_utilite_ssd.scr "

do_install () {
install -d ${D}/etc/
install -d ${D}/etc/network/
install -d ${D}/etc/NetworkManager/
install -d ${D}/home/root/
install -m 0644 ${WORKDIR}/NetworkManager.conf ${D}/etc/NetworkManager/
install -m 0644 ${WORKDIR}/profile ${D}/home/root/.profile
install -d ${D}/var/lib/smart/
install -m 0644 ${WORKDIR}/config ${D}/var/lib/smart/
install -d ${D}/home/root/.xbmc/userdata/
install -m 0644 ${WORKDIR}/advancedsettings.xml ${D}/home/root/.xbmc/userdata/
install -m 0644 ${WORKDIR}/guisettings.xml ${D}/home/root/.xbmc/userdata/
ln -s /var/volatile ${D}/home/root/.xbmc/temp
install -d ${D}/usr/
install -d ${D}/usr/bin/
install -m 0755 ${WORKDIR}/get_dvb_firmware ${D}/usr/bin/
install -m 0755 ${WORKDIR}/wd ${D}/usr/bin/
}

do_install_append_utilite () {
install -d ${D}/boot/
install -m 0644 ${WORKDIR}/boot_utilite_ssd.scr ${D}/boot/boot.scr
}


FILES_${PN} += "/home/root /boot/"
