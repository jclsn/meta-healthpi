SUMMARY = "Builds the healthpi Qt application"
AUTHOR = "Jan Claussen"

LICENSE = "CLOSED"

inherit qmake5

DEPENDS += " \
    qtbase \
    qtquickcontrols2 \
    qtquicktimeline \
    qtmultimedia \
    qttranslations \
"

PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/jclsn/healthpi-qt5.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

FILES:${PN} += " \
    /usr/bin \
    /usr/bin/HealthPi \
"

RDEPENDS:${PN} = " \
    qtbase \
    qtdeclarative \
    qtmultimedia \
    qtquickcontrols2 \
    qtquicktimeline \
    qtsvg \
"

COMPATIBLE_MACHINE = "raspberrypi4-64"


inherit systemd


SRC_URI:append = " file://healthpi.service"
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "healthpi.service"

FILES:${PN} += "${systemd_unitdir}/system/healthpi.service"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/healthpi.service ${D}/${systemd_unitdir}/system
}
