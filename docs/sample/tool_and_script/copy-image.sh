#! /bin/bash

Day=$(date +%F)
Day2=$(date +%T)

mkdir image-release-$Day-$Day2

echo "$Day - $Day2"
echo "Create folder image....."

cp  -v              \
    boot.img        \
    trust.img       \
    uboot.img       \
    flash-img.sh    \
    upgrade_tool    \
    update.img      \
    image-release-$Day-$Day2

sync

echo "Copy done!"