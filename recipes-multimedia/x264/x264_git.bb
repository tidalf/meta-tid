SUMMARY = "H.264/MPEG-4 AVC video encoder"
DESCRIPTION = "A free software library and application for encoding video streams into the H.264/MPEG-4 AVC format."
HOMEPAGE = "http://www.videolan.org/developers/x264.html"

LICENSE = "GPLv2"
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "yasm-native"

SRC_URI = "git://git.videolan.org/x264.git;branch=stable \
           file://don-t-default-to-cortex-a9-with-neon.patch \
           "

# SRCREV = "dd79a61e0e354a432907f2d1f7137b27a12dfce7"
SRCREV = "021c0dc6c95c1bc239c9db78a80dd85fc856a4dd"

PV = "r2265+git${SRCPV}"

S = "${WORKDIR}/git"

inherit lib_package pkgconfig perlnative

X264_DISABLE_ASM = ""
X264_DISABLE_ASM_armv4 = "--disable-asm"
X264_DISABLE_ASM_armv5 = "--disable-asm"
X264_DISABLE_ASM_powerpc = "${@bb.utils.contains("TUNE_FEATURES", "spe", "--disable-asm", "", d)}"

EXTRA_OECONF = '--prefix=${prefix} \
                --host=${HOST_SYS} \
                --libdir=${libdir} \
                --cross-prefix=${TARGET_PREFIX} \
                --sysroot=${STAGING_DIR_TARGET} \
                --enable-static \
                --enable-shared \
                --disable-lavf \
                --disable-swscale \
                --enable-pic \
                ${X264_DISABLE_ASM} \
               '

do_configure() {
    ./configure ${EXTRA_OECONF}
}

# Get rid of -e
EXTRA_OEMAKE = ""
AS = "${TARGET_PREFIX}gcc"

do_install() {
    oe_runmake install DESTDIR=${D}
}

# PIC can't be enabled for 32-bit x86
INSANE_SKIP_${PN}_append_i586 = " textrel"

