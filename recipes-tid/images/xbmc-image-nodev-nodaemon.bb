include recipes-core/images/core-image-base.bb
include xbmc-image.inc

# SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"
SOC_EXTRA_IMAGE_FEATURES="package-management"

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
"
#    read-only-rootfs 

BOOTSCRIPTS="uEnv.txt"

IMAGE_INSTALL += " \
                 ${SYSTEMTOOLS} \
                 ${XBMC} \
                 "

export IMAGE_BASENAME = "xbmc-image-nothing"
