This is the configuration project for yocto targeting console-image for Beaglebone-Black boards

To build yocto please clone the following yocto git repositories:

- git clone -b dunfell git://git.yoctoproject.org/poky.git poky-dunfell
- git clone -b dunfell git://git.openembedded.org/meta-openembedded poky-dunfell/meta-openembedded
- git clone -b dunfell https://github.com/meta-qt5/meta-qt5.git poky-dunfell/meta-qt5
- git clone -b dunfell git://git.yoctoproject.org/meta-security.git poky-dunfell/meta-security
- git clone -b dunfell https://github.com/jumpnow/meta-jumpnow.git poky-dunfell/meta-jumpnow


To use the bbb meta layer perform the following commands:

- git clone --recurse-submodules https://github.com/mkauli/yocto_bbb.git bbb
- edit file: bbb/build/conf/bblayers.conf  - adjust the HOME path
- source poky-dunfell/oe-init-build-env ./bbb/build
- bitbake console-image


