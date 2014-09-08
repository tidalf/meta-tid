do_install_append() { 
   ln -s ${D}${libdir}/libmpc.so.3.0.0 ${D}${libdir}/libmpc.so.2
}
FILES_${PN} += "/usr/lib/libmpc.so.2"
