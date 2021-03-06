SUMMARY = "A complete, cross-platform solution to record, convert and stream audio and video"
HOMEPAGE = "http://github.com/xbmc/ffmpeg"
SECTION = "libs"
LICENSE = "GPLv2+"
LICENSE_FLAGS = "commercial"

# Provides ffmpeg compat, see http://libav.org/about.html
PROVIDES = "ffmpeg"

ARM_INSTRUCTION_SET = "arm"

DEPENDS = "zlib libogg libvorbis libtheora yasm-native lzma"

INC_PR = "r8"

inherit autotools pkgconfig

B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"

EXTRA_FFCONF_armv7a = "--cpu=cortex-a8"
EXTRA_FFCONF ?= ""

PACKAGECONFIG ??= "bzip2 x264 ${@base_contains('DISTRO_FEATURES', 'x11', 'x11', '', d)}"
PACKAGECONFIG[jack] = "--enable-indev=jack,--disable-indev=jack,jack"
PACKAGECONFIG[bzip2] = "--enable-bzlib,--disable-bzlib,bzip2"
PACKAGECONFIG[schroedinger] = "--enable-libschroedinger,--disable-libschroedinger,schroedinger"
PACKAGECONFIG[gsm] = "--enable-libgsm,--disable-libgsm,libgsm"
# PACKAGECONFIG[x264] = "--enable-libx264,--disable-libx264,x264"
PACKAGECONFIG[vpx] = "--enable-libvpx,--disable-libvpx,libvpx"
PACKAGECONFIG[mp3lame] = "--enable-libmp3lame,--disable-libmp3lame,lame"
PACKAGECONFIG[faac] = "--enable-libfaac,--disable-libfaac,faac"
PACKAGECONFIG[x11] = "--enable-x11grab,--disable-x11grab,virtual/libx11 libxfixes libxext xproto virtual/libsdl"

do_package_qa() {
 echo kapoue 
}
#    --enable-libtheora  

EXTRA_OECONF = " \
    --enable-shared \
    --enable-static \
    --enable-pthreads \
    --enable-gpl \
    --disable-lzma \
    --enable-avfilter \
    \
    --cross-prefix=${TARGET_PREFIX} \
    --prefix=${prefix} \
    \
    --ld="${CCLD}" \
    --enable-libvorbis \
    --arch=${TARGET_ARCH} \
    --target-os="linux" \
    --enable-cross-compile \
    --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
    --extra-ldflags="${TARGET_LDFLAGS}" \
    --sysroot="${STAGING_DIR_TARGET}" \
    --enable-hardcoded-tables \
    ${EXTRA_FFCONF} \
    --libdir=${libdir} \
    --shlibdir=${libdir} \
    --enable-yasm \
    --enable-asm \
    --enable-pic \
    --enable-neon \
    --enable-hardcoded-tables \
 --disable-memalign-hack \
--disable-encoders \
--enable-encoder=ac3 \
--enable-encoder=aac \
--enable-encoder=wmav2 \
--disable-decoder=mpeg_xvmc \
--enable-hwaccels \
--disable-muxers \
--enable-muxer=spdif \
--enable-muxer=adts \
--enable-muxer=asf \
--enable-muxer=ipod \
--enable-demuxers \
--enable-parsers \
--enable-bsfs \
--enable-protocol=http \
--disable-indevs \
--disable-outdevs \
--enable-filters \
--disable-avisynth \
--enable-bzlib \
--disable-frei0r \
--disable-libopencore-amrnb \
--disable-libopencore-amrwb \
--disable-libopencv \
--disable-libdc1394 \
--disable-libfaac \
--disable-libfreetype \
--disable-libgsm \
--disable-libmp3lame \
--disable-libnut \
--disable-libopenjpeg \
--disable-librtmp \
--disable-libschroedinger \
--disable-libspeex \
--disable-libtheora \
--disable-libvo-aacenc \
--disable-libvo-amrwbenc \
--enable-libvorbis --enable-muxer=ogg --enable-encoder=libvorbis \
--disable-libvpx \
--disable-libx264 \
--disable-libxavs \
--disable-libxvid \
--enable-zlib \
--enable-asm \
--disable-altivec \
 --enable-optimizations \
