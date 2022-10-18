# core-image-sato support basic command
#
# Debug tool

require recipes-sato/images/core-image-sato.bb

inherit core-image

EXTRA_IMAGE_FEATURES += " package-management debug-tweaks eclipse-debug ssh-server-openssh x11-base ssh-server-dropbear hwcodecs qtcreator-debug"

# Support build SDK
inherit populate_sdk_qt5

# Expand rootfs space
IMAGE_ROOTFS_EXTRA_SPACE:append = " + 512000"

# i2c tool support
I2C_TOOLS_SUPPORT = "i2c-tools"

# Time zone support
TIME_ZONE_SUPPORT = "tzdata tzdata-asia tzdata-europe"

# Basic command
UTILS_TOOLS = "wpa-supplicant alsa-utils util-linux usbutils iw net-tools picocom bash-completion wget icu fbset htop nano watchdog rsync tinyalsa"

# Basic command
TTF_TOOLS = "ttf-dejavu-common ttf-dejavu-sans ttf-dejavu-sans-condensed ttf-dejavu-sans-mono ttf-dejavu-serif ttf-dejavu-serif-condensed"

# Network tool
NETWORK_TOOLS = "networkmanager networkmanager-nmcli networkmanager-bash-completion networkmanager-openvpn iptraf tcpdump ethtool"

# RTL WIFI BT Firmware and Tool
# RTL_FIRMWARE = "rkwifibt-firmware-ap6212a1-wifi rkwifibt-firmware-ap6212a1-bt brcm-tools"

#QT5
QT_SUPPORT = "packagegroup-qt5-doorphone qt5everywheredemo cinematicexperience"

# More libraries that application needed
IMAGE_INSTALL:append = " libpng libconfig libarchive"

#fb-test LCD
#FBTEST = "fb-test"

#Show image
FEH_IMG = "feh"

#apt tool
V4L2_UTILS = "v4l-utils ffmpeg gdb"

#Gstreamer
GSTREAMER_SP = "gstreamer1.0 gstreamer1.0-plugins-bad gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-rockchip rockchip-mpp xserver-xorg rockchip-librga rockchip-rkisp vlc"

#Support Firefox, Chromium
#FIREFOX_SP = "firefox"
#CHROMIUM_SP = "chromium-x11"
#IMAGE_INSTALL:append = " ${CHROMIUM_SP}"

IMAGE_INSTALL += "${I2C_TOOLS_SUPPORT} ${TIME_ZONE_SUPPORT} ${UTILS_TOOLS} ${TTF_TOOLS} ${NETWORK_TOOLS} ${FEH_IMG} ${V4L2_UTILS} ${GSTREAMER_SP} ${QT_SUPPORT}"
