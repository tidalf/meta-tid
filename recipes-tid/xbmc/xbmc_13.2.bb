SUMMARY = "XBMC Media Center"
DESCRIPTION = "XBMC is an award-winning free and open source (GPL) software \
media player and entertainment hub that can be installed on Linux, OSX, \
Windows, iOS, and Android, featuring a 10-foot user interface for use with \
televisions and remote controls."
HOMEPAGE = "http://xbmc.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=6eb631b6da7fdb01508a80213ffc35ff"

DEPENDS = "udev pulseaudio yajl fribidi mpeg2dec curl python libmodplug libmicrohttpd \
           sqlite3 libcdio libpcre boost lzo taglib libtinyxml jasper libass \
           libmad libsamplerate0 libvorbis tiff libxslt libgpg-error \
           swig-native gperf-native unzip-native zip-native \
           libcec rtmpdump ffmpeg libbluray python-stringold \
                   python-mime \
                   python-logging \
                   python-crypt \
                   python-netclient \
                   python-threading \
                   python-elementtree \
                   python-xml \
                   python-dbus \
                   python-html \
                   python-netserver \
                   python-zlib \
                   python-sqlite3 \
                   python-pydoc \
                   python-textutils \
                   python-shell \
                   python-image \
                   python-robotparser \
                   python-compression \
                   python-audio \
                   python-pprint \
                   python-email \
                   python-numbers \
                   python-subprocess \
                   python-xmlrpc \
                       python-compile \
    python-compiler \
    python-compression \
    python-core \
    python-curses \
    python-datetime \
    python-difflib \
    python-distutils \
    python-elementtree \
    python-email \
    python-fcntl \
    python-git \
    python-json \
    python-logging \
    python-mmap \
    python-multiprocessing \
    python-netclient \
    python-netserver \
    python-pickle \
    python-pkgutil \
    python-pprint \
    python-re \
    python-shell \
    python-sqlite3 \
    python-subprocess \
    python-textutils \
    python-unittest \
    python-unixadmin \
    python-xmlrpc \
		   " 

# XBMC plugins requires python modules and dynamically loaded libraries
RDEPENDS_${PN} = " python-stringold \
                   python-mime \
                   python-logging \
                   python-crypt \
                   python-netclient \
                   python-threading \
                   python-elementtree \
                   python-xml \
                   python-dbus \
                   python-html \
                   python-netserver \
                   python-zlib \
                   python-sqlite3 \
                   python-pydoc \
                   python-textutils \
                   python-shell \
                   python-image \
                   python-robotparser \
                   python-compression \ 
                   python-audio \
                   python-pprint \
                   python-email \
                   python-numbers \
                   python-json \
                   python-subprocess \
                   python-xmlrpc \
		       python-compile \
    python-compiler \
    python-compression \
    python-core \
    python-curses \
    python-datetime \
    python-difflib \
    python-distutils \
    python-elementtree \
    python-email \
    python-fcntl \
    python-git \
    python-json \
    python-logging \
    python-mmap \
    python-multiprocessing \
    python-netclient \
    python-netserver \
    python-pickle \
    python-pkgutil \
    python-pprint \
    python-re \
    python-rpm \
    python-shell \
    python-sqlite3 \
    python-subprocess \
    python-textutils \
    python-unittest \
    python-unixadmin \
    python-xmlrpc \
                   eglibc-gconv-cp1252 \
                   libcurl \
                   libnfs \
                   rtmpdump \
                   upower \
                   libmad \
                   libass \
                   mpeg2dec \
                   libcec \
                   kernel \
                   eglibc-gconv-ibm850 \
                   eglibc-gconv-utf-32 \
                   jasper \
                   libcec \
                   udev \
                   alsa-lib \
                   alsa-conf \
                   tzdata \
                   xbmc-pvr-addons \
                   shairplay \
                   libvorbis \
                   flac \
                   libbluray \
                 "




DEPENDS_append_arm = " cmake-native"
DEPENDS_append_x86 = " nasm-native"
DEPENDS_append_mx6 = " virtual/kernel virtual/libgles2 virtual/egl libfslvpuwrap "

CODENAME = "master"
#SRCREV = "0abf356f8d5f1108682578c4f081d4644bc6dc13"
#SRCREV = "2f561a29836b78e487d59bb89f58046f38121590"
SRCREV = "57a30dce1f92a040c97699f3013e50874d2a6133"


SRC_URI = "git://github.com/xbmc/xbmc.git;branch=${CODENAME} \
           file://ffwtf.patch \ 
           file://xbmc.service \
           file://splash.service"

# file://0003-Revert-fixed-ios-Add-memory-barriers-to-cas-assembly.patch
# file://0002-Revert-fixed-ios-Add-memory-barriers-to-atomic-Add-S.patch 
# file://0001-configure-don-t-run-python-distutils-to-find-STAGING.patch 

#           file://0004-Support-for-novfpnoneon-platforms.patch

#           file://xbmc-999.91-PR5202.patch 


S = "${WORKDIR}/git"

CPPFLAGS += " -I${STAGING_KERNEL_DIR}/include/uapi -I${STAGING_KERNEL_DIR}/include "
CXXFLAGS += " -I${STAGING_KERNEL_DIR}/include/uapi -I${STAGING_KERNEL_DIR}/include "
CFLAGS += " -I${STAGING_KERNEL_DIR}/include/uapi -I${STAGING_KERNEL_DIR}/include "

