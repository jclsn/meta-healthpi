FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RDEPENDS:{PN}:append = " \
    qtquicktimeline \
    qtquicktimeline-dev \
    qtquicktimeline-mkspecs \
    "
