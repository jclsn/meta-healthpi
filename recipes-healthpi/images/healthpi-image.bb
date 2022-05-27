# Copyright (C) 2022 Jan Claussen <jan.claussen10@web.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = ""
HOMEPAGE = ""
LICENSE = ""
SECTION = ""
DEPENDS = ""

SRC_URI = ""

inherit core-image
inherit populate_sdk_qt5

IMAGE_INSTALL:remove = " \
  x11 \
  wayland \
"

IMAGE_INSTALL:append = " \
  coreutils \
  gdb \
  gdbserver \
  module-init-tools \
  qtbase \
  qtbase-examples \
  qtbase-plugins \
  qtbase-tools \
  qtdeclarative \
  qtdeclarative-plugins \
  qtdeclarative-qmlplugins \
  qtdeclarative-tools \
  qtimageformats-plugins \
  qtmultimedia \
  qtmultimedia-plugins \
  qtmultimedia-qmlplugins \
  qtquickcontrols2 \
  qtquicktimeline \
  qtscript \
  qtsvg \
  qtsvg-plugins \
  qtsystems \
  qtsystems-qmlplugins \
  qtsystems-tools \
  rsync \
  screen \
  valgrind \
"

PACKAGECONFIG:append:pn-qtbase = " \
  eglfs \
  freetype \
  gles2 \
  kms  \
"


DISTRO_FEATURES:append = " \
  opengl \
  eglfs \
  gles2 \
"

RPI_KERNEL_DEVICETREE_OVERLAYS:append = "\
    overlays/mcp3008.dtbo \
"

# Hostname of the machine
hostname:pn-base-files = "healthpi64"

# Image file system types to package
IMAGE_FSTYPES = "rpi-sdimg"

# Package management configuration
PACKAGE_CLASSES = "package_ipk"

# rpi-specific
ENABLE_SPI = "1"
ENABLE_I2C = "1"
VC4DTBO = "vc4-fkms-v3d"

RPI_EXTRA_CONFIG = "\
  disable_overscan=1 \n\
  dtoverlay=max30102,int_pin=4 \n\
  dtoverlay=mcp3008:spi0-0-present,spi0-0-speed=3600000 \n\
  dtoverlay=w1-gpio,gpiopin=17 \n\
  dtparam=audio=on \n\
  dtparam=i2c_arm=on \n\
  dtparam=spi=on \n\
  enable_uart=1 \n\
"

MACHINE ??= "raspberrypi4-64"
DISTRO ??= "poky"
SDKMACHINE ?= "x86_64"
