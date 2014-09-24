require ffmpeg.inc

# SRC_URI = "http://libav.org/releases/${BP}.tar.xz"
# SRCREV = "ef312b8f0f47b976cc796dc5d2cdba4c88b1060c"
# SRCREV = "5c073bbb57b5698a559e90dfbbb0346e663414cb"
SRCREV = "68cd69c70771fb3427cc80c087b110a087112664"

#SRC_URI = "git://git.libav.org/libav.git"
SRC_URI = "git://github.com/xbmc/FFmpeg.git;branch=release/2.4-xbmc"

#           file://0001-configure-enable-pic-for-AArch64.patch"
#SRC_URI[md5sum] = "bfc894b3a2747212c2f48a38a468a15e"
#SRC_URI[sha256sum] = "1f920f057f93752f44e8ed3b497129ffca249d462721bed8270726023b6a8835"
S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://COPYING.GPLv3;md5=d32239bcb673463ab874e80d47fae504 \
                    file://COPYING.LGPLv2.1;md5=bd7a443320af8c812e4c18d1b79df004 \
                    file://COPYING.LGPLv3;md5=e6a600fd5e1d9cbde2d983680233ad02"

PROVIDES += "libpostproc"

EXTRA_OECONF += " \
    --enable-postproc \
    --disable-libtheora \
    --disable-libx264 \
"
