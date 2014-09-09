do_install_append() { 
    install -m 0755 ${D}${libdir}/libmpc.so.3.0.0 ${D}${libdir}/libmpc.so.2.0.0
    install -m 0755 ${D}${libdir}/libmpc.so.3.0.0 ${D}${libdir}/libmpc.so.2
}
FILES_${PN} += "/usr/lib/libmpc.so.2.0.0" 
FILES_${PN} += "/usr/lib/libmpc.so.2" 
