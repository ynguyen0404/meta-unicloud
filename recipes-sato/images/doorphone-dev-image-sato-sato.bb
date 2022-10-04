# core-image-sato support basic command
#
# Debug tool

require recipes-sato/images/core-image-sato.bb

inherit core-image

EXTRA_IMAGE_FEATURES += " package-management debug-tweaks eclipse-debug ssh-server-openssh x11-base ssh-server-dropbear hwcodecs qtcreator-debug"

# Support build SDK
# inherit populate_sdk_qt6_base

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
RTL_FIRMWARE = "rkwifibt-firmware-ap6212a1-wifi rkwifibt-firmware-ap6212a1-bt brcm-tools"

#QT5
#QT_SUPPORT = "packagegroup-qt5-doorphone"

#fb-test LCD
FBTEST = "fb-test"

IMAGE_INSTALL += "${I2C_TOOLS_SUPPORT} ${TIME_ZONE_SUPPORT} ${UTILS_TOOLS} ${TTF_TOOLS} ${NETWORK_TOOLS} ${RTL_FIRMWARE} ${FBTEST}"
