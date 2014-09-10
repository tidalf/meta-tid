FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " file://de58ed5cec519c4ba42b692e3127a3b418c3d7e6.patch \
file://d3797bdf646e8d53b711c555d29ad4d0066939d5.patch \
file://c7db7e468617822adcbfe287c06a48d894f47847.patch \
file://1bc304cd507fe9eb5673223f0d76ec0aa4ff55f3.patch \
file://2ce63690b95fb322a9e840c7c57f1982d0d16e82.patch \
file://20e36aab7589364348b595e66b834ce3a95bd2af.patch \
file://d6e35d087fe9d71f4ac201e89db478485c808890.patch \ 
file://defconfig" 

do_configure_append(){ 
    ARCH=arm make dtbs
}