inherit autotools-brokensep gettext python-dir systemd

do_install_append() { 
                 install -d ${D}${systemd_unitdir}/system
                 install -d ${D}${sysconfdir}/systemd/system/multi-user.wants
                 install -m 0644 ${WORKDIR}/xbmc.service ${D}${systemd_unitdir}/system
                 install -m 0644 ${WORKDIR}/splash.service ${D}${systemd_unitdir}/system
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "xbmc.service splash.service"

# Don't activate texturepacker as it needs libsdl-image-native. Due to some issues
# with qemu we use the host's libsdl on which libsdl-image-native depends.
PACKAGECONFIG ??= "${@base_contains('DISTRO_FEATURES', 'opengl', 'opengl', 'opengles2', d)} \
                   sdl airplay ssh libusb libcec samba mysql avahi xrandr x11 joystick \
                   mid rtmp libmp3lame optical-drive debug"

# PACKAGECONFIG[opengl] = "--enable-gl,--enable-gles,glew"
PACKAGECONFIG[opengles2] = "--enable-gles,--enable-gl,"
#PACKAGECONFIG[sdl] = "--enable-sdl,--disable-sdl,libsdl-mixer libsdl-image"
PACKAGECONFIG[airplay] = "--enable-airplay,--disable-airplay,libplist"
PACKAGECONFIG[ssh] = "--enable-ssh,--disable-ssh,libssh"
PACKAGECONFIG[libcec] = "--enable-libcec,--disable-libcec,libcec"
PACKAGECONFIG[libusb] = "--enable-libusb,--disable-libusb,libusb"
PACKAGECONFIG[samba] = "--enable-samba,--disable-samba,samba"
PACKAGECONFIG[mysql] = "--enable-mysql,--disable-mysql,mysql5"
PACKAGECONFIG[avahi] = "--enable-avahi,--disable-avahi,avahi"
# PACKAGECONFIG[xrandr] = "--enable-xrandr,--disable-xrandr,libxrandr"
# PACKAGECONFIG[x11] = "--enable-x11,--disable-x11,"
PACKAGECONFIG[joystick] = "--enable-joystick,--disable-joystick,"
PACKAGECONFIG[texturepacker] = "--enable-texturepacker,--disable-texturepacker,libsdl-image-native"
PACKAGECONFIG[mid] = "--enable-mid,--disable-mid,"
PACKAGECONFIG[rtmp] = "--enable-rtmp,--disable-rtmp,rtmpdump"
PACKAGECONFIG[optical-drive] = "--enable-optical-drive,--disable-optical-drive,libcdio"
PACKAGECONFIG[libmp3lame] = "--enable-libmp3lame,--disable-libmp3lame,lame"
PACKAGECONFIG[debug] = "--enable-debug,--disable-debug,"

# No neon / no VFP on ARMv4 and ARMv5
EXTRA_OECONF_append_armv4 = " --with-platform=novfpnoneon "
EXTRA_OECONF_append_armv5 = " --with-platform=novfpnoneon "

#    --enable-external-libraries 

EXTRA_OECONF_append = " \
    --disable-rxsx \
    --with-arch=${TARGET_ARCH} \
    --enable-external-libraries \
    --enable-libbluray \
    --disable-gl \
    --disable-x11 \
    --enable-gles \
    --enable-codec=imxvpu --disable-debug --disable-texturepacker --enable-airplay --enable-airtunes \
    "

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"

EXTRA_OECONF_append_armv7a = "--with-cpu=cortex-a8"

CACHED_CONFIGUREVARS += " \
    ac_cv_path_PYTHON="${STAGING_BINDIR_NATIVE}/python-native/python" \
"

# for python modules
export HOST_SYS
export BUILD_SYS
export STAGING_LIBDIR
export STAGING_INCDIR
export PYTHON_DIR

do_configure() {
    sh bootstrap
    oe_runconf
}

# On ARM don't run GL/X11 tests in xbmc shell wrapper as xbmc uses GLES
do_configure_prepend_arm() {
    sed -i '/FEH.py/ s/$/ --no-test/' ${S}/tools/Linux/xbmc.sh.in
}

do_qa_configure() { 
  echo kapoue 
}	


FILES_${PN} += " \
    ${datadir}/xsessions \
    ${datadir}/icons"
FILES_${PN}-dbg += " \
    ${libdir}/xbmc/.debug \
    ${libdir}/xbmc/*/.debug \
    ${libdir}/xbmc/*/*/.debug \
    ${libdir}/xbmc/*/*/*/.debug \
    "

# XBMC uses some kind of dlopen() method for libcec so we need to add it manually.
# XBMC wrapper calls xdpyinfo.
# OpenGL builds need glxinfo, that's in mesa-demos.
# service.py and other python tools need a couple of additional modules.
RRECOMMENDS_${PN}_append = " \
    libcec \
    libcurl \
    ${@base_contains('DISTRO_FEATURES', 'x11', 'xdpyinfo', '', d)} \
    python python-stringold python-codecs python-re python-lang python-netclient\
    "
#  ${@base_contains('DISTRO_FEATURES', 'opengl', 'mesa-demos', '', d)}
  
RRECOMMENDS_${PN}_append_libc-glibc = " \
    glibc-charmap-ibm850 glibc-charmap-utf-8 \
    glibc-gconv-ibm85 glibc-gconv-utf-32 \
    "

RDEPENDS_${PN} = " libpulsecommon"
