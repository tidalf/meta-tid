include recipes-core/images/core-image-base.bb

IMAGE_FEATURES += "debug-tweaks"
# DISTRO_FEATURES += "x11"

# SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"
SOC_EXTRA_IMAGE_FEATURES=""
IMAGE_ROOTFS_SIZE  = "1000000"

#    x11-base 
# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
    tools-debug \
    tools-profile \
"
#networkmanager 
#     packagegroup-xfce-multimedia 

IMAGE_INSTALL += " \
    e2fsprogs \
    e2fsprogs-mke2fs \
    lirc \ 
    libbluray \
    packagegroup-core-ssh-openssh \
    python-pip \
    dbus \
    mariadb-client \
    networkmanager \
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
    packagegroup-core-sdk \
    joe \
    nano \
    rsync \
    ethtool \
    samba \
    transmission \
    oscam \
    lxc \
    xz \
    gnupg \
    screen \
    iw \
    iproute2 \
    alsa-conf \
    apache2 \
    php \
    modphp \
    phpmyadmin \
    jpeg \
"

export IMAGE_BASENAME = "xbmc-image"

