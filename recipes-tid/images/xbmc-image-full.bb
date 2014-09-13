include recipes-core/images/core-image-base.bb

# SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"
SOC_EXTRA_IMAGE_FEATURES=""

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
"
#networkmanager 
BOOTSCRIPTS="env.txt"

#   systemd-analyze 
#    xserver-xorg 
#    xserver-xorg-fbdev 
#   xserver-xorg-fbdev 
#    xf86-video-imxfb-vivante 
#   xfce4-session 
CONSOLETOOLS += " \ 
    lzop \
    i2c-tools \
    cpufrequtils \
    net-tools \
    wget \
    smbnetfs \
    strace \
    joe \
    nano \
    rsync \
    ethtool \
    git \
    "

DEVTOOLS += " \
    gdb \
    packagegroup-core-sdk \
    python-distutils \
    "

SYSTEMTOOLS += " \
    connman \
    systemd-serialgetty \
    systemd-analyze \
    samba \
    watchdog \
    parted \
    dropbear \
    xz \
    gnupg \
    screen \
    iw \
    iproute2 \
    e2fsprogs \
    par2cmdline \
    unrar \
    python-cheetah \
    python-pprint \
    mariadb-client \
    procps \
    "

DAEMONS += " \
    python-pyopenssl \
    python-multiprocessing \
    python-unixadmin \
    lirc \ 
    tvheadend \
    transmission \
    nzbget \
    sabnzbd \
    sickbeard-git \
    util-linux-mount \
    libntfs-3g \
    ntfsprogs \
    ntfs-3g \
    util-linux \
    transmission \
    "    

XBMC += " \
     libbluray \
     gst-fsl-plugin \
     xbmc \
     xbmc-nm-addon \
     xbmc-image-custom-rfs \
     " 
#    run-postinsts 
#    util-linux-agetty 
#    firmware-imx-vpu-imx6d 

IMAGE_INSTALL += "${DAEMONS} \
                 ${SYSTEMTOOLS} \
                 ${DEVTOOLS} \ 
                 ${CONSOLETOOLS} \
                 ${XBMC} \
                 "


export IMAGE_BASENAME = "xbmc-image-full"
