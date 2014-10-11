SUMMARY = "A very basic X11 image with a terminal"
include recipes-core/images/core-image-base.bb

IMAGE_FEATURES += "splash package-management x11"

LICENSE = "MIT"
PACKAGE_INSTALL += "packagegroup-xfce-extended packagegroup-xfce-base xinit x11vnc"

inherit core-image distro_features_check

REQUIRED_DISTRO_FEATURES = "x11"
