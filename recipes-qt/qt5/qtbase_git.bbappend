FILESEXTRAPATHS:append := ":${THISDIR}/${PN}:"

QT_CONFIG_MANTARAY = "\
	qml-debug \
	examples \
	glib \
	eglfs \
	gles2 \
	sql-sqlite2 \
	sql-sqlite \
	sql-mysql \
	fontconfig \
	linuxfb \
	widgets \
	accessibility \
	gif \
	ico \
	libinput \
	udev \
"

PACKAGECONFIG_BYMACHINE = "${@bb.utils.contains('MACHINE', 'doorphone', '${QT_CONFIG_MANTARAY}', '', d)}"

PACKAGECONFIG:append = "${PACKAGECONFIG_BYMACHINE}"



