# Copyright (C) 2013, 2014 Freescale Semiconductor

require imx-vpu.inc

PE = "1"

SRC_URI[md5sum] = "71ea1b803864101ebf88a1bab45514d2"
SRC_URI[sha256sum] = "cd8a7bd50ff3274db76a331cc6622d3ba4bb7c790ce778f303e49187df2dfd72"

SRC_URI_append = " file://0001-IOGetVirtMem-returns-1-MAP_FAILED-on-failure.patch"

COMPATIBLE_MACHINE = "(mx6)"
