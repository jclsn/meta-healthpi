SUMMARY = "Builds the healthpi Qt application"
AUTHOR = "Jan Claussen"

LICENSE = "CLOSED"

inherit qmake5

DEPENDS += " \
    qtbase \
    qtmultimedia \
    qtquickcontrols2 \
    qtquicktimeline \
"

PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

SRC_URI = " \
    git://github.com/jclsn/healthpi-qt5.git;protocol=https;branch=master \
"

S = "${WORKDIR}/git"

FILES:${PN} += " \
    /home \
    /home/root \
    /home/root/fonts \
    /home/root/images \
    /home/root/sounds \
    /usr/bin \
    /usr/bin/healthpi \
"

RDEPENDS:${PN} = " \
    qtbase \
    qtmultimedia \
    qtquickcontrols2 \
    qtquicktimeline \
"

COMPATIBLE_MACHINE = "raspberrypi4-64"

do_install:append() {
  install -d ${D}/usr/bin
  install -d ${D}/home/root/fonts
  install -d ${D}/home/root/images
  install -d ${D}/home/root/sounds
  install -m 0755 ${WORKDIR}/build/HealthPi ${D}/usr/bin/healthpi
  install ${WORKDIR}/git/fonts/* ${D}/home/root/fonts
  install ${WORKDIR}/git/images/* ${D}/home/root/images
  install ${WORKDIR}/git/sounds/* ${D}/home/root/sounds
}

