include recipes-core/images/core-image-base.bb

IMAGE_ROOTFS_SIZE  = "1000000"

IMAGE_INSTALL += " \
    lirc \ 
    libbluray \
    dropbear \ 
    mariadb-client \
    networkmanager \
    nzbget \
    xbmc \
    xbmc-nm-addon \
    util-linux-mount \
    libntfs-3g \
    ntfsprogs \
    ntfs-3g \
    util-linux \
    firmware-imx-vpu-imx6d \
    fsl-rc-local \
    xbmc-image-custom-rfs \
    samba \
    transmission \
    oscam \
    xz \
    gnupg \
    iw \
    iproute2 \
    alsa-conf \
"

export IMAGE_BASENAME = "xbmc-image-prod"

