# Copyright (C) 2013 Freescale Semiconductor

DESCRIPTION = "bootloader for udoo"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

PV = "v2014.4"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

# revision of 3.10.9-1.0.0 alpha branch
SRC_URI = "git://git.denx.de/u-boot.git \
           file://0001-udoo-uEnv.txt-bootz-n-fixes.patch \
           file://uEnv.txt \
"
SRCREV = "dda0dbfc69f3d560c87f5be85f127ed862ea6721"
S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(udoo)"

# UENV_FILENAME ?= "uEnv${MACHINE}.txt"
UENV_FILENAME ?= "uEnv.txt"

deploy_uenv () {
    install ${WORKDIR}/uEnv.txt ${DEPLOYDIR}/${UENV_FILENAME}
}

do_deploy[postfuncs] += "deploy_uenv"


# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="-L${STAGING_BASE_LIBDIR_NATIVE} -L${STAGING_LIBDIR_NATIVE}" \
                 HOSTSTRIP=true \ 
                 CONFIG_SPLASH_SCREEN=1 \
                 '

