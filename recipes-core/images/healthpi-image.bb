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

EXTRA_IMAGE_FEATURES = "debug-tweaks ssh-server-openssh"
CORE_IMAGE_EXTRA_INSTALL += "openssh-sftp openssh-sftp-server"
INIT_MANAGER = "systemd"

LICENSE_FLAGS_ACCEPTED = "commercial"

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

DISTRO_FEATURES:append = " \
  opengl \
  eglfs \
  gles2 \
"
