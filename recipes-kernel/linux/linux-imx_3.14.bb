# Copyright (C) 2013, 2014 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by Freescale"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx_3.14.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "linux-linaro-lsk-v3.14-mx6"
SRCREV = "e85332f747c8ad0d6f4482ac1d4299a293ce52d5"
LOCALVERSION = ""

COMPATIBLE_MACHINE = "(mx6)"
