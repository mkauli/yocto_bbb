This is the configuration project for yocto targeting console-image for Beaglebone-Black boards

# Yocto git repositories

To build yocto please clone the following yocto git repositories into an empty directory (i.e. your yocto source directory):

* git clone -b dunfell https://git.yoctoproject.org/git/poky poky-dunfell
* git clone -b dunfell https://git.openembedded.org/meta-openembedded poky-dunfell/meta-openembedded
* git clone -b dunfell https://git.yoctoproject.org/git/meta-security poky-dunfell/meta-security
* git clone -b dunfell https://github.com/jumpnow/meta-jumpnow.git poky-dunfell/meta-jumpnow

# Beaglebone Black meta layer

To use the bbb meta layer perform the following commands inside your yocto source directory:

* git clone --recurse-submodules https://github.com/mkauli/yocto_bbb.git bbb
* edit file: bbb/build/conf/bblayers.conf  - adjust the HOME path
* source poky-dunfell/oe-init-build-env ./bbb/build
* bitbake console-image

# Image File

To create an image file perform the following commands inside your yocto source directory:

```
rm diskimage.img
dd if=/dev/zero of=diskimage.img bs=3M count=1024
sudo losetup -fP diskimage.img

sudo ./bbb/meta-bbb/scripts/mk2parts.sh loop0
sudo mkdir -p /media/card
sudo mkdir -p /media/card_boot

sudo OETMP=`pwd`/bbb/build/tmp bbb/meta-bbb/scripts/copy_boot.sh loop0
sudo OETMP=`pwd`/bbb/build/tmp bbb/meta-bbb/scripts/copy_rootfs.sh loop0 console

sleep 2
sudo mount /dev/loop0p1 /media/card_boot
sudo mount /dev/loop0p2 /media/card
sudo cp ./bbb/meta-mkaul/scripts/uEnv.txt /media/card_boot/uEnv.txt
sleep 2
sudo umount /media/card
sudo umount /media/card_boot
sleep 2

sudo losetup -d /dev/loop0

sudo rmdir /media/card
sudo rmdir /media/card_boot
```
