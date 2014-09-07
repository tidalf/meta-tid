include recipes-core/images/core-image-base.bb

# SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"
SOC_EXTRA_IMAGE_FEATURES=""

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
"
#networkmanager 
BOOTSCRIPTS="uEnv.txt"

#   systemd-analyze 
#    xserver-xorg 
#    xserver-xorg-fbdev 
#   xserver-xorg-fbdev 
#    xf86-video-imxfb-vivante 
#   xfce4-session 
IMAGE_INSTALL += " \
    run-postinsts \
    lirc \ 
    e2fsprogs \
    libbluray \
    parted \
    strace \
    gdb \
    tvheadend \
    oracle-jse-ejre-arm \
    xauth \
    x11vnc \
    python-cheetah \
    python-pyopenssl \
    python-multiprocessing \
    python-unixadmin \
    gst-fsl-plugin \
    par2cmdline \
    transmission \
    unrar \
    dropbear \
    nzbget \
    sabnzbd \
    sickbeard-git \
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
    packagegroup-core-sdk \
"
export IMAGE_BASENAME = "xbmc-image-mini"