--disable-armv5te --disable-armv6t2 \
--disable-extra-warnings \
--disable-ffprobe \
--disable-ffplay \
--disable-ffserver \
--enable-ffmpeg \
--enable-avdevice \
--enable-avcodec \
--enable-avformat \
--enable-swscale \
--enable-postproc \
--enable-avfilter \
--disable-devices \
--enable-pthreads \
--disable-w32threads \
--disable-x11grab \
--enable-network \
--disable-gray \
--enable-swscale-alpha \
--enable-dct \
--enable-fft \
--enable-mdct \
--enable-rdft \
--disable-crystalhd \
--disable-dxva2 \
--enable-runtime-cpudetect \
"

do_configure() {
    # We don't have TARGET_PREFIX-pkgconfig
    sed -i '/pkg_config_default="${cross_prefix}${pkg_config_default}"/d' ${S}/configure
    mkdir -p ${B}
    cd ${B}
    ${S}/configure ${EXTRA_OECONF}
    sed -i -e s:Os:O4:g ${B}/config.h
}

do_install_append() {
    install -m 0644 ${S}/libavfilter/*.h ${D}${includedir}/libavfilter/
}

FFMPEG_LIBS = "libavcodec libavdevice libavformat \
               libavutil libpostproc libswscale libavfilter"

PACKAGES += "${PN}-vhook-dbg ${PN}-vhook ffmpeg-x264-presets"

RSUGGESTS_${PN} = "mplayer"
FILES_${PN} = "${bindir}"
FILES_${PN}-dev = "${includedir}/${PN}"

FILES_${PN}-vhook = "${libdir}/vhook"
FILES_${PN}-vhook-dbg += "${libdir}/vhook/.debug"

FILES_ffmpeg-x264-presets = "${datadir}/*.ffpreset"

LEAD_SONAME = "libavcodec.so"

FILES_${PN} += " \
  /usr/share/ffprobe.xsd \
  /usr/share/examples \ 
  /usr/share/examples/scaling_video.c \ 
  /usr/share/examples/muxing.c \
  /usr/share/examples/avio_reading.c \
  /usr/share/examples/README \
  /usr/share/examples/filter_audio.c \
  /usr/share/examples/decoding_encoding.c \
  /usr/share/examples/Makefile \
  /usr/share/examples/resampling_audio.c \
  /usr/share/examples/metadata.c \
  /usr/share/examples/transcode_aac.c \
  /usr/share/examples/filtering_video.c \
  /usr/share/examples/transcoding.c \
  /usr/share/examples/filtering_audio.c \
  /usr/share/examples/remuxing.c \
  /usr/share/examples/demuxing_decoding.c \
 "

FILES_${PN}-dev = "${includedir}"

python populate_packages_prepend() {
    av_libdir = d.expand('${libdir}')
    av_pkgconfig = d.expand('${libdir}/pkgconfig')

    # Runtime package
    do_split_packages(d, av_libdir, '^lib(.*)\.so\..*',
                      output_pattern='lib%s',
                      description='libav %s library',
                      extra_depends='',
                      prepend=True,
                      allow_links=True)

    # Development packages (-dev, -staticdev)
    do_split_packages(d, av_libdir, '^lib(.*)\.so$',
                      output_pattern='lib%s-dev',
                      description='libav %s development package',
                      extra_depends='${PN}-dev',
                      prepend=True,
                      allow_links=True)
    do_split_packages(d, av_pkgconfig, '^lib(.*)\.pc$',
                      output_pattern='lib%s-dev',
                      description='libav %s development package',
                      extra_depends='${PN}-dev',
                      prepend=True)
    do_split_packages(d, av_libdir, '^lib(.*)\.a$',
                      output_pattern='lib%s-staticdev',
                      description='libav %s development package - static library',
                      extra_depends='${PN}-dev',
                      prepend=True,
                      allow_links=True)

    if d.getVar('TARGET_ARCH', True) == 'i586':
        # libav can't be build with -fPIC for 32-bit x86
        pkgs = d.getVar('PACKAGES', True).split()
        for pkg in pkgs:
            d.appendVar('INSANE_SKIP_%s' % pkg, ' textrel')
}

PACKAGES_DYNAMIC += "^lib(av(codec|device|filter|format|util)|postproc|swscale).*"
