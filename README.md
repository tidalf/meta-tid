meta-tid
========

Layer for XBMC on udoo board


This Layer is forked from Wolfgar's (http://github.com/wolfgar/meta-stef) 

daisy branch work with poky daisy layer except for freescale binaries that are kept to old version and udoo kernel 3.0.35
daisy-3.10.17 is up to date branch with standard meta-freescale-arm layer.


added 
=====
 - Xbmc (Gotham 13.2 Final and git)
 - TvHeadend (3.6)
 - Transmission
 - Sabnzbd
 - Oracle Java (for Arduino ide)
 - Sickbeard
 - nzbget
 
Note
====
 - there is some postinstall scripts that create an ext4 partition with the remaining space of the sdcard and copy the root home directory there so the first boot is longer (30s), the next ones are speeder (10-15s)
 - reboot command is not working but  hardware watchdog is used a workaround

Feel free to contribute here !
