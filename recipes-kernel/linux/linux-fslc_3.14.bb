# Copyright (C) 2012-2014 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "FSL Community BSP Linux mainline based kernel with backported features and fixes"
DESCRIPTION = "Linux kernel based on mainline kernel used by FSL Community BSP in order to \
provide support for some backported features and fixes, or because it was applied in linux-next \
and takes some time to become part of a stable version, or because it is not applicable for \
upstreaming."

include linux-fslc.inc

PV = "3.14+git${SRCPV}"

SRCBRANCH = "patches-3.14"
SRCREV = "ab42ba640b5edddd705c34620e2f9ecea28280eb"

COMPATIBLE_MACHINE = "(mxs|mx3|mx5|mx6)"
