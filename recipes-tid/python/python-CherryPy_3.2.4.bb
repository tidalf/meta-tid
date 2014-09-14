SUMMARY = "Yenc library for Python"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.txt;md5=7073d1d7e78d3b13f448ea0672e2afba"
SRC_URI = "https://pypi.python.org/packages/source/C/CherryPy/CherryPy-${PV}.tar.gz"

SRC_URI[md5sum] = "e2c8455e15c39c9d60e0393c264a4d16"
SRC_URI[sha256sum] = "abd73a449936740e99d3a05eb89b9381dc188ef696904f585463bc28079f1288"

S = "${WORKDIR}/CherryPy-${PV}"

inherit setuptools

RDEPENDS_${PN}_class-native = ""

FILES_${PN} += "/usr/share/cherrypy/favicon.ico \
  /usr/share/cherrypy/LICENSE.txt \
  /usr/share/cherrypy/cherryd \
  /usr/share/cherrypy/process \
  /usr/share/cherrypy/scaffold \
  /usr/share/cherrypy/tutorial \
  /usr/share/cherrypy/test \
  /usr/share/cherrypy/scaffold/site.conf \
  /usr/share/cherrypy/scaffold/example.conf \
  /usr/share/cherrypy/scaffold/static \
  /usr/share/cherrypy/scaffold/static/made_with_cherrypy_small.png \
  /usr/share/cherrypy/tutorial/custom_error.html \
  /usr/share/cherrypy/tutorial/tutorial.conf \
  /usr/share/cherrypy/tutorial/pdf_file.pdf \
  /usr/share/cherrypy/tutorial/README.txt \
  /usr/share/cherrypy/test/style.css \
  /usr/share/cherrypy/test/test.pem \
  /usr/share/cherrypy/test/static \
  /usr/share/cherrypy/test/static/dirback.jpg \
  /usr/share/cherrypy/test/static/index.html \
  "

BBCLASSEXTEND = "native nativesdk"
