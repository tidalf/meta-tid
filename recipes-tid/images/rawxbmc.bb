include recipes-core/images/core-image-base.bb

# SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"
SOC_EXTRA_IMAGE_FEATURES=""

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
"

IMAGE_INSTALL += " \
    run-postinsts \
    lirc \ 
    e2fsprogs \
    libbluray \
    parted \
    tvheadend \
    python-cheetah \
    python-pyopenssl \
    python-multiprocessing \
    python-unixadmin \
    dropbear \
    mariadb-client \
    networkmanager \ 
    python-pprint \
    dbus \
    xbmc \
    xbmc-nm-addon \
    procps \
    util-linux-mount \
    libntfs-3g \
    ntfsprogs \
    ntfs-3g \
    util-linux \
    firmware-imx-vpu-imx6d \
    fsl-rc-local \
    xbmc-image-custom-rfs \
    python-distutils \
"
export IMAGE_BASENAME = "xbmc-image-raw"
