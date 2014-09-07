DESCRIPTION = "Linux kernel for Udoo"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
DEPENDS += "lzop-native"
require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

# FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:${THISDIR}/linux-imx-3.0.35:"

SRC_URI += "file://defconfig"

# patch for the hardware of "Marie Curie" board

do_install_append () {
  rm -f ${D}/boot/uImage
  cp ${D}/boot/uImage-*  ${D}/boot/uImage
}
