SUMMARY = "Oracle Java SE runtime environment binaries"
DESCRIPTION = "This is the proprietary JRE from Sun/Oracle, with the Hotspot JVM. It is\
 provided by Sun/Oracle only in binary format.\
 Java Platform, Standard Edition (Java SE) lets you develop and deploy Java\
 applications on desktops and servers, as well as in today's demanding\
 embedded environments. Java offers the rich user interface, performance,\
 versatility, portability, and security that today's applications require.\
 The JRE (Java Runtime Environment) is needed on a system to run Java\
 applications and applets"

JDK_JRE = "ejre"

LICENSE_FLAGS = "oracle_java"
LICENSE = "Oracle_Binary_Code_License_Agreement"
LIC_FILES_CHKSUM = "\
             file://${WORKDIR}/${JDK_JRE}${PV}_${PV_UPDATE}/COPYRIGHT;md5=be9fe5d47a7dcfb78f142f487afb34bb \
                file://${WORKDIR}/${JDK_JRE}${PV}_${PV_UPDATE}/THIRDPARTYLICENSEREADME.txt;md5=f3a388961d24b8b72d412a079a878cdb \
             "

# get the java update version in the resulting package
PR =. "u${PV_UPDATE}"
S = "${WORKDIR}"

do_install () {
             install -d -m 0755                                              ${D}/usr/${JDK_JRE}${PV}_${PV_UPDATE}
             cp -a ${S}/${JDK_JRE}${PV}_${PV_UPDATE}        ${D}/usr/
             ln -sf ${JDK_JRE}${PV}_${PV_UPDATE}  ${D}/usr/java
}

# All the files are provided in a binaray package, and keeping all the
# files in a single package causes packaging QA errors and warnings.
# Avoid these packaging failure by skiping all the QA checks
INSANE_SKIP_${PN} = "${ERROR_QA} ${WARN_QA}"

# Inhibit warnings about files being stripped, we can't do anything about it.
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

FILES_${PN} = "/usr/"

RPROVIDES_${PN} += "java2-runtime"
