EXTRA_OECONF = "--with-kerneldir=${STAGING_KERNEL_DIR} --with-driver=${DRIVER}"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"


DRIVER ?= "uirt2_raw"

# fails to build at the moment, re-enable later
#DRIVER_collie = "sa1100"
DRIVER_uirt = "uirt2_raw"
DRIVER_uirt2 = "usb_uirt_raw"
DRIVER_h3600 = "sa1100"
DRIVER_simpad = "sa1100"
DRIVER_nslu2 = "nslu2"
#DEPENDS_wandboard-quad = "libirman"
#DRIVER_mx6 = "usb_irtoy"
