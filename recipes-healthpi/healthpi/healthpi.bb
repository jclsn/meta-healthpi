SUMMARY = "Builds the healthpi Qt application"
AUTHOR = "Jan Claussen"

LICENSE = "NONE"

DEPENDS += "qtbase qtquickcontrols2 qtquicktimeline"

SRC_URI = "\
           https://github.com/jclsn/healthpi-qt5;branch=master \
    "

PV = "git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "raspberrypi4-64"

do_install:append() {
  install -d ${D}/usr/bin
}

FILES:${PN} += "/usr/bin"

inherit qmake5
