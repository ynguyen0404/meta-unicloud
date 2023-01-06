#! /bin/bash

Day=$(date +%F)
Day2=$(date +%T)

echo "$Day - $Day2"
echo "Flashing PX30 Firmware....."

sudo ./upgrade_tool di -b boot.img
sudo ./upgrade_tool di -uboot uboot.img
sudo ./upgrade_tool di -trust trust.img
sudo ./upgrade_tool uf update.img

echo "Flash done!"
