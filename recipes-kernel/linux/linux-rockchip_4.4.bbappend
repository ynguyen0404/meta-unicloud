FILESEXTRAPATHS:append := ":${THISDIR}/${PN}:"

SRC_URI_DOORPHONE = "								\
		file://defconfig						\
		file://0001-Support-Touch-Goodix9271.patch 			\
		file://0002-Support-Touch-Goodix9271.patch 			\
		file://0003-Support-Device-Tree-doorphone.patch			\
		file://0004-Support-Device-Tree-doorphone.patch			\
"


SRC_URI += "${@bb.utils.contains('MACHINE', 'doorphone', '${SRC_URI_DOORPHONE}', '', d)} \
"

