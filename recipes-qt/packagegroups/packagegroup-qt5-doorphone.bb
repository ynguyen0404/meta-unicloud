# Copyright (C) 2014 O.S. Systems Software LTDA.

DESCRIPTION = "Target packages for Qt5 SDK"
LICENSE = "MIT"

PACKAGE_ARCH = "${TUNE_PKGARCH}"
inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

# Requires Wayland to work
USE_WAYLAND = " \
    qtwayland \
    qtwayland-plugins \
    qtwayland-tools \
"

# Requires X11 to work
USE_X11 = " \
    qtx11extras \
"

RDEPENDS:${PN} += " \
    libsqlite3 \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qt3d', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qt3d-qmlplugins', '', d)} \
    qtbase \
    qtbase-plugins \
    qtbase-tools \
    qttranslations-qtbase \
    qttranslations-qthelp \
    qtcharts \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtcharts-qmlplugins', '', d)} \
    qtconnectivity \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtconnectivity-qmlplugins', '', d)} \
    qttranslations-qtconnectivity \
    qtdeclarative \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtdeclarative-qmlplugins', '', d)} \
    qtdeclarative-tools \
    qtdeclarative-staticdev \
    qttranslations-qtdeclarative \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtgraphicaleffects-qmlplugins', '', d)} \
    qtimageformats \
    qtimageformats-plugins \
    qtlocation \
    qtlocation-plugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtlocation-qmlplugins', '', d)} \
    qttranslations-qtlocation \
    qtmqtt \
    qtmultimedia \
    qtmultimedia-plugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtmultimedia-qmlplugins', '', d)} \
    qttranslations-qtmultimedia \
    qtscript \
    qttranslations-qtscript \
    qtsensors \
    qtsensors-plugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtsensors-qmlplugins', '', d)} \
    qtserialport \
    qtserialbus \
    qtsvg \
    qtsvg-plugins \
    qtsystems \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtsystems-qmlplugins', '', d)} \
    qttools \
    qttools-staticdev \
    qttools-tools \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '${USE_WAYLAND}', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', '${USE_X11}', '', d)} \
    qtwebsockets \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtwebsockets-qmlplugins', '', d)} \
    qttranslations-qtwebsockets \
    qtwebchannel \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtwebchannel-qmlplugins', '', d)} \
    qtxmlpatterns \
    qttranslations-qtxmlpatterns \
    qtquickcontrols2 \
"
RDEPENDS:${PN}:remove:toolchain-clang:riscv32 = "qttools qttools-staticdev qttools-tools"
RDEPENDS:${PN}:remove:toolchain-clang:riscv64 = "qttools qttools-staticdev qttools-tools"

RRECOMMENDS:${PN} += " \
    qtquickcontrols-qmlplugins \
    qttools-plugins \
"

RRECOMMENDS:${PN}:remove:toolchain-clang:riscv32 = "qttools-plugins"
RRECOMMENDS:${PN}:remove:toolchain-clang:riscv64 = "qttools-plugins"
