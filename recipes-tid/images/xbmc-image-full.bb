include recipes-core/images/core-image-base.bb
include xbmc-image.inc

# SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"
SOC_EXTRA_IMAGE_FEATURES="package-management"

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
"
#networkmanager 
BOOTSCRIPTS="env.txt"

IMAGE_INSTALL += "${DAEMONS} \
                 ${SYSTEMTOOLS} \
                 ${DEVTOOLS} \ 
                 ${CONSOLETOOLS} \
                 ${XBMC} \
                 "


export IMAGE_BASENAME = "xbmc-image-full"
