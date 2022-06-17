# Copyright (C) 2022 Jan Claussen <claussen.j@eppendorf.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Adds the startup service for heatlhpi"
LICENSE = "CLOSED"

inherit systemd

SRC_URI = " file://healthpi.service"
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "healthpi.service"

FILES:${PN} += "${systemd_unitdir}/system/healthpi.service"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/healthpi.service ${D}/${systemd_unitdir}/system
}
